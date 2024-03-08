-- 코드를 작성해주세요
select 
    d.id,
    d.email,
    d.FIRST_NAME,
    d.LAST_NAME
from
    DEVELOPER_INFOS d
where
    d.skill_1 = 'Python' or
    d.skill_2 = 'Python' or
    d.skill_3 = 'Python'
order by
    d.id;
    