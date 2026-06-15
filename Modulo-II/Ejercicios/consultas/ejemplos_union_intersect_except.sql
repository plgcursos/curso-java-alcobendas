-- ciudades donde hay clientes y oficinas
select distinct c.ciudad
from clientes c
join oficinas o on c.ciudad = o.ciudad;

select ciudad
from clientes
intersect
select ciudad
from oficinas;

-- ciudades donde hay oficinas o hay clientes
select ciudad
from clientes
union
select ciudad
from oficinas;


-- ciudades donde hay clientes pero no hay oficinas
select distinct c.ciudad
from clientes c
where not exists (select * from oficinas where ciudad = c.ciudad);


select ciudad from clientes
except
select ciudad from oficinas;









