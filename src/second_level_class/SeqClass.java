package second_level_class;

import java.util.ArrayList;
import java.util.List;

import compilador.Node;
import utils.ID;

public abstract class SeqClass extends Node {
	private Integer index;
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public Integer getIndex() {
		return this.index;
	}

	public abstract ArrayList<ID> getAllSeqIds();
	public abstract ArrayList<EClass> getAllExpressions();
	public abstract int numberOfParameters();
	public abstract ArrayList<EClass> getAllScopes();
}
