-- case con condiciones
select 
	id_alumno, 
    nombre, 
    apellido1,
    id_asignatura,
    asignatura,
    nota,
	case
		when nota < 5 then 'SUSPENSO'
		when nota >= 5 and nota < 7 then 'APROBADO'
		when nota >= 7 and nota < 9 then 'NOTABLE'
		when nota >= 9 then 'SOBRESALIENTE'
        else 'CURSANDO'
	end as nota
from alumnos
join notas on id_alumno = fk_alumno
join asignaturas on fk_asignatura = id_asignatura;

use 07_jardineria;
select * from pedidos;
select distinct estado from pedidos;  -- Entregado / Rechazado / Pendiente

-- contar los pedidos por estado con group by
	-- una fila por estado
select estado, count(*) cant
from pedidos
group by estado;

-- contar algunos estados en diferentes columnas
select
	sum(case estado when 'Entregado' then 1 else 0 end) entregados,
	sum(case estado when 'Rechazado' then 1 else 0 end) rechazados,
	sum(case estado when 'Pendiente' then 1 else 0 end) pendientes
from pedidos;


-- notas por edades de los alumnos
select timestampdiff(year, fecha_nacimiento, now()) edad, count(*) alumnos_totales, count(nota) cant_notas, avg(nota) nota_media
from alumnos
join notas on id_alumno = fk_alumno
group by edad
order by edad;

-- notas por grupo de edades. Separados en peques, medios, mayores
select
	case
		when timestampdiff(year, fecha_nacimiento, now()) <= 27 then 'A - Peques'
        when timestampdiff(year, fecha_nacimiento, now()) >= 29 then 'C - Mayores'
        else 'B - Medios'
	end as edad,
    count(*) alumnos_totales,
    count(nota) cant_notas,
    avg(nota) nota_media
from alumnos
join notas on id_alumno = fk_alumno
group by edad
order by edad;
