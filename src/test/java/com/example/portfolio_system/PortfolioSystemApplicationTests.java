package com.example.portfolio_system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.portfolio_system.entity.News;
import com.example.portfolio_system.entity.User;
import com.example.portfolio_system.service.ifs.NewsService;
import com.example.portfolio_system.service.ifs.UserService;

@SpringBootTest
class PortfolioSystemApplicationTests {
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private UserService userService;
	
	
//	新規
	@Test
	public void addNewsTest() {
		News news = new News();
		news.setNewsTitle("test4");
		news.setNewsCreateDate(LocalDate.now());
		news.setNewsUpdateDate(LocalDate.now());
		news.setNewsCategory("緊急");
		news.setNewsReadingCount(0);
		news.setNewsDescription("News・News・News");
		newsService.addNews(news);
	}
	
//	表示
	@Test
	public void findAllNewsTest() {
		 List<News> result = newsService.showAllNews().getNewsList();
		 System.out.println(result.size());
	}
	
//	檢索
	@Test
	public void searchNewsTest() {
		
		List<News> newsList = new ArrayList<>();
		
		LocalDate startDate = LocalDate.of(2023, 7, 20);
		LocalDate endDate = LocalDate.of(2023, 8, 16);
		
		newsList = newsService.searchNews(null, null, null, null).getNewsList();
		System.out.println(newsList.size());
		
		newsList = newsService.searchNews("", "", null, null).getNewsList();
		System.out.println(newsList.size());
		
		newsList = newsService.searchNews("test1", null, null, null).getNewsList();
		System.out.println(newsList.size());
		
		newsList = newsService.searchNews(null, "緊急", null, null).getNewsList();
		System.out.println(newsList.size());

		newsList = newsService.searchNews("", "",startDate , null).getNewsList();
		System.out.println(newsList.size());

		newsList = newsService.searchNews("", "",null , endDate).getNewsList();
		System.out.println(newsList.size());
		
		newsList = newsService.searchNews("", "",startDate , endDate).getNewsList();
		System.out.println(newsList.size());
	}
	
//	使用者追加
	@Test
	public void addUserTest() {
		
		User user = new User();
		
		user.setUserAccount("AA0000002");
		user.setUserPassword("AA0000002");
		user.setUserName("使用者AA2");
		
		userService.addUser(user);
		System.out.println("完成");
	}
	

}
