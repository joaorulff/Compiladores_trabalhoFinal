package first_level_class;

import java.util.ArrayList;
import java.util.List;

import compilador.Token;
import second_level_class.ArgsClass;
import utils.ID;

public class ArgsClassCompound extends ArgsClass{
	
	public String id;
	public ArgsClass args;
	
	public ArgsClassCompound(Token id, ArgsClass args) {
		
		this.id = id.value;
		this.args = args;
	}

	@Override
	public void printTree() {
		System.out.print(this.id);
		this.args.printTree();
	}

	@Override
	public ArrayList<ID> getArgs() {
		
		ArrayList<ID> result = new ArrayList<>();
		ArrayList<ID> temp = this.args.getArgs();
		
		ID thisID = new ID(this.id);
		
		if(temp != null && temp.size() > 0){
			
			result.add(thisID);
			result.addAll(temp);
		}
		
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<String> generateCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
