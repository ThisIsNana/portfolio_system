
#新增資料庫
CREATE SCHEMA IF NOT EXISTS `portfolio_system` ;

#新增news表格+欄位
CREATE TABLE IF NOT EXISTS `portfolio_system`.`news` (
  `news_id` INT NOT NULL AUTO_INCREMENT,
  `news_title` VARCHAR(200) NOT NULL,
  `news_create_date` DATE NOT NULL,
  `news_update_date` DATE NOT NULL,
  `news_category` VARCHAR(200) NOT NULL,
  `news_description` VARCHAR(2000) NOT NULL,
  `news_reading_count` INT NOT NULL DEFAULT 0,
  `news_active1` TINYINT NOT NULL DEFAULT 1 
  PRIMARY KEY (`news_id`));
