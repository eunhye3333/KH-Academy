package com.kh.practice.generics.model.vo;

public class Fruit extends Farm{
	private String name;
	
	public Fruit() {}
	public Fruit(String kind, String name) {
		super(kind);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return super.toString() + " : " + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		Fruit other = (Fruit)obj;
		if(name == null) {
			if(other.name != null) {
				return false;
			}
		}
		if(!name.equals(other.name)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		
		result = PRIME * result + (name == null ? 0 : name.hashCode());
		
		return result;
	}
}
