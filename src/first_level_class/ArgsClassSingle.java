package first_level_class;

import java.util.ArrayList;
import java.util.List;

import compilador.Token;
import second_level_class.ArgsClass;
import utils.ID;

public class ArgsClassSingle extends ArgsClass {
	
	////Corresponding rule: ARGS ::= ID
	
	public String id;
	
	public ArgsClassSingle(Token id) {
		this.id = id.value;
	}

	@Override
	public void printTree() {
		
		System.out.println(this.id);
		
	}

	@Override
	public ArrayList<ID> getArgs() {
		
		ID thisID = new ID(this.id);
		
		ArrayList<ID> args = new ArrayList<>();
		args.add(thisID);
		
		
		return args;
	}

	@Override
	public List<String> generateCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
