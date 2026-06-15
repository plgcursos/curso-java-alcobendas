-- SUBCONSULTAS

-- SUBCONSULTAS EN EL WHERE
SELECT *
from productos
where precio > (select avg(precio) from productos);


-- El/Los producto/s de mayor precio
select *
from productos
where precio = (select max(precio) from productos);


-- nombre de los fabricantes que suministran algún producto sin usar join 
select * 
from fabricantes
where id_fabricante = any (select distinct fk_fabricante from productos);

-- nombre de los fabricantes que no suministran ningún producto sin usar join 
select * 
from fabricantes
where id_fabricante != all (select distinct fk_fabricante from productos);

-- SUBCONSULTAS EN EL FROM/JOIN
select id_fabricante, avg(precio)
from productos
join fabricantes on fk_fabricante = id_fabricante
group by id_fabricante;

select fk_fabricante id_fabricante, avg(precio)
from productos
group by fk_fabricante;



select id_producto, producto, precio, medias.id_fabricante, f.fabricante, medias.media
from productos
join (select fk_fabricante id_fabricante, avg(precio) media
	from productos
	group by fk_fabricante) as medias
    on fk_fabricante = medias.id_fabricante
join fabricantes f on fk_fabricante = f.id_fabricante
where precio > medias.media;




