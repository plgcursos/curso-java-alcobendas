-- FUNCIONES, PROCEDIMIENTOS Y TRIGGERS

-- FUNCIONES

use 07_jardineria;
-- Funcion calcula el IVA de un importe
	-- Entrada: base_imponible
	-- Salida: base_imponible * 0.21
	
	-- deterministic: para un valor de entrada siempre devuelve el mismo valor
	-- no sql: no necesita acceso a la base de datos

drop function if exists iva;
create function iva(base_imponible decimal(10, 2))
returns decimal(10, 2)
deterministic
no sql
return base_imponible * 0.21;
        
select iva(1000);

select *, iva(total) iva, total + iva(total) total_con_imp
from total_pedidos;


use 06_universidad;
-- Funcion que calcula la edad en base a la fecha de nacimiento
	-- Entrada: fecha_nac: date
    -- Salida: edad: int
    -- not deterministic
    -- no sql

drop function if exists edad;
create function edad(fecha_nac date)
returns int
not deterministic
no sql
return timestampdiff(year, fecha_nac, current_date);

select edad('1963-04-07');

select *, edad(fecha_nacimiento) edad
from alumnos;


-- Función que devuelva el precio mayor de los productos
use 07_jardineria;
	-- Entrada: --
    -- Salida: precio mayor: decimal(10,2)
    -- not deterministic
    -- reads sql data

drop function if exists mayor_precio_productos;
create function mayor_precio_productos()
returns decimal(10,2)
not deterministic
reads sql data
return (select max(precio_venta) from productos);

select mayor_precio_productos();

select *
from productos
where precio_venta = mayor_precio_productos();

-- Función que calcule el importe mayor de los pedidos de un año
	-- Entrada: anyo: int
    -- Sadlida: importe mayor: decimal(10,2)
    -- not deterministic
    -- reads sql data

drop function if exists pedido_mayor;
create function pedido_mayor(anyo int)
returns decimal(10, 2)
not deterministic
reads sql data
return (select max(total)
		from total_pedidos
        where anyo is null or year(fecha_pedido) = anyo);

select *
from total_pedidos
where total = pedido_mayor(2008);

select pedido_mayor(null);
select pedido_mayor(2006);
select pedido_mayor(2007);

-- PROCEDIMIENTOS
-- Buscar el/los pedido/s de mayor importe de un año

drop procedure if exists pedido_mayor;
delimiter //
create procedure pedido_mayor(in anyo int)
begin
	select *
    from total_pedidos
    where (anyo is null or year(fecha_pedido) = anyo)
		and total = pedido_mayor(anyo);
end //
delimiter ;

call pedido_mayor(2006);
call pedido_mayor(2007);
call pedido_mayor(2008);
call pedido_mayor(2009);
call pedido_mayor(null);

-- TRIGGERS
-- Trigger validar stock suficiente al insertar una linea de pedido
drop trigger if exists trg_validar_stock;

delimiter //
create trigger trg_validar_stock
before insert on detalles_pedido
for each row
begin
	declare stock_actual int;
    declare mje_error_stock varchar(45);
    
    select cantidad_en_stock into stock_actual
    from productos
    where id_producto = new.fk_producto;
    
    if new.cantidad <= 0 then
		signal sqlstate '45000'
        set message_text = 'La cantidad debe ser mayor que 0';
	end if;
    
    if new.cantidad > stock_actual then
		set mje_error_stock = concat('Del producto ', new.fk_producto, ' solo quedan ', stock_actual, ' unidades.');
   		signal sqlstate '45000'
        set message_text = mje_error_stock;
	end if;
end //

delimiter ;

-- Trigger actualizar stock después de insertar una linea de pedido

drop trigger if exists trg_actualiza_stock_insert;

delimiter //
create trigger trg_actualiza_stock_insert
after insert on detalles_pedido
for each row
begin
	update productos
    set cantidad_en_stock = cantidad_en_stock - new.cantidad
    where id_producto = new.fk_producto;
end //
delimiter ;


-- Trigger actualizar stock después de actualizar una linea de pedido

drop trigger if exists trg_actualiza_stock_update;

delimiter //
create trigger trg_actualiza_stock_update
after update on detalles_pedido
for each row
begin
	update productos
    set cantidad_en_stock = cantidad_en_stock - new.cantidad + old.cantidad
    where id_producto = new.fk_producto;
end //
delimiter ;


-- Trigger actualizar stock después de eliminar una linea de pedido

drop trigger if exists trg_actualiza_stock_delete;

delimiter //
create trigger trg_actualiza_stock_delete
after delete on detalles_pedido
for each row
begin
	update productos
    set cantidad_en_stock = cantidad_en_stock + old.cantidad
    where id_producto = old.fk_producto;
end //
delimiter ;



-- pruebas

insert into detalles_pedido (fk_pedido, fk_producto, cantidad, precio_unidad, numero_linea)
						values (1, 15, 10, 15.65, 1);
                        
update detalles_pedido
set cantidad = 7
where fk_pedido = 1 and fk_producto = 15;

delete from detalles_pedido
where fk_pedido = 1 and fk_producto = 15;

                        
select * from productos where id_producto = 15;

select * from pedidos where id_pedido = 1;

select * from detalles_pedido;






