-- alumnos que no cursan ninguna asignatura
select a.*
from alumnos a
left join notas on a.id_alumno = fk_alumno
where fk_asignatura is null;

select a.*
from alumnos a
where a.id_alumno not in(select fk_alumno from notas);

select a.*
from alumnos a
where a.id_alumno != all (select fk_alumno from notas);

select a.*
from alumnos a
where not exists (select * from notas where fk_alumno = id_alumno);