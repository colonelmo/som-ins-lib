package libbox.datasource.inmemory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import libbox.datasource.action.Action;
import libbox.datasource.action.Command;
import libbox.datasource.action.result.CreateResult;
import libbox.datasource.action.result.DeleteResult;
import libbox.datasource.action.result.ReadResult;
import libbox.datasource.action.result.Result;
import libbox.datasource.action.result.UpdateResult;
import libbox.datasource.structure.CRUDDatasource;

public class InMemoryDatabase implements CRUDDatasource{
	private ArrayList<HashMap<String, Object>> data;
	private HashMap<String, Type> fields;
	private String primaryKey ;
	
	
	public InMemoryDatabase(InMemoryDatabaseSchema schema){
		this.primaryKey = schema.getPrimaryKey();
		for(String fieldName : schema.getFields().keySet()){
			fields.put(fieldName, schema.getFields().get(fieldName));
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
		return null;
		
	}
	
	private ReadResult read(Command c){
		return null;
		
	}
	
	private UpdateResult update(Command c){
		return null;
		
	}
	
	private DeleteResult delete(Command c){
		return null;
		
	}
	
	
	
}
