package codeGeneration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import second_level_class.PClass;
import utils.FunctionDeclaration;
import utils.ID;
import utils.MIPSVar;

public class CodeGenerator {
	
	public static PClass program;
	
	public static Integer currentTemporaryRegister = 0;
	public static HashMap<String, MIPSVar> registersTable = new HashMap<>(); 
	
	public static List<String> generateCode(PClass currentProgram){
		program = currentProgram;
		List<String> commands = new ArrayList<>();
		commands.addAll(generateInitialCode());
		commands.addAll(program.generateCode());
		commands.add("li $v0, 1");
		commands.add("add $a0, $a0, $zero");
		commands.add("syscall");
		return commands;
	}
	
	public static String getNextRegister(){
		String nextRegister = "$t" + currentTemporaryRegister;
		currentTemporaryRegister++;
		return nextRegister;
	}
	
	public static void insertNewUsedRegister(String highLevelID, String register, int value){
		MIPSVar mipsVar = new MIPSVar(highLevelID, register, value);
		registersTable.put(highLevelID, mipsVar);
	}
	
	public static void printHash(){
		for(String key : registersTable.keySet()){
			System.out.println(key + " REGISTER: " + registersTable.get(key).mipsRegister + " VALUE: " + registersTable.get(key).value);
		}
	}
	
	public static ArrayList<String> generateInitialCode(){
		ArrayList<String> commands = new ArrayList<>();
		
		ArrayList<ID> globalIDs = program.globalIDsDeclared();
		commands.add("sw $fp 0($sp)");
		commands.add("addiu $sp $sp -4");
		for(int i = globalIDs.size()-1; i>=0; i--){
		
			commands.add("li $a0 "+globalIDs.get(i).value);
			commands.add("sw $a0 0($sp)");
			commands.add("addiu $sp $sp -4");
		}
		
		String firstFunction = program.globalFunctionsDeclared().get(0).name;
		commands.add("jal " + firstFunction + "_entry");
		
		return commands;
	}
	
	

}
