-- faster --
SELECT t1.Id
FROM Weather t1
INNER JOIN Weather t2
ON TO_DAYS(t1.RecordDate) = TO_DAYS(t2.RecordDate) + 1
WHERE t1.Temperature > t2.Temperature;


SELECT
    weather.Id AS 'Id'
FROM
    Weather
        JOIN
    Weather w ON DATEDIFF(Weather.RecordDate, w.RecordDate) = 1
        AND weather.Temperature > w.Temperature
;