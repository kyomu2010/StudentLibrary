package com.msmart.concurrency.model;

import java.util.Random;

import com.msmart.concurrency.constants.Constants;

public class Student implements Runnable {

	private int id;
	private Book[] books;

	public Student(int id, Book[] books) {
		this.id = id;
		this.books = books;
	}

	@Override
	public void run() {
		
		Random random = new Random();
		
		while (true) {
			
			// randomly select a book
			int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
			
			try {
				books[bookId].read(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Student #" + id;
	}
}
