package libbox.datasource.action;

import java.util.ArrayList;
import java.util.HashMap;

import libbox.datasource.condition.OneFieldCondition;

public class Command {
	private Action type;
	private ArrayList<HashMap<String, Object>> data;
	private ArrayList<OneFieldCondition> oneFieldConditions;
	public Command(Action type){
		this.type = type ;
		data = new ArrayList<>();
		oneFieldConditions = new ArrayList<>();
	}
	
	public void addData(HashMap<String, Object> row){
		HashMap<String, Object> toAdd = new HashMap<>();
		for(String k : row.keySet()){
			toAdd.put(k, row.get(k));
		}
		data.add(toAdd);
	}
	
	public void addOneFieldCondition(OneFieldCondition c){
		oneFieldConditions.add(c);
	}
	
	public Action getType(){
		return type;
	}
	
	public ArrayList<HashMap<String, Object>> getData(){
		return data;
	}
	
	public ArrayList<OneFieldCondition> getOneFieldConditions(){
		return oneFieldConditions;
	}
}
