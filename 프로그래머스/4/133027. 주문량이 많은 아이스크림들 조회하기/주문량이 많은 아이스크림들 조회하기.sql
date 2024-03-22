-- 코드를 입력하세요
SELECT
    fh.FLAVOR
from 
    FIRST_HALF fh
join 
    JULY j on fh.FLAVOR = j.FLAVOR
group by
    fh.FLAVOR
order by
    sum(fh.total_order) desc
limit 3;