package com.example.portfolio_system.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchNewsRequest {
	
	@JsonProperty("show_new_id")
	private int newsId;

	@JsonProperty("search_title")
	private String title;

	@JsonProperty("search_category")
	private String category;

	@JsonProperty("search_start_date")
	private LocalDate startDate;

	@JsonProperty("search_end_date")
	private LocalDate endDate;
	
//	==========================================

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	
	
}
