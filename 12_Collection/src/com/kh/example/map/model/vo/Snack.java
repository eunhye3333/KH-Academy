package com.kh.example.map.model.vo;

public class Snack {
	private String flavor;
	private int price;
	public Snack() {}
	public Snack(String flavor, int price) {
		this.flavor = flavor;
		this.price = price;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return flavor + "[" + price + "¿ø]";
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
		
		Snack other = (Snack)obj;
		if(flavor == null) {
			if(other.flavor != null) {
				return false;
			}
		} else if(!flavor.equals(other.flavor)) {
			return false;
		}
		
		if(price != other.price) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (flavor == null ? 0: flavor.hashCode());
		result = PRIME * result + price;
		return result;
	}
}
