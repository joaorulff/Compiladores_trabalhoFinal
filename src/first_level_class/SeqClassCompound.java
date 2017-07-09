package first_level_class;

import java.util.ArrayList;
import java.util.List;

import second_level_class.EClass;
import second_level_class.SeqClass;
import utils.ID;

public class SeqClassCompound extends SeqClass{
	
	////Corresponding rule: SEQ ::= SEQ COMMA E
	
	public SeqClass seq;
	public EClass e;
	
	public SeqClassCompound(SeqClass seq, EClass e) {
		this.seq = seq;
		this.e = e;
	}
	
	@Override
	public ArrayList<EClass> getAllExpressions(){
		
		this.e.setIndex(this.getIndex());
		this.seq.setIndex(this.getIndex() + 1);
		ArrayList<EClass> thisIds = this.e.getAllUsedExpressions();
		ArrayList<EClass> seqIds = this.seq.getAllExpressions();
		
		thisIds.addAll(seqIds);
		
		return thisIds;
	}

	@Override
	public ArrayList<ID> getAllSeqIds() {
		this.e.setIndex(this.getIndex());
		this.seq.setIndex(this.getIndex() + 1);
		ArrayList<ID> thisIds = this.e.getAllUsedIdentifiers();
		ArrayList<ID> seqIds = this.seq.getAllSeqIds();
		
		thisIds.addAll(seqIds);
		
		return thisIds;
	}

	@Override
	public int numberOfParameters() {
		return this.seq.numberOfParameters() + 1;
	}

	@Override
	public List<String> generateCode() {
		return null;
	}
	
	public ArrayList<EClass> getAllScopes(){
		ArrayList<EClass> seqScopes = this.seq.getAllScopes();
		seqScopes.add(this.e);
		return seqScopes;
		
	}

}
