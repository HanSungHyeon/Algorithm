-- 코드를 입력하세요
SELECT p.product_code as product_code , sum(p.price * o.sales_amount) as sales
from PRODUCT p
join OFFLINE_SALE o on p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_ID
order by sales desc, product_code asc