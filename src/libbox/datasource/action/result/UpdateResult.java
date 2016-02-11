package libbox.datasource.action.result;

public class UpdateResult extends Result {
	private int updateCount;
	
	public UpdateResult(String msg, int updateCount){
		super(msg);
		this.updateCount = updateCount;
	}
	
	public int getUpdateCount(){
		return updateCount;
	}
}
