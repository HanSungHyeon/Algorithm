-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum (o.SALES_AMOUNT * p.PRICE) as sales
from PRODUCT p
join OFFLINE_SALE o on o.PRODUCT_ID = p.PRODUCT_ID
group by p.PRODUCT_CODE
order by sales desc, p.product_code

