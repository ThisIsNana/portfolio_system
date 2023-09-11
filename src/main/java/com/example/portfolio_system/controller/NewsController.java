package com.example.portfolio_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfolio_system.service.ifs.NewsService;
import com.example.portfolio_system.vo.AddNewsRequest;
import com.example.portfolio_system.vo.InactiveNewsRequest;
import com.example.portfolio_system.vo.NewsResponse;
import com.example.portfolio_system.vo.SearchNewsRequest;
import com.example.portfolio_system.vo.UpdateNewsRequest;

@CrossOrigin
@RestController
public class NewsController {

	@Autowired
	private NewsService newsService;
	
//	 ニュース追加
	@PostMapping(value = "add_news")
	public NewsResponse addNews(@RequestBody AddNewsRequest request) {
		return newsService.addNews(request.getNewsTitle(),request.getNewsCategory(), 
				request.getNewsCreateDate(), request.getNewsUpdateDate(),request.getNewsDescription());
	}
	

//	 ニュース表示
	@GetMapping(value = "show_all_news")
	public NewsResponse showAllNews() {
		return newsService.showAllNews();
	}
	
//	 ニュース検索
	@PostMapping(value = "search_news")
	public NewsResponse searchNews(@RequestBody SearchNewsRequest request) {
		return newsService.searchNews(
				request.getTitle(), 
				request.getCategory(), 
				request.getStartDate(), 
				request.getEndDate());
	}
	
//	 單一表示
	@PostMapping(value = "show_one_news")
	public NewsResponse showOneNews(@RequestBody SearchNewsRequest request) {
		return newsService.showOneNews(request.getNewsId());
	}
	
	
//	更新
	@PostMapping(value = "update_news")
	public NewsResponse updateNews(@RequestBody UpdateNewsRequest request) {
		return newsService.updateNews(request.getNewsId(),request.getNewsTitle(),request.getNewsCategory(),request.getNewsDescription(),request.getNewsUpdateDate());
	}
	
//	削除(變更顯示狀態=false)
	@PostMapping(value = "inactive_news")
	public NewsResponse inactiveNews(@RequestBody InactiveNewsRequest request) {
		return newsService.inactiveNews(request.getNewsId(), false);
		
	}
	
//	更新閲覧数
	@PostMapping(value = "update_reading_count")
	public NewsResponse updateReadingCount(@RequestBody UpdateNewsRequest request) {
		return newsService.updateReadingCount(request.getNewsId());
	}
}
