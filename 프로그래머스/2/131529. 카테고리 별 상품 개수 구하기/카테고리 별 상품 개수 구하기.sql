select
    left(product_code, 2) as CATEGORY, count(*) as proucts
from
    product
group by
    CATEGORY;
    