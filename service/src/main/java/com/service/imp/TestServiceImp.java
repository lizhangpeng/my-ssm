package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookDAO;

import com.entity.Book;

import com.service.TestService;

@Service
public class TestServiceImp implements TestService  {

	@Autowired
	private BookDAO dao;
	
	public List<Book>  getData() {
		// TODO Auto-generated method stub
		return dao.getAllBooks();
	}

}
