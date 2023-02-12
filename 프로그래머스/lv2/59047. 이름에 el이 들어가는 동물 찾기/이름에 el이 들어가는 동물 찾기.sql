-- 코드를 입력하세요
SELECT animal_id, name
from animal_ins
where animal_type like 'dog'and name like '%el%'
order by name