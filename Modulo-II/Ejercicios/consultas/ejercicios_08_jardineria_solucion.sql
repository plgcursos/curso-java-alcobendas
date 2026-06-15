-- *** BBDD 07_jardineria ***

-- 1 Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina 
	-- a la que pertenece el representante.
select id_cliente, nombre_cliente, id_empleado, nombre, apellido1, apellido2, id_oficina, oficina
from clientes
join empleados on fk_empleado_rep_ventas = id_empleado
join oficinas on fk_oficina = id_oficina
where not exists (select * from pagos where fk_cliente = id_cliente);

-- 2 Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.
select id_cliente, nombre_cliente
from clientes
where not exists (select * from pagos where fk_cliente = id_cliente)
	and not exists (select * from pedidos where fk_cliente = id_cliente);

select distinct id_cliente, nombre_cliente
from clientes
left join pagos p on id_cliente = p.fk_cliente
left join pedidos ped on id_cliente = ped.fk_cliente
where p.id_transaccion is null or ped.id_pedido is null;

-- 3 Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago.
	-- con exists (recomendada)
    select *
    from clientes
    where exists (select * from pagos where fk_cliente = id_cliente);

	-- con in (igual que =any)  
    select *
    from clientes
    where id_cliente in (select distinct fk_cliente from pagos);
    
    -- con join
    select distinct c.*
    from clientes c
    join pagos p on c.id_cliente = p.fk_cliente;
      
    
-- 4 Calcula el número de clientes que tiene la empresa.
	-- Calculamos los clientes que han realizado alguna compra.
    select count(distinct fk_cliente) cant
    from pedidos;
    
-- 5 Devuelve el nombre del producto que tenga el precio de venta más caro.
select *
from productos
where precio_venta = (select max(precio_venta) from productos);

-- con >= all
-- es importante tener en cuenta que el precio_venta está definido como not null, si no fueras así, la subconsulta
	-- sería (select precio_venta from productos where precio_venta is not null)
select *
from productos
where precio_venta >= all (select precio_venta from productos);

-- 6 Devuelve un listado indicando todas las ciudades donde hay oficinas y el número de empleados que tiene.
select ciudad, count(id_empleado) cant_empleados
from oficinas
join empleados on id_oficina = fk_oficina
group by ciudad;

-- 7 Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos 
	-- que no han sido entregados a tiempo.
select id_pedido, fk_cliente, fecha_esperada, fecha_entrega
from pedidos
where datediff(fecha_esperada, fecha_entrega) < 0;

	-- si incluimos los que no han sido entregados y la fecha_esperada ya ha pasado:
	select id_pedido, fk_cliente, fecha_esperada, fecha_entrega
	from pedidos
	where datediff(fecha_esperada, fecha_entrega) < 0
		or fecha_entrega is null and datediff(fecha_esperada, current_date) < 0;

-- 8 Devuelve un listado de los productos que nunca han aparecido en un pedido.
	select *
    from productos
    where not exists (select * from detalles_pedido where fk_producto = id_producto);
    
-- 9 Calcula el número de clientes que no tiene asignado representante de ventas.
select count(*) cant
from clientes 
where fk_empleado_rep_ventas is null;

-- 10 Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
	-- en realidad que no esté asignados como representantes de ventas
    select id_empleado, nombre, apellido1, apellido2, puesto
    from empleados
    where not exists (select * from clientes where fk_empleado_rep_ventas = id_empleado);
    
-- 11 Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código 
	-- de empleado 11 o 30.
    select *
    from clientes
    where lower(ciudad) = 'madrid'
		and fk_empleado_rep_ventas in (11, 30);
    
-- 12 Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
select id_empleado, nombre, apellido1, apellido2, puesto
from empleados 
where fk_jefe is null;

-- 13 Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago, 
	-- utilizando una subconsulta
select *
from clientes
where exists (select * from pedidos where fk_cliente = id_cliente)
	and not exists (select * from pagos where fk_cliente = id_cliente);
    
