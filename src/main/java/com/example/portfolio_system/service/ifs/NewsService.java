package com.example.portfolio_system.service.ifs;

import java.time.LocalDate;

import com.example.portfolio_system.entity.News;
import com.example.portfolio_system.vo.NewsResponse;

public interface NewsService {
	
//	新規
	public NewsResponse addNews(News news);

//	全部表示
	public NewsResponse showAllNews();
	
//	檢索
	public NewsResponse searchNews(String title, String category, LocalDate startDate, LocalDate endDate);
	

}
