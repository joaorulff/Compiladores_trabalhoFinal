package first_level_class;

import java.util.ArrayList;
import java.util.List;

import compilador.Token;
import second_level_class.ArgsClass;
import second_level_class.DClass;
import second_level_class.EClass;
import utils.FunctionDeclaration;

public class DClassInstance extends DClass {
	
	////Corresponding rule: D ::= DEF ID:id OPEN ARGS:args CLOSE EQUAL E:e ENDSTMT 
	
	public String id;
	public ArgsClass args;
	public EClass scope;
	private Integer z;
	
	public DClassInstance(Token id, ArgsClass args, EClass e){
		this.id = id.value;
		this.args = args;
		this.scope = e;
		this.z = args.getArgs().size() * 4 + 8;
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
		return new FunctionDeclaration(this.id, this.scope, this.args.getArgs());
	}

	@Override
	public List<String> generateCode() {
		List<String> result = new ArrayList<>();
		result.add(this.id + "_entry:");
		result.add("move $fp $sp");
		result.add("sw $ra 0($sp)");
		result.add("addiu $sp $sp -4");
		result.addAll(this.scope.generateCode());
		result.add("lw $ra 4($sp)");
		result.add("addiu $sp $sp " + this.z);
		result.add("lw $fp 0($sp)");
		result.add("jr $ra");
		return result;
	}

}
