-- 코드를 입력하세요
with max_f as (SELECT f.category, max(price) as max_price
from food_product f
group by category
)
select m.category, m.max_price, f.product_name
from max_f m
join food_product f on m.category = f.category and m.max_price = f.price
where m.category in ('과자','국','김치','식용유')
order by max_price desc;
