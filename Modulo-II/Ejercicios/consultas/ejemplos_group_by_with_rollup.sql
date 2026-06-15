select fk_asignatura, count(fk_alumno) cant_alumnos, count(nota) cant_notas, avg(nota) media_nota 
from notas
group by fk_asignatura;

-- calcula totales
select fk_asignatura, count(fk_alumno) cant_alumnos, count(nota) cant_notas, avg(nota) media_nota 
from notas
group by fk_asignatura with rollup;

-- al agruparse por mas de una columna, calcula sub-totales y totales
select ciudad, direccion, count(*)
from alumnos
group by ciudad, direccion with rollup;