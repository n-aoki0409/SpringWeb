USE SPRING;

CREATE TABLE IF NOT EXISTS ITEM(
	ITEM_ID INTEGER(5) AUTO_INCREMENT,
	ITEM_NAME VARCHAR(20),
	PRICE INTEGER(6),
	DESCRIPTION VARCHAR(50),
	PICTURE_URL VARCHAR(20),
	PRIMARY KEY (ITEM_ID)
);

DELETE FROM ITEM;
LOAD DATA LOCAL INFILE 'item.csv' 
INTO TABLE ITEM 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n';
QUIT