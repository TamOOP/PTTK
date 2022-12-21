package com.example.PTTK.responsity.DAO;

import java.sql.SQLException;
import java.util.List;

import com.example.PTTK.models.Book;

public interface BookResponsDAO {
	public List<Book> getAll() throws SQLException;
}
