package SemanticAnalysis;

import java.util.ArrayList;
import java.util.HashMap;

import second_level_class.PClass;
import utils.FunctionCall;
import utils.FunctionDeclaration;
import utils.ID;

public class SemanticAnalysis {
	

	public PClass program;
	
	
	public SemanticAnalysis(PClass program){
		this.program = program;
	}
	
	public void checkRuleA() throws Exception{
		/* RULE A: Os identificadores que aparecem em cada função são passados como parâmetros; */
		
		ArrayList<FunctionDeclaration> declarations = program.globalFunctionsDeclared();
		
		//Use Set to improve efficiency
		for (FunctionDeclaration functionDeclaration : declarations) {
			
			ArrayList<ID> parameters = functionDeclaration.args;
			ArrayList<ID> globalParams = program.globalIDsDeclared();
			
			if(globalParams != null && globalParams.size() > 0){
				parameters.addAll(globalParams);
			}
			
			ArrayList<ID> ids = functionDeclaration.scope.getAllUsedIdentifiers();
			
			for (ID id : ids) {
				boolean flag = false;
				for (ID param : parameters) {
					if(id.id.equals(param.id)){
						flag = true;
					}
				}
				if(!flag){
					throw new Exception("Erro ao usar variável não declarada na função: " + functionDeclaration.name);
				}
			}
		}
		return;
	}
	
	public void checkRuleB() throws Exception {
		/* RULE B: As funções chamadas foram definidas e com a quantidade de parâmetros compatível */
		
		ArrayList<FunctionDeclaration> declarations = program.globalFunctionsDeclared();
		
		HashMap<String, Integer> allProgramFunctions = new HashMap<>();
		
		for (FunctionDeclaration functionDeclaration : declarations) {
			allProgramFunctions.put(functionDeclaration.name, functionDeclaration.args.size());	
		}
		
		for (FunctionDeclaration functionDeclaration : declarations) {
			
			ArrayList<FunctionCall> calls = functionDeclaration.scope.getFunctionCalls();
			
			for (FunctionCall functionCall : calls) {
				
				if( !allProgramFunctions.containsKey(functionCall.id) ){
					throw new Exception("A função " + functionCall.id + " não foi declarada");
				}else{
					if( functionCall.numberOfArgs != allProgramFunctions.get(functionCall.id) ){
						throw new Exception("A chamada de função " + functionCall.id + " está com o número errado de parâmetros");
						
					}
				}	
			}	
		}
	}
	
	public void checkRuleC() throws Exception{
		/*RULE C: Não há parâmetros repetidos na declaração da função*/
		
		ArrayList<FunctionDeclaration> declarations = program.globalFunctionsDeclared();
		
		for (FunctionDeclaration functionDeclaration : declarations) {
			
			if(functionDeclaration.checkForRepeatedParamenters()){
				throw new Exception("A declaração da função " + functionDeclaration.name + " possui parâmetros repetidos");
			}
		}
		
		
	}
	
	public void checkRuleD() throws Exception{
		/* RULE D: Não há funções declaradas mais de uma vez */
		
		ArrayList<FunctionDeclaration> declarations = program.globalFunctionsDeclared();
		
		for (FunctionDeclaration functionDeclarationI : declarations) {
			for (FunctionDeclaration functionDeclarationJ : declarations) {
				
				if(functionDeclarationI.name.equals(functionDeclarationJ.name)  && !functionDeclarationI.equals(functionDeclarationJ) ){
					
					throw new Exception("Duas funções declaradas com o mesmo nome: " + functionDeclarationI.name);
				}
			}
		}
		
	}


}
