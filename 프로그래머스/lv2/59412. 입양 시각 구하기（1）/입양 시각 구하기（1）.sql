-- 코드를 입력하세요
SELECT hour(DATETIME) as HOUR, count(*) as 'COUNT'
from ANIMAL_OUTS
group by hour(DATETIME)
having hour >= 9 and hour < 20
order by hour asc;
