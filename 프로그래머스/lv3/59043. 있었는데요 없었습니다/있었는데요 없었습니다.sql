-- 코드를 입력하세요
SELECT
    o.ANIMAL_ID,
    o.NAME
from
    ANIMAL_OUTS o
inner join
    ANIMAL_INS i on i.ANIMAL_ID = o.ANIMAL_ID
where
    TIMESTAMPDIFF(second, i.datetime,o.datetime) < 0
order by 
    i.DATETIME

    