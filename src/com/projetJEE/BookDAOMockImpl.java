package com.projetJEE;

import java.util.ArrayList;
import java.util.List;

public class BookDAOMockImpl implements BookDAO {

	public List<Book> findByAll() {
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book(0,"t0","a0"));
		books.add(new Book(1,"t1","a1"));
		return books;
	}

	@Override
	public List<Book> findByTitle(String txt) {
		ArrayList<Book> books = new ArrayList<Book>();
		return books;
	}

}
