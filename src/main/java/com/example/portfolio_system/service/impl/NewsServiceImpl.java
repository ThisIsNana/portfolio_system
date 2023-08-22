package com.example.portfolio_system.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.portfolio_system.constant.RtnCode;
import com.example.portfolio_system.entity.News;
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
			return new NewsResponse(RtnCode.DATE_ERROR.getMessage());

		}

//		瀏覽次數歸零
		if (news.getNewsReadingCount() != 0) {

			news.setNewsReadingCount(0);
		}

		newsDao.save(news);
		return new NewsResponse(news, RtnCode.CREATE_SUCCESS.getMessage());
	}

	
	
//	全部表示(GET)
	@Override
	public NewsResponse showAllNews() {

		List<News> result = newsDao.findAll();

		if (result.size() == 0) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}

		return new NewsResponse(result, RtnCode.SEARCH_SUCCESS.getMessage());
	}
	
	

//	檢索
	@Override
	public NewsResponse searchNews(String title, String category, LocalDate startDate,
			LocalDate endDate) {

		List<News> result = new ArrayList<>();
		
		if(StringUtils.hasText(title) || StringUtils.hasText(category)
			|| startDate != null || endDate != null) {
//			有任何一個值，就使用Query語法進行搜尋
			result = newsDao.searchNews(title, category, startDate, endDate);
			
		}else {
//			所有參數皆空，顯示全部結果
			result = newsDao.findAll();
		}
				
//		搜尋不到結果時，回傳錯誤
		if (result.isEmpty()) {
			return new NewsResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
		return new NewsResponse(result, RtnCode.SEARCH_SUCCESS.getMessage());
	}

}
