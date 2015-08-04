package com.iwinner.hb.entity;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@Column(name = "studentid")
	private int studentId;

	@Column(name = "studentname", length = 10)
	private String studentName;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Book.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_studentid", referencedColumnName = "studentid")
	private Set book;

	public int getstudentId() {
		return studentId;
	}

	public void setstudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getstudentName() {
		return studentName;
	}

	public void setstudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set getbook() {
		return book;
	}

	public void setbook(Set book) {
		this.book = book;
	}
}