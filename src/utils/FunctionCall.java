package utils;

import java.util.ArrayList;

import second_level_class.SeqClass;

public class FunctionCall {
	
	public String id;
	public ArrayList<ID> args;
	public int numberOfArgs;
	public SeqClass seqOfParams;
	
	public FunctionCall(String id, ArrayList<ID> args, SeqClass seq){
		this.id = id;
		this.args = args;
		this.seqOfParams = seq;
		this.numberOfArgs = seq.numberOfParameters();
		
	}
	
}
