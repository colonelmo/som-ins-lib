package libbox.datasource.inmemory;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import libbox.datasource.action.Action;
import libbox.datasource.action.Command;
import libbox.datasource.action.result.CreateResult;
import libbox.datasource.action.result.DeleteResult;
import libbox.datasource.action.result.ReadResult;
import libbox.datasource.action.result.Result;
import libbox.datasource.action.result.UpdateResult;
import libbox.datasource.condition.OneFieldCondition;
import libbox.datasource.structure.CRUDDatasource;

public class InMemoryDatabase implements CRUDDatasource{
	private ArrayList<HashMap<String, Object>> data;
	private HashSet<String> fields;
	private String primaryKey ;
	
	
	public InMemoryDatabase(InMemoryDatabaseSchema schema){
		this.primaryKey = schema.getPrimaryKey();
		fields = new HashSet<>();
		data = new ArrayList<>();
		for(String fieldName : schema.getFields()){
			fields.add(fieldName);
		}
	}
	
	public Result query(Command c){
		if(c.getType() == Action.CREATE){
			return create(c);
		}else if(c.getType() == Action.READ){
			return read(c);
		}else if(c.getType() == Action.UPDATE){
			return update(c);
		}else{//(c.getType() == Action.DELETE)
			return delete(c);
		}
	}
	
	private CreateResult create(Command c){
		for(HashMap<String, Object> record : data){
			if(record.get(primaryKey).equals(c.getData().get(0).get(primaryKey))){
				return new CreateResult("Aready exists", false);
			}
		}
		HashMap<String, Object> toAdd = new HashMap<>();
		for(String key : c.getData().get(0).keySet()){
			toAdd.put(key, c.getData().get(0).get(key));
		}
		data.add(toAdd);
		return new CreateResult("Created", true);
	}
	
	private ReadResult read(Command c){
		ArrayList<HashMap<String, Object>> ret = new ArrayList<>();
		for(HashMap<String, Object> record : data){
			boolean good = true;
			for(OneFieldCondition cond : c.getOneFieldConditions()){
				if(!cond.satisfy(record.get(cond.getFieldName()))){
					good = false;
					break;
				}
			}
			if(good){
				ret.add(record);
			}
		}
		return new ReadResult("", ret);
	}
	
	private UpdateResult update(Command c){
		int updateCount = 0 ;
		for(HashMap<String, Object> record : data){
			boolean good = true;
			for(OneFieldCondition cond : c.getOneFieldConditions()){
				if(!cond.satisfy(record.get(cond.getFieldName()))){
					good = false;
					break;
				}
			}
			if(good){
				updateCount ++ ;
				for(String key : c.getData().get(0).keySet()){
					record.put(key, c.getData().get(0).get(key));
				}
			}
		}
		return new UpdateResult("", updateCount);
	}
	
	private DeleteResult delete(Command c){
		int deleteCount = 0 ;
		ArrayList<Integer> toDel = new ArrayList<>();
		int n = data.size();
		for(int i = 0 ;i < n ;i ++){
			HashMap<String, Object> record = data.get(i);
			boolean good = true;
			for(OneFieldCondition cond : c.getOneFieldConditions()){
				if(!cond.satisfy(record.get(cond.getFieldName()))){
					good = false;
					break;
				}
			}
			if(good){
				deleteCount ++ ;
				toDel.add(i);
			}
		}
		return new DeleteResult("", deleteCount);
	}
	
	public static HashMap<String, Object> serialize(Object o){
		HashMap<String, Object> ret = new HashMap<>();
		
		for(Field f : o.getClass().getDeclaredFields()){
			f.setAccessible(true);
			try {
				ret.put(f.getName(), f.get(o));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	
}
