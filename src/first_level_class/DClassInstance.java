package first_level_class;

import java.util.ArrayList;
import java.util.List;

import compilador.Token;
import second_level_class.ArgsClass;
import second_level_class.DClass;
import second_level_class.EClass;
import utils.FunctionDeclaration;
import utils.ID;

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

		ArrayList<ID> args = this.args.getArgs();
		ArrayList<ID> usedIDs = this.scope.getAllUsedIdentifiers();
		for (ID id : usedIDs) {
			for (ID arg : args) {
				if(id.id.equals(arg.id)){
					id.scopeParent.setIndex((args.indexOf(arg)) + 1);
				}
			}
		}
		
		result.addAll(this.scope.generateCode());
		result.add("lw $ra 4($sp)");
		result.add("addiu $sp $sp " + this.z);
		result.add("lw $fp 0($sp)");
		result.add("jr $ra");
		return result;
	}

}
