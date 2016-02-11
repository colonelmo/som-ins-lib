package libbox.datasource.condition;

import java.lang.reflect.Type;

public class EqualCondition extends OneFieldCondition{
	public EqualCondition(String fieldName, Object value){
		super(fieldName, value);
	}

	@Override
	public boolean satisfy(Object other) {
		if(other instanceof Integer && this.getValue() instanceof Integer){
			return ((Integer)this.getValue()).compareTo((Integer)other) == 0 ;
		}else if(other instanceof String && this.getValue() instanceof String){
			return ((String)this.getValue()).compareTo((String)other) == 0 ;
		}else if(other instanceof Long && this.getValue() instanceof Long){
			return ((Long)this.getValue()).compareTo((Long)other) == 0 ;
		}
		// throw
		return false ;
	}
	
}
