package libbox.datasource.action.result;

public class DeleteResult extends Result {
	private int deleteCount;
	
	public DeleteResult(String msg, int deleteCount){
		super(msg);
		this.deleteCount = deleteCount;
	}
}
