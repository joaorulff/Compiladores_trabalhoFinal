package codeGeneration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import second_level_class.PClass;
import utils.MIPSVar;

public class CodeGenerator {
	
	public static PClass program;
	
	public static Integer currentTemporaryRegister = 0;
	public static HashMap<String, MIPSVar> registersTable = new HashMap<>(); 
	
	public static List<String> generateCode(PClass currentProgram){
		program = currentProgram;
		return program.generateCode();
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

}
