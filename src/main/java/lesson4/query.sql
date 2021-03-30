SELECT
    v1.name_fld AS 'фильм 1',
    v1.start_time_fld AS 'время начала',
    v1.duration_fld AS 'длительность',
    v2.name_fld AS 'фильм 2',
    v2.start_time_fld AS 'время начала',
    v2.duration_fld AS 'длительность',
    @deff_time:=TIMESTAMPDIFF(MINUTE,
                              v1.start_time_fld,
                              v2.start_time_fld) - v1.duration_fld AS 'длительность перерыва',
    IF(@deff_time < 30,
       'ошибка в расписании',
       '') AS 'errors'
FROM
    schedule_viev v1
        LEFT JOIN
    schedule_viev v2 ON v2.num = v1.num + 1
ORDER BY @deff_time ASC
;