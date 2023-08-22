package com.example.portfolio_system.vo;

import java.util.List;

import com.example.portfolio_system.entity.News;

public class NewsResponse {

	private News news;

	private List<News> newsList;

	private String Message;

//	==================================

	public NewsResponse() {
		super();
	}

	public NewsResponse(News news, String message) {
		super();
		this.news = news;
		Message = message;
	}

	public NewsResponse(String message) {
		super();
		Message = message;
	}

	public NewsResponse(List<News> newsList, String message) {
		super();
		this.newsList = newsList;
		Message = message;
	}

//	==================================

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
