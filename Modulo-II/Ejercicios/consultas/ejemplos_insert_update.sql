describe departamentos;

insert into departamentos (departamento) values ('Fisica');

insert into departamentos values (NULL, 'Matematica Discreta');

create table prueba(
	a varchar(25) primary key,
    b varchar(25),
    c varchar(25) not null,
	d varchar(25)
);


insert into prueba values ('uno', 'dos'); -- NO FUNCIONA POR LA CANTIDAD DE COLUMNAS

insert into prueba values ('uno', 'dos', NULL, NULL); -- NO FUNCIONA PORQUE EL TERCERO ES NOT NULL

insert into prueba values ('uno', 'dos', 'tres', NULL); -- OK

insert into prueba (a, c) values ('segundo', 'algo');

alter table prueba change a nuevo varchar(25);

describe prueba;

alter table prueba add nueva int; -- agrega la columna al final
alter table prueba add primera int first; -- agrega la columna al principio
alter table prueba add otra_mas int after c; -- agrega la columna despues de c


CREATE TABLE `empleados_prueba` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nif` varchar(9) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) DEFAULT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `nif` (`nif`)
);

insert into empleados_prueba (select NULL, nif, nombre, apellido1, apellido2, coalesce(departamento, 'SIN ASIGNAR')
								from 05_empleados.empleados emp
                                left join 05_empleados.departamentos dpto on emp.fk_departamento = dpto.id_departamento);

select * from empleados_prueba;

update empleados_prueba set departamento = upper(departamento) where departamento = 'sin asignar';