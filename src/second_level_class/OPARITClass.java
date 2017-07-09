package second_level_class;

import java.util.List;

import compilador.Node;
import compilador.Token;

public class OPARITClass extends Node {
	
	public Token operator;

	public OPARITClass(Token operator) {
		super();
		this.operator = operator;
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
