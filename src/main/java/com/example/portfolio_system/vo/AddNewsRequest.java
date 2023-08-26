package com.example.portfolio_system.vo;

import com.example.portfolio_system.entity.News;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddNewsRequest {

	@JsonProperty("news")
	private News news;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	

}
