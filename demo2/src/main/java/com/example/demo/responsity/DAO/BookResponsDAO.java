package com.example.demo.responsity.DAO;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.models.Book;

public interface BookResponsDAO {
	public List<Book> getAll() throws SQLException;
}
