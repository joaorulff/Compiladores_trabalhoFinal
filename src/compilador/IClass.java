package compilador;

public class IClass implements Node{
	
	public Node D, I;

	public IClass(Node d, Node i) {
		super();
		D = d;
		I = i;
	}
	
	public IClass(Node d){
		this.D = d;
	}
	
	

}
