select p.id_producto, p.producto, p.precio, p.fk_fabricante, f.id_fabricante, f.fabricante
from fabricantes as f
join productos p on f.id_fabricante = p.fk_fabricante;

select p.id_producto, p.producto, p.precio, p.fk_fabricante, f.id_fabricante, f.fabricante
from productos as p
join fabricantes f on p.fk_fabricante = f.id_fabricante;

select productos.id_producto, productos.producto, fabricantes.fabricante
from productos
join fabricantes on fk_fabricante = id_fabricante;

-- Productos del fabricante 4
select *
from fabricantes join productos on fk_fabricante = id_fabricante
where id_fabricante = 4;

select *
from productos 
where fk_fabricante = 4;

-- ------------------------
-- Funciones de agregación
select count(*) from productos;
select sum(precio) from productos;
select avg(precio) from productos;
select max(precio) from productos;
select min(precio) from productos;

select count(*) cant, avg(precio) media, max(precio) maximo, min(precio) minimo,
		sum(precio) / count(*) media2
from productos;

-- No se puede hacer
select id_producto, producto, max(precio)
from productos;

select fk_fabricante, count(id_producto)
from productos
group by fk_fabricante;

select f.id_fabricante, f.fabricante, count(p.id_producto) cant, max(p.precio) precio_maximo
from productos p
join fabricantes f on p.fk_fabricante=f.id_fabricante
where p.precio > 150 and f.fabricante != 'Asus'
group by p.fk_fabricante
having cant > 1
order by precio_maximo desc;
