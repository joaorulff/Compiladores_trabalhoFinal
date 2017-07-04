package utils;


import java.util.ArrayList;
import second_level_class.EClass;

public class FunctionDeclaration {
	
	public String name;
	public EClass scope;
	public ArrayList<ID> args;
	
	
	public FunctionDeclaration(String name, EClass scope, ArrayList<ID> args){
		
		this.name = name;
		this.scope = scope;
		this.args = args;
		
	}
	
	
	public boolean checkForRepeatedParamenters(){
		
		for (int i = 0; i < args.size(); i++) {
			
			ID currentID = this.args.get(i);
			
			for (int j = 0; j < args.size() && j != i; j++) {
				
				ID IDToCompare = this.args.get(j);
				if(currentID.id == IDToCompare.id){
					return false;
				}	
			}
		}
		
		return true;
		
	}

}
