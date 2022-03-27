package com.manager;

import com.manager.entity.Cases;
import com.manager.entity.Users;
import com.manager.service.CasesService;
import com.manager.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
public class ManagerApplicationTests {

	@Autowired
	private CasesService bookService;

	@Autowired
	private UserService userService;


	@Test
	public void contextLoads() {
		for (int i = 0; i < 15; i++) {
			Cases book = new Cases();
			book.setMethod("121312"+i);
			book.setAuthor("Jason"+i);
			book.setName("《高等数学必修》"+i);
//			book.setPages(150+i);
//			book.setPrice(15d+i);
			book.setProject("北京邮电出版社分社"+i);
//			cases.setSize(i);
//			book.setTranslate("翻译者"+i);
//			cases.setType(0);
			book.setCreateTime(new Date());
//			bookService.addBook(book);

			Users user = new Users();
			user.setAddress("北京街道"+i);
			user.setAvatar("avatar"+i+".jpg");
			user.setBirthday(new Date());
			user.setEmail("demo"+i+"@163.com");
			user.setIdentity(0);
			user.setIsAdmin(0);
			user.setNickname("admin"+i);
			user.setUsername("admin"+i);
			user.setPassword("123"+i);
			userService.addUser(user);
		}

	}

}
