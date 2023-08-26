package com.example.portfolio_system.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateNewsRequest {
	
	@JsonProperty("update_news_id")
	private int newsId;

	@JsonProperty("update_title")
	private String newsTitle;

	@JsonProperty("update_description")
	private String newsDescription;

	@JsonProperty("update_update_date")
	private LocalDate newsUpdateDate;

	@JsonProperty("update_category")
	private String newsCategory;

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}

	public LocalDate getNewsUpdateDate() {
		return newsUpdateDate;
	}

	public void setNewsUpdateDate(LocalDate newsUpdateDate) {
		this.newsUpdateDate = newsUpdateDate;
	}

	public String getNewsCategory() {
		return newsCategory;
	}

	public void setNewsCategory(String newsCategory) {
		this.newsCategory = newsCategory;
	}


}
