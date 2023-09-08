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

//	建立SQL
	@Test
	public void createSqlTest() {
		
	}
	
	
	
	
//	新規
	@Test
	public void addNewsTest() {
		newsService.addNews("test1", "緊急,新聞", LocalDate.now(), LocalDate.now(), 
				"新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容<br>新聞內容新聞內容<br>"
				+ "新聞內容新聞內容新聞內容新聞內容<br>新聞內容新聞內容");

		newsService.addNews("アンケートtest", "重要,アンケート", LocalDate.now(), LocalDate.now(), 
				"新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容新聞內容<br>新聞內容新聞內容<br>"
				+ "新聞內容新聞內容新聞內容新聞內容<br>新聞內容新聞內容");

		newsService.addNews("千葉と伊豆諸島で線状降水帯　台風13号が東日本上陸へ、大雨に警戒", "緊急,新聞", LocalDate.now(), LocalDate.now(), 
				"台風13号（インニョン）は8日午後、東日本にかなり接近して上陸する見通しだ。"
				+ "気象庁は午前8時前に伊豆諸島南部、同10時に千葉県北西部と南部、同10時20分ごろに北東部で線状降水帯が発生したと発表。"
				+ "東海や関東甲信、東北地方では、9日にかけて雷を伴う大雨となる恐れがある。<br>"
				+ "<br>"
				+ "大雨、いつ避難すれば？　参考になるサイトの使い方、Q＆Aで解説<br>"
				+ "線状降水帯予測、まずすべきことは　気象予報士・防災士にきいた<br>"
				+ "　気象庁によると、台風13号は8日午前9時時点で、静岡県御前崎市の南南西約190キロをゆっくりと北に進んでいる。<br>"
				+ "中心気圧は996ヘクトパスカル。中心付近の最大風速は23メートル、最大瞬間風速は35メートル。");

		newsService.addNews("「映画監督か育児か」　選択迫られた私、8年ぶりの新作に込めた願い", "普通,新聞", LocalDate.now(), LocalDate.now(), 
				"米国やイタリアなど世界の映画界で活躍する女性監督や俳優が集結し、女性が主人公の七つの短編物語で構成した映画「私たちの声」が公開中だ。"
				+ "日本からは「きみはいい子」以来8年ぶりの監督作となる呉美保（おみぽ）監督（46）と俳優の杏さん（37）が参加した。"
				+ "なぜ、呉監督が新作を撮るのに8年もかかったのか。短編のストーリーそのものとも地続きのその理由は、映画界の現状を浮き彫りにする。");

		newsService.addNews("アップル、時価総額28兆円消失　中国の「iPhone禁止」報道で", "緊急,アンケート", LocalDate.now(), LocalDate.now(), 
				"時価総額で世界首位の米アップルの株式が売り込まれ、7日までの2日間で約1900億ドル（約28兆円）分の時価総額が消失した。"
				+ "中国政府がiPhone（アイフォーン）の利用を禁止したとの報道を受け、主要市場での販売に懸念が広がった。<br>"
				+ "<br>"
				+ "　アップル株は7日までの2日間で約6%下落した。日本で2番目に大きいソニーの時価総額（約16兆円）を上回る価値が2日間で吹き飛んだことになる。");
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
