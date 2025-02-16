package hva.exceptions;

import java.io.Serial;

public class TreeNotFoundException extends Exception  {
    @Serial
	private static final long serialVersionUID = 202406100252L;
    
    private final String _treeId;

    public TreeNotFoundException(String treeId) {
        _treeId = treeId;
    }

    public String getTreeId() {
        return _treeId;
    }
}