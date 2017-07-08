package second_level_class;

import java.util.List;

import compilador.Node;
import compilador.Token;

public class OPRELClass extends Node{
	
	public Token equal;

	public OPRELClass(Token equal) {
		super();
		this.equal = equal;
	}


	@Override
	public void printTree() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<String> generateCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
