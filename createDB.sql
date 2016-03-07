/***********************************************************************************************************************************************
* Created By - Shilpita Roy
* Created On - 18Feb2016
* COEN 280 HW03 Part 1 DLL CreatDB script for Yelp Application Database
*************************************************************************************************************************************************/


CREATE TABLE BUSINESS(
      business_id VARCHAR2(50)
      ,full_address VARCHAR2(500)
      ,is_open VARCHAR2(30)
      --,categories VARCHAR2(1000)
      ,city VARCHAR2(30)
      ,review_count NUMBER
      ,business_name VARCHAR2(1000)
      --,neighborhoods VARCHAR2(1000)
      ,state VARCHAR2(50)
      ,stars FLOAT
      ,latitude FLOAT
      ,attributes CLOB
      ,type VARCHAR2(50)
      ,PRIMARY KEY (business_id)
);



CREATE TABLE YELP_USER (
    yelping_since VARCHAR2(20)
    ,review_count NUMBER
    ,name VARCHAR2(50)
    ,user_id VARCHAR2(50)
    ,total_friends NUMBER
    ,friends CLOB
    ,fans NUMBER
    ,average_stars FLOAT
    ,type VARCHAR2(20)
    ,compliments VARCHAR2(2000)
    ,funny_votes NUMBER
    ,useful_votes NUMBER
    ,cool_votes NUMBER
    ,total_votes NUMBER
    ,PRIMARY KEY (user_id)
);





CREATE TABLE ELITE(
    user_id VARCHAR2(50),
    elite_year  NUMBER
    ,primary key (user_id, elite_year)
    ,foreign key (user_id) references YELP_USER(user_id)
    ON DELETE CASCADE
);



CREATE TABLE OPERATION(
       business_id VARCHAR2(50)
      ,day VARCHAR2(50)
      ,close VARCHAR2(20)
      ,open VARCHAR2(20)
      ,primary key (business_id, day)
      ,foreign key (business_id) references BUSINESS(business_id)
      ON DELETE CASCADE
     );


CREATE TABLE BUSINESS_NEIGHBORHOOD(
       business_id VARCHAR2(50)
      ,neighborhoods VARCHAR2(200)
      ,primary key (business_id, neighborhoods)
      ,foreign key (business_id) references BUSINESS(business_id)
      ON DELETE CASCADE
);     
 
   
CREATE TABLE SUB_CATEGORY(
     business_id VARCHAR2(50)
    ,categories VARCHAR(50)
    ,subcategories VARCHAR(50)
 --   ,primary key (business_id,categories, subcategories)
    ,foreign key (business_id) references BUSINESS(business_id)
     ON DELETE CASCADE
);


CREATE TABLE REVIEWS(
    review_id VARCHAR2(50)
    ,user_id VARCHAR2(50)
    ,business_id VARCHAR2(50)
    ,stars NUMBER
    ,text CLOB
    ,publish_date VARCHAR2(30)
    ,funny NUMBER
    ,useful NUMBER
    ,cool NUMBER
    ,total_votes NUMBER
    ,type VARCHAR2(50)
    ,primary key (review_id,business_id)
    ,foreign key (business_id) references BUSINESS(business_id)
    ON DELETE CASCADE
);


CREATE TABLE CHECKINS(
    business_id VARCHAR2(50)
    ,day_index NUMBER 
    ,day VARCHAR2(50)
    ,from_hour NUMBER
    ,to_hour NUMBER
    ,checkin_count number
    ,type VARCHAR2(50)
    ,primary key (business_id,day,from_hour,to_hour)
    ,foreign key (business_id) references BUSINESS(business_id)
    ON DELETE CASCADE
);



---ALTER TABLE YELP_USER ADD elite VARCHAR2(200);

/*
-- DROP TABLE VOTES;

CREATE TABLE VOTES(
user_id VARCHAR2(50),
funny NUMBER,
useful NUMBER,
cool NUMBER
,primary key (user_id)
,foreign key (user_id) references YELP_USER(user_id)
ON DELETE CASCADE
);


--DROP TABLE FRIENDS;
CREATE TABLE FRIENDS(
user_id VARCHAR2(50),
friend  VARCHAR2(50)
,primary key (user_id, friend)
,foreign key (user_id) references YELP_USER(user_id)
ON DELETE CASCADE
);
*/
