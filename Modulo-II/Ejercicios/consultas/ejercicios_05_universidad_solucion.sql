-- *** BBDD 06_universidad ***
use 06_universidad;
-- Obtener el nombre completo de los alumnos que estén cursando "Matematica Discreta"
select a.id_alumno, a.nombre, a.apellido1, a.apellido2
from alumnos a 
join notas n on a.id_alumno = n.fk_alumno
join asignaturas asig on n.fk_asignatura = asig.id_asignatura
where lower(asig.asignatura) = 'matematica discreta';

-- Obtener el nombre completo y la nota obtenida de los alumnos que hayan cursado "Matematica Discreta"
select a.id_alumno, a.nombre, a.apellido1, a.apellido2, n.nota
from alumnos a 
join notas n on a.id_alumno = n.fk_alumno
join asignaturas asig on n.fk_asignatura = asig.id_asignatura
where lower(asig.asignatura) = 'matematica discreta';

-- Obtener el listado de profesores de la Factultad de "Informatica"
select distinct p.id_profesor, p.apellido1, p.apellido2, p.nombre
from profesores p
join asignaturas a on p.id_profesor = a.fk_profesor
where lower(a.facultad) = 'informatica';

-- Obtener la cantidad de alumnos por ciudad
select ciudad, count(*) cant_alumnos
from alumnos
group by ciudad;

-- Obtener el nombre completo y edad de todos los alumnos
select a.id_alumno, a.nombre, a.apellido1, a.apellido2, timestampdiff(year, a.fecha_nacimiento, now()) edad
from alumnos a;

-- Obtener las edades de los alumnos que cursan asignaturas
select distinct a.id_alumno, a.nombre, a.apellido1, a.apellido2, timestampdiff(year, a.fecha_nacimiento, now()) edad
from alumnos a
join notas on a.id_alumno = fk_alumno;

-- Obtener las notas medias de los alumnos por edad
select distinct timestampdiff(year, a.fecha_nacimiento, now()) edad, round(avg(nota), 3) nota_media
from alumnos a
join notas on a.id_alumno = fk_alumno
group by edad;

-- Obtener los datos de los alumnos que no cursan ninguna asignatura ni tienen ninguna nota
select distinct a.id_alumno, a.nombre, a.apellido1, a.apellido2
from alumnos a
left join notas on a.id_alumno = fk_alumno
where fk_alumno is null;

-- Cantidad de notas y media de notas de cada alumno
select a.id_alumno, a.nombre, a.apellido1, a.apellido2, count(nota) cant_notas, round(avg(nota), 3) nota_media
from alumnos a
join notas on a.id_alumno = fk_alumno
group by a.id_alumno;

-- Listado de profesores con la cantidad de asignaturas que imparte cada uno de ellos, aunque ahora no estén impartiendo ninguna.
select id_profesor, apellido1, apellido2, nombre, count(id_asignatura) cant_asignaturas
from profesores
left join asignaturas on id_profesor = fk_profesor
group by id_profesor;

-- Notas medias por asignaturas que imparte cada profesor
select id_profesor, apellido1, apellido2, nombre, id_asignatura, asignatura, avg(nota) nota_media
from profesores
join asignaturas on id_profesor = fk_profesor
join notas on id_asignatura = fk_asignatura
group by id_profesor, id_asignatura
order by id_profesor, id_asignatura;

-- Mostrar, de la Asignatura “Programacion I”, la nota máxima, mínima y la diferencia entre ambas. 
   -- Devolver también el número de alumnos que la han cursado.
select id_asignatura, asignatura, max(nota) nota_maxima, min(nota) nota_minima, (max(nota) - min(nota)) delta_nota, count(fk_alumno) cant_alumnos
from asignaturas
join notas on id_asignatura = fk_asignatura
where lower(asignatura) = 'programacion i'
group by id_asignatura;

