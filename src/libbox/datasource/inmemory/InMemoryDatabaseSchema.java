package libbox.datasource.inmemory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryDatabaseSchema {
	private ArrayList<String> fields;
	private String primaryKey;
	
	public InMemoryDatabaseSchema(){
		this(new ArrayList<>());
	}
	
	public InMemoryDatabaseSchema(ArrayList<String> schema){
		this.fields = schema ;
	}
	
	public void add(String name){
		this.fields.add(name);
	}
	
	public String getPrimaryKey(){
		return this.primaryKey;
	}
	
	public void setPrimaryKey(String primaryKey){
		this.primaryKey = primaryKey;
	}
	
	public ArrayList<String> getFields(){
		return this.fields;
	}
	
}
