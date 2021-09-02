package com.kh.practice.list.library.model.vo;

public class Book implements Comparable<Book> {
	private String title;
	private String author;
	private String category;
	private int price;
	
	public Book() {}
	public Book(String title, String author, String category, int price) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "	(" + title + "/" + author + "/" + category + "/" + price + ")";
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
		
		Book other = (Book)obj;
		if(title == null) {
			if(other.title != null) {
				return false;
			}
		} else if(!title.equals(other.title)) {
			return false;
		}
		
		if(author == null) {
			if(other.author != null) {
				return false;
			}
		} else if(!author.equals(other.author)) {
			return false;
		}
		
		if(category == null) {
			if(other.category != null) {
				return false;
			}
		} else if(!category.equals(other.category)) {
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
		result = PRIME * result + (title == null ? 0 : title.hashCode());
		result = PRIME * result + (author == null ? 0 : author.hashCode());
		result = PRIME * result + (category == null ? 0 : category.hashCode());
		result = PRIME * result + price;
		
		return result;
	}
	
	@Override
	public int compareTo(Book o) {
		return title.compareTo(o.title);
	}
	
	
	
	
}
