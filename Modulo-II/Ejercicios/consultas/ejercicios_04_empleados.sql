-- Modificar la tabla empleados de la BBDD 05_empleados
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
-- Listado de empleados con su jefe y el departamente al que pertenece
-- Listado de Jefes con la cantidad de gente a cargo
-- Listado de Jefes con la cantidad de gente a cargo y el departamento al que pertence el jefe
-- Listado de Jefes con su gente a cargo
-- Listado de Jefes con su gente a cargo, incluyendo el departamento del jefe y el de cada uno de sus empleados
