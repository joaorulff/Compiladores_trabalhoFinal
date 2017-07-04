package second_level_class;

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

}
