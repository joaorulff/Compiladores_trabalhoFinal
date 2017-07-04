package first_level_class;

import java.util.ArrayList;

import second_level_class.EClass;
import second_level_class.SeqClass;
import utils.ID;

public class SeqClassSingle extends SeqClass{
	
	public EClass e;

	public SeqClassSingle(EClass e) {
		this.e = e;
	}
	
	@Override
	public ArrayList<ID> getAllSeqIds() {
		
		ArrayList<ID> thisIDs = this.e.getAllUsedIdentifiers();
		
		return thisIDs;
	}

	@Override
	public void printTree() {
		this.e.printTree();
	}
	
	

}
