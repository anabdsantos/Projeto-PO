package hva.exceptions;

import java.io.Serial;

public class TreeAlreadyExistsException extends Exception {
    @Serial
	private static final long serialVersionUID = 202406100246L;

    private final String _treeId;

    public TreeAlreadyExistsException(String treeId) {
        _treeId = treeId;
    }

    public String getTreeId() {
        return _treeId;
    }   
}
