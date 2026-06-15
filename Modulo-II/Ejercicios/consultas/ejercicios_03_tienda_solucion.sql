-- *** BBDD 04_tienda ***
-- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
select p.producto, p.precio, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante;

-- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. 
	-- Ordene el resultado por el nombre del fabricante, por orden alfabético.
select p.producto, p.precio, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
order by f.fabricante;

-- Devuelve una lista con el código del producto, nombre del producto, código del fabricante y nombre del fabricante, 
	-- de todos los productos de la base de datos.
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante;

-- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
order by precio
limit 1;

-- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
order by precio desc
limit 1;

-- Devuelve una lista de todos los productos del fabricante Lenovo.
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where f.fabricante = 'Lenovo';

select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) = 'lenovo';

-- Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) = 'crucial' and p.precio > 200;

-- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate. 
	-- Sin utilizar el operador IN.
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) = 'lenovo' or lower(f.fabricante) = 'hewlett-packard' or lower(f.fabricante) = 'seagate';

-- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate. 
	-- Utilizando el operador IN.
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) in ('lenovo', 'hewlett-packard', 'seagate');

-- Devuelve un listado con el nombre y el precio de todos los productos de los fabricantes 
	-- cuyo nombre termine por la vocal e.
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) like '%e';

-- Devuelve un listado con el nombre y el precio de todos los productos cuyo nombre de fabricante 
	-- contenga el carácter w en su nombre.
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) like '%w%';

-- Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos 
	-- que tengan un precio mayor o igual a 180€. Ordene el resultado en primer lugar por el precio (en orden descendente)
    -- y en segundo lugar por el nombre (en orden ascendente)
select p.id_producto, p.producto, p.precio, f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where p.precio > 180
order by p.precio desc, p.producto;

-- Devuelve un listado con el código y el nombre de fabricante, solamente de aquellos fabricantes que tienen productos 
	-- asociados en la base de datos.
select distinct f.id_fabricante, f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante;

-- NO -- Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene
	-- cada uno de ellos. El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
-- NO -- Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.

-- Calcula el número total de productos que hay en la tabla productos.
select count(*) cant
from productos;

-- Calcula el número total de fabricantes que hay en la tabla fabricante.
select count(*) cant
from fabricantes;

-- Calcula el número de valores distintos de código de fabricante aparecen en la tabla productos.
select count(distinct fk_fabricante) cant
from productos;

-- Calcula la media del precio de todos los productos.
select round(avg(precio), 2) media
from productos;

-- Calcula el precio más barato de todos los productos.
select min(precio) precio_min
from productos;

-- Calcula el precio más caro de todos los productos.
select max(precio) precio_max
from productos;

-- Lista el nombre y el precio del producto más barato.
select id_producto, producto, precio
from productos
order by precio
limit 1;

-- Lista el nombre y el precio del producto más caro.
select id_producto, producto, precio
from productos
order by precio desc
limit 1;

-- Calcula la suma de los precios de todos los productos.
select sum(precio) suma_precio
from productos;

-- Calcula el número de productos que tiene el fabricante Asus.
select count(*) cant
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) = 'asus';

-- Calcula la media del precio de todos los productos del fabricante Asus.
select round(avg(p.precio), 2) media
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) = 'asus';

-- Calcula el precio más barato de todos los productos del fabricante Asus.
select min(p.precio) precio_min
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) = 'asus';

-- Calcula el precio más caro de todos los productos del fabricante Asus.
select max(p.precio) precio_max
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) = 'asus';

-- Calcula la suma de todos los productos del fabricante Asus.
select sum(p.precio) sum_precio
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) = 'asus';

-- Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
select max(p.precio) max_precio, min(p.precio) min_precio, avg(p.precio) avg_precio, count(*) cant
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where lower(f.fabricante) = 'crucial';

-- NO -- Muestra el número total de productos que tiene cada uno de los fabricantes. El listado también debe incluir 
	-- los fabricantes que no tienen ningún producto. El resultado mostrará dos columnas, 
    -- una con el nombre del fabricante y otra con el número de productos que tiene. 
    -- Ordene el resultado descendentemente por el número de productos.
    
-- Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes. 
	-- El resultado mostrará el nombre del fabricante junto con los datos que se solicitan.
select f.id_fabricante, f.fabricante, max(p.precio) max_precio, min(p.precio) min_precio, avg(p.precio) avg_precio
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
group by f.id_fabricante;

-- Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes 
	-- que tienen un precio medio superior a 200€. No es necesario mostrar el nombre del fabricante, 
    -- con el código del fabricante es suficiente.
select p.fk_fabricante id_fabricante, max(p.precio) max_precio, min(p.precio) min_precio, avg(p.precio) avg_precio, count(*) cant
from productos p
group by p.fk_fabricante
having avg_precio > 200;

-- Muestra el nombre de cada fabricante, junto con el precio máximo, precio mínimo, precio medio y el número total 
	-- de productos de los fabricantes que tienen un precio medio superior a 200€. 
    -- Es necesario mostrar el nombre del fabricante.
select f.id_fabricante, f.fabricante, max(p.precio) max_precio, min(p.precio) min_precio, avg(p.precio) avg_precio, count(*) cant
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
group by p.fk_fabricante
having avg_precio > 200;

-- Calcula el número de productos que tienen un precio mayor o igual a 180€.
select count(*) cant
from productos
where precio > 180;

-- Calcula el número de productos que tiene cada fabricante con un precio mayor o igual a 180€.
select fk_fabricante id_fabricante, count(*) cant
from productos
where precio > 180
group by fk_fabricante;

-- Lista el precio medio los productos de cada fabricante, mostrando solamente el código del fabricante.
select fk_fabricante id_fabricante, round(avg(precio), 2) avg_precio
from productos
group by fk_fabricante;

-- Lista el precio medio los productos de cada fabricante, mostrando solamente el nombre del fabricante.
select f.fabricante, round(avg(p.precio), 2) avg_precio
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
group by fk_fabricante;

-- Lista los nombres de los fabricantes cuyos productos tienen un precio medio mayor o igual a 150€.
select f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
group by fk_fabricante
having avg(p.precio) >= 150;

-- Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
select f.fabricante
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
group by fk_fabricante
having count(*) >= 2;

-- Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio 
	-- superior o igual a 220 €. No es necesario mostrar el nombre de los fabricantes que no tienen productos 
    -- que cumplan la condición.
select f.fabricante, count(*) cant_prods
from productos p
join fabricantes f on p.fk_fabricante = f.id_fabricante
where p.precio > 220
group by fk_fabricante;


