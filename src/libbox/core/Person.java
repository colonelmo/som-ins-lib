package libbox.core;

import java.util.HashMap;

public class Person {
	private String fullname;
	private Integer id ;
	
	@Override
	public String toString() {
		return fullname + " with id " + id ;
	}
	
	
	public Person(){
	}
	
	public void setFullname(String fullname){
		this.fullname = fullname;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getFullname(){
		return this.fullname;
	}
	
	public Integer getId(){
		return this.id;
	}
}
