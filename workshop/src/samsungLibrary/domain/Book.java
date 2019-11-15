package samsungLibrary.domain;

import java.io.Serializable;

/*
 * 생성자(o), Encapsulation, toString()(o) 적용
 */
public class Book implements Comparable<Book>, Serializable{
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;

	//생성자
	public Book() {}
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	//getter setter
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	//toString
	@Override
	public String toString() {
		return "isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", desc=" + desc +" ";
	}
	@Override
	public int compareTo(Book b) {
		// TODO Auto-generated method stub
		return -(isbn.compareTo(b.getIsbn()));
		//return -(new Integer(price).compareTo(b.getPrice()));
	}








}