-- 14 Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene el resultado de mayor a menor.
select *
from pagos
where year(fecha_pago) = 2008
and lower(forma_pago) = 'paypal'
order by total desc;

-- 15 Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean representante de ventas de ningún cliente, utilizando una subconsulta
select id_empleado, nombre, apellido1, apellido2, puesto, o.telefono
from empleados
join oficinas o on fk_oficina = o.id_oficina
where not exists (select * from clientes where fk_empleado_rep_ventas = id_empleado);
    
-- 16 Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.
select *
from clientes
join empleados on fk_empleado_rep_ventas = id_empleado
where exists (select * from pagos where fk_cliente = id_cliente);

-- 17 Devuelve el nombre del producto del que se han vendido más unidades. (Tenga en cuenta que tendrá que calcular cuál es el número 
	-- total de unidades que se han vendido de cada producto a partir de los datos de la tabla detalle_pedido)

	-- calcular la cantidad mas vendida
		-- primero calculamos la cantidad vendida por cada producto
        select fk_producto, sum(cantidad) cant
        from detalles_pedido
        group by fk_producto;
		
        -- ahora calculamos el valor maximo
        select max(cant) cant_mayor
        from (select fk_producto, sum(cantidad) cant
			from detalles_pedido
			group by fk_producto) cantidades;

	-- ahora buscamos los productos de los cuales se vendieron esa cantidad
    select id_producto, nombre, sum(cantidad) cant
    from productos
    join detalles_pedido on id_producto = fk_producto
    group by id_producto
    having cant = (select max(cant) cant_mayor
							from (select fk_producto, sum(cantidad) cant
								from detalles_pedido
								group by fk_producto) cantidades);

    select id_producto, nombre, sum(cantidad) cant
    from productos
    join detalles_pedido on id_producto = fk_producto
    group by id_producto
    having cant = (select sum(cantidad) cant_mayor
					from detalles_pedido
                    group by fk_producto
                    having cant_mayor >= all (select sum(cantidad)
								from detalles_pedido
								group by fk_producto));

	-- utilizando rank() over(...) 
    select fk_producto, sum(cantidad) cant,
						rank() over(order by sum(cantidad) desc) rank_, 
						dense_rank() over(order by sum(cantidad) desc) dense_rank_,
						percent_rank() over(order by sum(cantidad) desc) percent_rank_,
						row_number() over(order by sum(cantidad) desc) row_number_
	from detalles_pedido
	group by fk_producto; 

	select id_producto, nombre
	from productos
	join (select fk_producto, rank() over(order by sum(cantidad) desc) ranking
			from detalles_pedido
			group by fk_producto) rankings on id_producto = fk_producto
	where ranking = 1;

	select id_producto, nombre
	from productos
	where (id_producto, 1) in (select fk_producto, rank() over(order by sum(cantidad) desc) ranking
			from detalles_pedido
			group by fk_producto);

-- 18 Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.

	-- modificacion de la tabla para que tenga sentido la consulta
	alter table empleados
	modify fk_oficina int unsigned null;

	alter table empleados
	add constraint empleados_oficinas foreign key(fk_oficina) references oficinas(id_oficina);

	update empleados set fk_oficina = null where id_empleado = 31;
	update empleados set fk_oficina = null where id_empleado = 1;


select *
from empleados e
where not exists (select * from oficinas where id_oficina = e.fk_oficina)
	and not exists (select * from clientes where fk_empleado_rep_ventas = e.id_empleado);

-- 20 ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?
select count(*) cant
from clientes
where lower(ciudad) = 'madrid';

-- 21 Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
select id_oficina, ciudad
from oficinas;

-- 22 Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.
select *
from empleados e
left join empleados j on e.fk_jefe = j.id_empleado
where not exists (select * from clientes where fk_empleado_rep_ventas = e.id_empleado);
	-- si no ponemos left join no sale el Director General

-- 23 Devuelve el producto que más unidades tiene en stock.
select *
from productos 
where cantidad_en_stock = (select max(cantidad_en_stock) from productos);

