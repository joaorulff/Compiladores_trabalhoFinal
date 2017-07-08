package first_level_class;

import java.util.ArrayList;
import java.util.List;

import second_level_class.EClass;
import second_level_class.SeqClass;
import utils.ID;

public class SeqClassSingle extends SeqClass{
	
	////Corresponding rule: SEQ ::= E
	
	public EClass e;

	public SeqClassSingle(EClass e) {
		this.e = e;
	}
	
	@Override
	public ArrayList<ID> getAllSeqIds() {
		return this.e.getAllUsedIdentifiers();
	}

	@Override
	public void printTree() {
		this.e.printTree();
	}

	@Override
	public int numberOfParameters() {
		return 1;
	}

	@Override
	public List<String> generateCode() {
		return e.generateCode();
	}

}
