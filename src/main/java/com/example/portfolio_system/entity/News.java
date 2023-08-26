package com.example.portfolio_system.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id")
	private int newsId;

	@Column(name = "news_title")
	private String newsTitle;

	@Column(name = "news_create_date")
	private LocalDate newsCreateDate;

	@Column(name = "news_update_date")
	private LocalDate newsUpdateDate;

	@Column(name = "news_category")
	private String newsCategory;

	@Column(name = "news_description")
	private String newsDescription;

	@Column(name = "news_reading_count")
	private int newsReadingCount;

	@Column(name = "news_active")
	private boolean newsIsActive;
	
//	=========================================

	public News() {
		super();
	}


	public News(int newsId, String newsTitle, LocalDate newsCreateDate, LocalDate newsUpdateDate, String newsCategory,
			String newsDescription, int newsReadingCount, boolean newsIsActive) {
		super();
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.newsCreateDate = newsCreateDate;
		this.newsUpdateDate = newsUpdateDate;
		this.newsCategory = newsCategory;
		this.newsDescription = newsDescription;
		this.newsReadingCount = newsReadingCount;
		this.newsIsActive = newsIsActive;
	}


//	=========================================


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

	public int getNewsReadingCount() {
		return newsReadingCount;
	}

	public void setNewsReadingCount(int newsReadingCount) {
		this.newsReadingCount = newsReadingCount;
	}

	public boolean isNewsIsActive() {
		return newsIsActive;
	}

	public void setNewsIsActive(boolean newsIsActive) {
		this.newsIsActive = newsIsActive;
	}
	
	
}