-- 24 Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.
select *
from clientes
join empleados on fk_empleado_rep_ventas = id_empleado
where not exists (select * from pagos where fk_cliente = id_cliente);

-- 25 Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
select id_oficina, ciudad, telefono
from oficinas
where lower(pais) = 'españa';

-- 26 La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el total facturado. 
	-- La base imponible se calcula sumando el precio_unidad del producto por el número de unidades vendidas de la tabla detalle_pedido. 
    -- El IVA es el 21 % de la base imponible, y el total la suma de los dos campos anteriores.
select sum(cantidad * precio_unidad) base_imponible, sum(cantidad * precio_unidad) * 0.21 IVA, sum(cantidad * precio_unidad) * 1.21 Total
from detalles_pedido;

	-- con subconsulta en el from
	select base_imponible, base_imponible * 0.21 IVA, base_imponible * 1.21 Total
	from (select sum(cantidad * precio_unidad) base_imponible from detalles_pedido) facturacion;

-- 27 Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
select *
from empleados
where fk_jefe = 7;  

-- 28 Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
select *
from oficinas
where id_oficina in (select distinct fk_oficina
					from empleados
                    join clientes on id_empleado = fk_empleado_rep_ventas
                    where lower(ciudad) = 'fuenlabrada');

-- 29 Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
select *
from pedidos
where lower(estado) = 'rechazado' and year(fecha_pedido) = 2009;

-- 30 Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. 
	-- Tenga en cuenta que no deben aparecer formas de pago repetidas.
select distinct forma_pago
from pagos;

-- 31 Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
select *
from clientes
where not exists (select * from pagos where fk_cliente = id_cliente);

-- 32 Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.
select *
from clientes
where exists (select * from pedidos where fk_cliente = id_cliente)
	and not exists(select * from pagos where fk_cliente = id_cliente);
    
-- 33 Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos.
select fk_pedido id_pedido, sum(cantidad) cantidades
from detalles_pedido
group by fk_pedido;

-- 34 Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
select distinct id_cliente, gama
from clientes
join pedidos on id_cliente = fk_cliente
join detalles_pedido on id_pedido = fk_pedido
join productos on fk_producto = id_producto
join gamas_productos on fk_gama = id_gama;

-- 35 Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
select *
from empleados
where not exists(select * from clientes where fk_empleado_rep_ventas = id_empleado);

select *
from empleados
where id_empleado not in (select fk_empleado_rep_ventas from clientes);

select *
from empleados
where id_empleado != all (select fk_empleado_rep_ventas from clientes where fk_empleado_rep_ventas is not null);

select *
from empleados
left join clientes on id_empleado = fk_empleado_rep_ventas
where id_cliente is null;

-- 36 Devuelve un listado con los distintos estados por los que puede pasar un pedido.
select distinct estado
from pedidos;

-- 37 Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que tienen más de 100 unidades en stock. 
	-- El listado deberá estar ordenado por su precio de venta, mostrando en primer lugar los de mayor precio.
select *
from productos
where cantidad_en_stock > 100
	and fk_gama = (select id_gama from gamas_productos where lower(gama) = 'ornamentales')
order by precio_venta desc;

-- 38 Calcula el precio de venta del producto más caro y más barato en una misma consulta.
select max(precio_venta) maximo, min(precio_venta) minimo
from productos;

-- 39 Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece 
	-- el representante.
select id_cliente, c.nombre_cliente, e.id_empleado, e.nombre, e.apellido1, e.apellido2, o.ciudad
from clientes c
join empleados e on fk_empleado_rep_ventas = id_empleado
join oficinas o on fk_oficina = id_oficina;

-- 40 Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.
select id_empleado, nombre, apellido1, apellido2, count(id_cliente) cant_clientes
from empleados
join clientes on id_empleado = fk_empleado_rep_ventas
group by id_empleado;

