package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Book;
import com.service.TestService;
import com.service.imp.TestServiceImp;

@Controller
public class TestController {
   private static final String TEST="test";
   
   @Autowired
   TestService tTestService;
   
     @ResponseBody
	 @RequestMapping("/test")
	 public String test(){
		 List<Book> mybatis_tests=tTestService.getData();
		 for (Book book : mybatis_tests) {
			System.out.println(book.getTitle());
		}
		 return mybatis_tests.toString();
	 }
     
     
	 @RequestMapping("/testmvc")
	 public String testmvc(){
		 return TEST;
	 }
}