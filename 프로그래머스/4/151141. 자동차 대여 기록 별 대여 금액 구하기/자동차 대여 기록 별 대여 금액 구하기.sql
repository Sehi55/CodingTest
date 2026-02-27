select h.history_id , truncate(c.daily_fee * (datediff(h.end_date, h.start_date)+1)*((100-IFNULL(p.discount_rate,0))/100),0) as fee
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
join CAR_RENTAL_COMPANY_CAR c on h.car_id = c.car_id
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.car_type = p.car_type
and p.duration_type = (
    select duration_type from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where datediff(h.end_date,h.start_date)+1 >= cast(REGEXP_REPLACE(duration_type, '[^0-9]','')AS UNSIGNED)
    order by cast(REGEXP_REPLACE(duration_type, '[^0-9]','')AS UNSIGNED) desc
    LIMIT 1
)
where c.car_type = '트럭'
order by fee desc, h.history_id desc;