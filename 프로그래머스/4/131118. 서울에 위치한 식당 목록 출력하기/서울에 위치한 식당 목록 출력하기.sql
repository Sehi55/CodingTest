-- 코드를 입력하세요
SELECT i.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(AVG(r.review_score),2) AS SCORE from REST_INFO i join REST_REVIEW r ON i.rest_id = r.rest_id
where i.address like "서울%"
group by i.REST_ID
order by score desc, favorites desc;