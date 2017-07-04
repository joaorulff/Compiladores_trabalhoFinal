package codeGeneration;

import second_level_class.PClass;

public class CodeGenerator {
	
	public static PClass program;
	
	public static Integer currentTemporaryRegister = 0;
	
	public static void generateCode(PClass currentProgram){
		
		program = currentProgram;
		program.generateCode();
	}
	
	
	public static String getNextRegister(){
		
		String nextRegister = "$t" + currentTemporaryRegister;
		currentTemporaryRegister++;
		return nextRegister;
		
	}

}
