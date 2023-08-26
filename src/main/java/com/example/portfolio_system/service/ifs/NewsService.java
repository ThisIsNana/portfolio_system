package com.example.portfolio_system.service.ifs;

import java.time.LocalDate;

import com.example.portfolio_system.entity.News;
import com.example.portfolio_system.entity.User;
import com.example.portfolio_system.vo.NewsResponse;

public interface NewsService {
	
	
//	新規
	public NewsResponse addNews(News news);

//	全部表示
	public NewsResponse showAllNews();
	
//	單一表示
	public NewsResponse showOneNews(int newsId);
	
//	檢索
	public NewsResponse searchNews(String title, String category, LocalDate startDate, LocalDate endDate);
	
//	更新
	public NewsResponse updateNews(int newsId, String title, String category, String decription, LocalDate updateDate);

//	刪除
	public NewsResponse inactiveNews(int newsId, boolean isActive);
	
}
