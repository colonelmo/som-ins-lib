package libbox.datasource.inmemory;

import java.lang.reflect.Type;

public class InMemoryDatabaseField {
	private String name;
	private Type type; 

	public InMemoryDatabaseField(String name, Type type){
		this.name = name ;
		this.type = type ;
	}
	
	public Type getType(){
		return this.type ;
	}

	public void setType(Type t){
		this.type = t;
	}
	
	public String getName(){
		return this.name ;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
}
