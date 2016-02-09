package libbox.datasource.inmemory;

import java.lang.reflect.Type;
import java.util.HashMap;

public class InMemoryDatabaseSchema {
	private HashMap<String, Type> fields;
	private String primaryKey;
	
	public InMemoryDatabaseSchema(){
		this(new HashMap<>());
	}
	
	public InMemoryDatabaseSchema(HashMap<String, Type> schema){
		this.fields = schema ;
	}
	
	public void add(String name, Type type){
		this.fields.put(name, type);
	}
	
	public String getPrimaryKey(){
		return this.primaryKey;
	}
	
	public void setPrimaryKey(String primaryKey){
		this.primaryKey = primaryKey;
	}
	
	public HashMap<String, Type> getFields(){
		return this.fields ;
	}
	
}
