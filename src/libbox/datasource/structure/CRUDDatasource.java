package libbox.datasource.structure;

import libbox.datasource.action.Command;
import libbox.datasource.action.result.Result;
import libbox.datasource.exception.CRUDException;

public interface CRUDDatasource {
	public Result query(Command c)throws CRUDException;
}
