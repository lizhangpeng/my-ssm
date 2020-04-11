package com.web.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Book;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.service.TestService;

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
	 
	 @RequestMapping("/videoManag")
	 public String videoManag() {
		 return "videoManag";
	 }
	 
	 
	 @RequestMapping("/addVideo")
	 public String addVideo(@RequestParam(value = "file", required = false) MultipartFile file,
				HttpServletRequest req, HttpServletResponse res) {
			try {
				// 获取当前上下文
				String path = req.getSession().getServletContext().getRealPath("/static/imgs");
				// 文件名称
				String newName = System.currentTimeMillis() + ".png";
				File targetFile = new File(path, newName);
				// 文件夹不存在,则创建文件夹
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				// 保存
				try {
					file.transferTo(targetFile);
				} catch (Exception e) {
					System.out.println(e);
				}


				req.setAttribute("result", "封面上传成功!");
				return "redirect:/videoManag";
			} catch (Exception e) {
				System.out.println(e);
				req.setAttribute("result", "上传失败!");
			}
			return "";

		}
	 
	 
}