package libbox.datasource.condition;

import java.lang.reflect.Type;

public abstract class OneFieldCondition {
	private String fieldName;
	private Object value;

	public abstract boolean satisfy(Object other);

	public OneFieldCondition(String fieldName, Object value){
		this.fieldName = fieldName;
		this.value = value;
	}
	
	public String getFieldName(){
		return this.fieldName;
	}
	
	public Object getValue(){
		return this.value;
	}

}