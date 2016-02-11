package libbox.datasource.action.result;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadResult extends Result {
	private ArrayList<HashMap<String, Object>> data;

	public ReadResult(String msg, ArrayList<HashMap<String,Object>> data){
		super(msg);
		this.data = data;
	}
	
	public <T> ArrayList<T> convert(T obj){
		ArrayList<T> ret = new ArrayList<T>();
		for(HashMap<String, Object> record : this.data){
			Constructor<T> c = null;
			try {
				c = (Constructor<T>) obj.getClass().getDeclaredConstructor();
			} catch (NoSuchMethodException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				T toAdd = c.newInstance();
				for(String key : record.keySet()){
					try {
						Field f = toAdd.getClass().getDeclaredField(key);
						f.setAccessible(true);
						f.set(toAdd, record.get(key));
					} catch (SecurityException | NoSuchFieldException e) {
						e.printStackTrace();
					}
				}
				ret.add(toAdd);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		return ret;
	}

}
