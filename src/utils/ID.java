package utils;

import second_level_class.EClass;

public class ID {
	
	public String id;
	public Integer value = null;
	public EClass scopeParent;
	
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
	
	public ID(String id, EClass parent){
		this.id = id;
		this.scopeParent = parent;
	}
}
