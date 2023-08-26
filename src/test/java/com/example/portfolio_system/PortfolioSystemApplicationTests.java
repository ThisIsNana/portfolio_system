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
		newsService.addNews("test4", "緊急,新聞", LocalDate.now(), LocalDate.now(), 
				"新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容<br>新聞內容新聞內容<br>"
				+ "新聞內容新聞內容新聞內容新聞內容<br>新聞內容新聞內容");
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
	
//	更新
	@Test
	public void updateNewsTest() {
		
		LocalDate date = LocalDate.now();
		newsService.updateNews(5, "", null,"", date);
		
//		隨便找的一篇文章
		newsService.updateNews(2, "JT子会社を「戦争支援企業」に　ウクライナ政府「侵略国支えてる」", "緊急,アンケート", 
				"ウクライナ政府は24日、日本たばこ産業（JT）の子会社「JTインターナショナル」"
				+ "（JTI）を「戦争支援企業」のリストに加えたと発表した。「ロシアでビジネスを続けて多額の税金を納め"
				+ "、侵略国の経済を支えている」と批判している。\r\n"
				+ "\r\n"
				+ "　リストに日本企業が入るのは初めて。JTは取材に、ウクライナ政府の決定を承知しているとした上で、"
				+ "「ウクライナにおける我々の事業は通常通り行われ、我々はウクライナ経済への貢献、"
				+ "支援を必要とする人びとへの援助の提供を続けていく」とコメントした。\r\n"
				+ "\r\n"
				+ "　ウクライナ政府の発表によると、JTIはロシアでウィンストンやメビウスといったブランドを展開。"
				+ "たばこ市場で34・9%のシェアを占め、「過去20年間でロシア経済への投資額は46億ドル（約6700億円）を超えた」という。"
				, date);
	}
	
//	變更新聞顯示(目前功能為刪除)
	@Test
	public void inactiveNewsTest() {
		newsService.inactiveNews(2, false);
		System.out.println("完成");
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