-- 41 Devuelve el nombre del cliente, el nombre y primer apellido de su representante de ventas y el número de teléfono de la oficina 
	-- del representante de ventas, de aquellos clientes que no hayan realizado ningún pago.
select id_cliente, c.nombre_cliente, e.id_empleado, e.nombre, e.apellido1, e.apellido2, o.telefono
from clientes c
join empleados e on fk_empleado_rep_ventas = id_empleado
join oficinas o on fk_oficina = id_oficina
where not exists (select * from pagos where fk_cliente = id_cliente);

-- 42 Devuelve el nombre de los clientes que hayan hecho pedidos en 2008 ordenados alfabéticamente de menor a mayor.
select *
from clientes
where id_cliente in (select distinct fk_cliente from pedidos where year(fecha_pedido) = 2008)
order by nombre_cliente;

select *
from clientes
where exists (select * from pedidos where year(fecha_pedido) = 2008 and fk_cliente = id_cliente)
order by nombre_cliente;

-- 43 Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria.
select *
from empleados
where fk_jefe in (select id_empleado from empleados where (lower(nombre), lower(apellido1)) = ('alberto', 'soria'));

-- 44 Devuelve un listado de los productos que han aparecido en un pedido alguna vez.
select *
from productos
where exists (select * from detalles_pedido where fk_producto = id_producto);

-- 45 Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina 
	-- a la que pertenece el representante.
select id_cliente, nombre_cliente, id_empleado, nombre, apellido1, apellido2, o.ciudad
from clientes
join empleados on fk_empleado_rep_ventas = id_empleado
join oficinas o on fk_oficina = o.id_oficina
where exists (select * from pagos where fk_cliente = id_cliente);

-- 46 Devuelve un listado de los 20 productos más vendidos y el número total de unidades que se han vendido de cada uno. 
	-- El listado deberá estar ordenado por el número total de unidades vendidas.
select id_producto, nombre, ranking, cant
from (select fk_producto, sum(cantidad) cant, dense_rank() over(order by sum(cantidad) desc)ranking 
		from detalles_pedido 
        group by fk_producto) ranking
join productos on fk_producto = id_Producto
where ranking <= 20;


select id_producto, nombre, sum(cantidad) cant
from productos
join detalles_pedido on id_producto = fk_producto
group by id_producto
having cant in (select cant 
				from (select distinct sum(cantidad) cant 
					from detalles_pedido 
					group by fk_producto 
                    order by cant desc limit 20) cantidades)
order by cant desc;

select id_producto, nombre, sum(cantidad) cant
from productos
join detalles_pedido on id_producto = fk_producto
group by id_producto
having cant >= (select min(cant)
				from (select distinct sum(cantidad) cant 
					from detalles_pedido 
					group by fk_producto 
                    order by cant desc limit 20) cantidades)
order by cant desc;

-- 47 Devuelve el listado de clientes donde aparezca el nombre del cliente, el nombre y primer apellido de su representante de ventas 
	-- y la ciudad donde está su oficina.
    select id_cliente, nombre_cliente, id_empleado, nombre, apellido1, o.ciudad
    from clientes
    join empleados on fk_empleado_rep_ventas = id_empleado
    join oficinas o on fk_oficina = id_oficina;
    
-- 48 Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que 
	-- deberá eliminar aquellos códigos de cliente que aparezcan repetidos. 
    -- Resuelva la consulta: Utilizando la función YEAR de MySQL., 
    -- Utilizando la función DATE_FORMAT de MySQL., Sin utilizar ninguna de las funciones anteriores.
select *
from clientes
where exists (select * 
				from pagos 
                where year(fecha_pago) = 2008 and fk_cliente = id_cliente);

select *
from clientes
where exists (select * 
				from pagos
                where date_format(fecha_pago, '%Y') = 2008 and fk_cliente = id_cliente);

select *
from clientes
where exists (select * 
				from pagos 
                where fecha_pago between '2008-01-01' and '2008-12-31' and fk_cliente = id_cliente);

