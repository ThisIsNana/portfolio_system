package com.example.portfolio_system.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InactiveNewsRequest {

	@JsonProperty("inactive_news_id")
	private int newsId;

	@JsonProperty("is_news_active")
	private boolean isNewsActive;

//	========================================
	
	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public boolean isNewsActive() {
		return isNewsActive;
	}

	public void setNewsActive(boolean isNewsActive) {
		this.isNewsActive = isNewsActive;
	}
	
}
