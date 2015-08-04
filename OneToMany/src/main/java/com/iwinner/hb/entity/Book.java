package com.iwinner.hb.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book{
	@Id
	@Column(name = "bookid")
	private int bookId;
	
	@Column(name = "bookname", length=10)
	private String bookName;
	
	public int getbookId() {
		return bookId;
	}
	public void setbookId(int bookId) {
		this.bookId = bookId;
	}
	public String getbookName() {
		return bookName;
	}
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}
}