-- 코드를 입력하세요
-- 온라인
    SELECT
        DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as SALES_DATE,
        PRODUCT_ID,
        USER_ID,
        SALES_AMOUNT
    FROM
        ONLINE_SALE ons
    WHERE YEAR(SALES_DATE) = '2022' 
            AND MONTH(SALES_DATE) = '3'
union
-- 오프라인
    SELECT
        DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as SALES_DATE,
        PRODUCT_ID,
        null as USER_ID,
        SALES_AMOUNT
    FROM
        OFFLINE_SALE ofs
    WHERE YEAR(SALES_DATE) = '2022' 
            AND MONTH(SALES_DATE) = '3'
        
order by SALES_DATE, PRODUCT_ID, USER_ID;