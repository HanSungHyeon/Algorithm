SELECT
    c.car_id,
    c.car_type,
    round((c.DAILY_FEE * (1- (p.discount_rate * 0.01))) * 30, 0) as fee
from
    (select *
    from CAR_RENTAL_COMPANY_CAR 
    where CAR_TYPE like '세단' or CAR_TYPE like 'SUV') c
join 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY h on h.car_id = c.car_id
join 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on p.car_type = c.car_type
where c.car_id not in (
    select distinct h.car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    WHERE h.START_DATE<='2022-11-30' AND h.END_DATE>='2022-11-01'
) and
    (c.DAILY_FEE * (1- (p.discount_rate * 0.01))) * 30 >= 500000 and 
    (c.DAILY_FEE * (1- (p.discount_rate * 0.01))) * 30 < 2000000 and
    p.DURATION_TYPE like '30%'
group by
    c.car_id
order by
    fee desc, c.car_type, c.car_id desc