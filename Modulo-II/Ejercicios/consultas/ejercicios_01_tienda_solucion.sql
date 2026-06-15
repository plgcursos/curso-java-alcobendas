use 04_tienda;
-- Lista el nombre de todos los productos que hay en la tabla producto.
select producto
from productos;

-- Lista los nombres y los precios de todos los productos de la tabla producto.
select producto, precio
from productos;

-- Lista todas las columnas de la tabla producto.
select id_producto, producto, precio, fk_fabricante
from productos;

-- Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD).
select producto, precio EUROS, round(precio * 1.16, 2) USD
from productos;

-- Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD). 
	-- Utiliza los siguientes alias para las columnas: nombre de producto, euros, dólares.
select producto "nombre de producto", precio euros, round(precio * 1.16, 2) dólares
from productos;

-- Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a mayúscula.
select upper(producto), precio
from productos;

-- Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a minúscula.
select lower(producto), precio
from productos;

-- Lista el nombre de todos los fabricantes en una columna, y en otra columna obtenga en mayúsculas los dos primeros caracteres 
	-- del nombre del fabricante.
select fabricante, upper(left(fabricante, 2))
from fabricantes;

-- Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.
select producto, round(precio)
from productos;

-- Lista los nombres y los precios de todos los productos de la tabla producto, truncando el valor del precio para mostrarlo 
	-- sin ninguna cifra decimal.
select producto, truncate(precio, 0)
from productos;

-- Lista el código de los fabricantes que tienen productos en la tabla producto.
select fk_fabricante
from productos;

-- Lista el código de los fabricantes que tienen productos en la tabla producto, eliminando los códigos que aparecen repetidos.
select distinct fk_fabricante
from productos;

-- Lista los nombres de los fabricantes ordenados de forma ascendente.
select fabricante
from fabricantes
order by fabricante;

-- Lista los nombres de los fabricantes ordenados de forma descendente.
select fabricante
from fabricantes
order by fabricante desc;

-- Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar 
	-- por el precio de forma descendente.
select producto
from productos
order by producto, precio desc;

-- Devuelve una lista con las 5 primeras filas de la tabla fabricante.
select id_fabricante, fabricante
from fabricantes
limit 5;

-- Devuelve una lista con 2 filas a partir de la cuarta fila de la tabla fabricante. 
	-- La cuarta fila también se debe incluir en la respuesta.
select id_fabricante, fabricante
from fabricantes
limit 2 offset 3;

-- Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y LIMIT)
select producto, precio
from productos
order by precio
limit 1;

-- Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y LIMIT)
select producto, precio
from productos
order by precio desc
limit 1;

-- Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
select producto, fk_fabricante
from productos
where fk_fabricante = 2;

-- Lista el nombre de los productos que tienen un precio menor o igual a 120€.
select producto, precio
from productos
where precio <= 120;

-- Lista el nombre de los productos que tienen un precio mayor o igual a 400€.
select producto, precio
from productos
where precio >= 140;

-- Lista el nombre de los productos que no tienen un precio mayor o igual a 400€.
select producto, precio
from productos
where precio < 400;

select producto, precio
from productos
where not(precio >= 400);

-- Lista todos los productos que tengan un precio entre 80€ y 300€. Sin utilizar el operador BETWEEN.
select producto, precio
from productos
where precio >= 80 and precio <= 300;

-- Lista todos los productos que tengan un precio entre 60€ y 200€. Utilizando el operador BETWEEN.
select producto, precio
from productos
where precio between 60 and 200;

-- Lista todos los productos que tengan un precio mayor que 200€ y que el código de fabricante sea igual a 6.
select producto, precio, fk_fabricante
from productos
where precio > 200 and fk_fabricante = 6;

-- Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Sin utilizar el operador IN.
select producto, fk_fabricante
from productos
where fk_fabricante = 1 or fk_fabricante = 3 or fk_fabricante = 5;

-- Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador IN.
select producto, fk_fabricante
from productos
where fk_fabricante in (1, 3, 5);

-- Lista el nombre y el precio de los productos en céntimos (Habrá que multiplicar por 100 el valor del precio). 
	-- Cree un alias para la columna que contiene el precio que se llame céntimos.
select producto, precio * 100 céntimos
from productos;

-- Lista los nombres de los fabricantes cuyo nombre empiece por la letra S.
select id_fabricante, fabricante
from fabricantes
where left(fabricante, 1) = 'S';

select id_fabricante, fabricante
from fabricantes
where fabricante like 'S%';

-- Lista los nombres de los fabricantes cuyo nombre termine por la vocal e.
select id_fabricante, fabricante
from fabricantes
where right(fabricante, 1) = 'e';

select id_fabricante, fabricante
from fabricantes
where fabricante like '%e';

-- Lista los nombres de los fabricantes cuyo nombre contenga el carácter w.
select id_fabricante, fabricante
from fabricantes
where position('w' in fabricante) != 0;

select id_fabricante, fabricante
from fabricantes
where fabricante like '%w%';

-- Lista los nombres de los fabricantes cuyo nombre sea de 4 caracteres.
select id_fabricante, fabricante
from fabricantes
where length(fabricante) = 4;

select id_fabricante, fabricante
from fabricantes
where fabricante like '____';

-- Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil en el nombre.
select id_producto, producto
from productos
where lower(producto) like '%portatil%';

-- Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre 
	-- y tienen un precio inferior a 215 €.
select id_producto, producto
from productos
where lower(producto) like '%monitor%' and precio < 215;

-- Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€. 
	-- Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
select id_producto, producto, precio
from productos
where precio >= 180
order by precio desc, producto;
