package first_level_class;

import java.util.ArrayList;
import java.util.Arrays;

import codeGeneration.CodeGenerator;
import compilador.Node;
import compilador.Token;
import second_level_class.PClass;
import utils.FunctionDeclaration;
import utils.ID;

public class PClassAssign extends PClass {
	
	//Corresponding Rule: P ::= ID:id EQUAL INTEGER:integer ENDSTMT P:p 
	
	public String id;
	public int integer;
	public PClass pclass;
	
	
	public PClassAssign(Token id, Token integer, PClass p) {
		this.id = id.value;
		this.integer = Integer.parseInt(integer.value);
		this.pclass = p;
		
	}
	
	public void printTree(){
		
		System.out.println();
		System.out.print( "ID:"+ this.id +" = " + " INTEGER: " + this.integer + " P: ");
		this.pclass.printTree();
		
	}

	@Override
	public int numberOfGlobalVariablesDeclared() {
		
		return 1+this.pclass.numberOfGlobalVariablesDeclared();
		
	}

	@Override
	public ArrayList<ID> globalIDsDeclared() {
		
		ArrayList<ID> temp = this.pclass.globalIDsDeclared();
		ArrayList<ID> result = new ArrayList<>();
		
		ID localID = new ID(this.id, this.integer);
		result.add(localID);
		
		if(temp != null && temp.size() > 0){
			result.addAll(temp);
			return result;
		}else{
			return result;
		}
	}

	@Override
	public ArrayList<FunctionDeclaration> globalFunctionsDeclared() {
		
		ArrayList<FunctionDeclaration> functions = this.pclass.globalFunctionsDeclared();
		return functions;
	}

	@Override
	public void generateCode() {
		
		System.out.println("\t li " + CodeGenerator.getNextRegister() + " " + this.integer);
		this.pclass.generateCode();
	}
	
	
	
	
}