select distinct fk_cliente 
from pagos 
where fecha_pago between '2008-01-01' and '2008-12-31';

-- 49 Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
    select id_cliente, nombre_cliente, id_empleado, nombre, apellido1
    from clientes
    join empleados on fk_empleado_rep_ventas = id_empleado;

-- 50 Calcula la fecha del primer y último pago realizado por cada uno de los clientes. 
	-- El listado deberá mostrar el nombre y los apellidos de cada cliente.
select id_cliente, nombre_cliente, min(fecha_pago) primer_pabgo, max(fecha_pago) ultimo_pago
from clientes
join pagos on id_cliente = fk_cliente
group by id_cliente;

-- 51 Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar INNER JOIN).
select *
from clientes
where limite_credito > (select sum(total)
						from pagos 
                        where fk_cliente = id_cliente);

	-- con join
	select clientes.*
	from clientes
	join pagos on id_cliente = fk_cliente
	group by id_cliente
	having limite_credito > sum(total);

-- 52 Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
select e.id_empleado, e.nombre, e.apellido1, j.id_empleado id_jefe, j.nombre, j.apellido1
from empleados e
left join empleados j on e.fk_jefe = j.id_empleado;

-- 53 ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
select estado, count(*) cant
from pedidos
group by estado
order by cant desc;

-- 54 Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
select *
from oficinas
where not exists(select * 
				from empleados 
                where id_oficina = fk_oficina 
                  and exists(select * 
								from clientes 
                                where fk_empleado_rep_ventas = id_empleado 
                                   and exists (select * 
												from productos 
                                                join gamas_productos on fk_gama = id_gama
												join detalles_pedido on id_producto = fk_producto
                                                join pedidos on fk_pedido = id_pedido
                                                where lower(gama) = 'frutales'
                                                  and fk_cliente = id_cliente)));

-- esta es la mas clara!!
-- en la subconsulta buscamos los empleados que han sido ... etc. etc. y buscamos las oficnas que no son de esos empleados
select *
from oficinas
where id_oficina not in(
		select distinct fk_oficina
		from empleados
		join clientes on id_empleado = fk_empleado_rep_ventas
		join pedidos on id_cliente = fk_cliente
		join detalles_pedido on fk_pedido = id_pedido
		join productos on fk_producto = id_producto
		join gamas_productos on fk_gama = id_gama
		where fk_oficina is not null
		  and lower(gama) = 'frutales');

select *
from oficinas
where not exists (
		select *
		from empleados
		join clientes on id_empleado = fk_empleado_rep_ventas
		join pedidos on id_cliente = fk_cliente
		join detalles_pedido on fk_pedido = id_pedido
		join productos on fk_producto = id_producto
		join gamas_productos on fk_gama = id_gama
		where lower(gama) = 'frutales'
          and fk_oficina = id_oficina);

-- 55 Devuelve un listado con el nombre de los todos los clientes españoles.
select *
from clientes
where lower(pais) = 'spain';

-- 56 Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.
select *
from empleados
join oficinas on fk_oficina = id_oficina
where not exists (select * from clientes where fk_empleado_rep_ventas = id_empleado);

-- 57 Devuelve el producto que menos unidades tiene en stock.
select *
from productos
where cantidad_en_stock = (select min(cantidad_en_stock) from productos);

-- 58 Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M
select ciudad, count(*) cant
from clientes
where lower(ciudad) like 'm%'
group by ciudad;

-- 59 Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
select *
from pedidos
where month(fecha_entrega) = 1 and lower(estado) = 'entregado';

-- 60 ¿Cuál fue el pago medio en 2009?
select round(avg(total), 2) media_pagos
from pagos
where year(fecha_pago) = 2009;

-- 61 Devuelve el nombre del cliente con mayor límite de crédito.
select *
from clientes
where limite_credito = (select max(limite_credito) from clientes);

