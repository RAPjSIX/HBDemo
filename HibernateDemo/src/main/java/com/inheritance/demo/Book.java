package com.inheritance.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@ Table(name = "BookFiction")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "Type")
//@DiscriminatorValue(value = "B")
public class Book{
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}
	
	@Id
	@GeneratedValue
	@Column(name="BookID")
	private int bookId;
	private String bookName;
	private float bookPrice;	
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Book() {
	}
}
@Entity
@ Table(name = "FictionBook")

class FictionBook extends Book{
	//@PrimaryKeyJoinColumn
	private String publication;
	private int pageNo;
	
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}