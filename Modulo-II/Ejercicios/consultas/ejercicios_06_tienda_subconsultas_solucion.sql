-- *** BBDD 04_tienda ***
-- *** Subconsultas (En la cláusula WHERE) ***

-- *** Con operadores básicos de comparación ***
-- Devuelve todos los productos del fabricante Lenovo. (Utilizando al menos una subconsulta).
select *
from productos
where fk_fabricante = (select id_fabricante 
						from fabricantes 
                        where lower(fabricante) = 'lenovo');

-- Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. 
	-- (Utilizando al menos una subconsulta).
    
    -- sin usar ningun join
    select *
	from productos
	where precio = (select max(precio)
					from productos
					where fk_fabricante = (select id_fabricante 
											from fabricantes 
											where lower(fabricante) = 'lenovo'
                                            )
					);

    -- usando un join en la subconsulta
	select *
	from productos
	where precio = (select max(precio)
					from productos
					join fabricantes on fk_fabricante = id_fabricante
					where lower(fabricante) = 'lenovo');

-- Lista el nombre del producto más caro del fabricante Lenovo.

	-- con comparación de tuplas
	select *
	from productos
	where (fk_fabricante, precio) = (select id_fabricante, max(precio)
									from productos
									join fabricantes on fk_fabricante = id_fabricante
									where lower(fabricante) = 'lenovo'
									group by id_fabricante);

	-- con subconsulta en el join
	select p.*
	from productos p
	join (select id_fabricante, max(precio) precio_max
			from productos
			join fabricantes on fk_fabricante = id_fabricante
			where lower(fabricante) = 'lenovo'
			group by id_fabricante) precio on p.fk_fabricante = precio.id_fabricante
	where p.precio = precio.precio_max;

-- Lista el nombre del producto más barato del fabricante Hewlett-Packard.
select *
from productos
where (fk_fabricante, precio) = (select id_fabricante, min(precio)
								from productos
								join fabricantes on fk_fabricante = id_fabricante
								where lower(fabricante) = 'hewlett-packard'
                                group by id_fabricante);

-- Devuelve todos los productos de la base de datos que tienen un precio mayor o igual al producto más caro del fabricante Lenovo.
select *
from productos
where precio >= (select max(precio)
						from productos
                        join fabricantes on fk_fabricante = id_fabricante
                        where lower(fabricante) = 'lenovo');
                        
-- Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.
select p.*
from productos p
join (select id_fabricante, avg(precio) precio_medio
		from productos
		join fabricantes on fk_fabricante = id_fabricante
		where lower(fabricante) = 'asus'
		group by id_fabricante) precio on p.fk_fabricante = precio.id_fabricante
where p.precio > precio.precio_medio;
	
    -- también pueden resolverse, algunas de las anteriores y esto con una consulta correlacionada
    select p.*
	from productos p
    join fabricantes f on p.fk_fabricante = f.id_fabricante
    where lower(fabricante) = 'asus'
		and p.precio > (select avg(precio) precio_medio
						from productos
						where fk_fabricante = f.id_fabricante);

-- *** Subconsultas con ALL y ANY ***
-- Devuelve el producto más caro que existe en la tabla producto sin hacer uso de MAX, ORDER BY ni LIMIT.
select *
from productos
where precio >= all (select precio from productos);

-- Devuelve el producto más barato que existe en la tabla producto sin hacer uso de MIN, ORDER BY ni LIMIT.
	-- Por favor, no copiar y pegar del anterior. Volver a pensarlo y escribirlo completo!!!
select *
from productos
where precio <= all (select precio from productos);

-- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando ALL o ANY).
select *
from fabricantes
where id_fabricante = any (select fk_fabricante from productos);

-- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando ALL o ANY).
select *
from fabricantes
where id_fabricante <> all (select fk_fabricante from productos);

-- *** Subconsultas con IN y NOT IN ***
-- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).
select *
from fabricantes
where id_fabricante in (select fk_fabricante from productos);

-- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN).
select *
from fabricantes
where id_fabricante not in (select fk_fabricante from productos);

-- *** Subconsultas con EXISTS y NOT EXISTS ***
-- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).
select *
from fabricantes
where exists (select * from productos where fk_fabricante = id_fabricante);

-- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).
select *
from fabricantes
where not exists (select * from productos where fk_fabricante = id_fabricante);

-- *** Subconsultas correlacionadas ***
-- Lista el nombre de cada fabricante con el nombre y el precio de su producto más caro.
select f.id_fabricante, f.fabricante, p.id_producto, p.producto, p.precio
from fabricantes f
join productos p on f.id_fabricante = p.fk_fabricante
where precio = (select max(precio) from productos where fk_fabricante = f.id_fabricante);

-- Devuelve un listado de todos los productos que tienen un precio mayor o igual a la media de todos los productos de su mismo fabricante.
select p.id_producto, p.producto, p.precio, p.fk_fabricante
from productos p
where precio >= (select avg(precio) from productos where fk_fabricante = p.fk_fabricante);