-- 62 Devuelve el listado de clientes indicando el nombre del cliente y cuántos pedidos ha realizado. Tenga en cuenta que pueden existir clientes que no han realizado ningún pedido.
select id_cliente, nombre_cliente, count(id_pedido) cant_pedidos
from clientes
left join pedidos on id_cliente = fk_cliente
group by id_cliente
order by cant_pedidos;

-- 63 Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre y la descripción.
select *
from productos
where not exists (select *
					from detalles_pedido
                    where fk_producto = id_producto);

-- 64 Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean representante de ventas de ningún cliente.
select id_empleado, nombre, apellido1, apellido2, puesto, telefono
from empleados
join oficinas on fk_oficina = id_oficina
where not exists (select *
					from clientes
                    where fk_empleado_rep_ventas = id_empleado);

-- 65 Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.
select *
from empleados emp
left join empleados jefes on emp.fk_jefe = jefes.id_empleado
left join empleados jefazos on jefes.fk_jefe = jefazos.id_empleado;

-- 66 Muestre la suma total de todos los pagos que se realizaron para cada uno de los años que aparecen en la tabla pagos.
select year(fecha_pago) anyo, sum(total) total
from pagos
group by anyo;

-- 67 Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
select *
from clientes
where not exists (select *
					from pedidos
                    where fk_cliente = id_cliente);

-- 68 Devuelve el nombre del cliente con mayor límite de crédito utilizando una subconsulta
select *
from clientes
where limite_credito = (select max(limite_credito) from clientes);

-- 69 Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada. 
	-- Utilizando la función ADDDATE de MySQL., 
    -- Utilizando la función DATEDIFF de MySQL., 
    -- ¿Sería posible resolver esta consulta utilizando el operador de suma + o resta -?

select str_to_date('2026-12-30', '%Y-%m-%d');
select cast('2026-12-30' as date);

-- no se puede utilizar '+' o '-' para operar con fechas
select cast('2026-12-30' as date) - 1;
select cast('2026-01-01' as date) - 1;

select id_pedido, fk_cliente, fecha_esperada, fecha_entrega
from pedidos
where adddate(fecha_entrega, interval 2 day) <= fecha_esperada;

select id_pedido, fk_cliente, fecha_esperada, fecha_entrega
from pedidos
where datediff(fecha_esperada, fecha_entrega) >= 2;


-- 70 Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún cliente.
select *
from empleados
where not exists(select * from clientes where fk_empleado_rep_ventas = id_empleado);

-- 71 Devuelve el nombre del producto que tenga el precio de venta más caro utilizando una subconsulta
select *
from productos
where precio_venta = (select max(precio_venta)
						from productos);

-- 72 Devuelve un listado con los nombres de los clientes y el total pagado por cada uno de ellos. Tenga en cuenta que pueden existir clientes que no han realizado ningún pago.
select id_cliente, nombre_cliente, coalesce(sum(total), 0.00) total
from clientes
left join pagos on id_cliente = fk_cliente
group by id_cliente
order by total;

-- 73 ¿Cuántos clientes tiene cada país?
select pais, count(*) cant
from clientes
group by pais
order by cant desc;

-- 75 Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA).
select id_producto, nombre, sum(cantidad * precio_unidad) total_fact, sum(cantidad * precio_unidad) * 1.21 total_con_impuestos
from productos
join detalles_pedido on id_producto = fk_producto
group by id_producto
having total_fact > 3000;

-- 76 Calcula el número de productos diferentes que hay en cada uno de los pedidos.
select fk_pedido, count(fk_producto)
from detalles_pedido
group by fk_pedido;

-- 77 ¿Cuántos empleados hay en la compañía?
select count(*)
from empleados;

-- 78 Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
select distinct id_cliente, nombre_cliente
from clientes
join pedidos on id_cliente = fk_cliente
where fecha_entrega <= fecha_esperada;

select id_cliente, nombre_cliente
from clientes
where exists (select * 
				from pedidos 
                where fk_cliente = id_cliente and fecha_entrega <= fecha_esperada);

-- 79 Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
select *
from empleados
where fk_oficina is null;


