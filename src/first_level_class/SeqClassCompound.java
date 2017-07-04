package first_level_class;

import java.util.ArrayList;

import second_level_class.EClass;
import second_level_class.SeqClass;
import utils.ID;

public class SeqClassCompound extends SeqClass{
	
	
	public SeqClass seq;
	public EClass e;
	
	public SeqClassCompound(SeqClass seq, EClass e) {
		
		this.seq = seq;
		this.e = e;
		
	}

	@Override
	public ArrayList<ID> getAllSeqIds() {
		
		ArrayList<ID> thisIds = this.e.getAllUsedIdentifiers();
		ArrayList<ID> seqIds = this.seq.getAllSeqIds();
		
		thisIds.addAll(seqIds);
		
		return thisIds;
	}

	@Override
	public void printTree() {
		
		this.seq.printTree();
		this.e.printTree();
		
	}

	@Override
	public int numberOfParameters() {
		return this.seq.numberOfParameters() + 1;
	}

	@Override
	public void generateCode() {
		// TODO Auto-generated method stub
	}
}
