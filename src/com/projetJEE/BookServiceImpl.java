package com.projetJEE;

import java.util.List;

public class BookServiceImpl implements BookService {
	private BookDAO bookDao = new BookDAOMockImpl();
	@Override
	public List<Book> getAllBooks() {
		return bookDao.findByAll();
	}
	@Override
	public List<Book> getBooksByTitle(String title) {
		return bookDao.findByTitle(title);
	}

}
