package first_level_class;

import compilador.Token;
import second_level_class.ArgsClass;
import second_level_class.DClass;
import second_level_class.EClass;
import utils.FunctionDeclaration;

public class DClassInstance extends DClass {
	
	public String id;
	public ArgsClass args;
	public EClass scope;
	
	
	public DClassInstance(Token id, ArgsClass args, EClass e){
		
		this.id = id.value;
		this.args = args;
		this.scope = e;
		
	}
	
	

	@Override
	public void printTree() {
		
		System.out.println();
		System.out.print("DEF: " + this.id + "OPEN ARGS: " );
		this.args.printTree();
		System.out.print("CLOSE EQUAL E: ");
		this.scope.printTree();
		System.out.println("ENDSTMT");
		
	}



	@Override
	public FunctionDeclaration getFunction() {
		
		FunctionDeclaration function = new FunctionDeclaration(this.id, this.scope, this.args.getArgs());
		
		return function;
	}



	@Override
	public void generateCode() {
		
		System.out.println(this.id + "_entry");
		System.out.println("\t move $fp $sp");
		System.out.println("\t sw $ra 0($sp)");
		System.out.println("\t addiu $sp $sp-4");
		
		System.out.println("--------------TODO-------------");
		System.out.println("cgen(e)");
		this.scope.generateCode();
		System.out.println("--------------TODO-------------");
		
		System.out.println("\t lw $ra 4($sp)");
		System.out.println("\t addiu $sp z");
		System.out.println("\t lw $fp 0($sp)");
		System.out.println("\t jr $ra");
		
		
		
	}

}
