-- Modificar la tabla empleados de la BBDD 05_empleados

alter table empleados
add column fk_jefe int,
add foreign key(fk_jefe) references empleados(id_empleado);


	-- Agregarle una columna fk_jefe y cargar id para referenciar el jefe a cada uno

-- hay que agregarle a mano las fk
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '6' WHERE (`id_empleado` = '1');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '6' WHERE (`id_empleado` = '13');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '6' WHERE (`id_empleado` = '7');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '1' WHERE (`id_empleado` = '3');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '1' WHERE (`id_empleado` = '12');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '1' WHERE (`id_empleado` = '9');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '7' WHERE (`id_empleado` = '4');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '7' WHERE (`id_empleado` = '5');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '7' WHERE (`id_empleado` = '10');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '13' WHERE (`id_empleado` = '11');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '13' WHERE (`id_empleado` = '8');
UPDATE `05_empleados`.`empleados` SET `fk_jefe` = '7' WHERE (`id_empleado` = '2');

-- Listado de empleados con su jefe
select e.id_empleado, e.nombre, e.apellido1, e.apellido2, j.id_empleado id_jefe, j.nombre nom_jefe, j.apellido1 ape1_jefe, j.apellido2 ape2_jefe
from empleados e
join empleados j on e.fk_jefe = j.id_empleado;

-- Listado de empleados con su jefe y el departamente al que pertenece
select e.id_empleado, e.nombre, e.apellido1, e.apellido2, d.id_departamento, d.departamento,  j.id_empleado id_jefe, j.nombre nom_jefe, j.apellido1 ape1_jefe, j.apellido2 ape2_jefe
from empleados e
join empleados j on e.fk_jefe = j.id_empleado
join departamentos d on e.fk_departamento = d.id_departamento;

-- Listado de Jefes con la cantidad de gente a cargo
select j.id_empleado id_jefe, j.nombre nom_jefe, j.apellido1 ape1_jefe, j.apellido2 ape2_jefe, count(e.id_empleado) cant_empls
from empleados e
join empleados j on e.fk_jefe = j.id_empleado
group by j.id_empleado;

-- Listado de Jefes con la cantidad de gente a cargo y el departamento al que pertence el jefe
select j.id_empleado id_jefe, j.nombre nom_jefe, j.apellido1 ape1_jefe, j.apellido2 ape2_jefe, d.id_departamento, d.departamento, count(e.id_empleado) cant_empls
from empleados e
join empleados j on e.fk_jefe = j.id_empleado
left join departamentos d on j.fk_departamento = d.id_departamento
group by j.id_empleado;

-- Listado de Jefes con su gente a cargo
select j.id_empleado id_jefe, j.nombre nom_jefe, j.apellido1 ape1_jefe, j.apellido2 ape2_jefe, e.id_empleado, e.nombre, e.apellido1, e.apellido2
from empleados e
join empleados j on e.fk_jefe = j.id_empleado
order by j.id_empleado;

-- Listado de Jefes con su gente a cargo, incluyendo el departamento del jefe y el de cada uno de sus empleados
select j.id_empleado id_jefe, j.nombre nom_jefe, j.apellido1 ape1_jefe, j.apellido2 ape2_jefe, d_j.id_departamento id_dpto_jefe, d_j.departamento dpto_jefe, e.id_empleado, e.nombre, e.apellido1, e.apellido2, d_e.id_departamento id_dpto_emp, d_e.departamento dpto_emp
from empleados e
join empleados j on e.fk_jefe = j.id_empleado
left join departamentos d_j on j.fk_departamento = d_j.id_departamento
left join departamentos d_e on e.fk_departamento = d_e.id_departamento
order by j.id_empleado;

select * from empleados;