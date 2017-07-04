package utils;

public class ID {
	
	public String id;
	public Integer value = null;
	
	
	public ID(String id, int value){
		this.id = id;
		this.value = value;
	}
	
	public ID(String id){
		this.id = id;
	}
	
	public ID(int value){
		this.value = value;
	}
	
}
