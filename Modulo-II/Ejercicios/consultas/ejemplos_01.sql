SELECT id_producto, left(producto, 5) izq, right(producto, 3) der, substr(producto, 4, 8) medio, precio 
FROM 04_tienda.productos;

select concat(left(producto, 3), " - ", right(producto, 3)), concat_ws(" - ", left(producto, 3), right(producto, 3)) 
from productos;

select lower(concat(left(producto, 3), " - ", precio)) 
from productos;

select producto, char_length(producto) largo
from productos;

select id_producto, producto, replace(producto, "HD", "SUPER")
from productos;