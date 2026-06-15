-- datediff solo devuelve la diferencia en días
-- timestampdiff se le puede indicar en qué las devuelva
-- now() devuelve la fecha y hora actual
-- current_date() devuelve la fecha actual

select datediff(now(), '2000/04/11') / 365.25;

select timestampdiff(year, '2000/04/10', now());

select current_date(), now();


set @f = '2000/04/11';

select 
	timestampdiff(year, @f, now()) años, 
    timestampdiff(month, @f, now()) meses, 
    timestampdiff(day, @f, now()) días, 
    timestampdiff(hour, @f, now()) horas, 
    timestampdiff(minute, @f, now()) minutos, 
    timestampdiff(second, @f, now()) segundos;