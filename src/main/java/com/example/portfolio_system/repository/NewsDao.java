package com.example.portfolio_system.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.portfolio_system.entity.News;

@Repository
public interface NewsDao extends JpaRepository<News, Integer> {
	
//	用JPQL來取代冗長的JPA:)
	@Query("SELECT n FROM News n WHERE " +
		       "(:title IS NULL OR n.newsTitle LIKE %:title%) AND " +
		       "(:category IS NULL OR n.newsCategory LIKE %:category%) AND " +
		       "(:startDate IS NULL OR n.newsUpdateDate >= :startDate) AND " +
		       "(:endDate IS NULL OR n.newsUpdateDate <= :endDate)")
		List<News> searchNews(
		    @Param("title") String title, 
		    @Param("category") String category, 
		    @Param("startDate") LocalDate startDate, 
		    @Param("endDate") LocalDate endDate
		);
	
	
////	搜尋標題
//	public List<News> findByNewsTitleContaining(String title);
//
////	搜尋分類
//	public List<News> findByNewsCategoryContaining(String category);
//
////	搜尋標題+分類
//	public List<News> findByNewsTitleContainingAndNewsCategoryContaining(String title, String category);
//
//	
////	搜尋更新日期(某天之前)
//	public List<News> findByNewsUpdateDateBefore(LocalDate Date);
//
////	搜尋更新日期(某天之後)
//	public List<News> findByNewsUpdateDateAfter(LocalDate Date);
//
////	搜尋更新日期(某天~某天之間)
//	public List<News> findByNewsUpdateDateBetween(LocalDate startDate, LocalDate endDate);
//	
//	
////	搜尋標題+更新日期(某天之前)
//	public List<News> findByNewsTitleContainingAndNewsUpdateDateBefore(String title, LocalDate Date);
//
////	搜尋標題+更新日期(某天之後)
//	public List<News> findByNewsTitleContainingAndNewsUpdateDateAfter(String title, LocalDate Date);
//
////	搜尋標題+更新日期(某天~某天之間)
//	public List<News> findByNewsTitleContainingAndNewsUpdateDateBetween(String title, LocalDate startDate, LocalDate endDate);
//
//	
////	搜尋分類+更新日期(某天之前)
//	public List<News> findByNewsCategoryContainingAndNewsUpdateDateBefore(String category, LocalDate Date);
//
////	搜尋分類+更新日期(某天之後)
//	public List<News> findByNewsCategoryContainingAndNewsUpdateDateAfter(String category, LocalDate Date);
//
////	搜尋分類+更新日期(某天~某天之間)
//	public List<News> findByNewsCategoryContainingAndNewsUpdateDateBetween(String category, LocalDate startDate, LocalDate endDate);
//
//	
////	搜尋分類+標題+更新日期(某天之前)
//	public List<News> findByNewsTitleContainingAndNewsCategoryContainingAndNewsUpdateDateBefore(String title, String category, LocalDate Date);
//
////	搜尋分類+標題+更新日期(某天之後)
//	public List<News> findByNewsTitleContainingAndNewsCategoryContainingAndNewsUpdateDateAfter(String title, String category, LocalDate Date);
//
////	搜尋分類+標題+更新日期(某天~某天之間)
//	public List<News> findByNewsTitleContainingAndNewsCategoryContainingAndNewsUpdateDateBetween(String title, String category, LocalDate startDate, LocalDate endDate);

	
}
