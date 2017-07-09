package first_level_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import compilador.Token;
import second_level_class.EClass;
import second_level_class.SeqClass;
import utils.FunctionCall;
import utils.ID;

public class EClassFunc extends EClass{

	public SeqClass seq;
	public String id;
	
	public EClassFunc(Token id, SeqClass seq) {
		this.id = id.value;
		this.seq = seq;
	}
	
	@Override
	public int numberOfFunctionCalls() {
		return 1;
	}

	@Override
	public ArrayList<FunctionCall> getFunctionCalls() {
		this.seq.setIndex(0);
		ArrayList<ID> params = this.seq.getAllSeqIds();
		FunctionCall functionCall = new FunctionCall(this.id, params, this.seq);
		
		ArrayList<FunctionCall> thisCall = new ArrayList<>();
		thisCall.add(functionCall);
		
		return thisCall;
	}

	@Override
	public ArrayList<ID> getAllUsedIdentifiers() {
		this.seq.setIndex(0);
		ArrayList<ID> usedIds = this.seq.getAllSeqIds();
		return usedIds;
	}

	@Override
	public void printTree() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ID getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> generateCode() {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		
		result.add("sw $fp 0($sp)");
		result.add("addiu $sp $sp -4");
		ArrayList<EClass> scopes = this.seq.getAllScopes();
		for(int i = scopes.size() - 1; i >= 0; i--){
			EClass scope = scopes.get(i);
			scope.generateCode();
			result.add("sw $a0 0($sp)");
			result.add("addiu $sp $sp -4");
		}
		
		result.add("jal "+ this.id +"_entry");
	
		return result;
	}
	
	public void printType(){
		System.out.println("EClassFunc");
	}
	
	

}
