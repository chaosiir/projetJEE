package com.projetJEE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {


	@Override
	public List<Book> findByAll() {
		ArrayList<Book> books = new ArrayList<>();
		try {
			Connection con = DBManager.getInstance().getConnection();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select * from books");
			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				int id = rs.getInt("id");
				books.add(new Book(id, title, author));
			}
		} catch (SQLException e) {
			System.out.print("coucou");
		}
		return books;
	}

	@Override
	public List<Book> findByTitle(String txt) {
		ArrayList<Book> books = new ArrayList<>();
		try {
			Connection con = DBManager.getInstance().getConnection();
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select * from books where title like \"%"+txt+"%\";");
			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				int id = rs.getInt("id");
				books.add(new Book(id, title, author));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

}