-- Obtener de Cada profesor las asignaturas que imparte, con los alumnos en cada una de ellas y su nota
select  p.id_profesor, p.apellido1, p.apellido2, p.nombre, a.id_asignatura, a.asignatura, alu.id_alumno , alu.apellido1, alu.apellido2, n.nota
from profesores p
join asignaturas a on p.id_profesor = a.fk_profesor
join notas n on a.id_asignatura = n.fk_asignatura
join alumnos alu on n.fk_alumno = alu.id_alumno
order by id_profesor, id_asignatura, id_alumno;

-- *** Subconsultas ***
-- Cantidad de alumnos matriculados en más de dos asignaturas

		-- cantidad de asignaturas por alumno
        select fk_alumno, count(fk_asignatura) cant_asig
        from notas
        group by fk_alumno;

		-- quedarme sólo con los que tengan más de dos
        select fk_alumno, count(fk_asignatura) cant_asig
        from notas
        group by fk_alumno
        having cant_asig > 2;        
        -- contarlos
        select count(*)
        from (select fk_alumno, count(fk_asignatura) cant_asig
			from notas
			group by fk_alumno
			having cant_asig > 2) cantidades;

-- Cantidad de alumnos aprobados por ciudad, usando una subconsulta
select ciudad, count(id_alumno) cant
from alumnos
where id_alumno in (select fk_alumno
					from notas
                    where nota >= 5)
group by ciudad
order by ciudad;

-- Notas de las asignaturas de cada uno de los alumnos comparada con la nota media de la asignatura
select id_alumno, nombre, apellido1, apellido2, id_asignatura, asignatura, nota, medias.media media
from alumnos
join notas on id_alumno = fk_alumno
join asignaturas on fk_asignatura = id_asignatura
join (select fk_asignatura, avg(nota) media
      from notas
      group by fk_asignatura) medias on id_asignatura = medias.fk_asignatura
where nota is not null
order by id_alumno, id_asignatura;

-- con subconsulta correlacionada en el select
select id_alumno, nombre, apellido1, apellido2, asig.id_asignatura, asig.asignatura, nota, (select avg(nota) media
																				  from notas
																				  where fk_asignatura = asig.id_asignatura) media
from alumnos
join notas on id_alumno = fk_alumno
join asignaturas asig on fk_asignatura = asig.id_asignatura
where nota is not null
order by id_alumno, asig.id_asignatura;

-- Alumnos que están cursando asignaturas con los profesores de Málaga (subconsulta en JOIN)
select distinct a.*
from alumnos a
join notas n on a.id_alumno = n.fk_alumno
join (select distinct fk_asignatura
      from notas
      join asignaturas on fk_asignatura = id_asignatura
      join profesores on fk_profesor = id_profesor
      where lower(ciudad) = 'malaga') profes on n.fk_asignatura = profes.fk_asignatura;

-- otras opciones mejores
select distinct a.*
from alumnos a
join notas n on a.id_alumno = n.fk_alumno
where n.fk_asignatura in (select distinct fk_asignatura
						  from notas
						  join asignaturas on fk_asignatura = id_asignatura
						  join profesores on fk_profesor = id_profesor
						  where lower(ciudad) = 'malaga');

-- exists, usa una subconsulta correlacionada
select distinct a.*
from alumnos a
where exists (select *
			  from notas
			  join asignaturas on fk_asignatura = id_asignatura
			  join profesores on fk_profesor = id_profesor
			  where lower(ciudad) = 'malaga' and fk_alumno = a.id_alumno);

-- Nota media por asignatura, sólo aquéllas que la nota media sea mayor a la nota media del alumnos con dni 55630078R
	-- nota media del alumno con dni 55630078R
    select avg(nota)
    from notas
    join alumnos on fk_alumno = id_alumno
    where upper(dni) = '55630078R';
    
select a.id_asignatura, a.asignatura, avg(nota) media
from asignaturas a
join notas on a.id_asignatura = fk_asignatura
group by a.id_asignatura
having media > (select avg(nota)
				from notas
				join alumnos on fk_alumno = id_alumno
				where upper(dni) = '55630078R'
                );