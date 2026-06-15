-- 1. Obtener los datos de la/s tarjeta/s del cliente con nif 10481533L
--    (id tarjeta, pan, marca, año de vencimiento y mes de vencimiento) 
--    <id_cliente: 124, 2 tarjetas: 235, 236>
select id_tarjeta, pan, marca, anyo_vencimiento, mes_vencimiento 
from tarjetas t
join cuentas cu on t.fk_cuenta = cu.id_cuenta
join clientes cli on cu.fk_cliente = cli.id_cliente
where cli.nif = '10481533L';

-- 2. Obtener los datos de los titulares de cuentas de la provincia de Madrid que no tienen tarjetas
--    (Id del cliente, apellidos y nombre, municipio, id de la cuenta y número de cuenta)
--  <8 clientes> el cliente 457 es de Madrid y tiene cuentas con y sin tarjetas
select cli.id_cliente, cli.apellido1, cli.apellido2, cli.nombre, cli.municipio, id_cuenta, numero
from clientes cli
join cuentas on id_cliente = fk_cliente
where cli.id_cliente not in (select distinct c.fk_cliente from cuentas c
							join tarjetas t on c.id_cuenta = t.fk_cuenta)
	and lower(cli.provincia) = 'madrid';
    
select *
from clientes cli
where not exists (select * from cuentas join tarjetas on id_cuenta = fk_cuenta where fk_cliente = cli.id_cliente)
and cli.provincia = 'Madrid';

--  esto es incorrecto
select distinct cli.*
from clientes cli
join cuentas cu on cli.id_cliente = cu.fk_cliente
left join tarjetas on cu.id_cuenta = fk_cuenta
where id_tarjeta is null and cli.provincia = 'Madrid';

select *
from clientes 
join cuentas on id_cliente = fk_cliente
left join tarjetas on id_cuenta = fk_cuenta
where id_cliente = 457;

-- 3. Obtener los datos de los extractos del cliente 29 con el importe total de cada extracto.
--    (Id del cliente, número de cuenta, año, mes e importe total del extracto)
--    ordernados por número de cuenta, año y mes del extracto
--     22 filas
select cu.fk_cliente, cu.numero, e.anyo, e.mes, sum(m.importe) total
from extractos e
join movimientos m on e.id_extracto = m.fk_extracto
join cuentas cu on e.fk_cuenta = cu.id_cuenta
where fk_cliente = 29
group by e.id_extracto
order by cu.numero, e.anyo, e.mes;

-- 4. Datos de los Clientes (id del cliente, nombre y apellidos) y cantidad de tarjetas que tiene, 
--    de aquéllos con más de cuatro tarjetas.
--    <7 clientes>
select id_cliente, nombre, apellido1, apellido2, count(id_tarjeta) cant
from clientes cli
join cuentas on id_cliente = fk_cliente
join tarjetas on id_cuenta = fk_cuenta
group by id_cliente
having cant > 4;

-- 5. Datos de los clientes que han realizado compras en el mes de junio de 2020 con importes inferiores a la media 
--    de los importes de compra de dicho mes.
--    (id cliente, nombre y apellidos)
--    <142 filas>
select distinct clientes.*
from clientes
join cuentas on id_cliente = fk_cliente
join tarjetas on id_cuenta = fk_cuenta
join movimientos on id_tarjeta = fk_tarjeta
join tipos_movimientos on fk_tipo = id_tipo_movimiento
where year(fecha) = 2020 and month(fecha) = 6 
	and lower(tipo_movimiento) = 'compra'
	and importe < (select avg(importe) 
					from movimientos 
                    join tipos_movimientos on fk_tipo = id_tipo_movimiento 
                    where year(fecha) = 2020 and month(fecha) = 6 
                        and lower(tipo_movimiento) = 'compra'
				   )
;

select distinct clientes.*
from clientes
join cuentas on id_cliente = fk_cliente
join tarjetas on id_cuenta = fk_cuenta
join movimientos on id_tarjeta = fk_tarjeta
join tipos_movimientos on fk_tipo = id_tipo_movimiento
where fecha between '2020-06-01' and '2020-06-30'
	and tipo_movimiento = 'COMPRA'
	and importe < (select avg(importe) 
					from movimientos 
                    join tipos_movimientos on fk_tipo = id_tipo_movimiento 
                    where fecha between '2020-06-01' and '2020-06-30' 
                        and tipo_movimiento = 'COMPRA'
				   )
;
