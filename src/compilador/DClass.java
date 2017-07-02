package compilador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DClass extends Node {

	public String definedFn;
	public Integer qttParams;
	
	public DClass(Token id, Node args, Node e) throws Exception{
		this.definedFn = id.value;
		this.nodes = Arrays.asList(args, e);
		this.qttParams = this.countParams(args);
	}
	
	private int countParams(Node args) throws Exception{
		int count = 0;
		Set<String> argSet = new HashSet<String>();
		Node currentNode = args;
		while(currentNode != null) {
			count++;
			if(!argSet.add(((ArgsClass) currentNode).id)) {
				throw new Exception("Parametros repetidos.");
			}
			if(currentNode.nodes.size() > 0) {
				currentNode = currentNode.nodes.get(0);
			} else {
				currentNode = null;
			}
		}
		return count;
	}
	
	@Override
	public String getResult() {
		String result = this.definedFn;
		for(Node n:nodes) {
			result += n.getResult();
		}
		System.out.println("D:  " + result);
		
		analyzeDef();
		
		return result;
	}
	
	public void analyzeDef(){
		
		ArrayList<String> listOfArgs = new ArrayList<>();
		
		ArgsClass args = (ArgsClass)nodes.get(0);
		EClass e = (EClass)nodes.get(1);
		
		while(args != null){
			
			listOfArgs.add(args.id);

			if( args.nodes.size() > 0 ){
				args = (ArgsClass)args.nodes.get(0);
			}else{
				args = null;
			}
		}
		
		while(e != null){
			
			
			
		}
		

}
