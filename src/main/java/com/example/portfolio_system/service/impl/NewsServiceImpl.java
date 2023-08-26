package com.example.portfolio_system.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.portfolio_system.constant.RtnCode;
import com.example.portfolio_system.entity.News;
import com.example.portfolio_system.entity.User;
import com.example.portfolio_system.repository.NewsDao;
import com.example.portfolio_system.service.ifs.NewsService;
import com.example.portfolio_system.vo.NewsResponse;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

//	新增
	@Override
	public NewsResponse addNews(News news) {

		if (news == null) {

			System.out.println("news is null");
			return new NewsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(news.getNewsTitle()) || !StringUtils.hasText(news.getNewsDescription())
				|| !StringUtils.hasText(news.getNewsCategory())) {

			System.out.println("title/description/category is empty");
			return new NewsResponse(RtnCode.CANNOT_EMPTY.getMessage());

		}

//		日期バリデーション
		if (news.getNewsUpdateDate().isBefore(news.getNewsCreateDate())) {

			System.out.println("date error");
			return new NewsResponse(RtnCode.NEWS_DATE_ERROR.getMessage());

		}

//		瀏覽次數歸零
		if (news.getNewsReadingCount() != 0) {

			news.setNewsReadingCount(0);
		}

//		設定為可讀狀態
		if (!news.isNewsIsActive()) {
			news.setNewsIsActive(true);
		}

		newsDao.save(news);
		return new NewsResponse(news, RtnCode.CREATE_NEWS_SUCCESS.getMessage());
	}

//	全部表示(GET)
	@Override
	public NewsResponse showAllNews() {

		List<News> result = newsDao.findAll();

		if (result.size() == 0) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}

		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}

//	檢索
	@Override
	public NewsResponse searchNews(String title, String category, LocalDate startDate, LocalDate endDate) {

		List<News> result = new ArrayList<>();

		if (StringUtils.hasText(title) || StringUtils.hasText(category) || startDate != null || endDate != null) {
//			有任何一個值，就使用Query語法進行搜尋
			result = newsDao.searchNews(title, category, startDate, endDate);

		} else {
//			所有參數皆空，顯示全部結果
			result = newsDao.findAll();
		}

//		搜尋不到結果時，回傳錯誤
		if (result.isEmpty()) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}

		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}

//	單一表示
	@Override
	public NewsResponse showOneNews(int newsId) {
		if (newsId <= 0) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}

		Optional<News> result = newsDao.findById(newsId);
		if (!result.isPresent()) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}

		News res = result.get();

		if (!res.isNewsIsActive()) {
			return new NewsResponse(res, RtnCode.NOT_ACTIVE.getMessage());
		}

		return new NewsResponse(res, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}

//	更新
	@Override
	public NewsResponse updateNews(
			int newsId, 
			String title, 
			String category, 
			String decription, 
			LocalDate updateDate) {

//		防呆
		if(newsId < 0) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
		if(!StringUtils.hasText(title) 
			|| !StringUtils.hasText(decription)
			|| !StringUtils.hasText(category)) {
			return new NewsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		
//		分類不超過兩個
		if(category.split(",").length > 2) {
			return new NewsResponse(RtnCode.CATEGORY_ERROR.getMessage());
		}

		
//		進資料庫搜尋
		Optional<News> result = newsDao.findById(newsId);
		if(!result.isPresent()) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
		News updateNews = result.get();
		
		updateNews.setNewsTitle(title);
		updateNews.setNewsDescription(decription);
		updateNews.setNewsUpdateDate(updateDate);
		updateNews.setNewsCategory(category);
		
		newsDao.save(updateNews);
		return new NewsResponse(updateNews, RtnCode.UPDATE_NEWS_SUCCESS.getMessage());
	}

	

//	變更顯示狀態(目前功能為刪除)
	@Override
	public NewsResponse inactiveNews(int newsId, boolean isActive) {

//		防呆
		if(newsId < 0) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
//		進資料庫搜尋
		Optional<News> result = newsDao.findById(newsId);
		if(!result.isPresent()) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}
		News inactiveNews = result.get();
		
//		變更狀態，回存
		inactiveNews.setNewsIsActive(isActive);
		newsDao.save(inactiveNews);
		return new NewsResponse(inactiveNews, RtnCode.INACTIVE_NEWS_SUCCESS.getMessage());
	}
	
	
	
}