-- *** Vistas ***
-- 80 Escriba una vista que se llame listado_pagos_clientes que muestre un listado donde aparezcan todos los clientes 
	-- y los pagos que ha realizado cada uno de ellos. +9
	-- La vista deberá tener las siguientes columnas: nombre y apellidos del cliente concatenados, teléfono, ciudad, pais, fecha_pago, total del pago, id de la transacción
drop view if exists listado_pagos_clientes;

create view listado_pagos_clientes as
	select id_cliente, nombre_cliente, concat(nombre_contacto, " ", apellido_contacto) contacto, telefono, ciudad, pais, fecha_pago, total, id_transaccion
    from clientes
    join pagos on id_cliente = fk_cliente;


-- 81 Escriba una vista que se llame listado_pedidos_clientes que muestre un listado donde aparezcan todos los clientes y los pedidos que ha realizado cada uno de ellos. 
	-- La vista debe tener las siguientes columnas: nombre y apellidos del cliente concatendados, teléfono, ciudad, pais, código del pedido, 
		-- fecha del pedido, fecha esperada, fecha de entrega 
    -- y la cantidad total del pedido, que será la suma del producto de todas las cantidades por el precio de cada unidad, que aparecen en cada línea de pedido.
drop view if exists listado_pedidos_clientes;

create view listado_pedidos_clientes as
	select id_cliente, nombre_cliente, concat(nombre_contacto, " ", apellido_contacto) contacto, telefono, ciudad, pais, 
			id_pedido, fecha_pedido, fecha_esperada, fecha_entrega, sum(cantidad * precio_unidad) total
	from clientes
    join pedidos on id_cliente = fk_cliente
    join detalles_pedido on id_pedido = fk_pedido
    group by id_pedido;

-- 82 Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes de la ciudad de Madrid 
		-- que han realizado pagos.
select distinct id_cliente, nombre_cliente, contacto, telefono, ciudad, pais
from listado_pagos_clientes
where lower(ciudad) = 'madrid';

-- 83 Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes que todavía no han recibido su pedido.
select distinct id_cliente, nombre_cliente, contacto, telefono, ciudad, pais
from listado_pedidos_clientes
where fecha_entrega is null;

-- 84 Utilice las vistas que ha creado en los pasos anteriores para calcular el número de pedidos que se ha realizado cada uno de los clientes.
select id_cliente, nombre_cliente, contacto, count(id_pedido) cantidad
from listado_pedidos_clientes
group by id_cliente;

-- 85 Utilice las vistas que ha creado en los pasos anteriores para calcular el valor del pedido máximo y mínimo que ha realizado cada cliente.
select id_cliente, nombre_cliente, contacto, max(total) maximo, min(total) minimo
from listado_pedidos_clientes
group by id_cliente;


-- Ejemplos de teoría de vistas
-- crear una vista con el total facturado por cliente

create view total_facturado_clientes as
select id_cliente, nombre_cliente, sum(total) total_facturado
from total_pedidos
group by id_cliente
order by total_facturado desc;

-- crear una consulta que devuelva los datos del vendedor/es que han facturado la mayor cantidad

create view total_ventas_por_vendedor as
select id_empleado, sum(tfc.total_facturado) total
from empleados
join clientes c on id_empleado = c.fk_empleado_rep_ventas
join total_facturado_clientes tfc on c.id_cliente = tfc.id_cliente
group by id_empleado;


select e.id_empleado, e.nombre, e.apellido1, e.apellido2, tvpv.total
from empleados e
join total_ventas_por_vendedor tvpv on e.id_empleado = tvpv.id_empleado
where total = (select max(total) from total_ventas_por_vendedor);


create view total_pedidos as
select id_pedido, fecha_pedido, estado, id_cliente, nombre_cliente, sum(cantidad * precio_unidad) total
from clientes
join pedidos on id_cliente = fk_cliente
join detalles_pedido on id_pedido = fk_pedido
group by id_pedido
order by total desc;