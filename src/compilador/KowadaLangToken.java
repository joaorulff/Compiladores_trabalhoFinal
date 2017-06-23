package compilador;

public class KowadaLangToken {
	
	
	public String type;
	public String value;
	public Integer line;
	public Integer column;
	
	
	public KowadaLangToken(String type, String value, Integer line, Integer column) {
		
		this.type = type;
		this.value = value;
		this.line = line;
		this.column = column;
	}
	
	
	

}
