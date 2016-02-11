package libbox.datasource.action.result;

public class CreateResult extends Result {
	private boolean ok;

	public CreateResult(String msg, boolean ok){
		super(msg);
		this.ok= ok;
	}
	
	public boolean isOk(){
		return ok;
	}
}
