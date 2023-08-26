package com.example.portfolio_system.vo;

import java.time.LocalDate;

import javax.persistence.Column;

import com.example.portfolio_system.entity.News;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddNewsRequest {


	@JsonProperty("news_title")
	private String newsTitle;

	@JsonProperty("news_create_date")
	private LocalDate newsCreateDate;

	@JsonProperty("news_update_date")
	private LocalDate newsUpdateDate;

	@JsonProperty("news_category")
	private String newsCategory;

	@JsonProperty("news_description")
	private String newsDescription;

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public LocalDate getNewsCreateDate() {
		return newsCreateDate;
	}

	public void setNewsCreateDate(LocalDate newsCreateDate) {
		this.newsCreateDate = newsCreateDate;
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

	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}

}
