drop database if exists 01_alquiler_coches;

create database 01_alquiler_coches;
use 01_alquiler_coches;

create table marcas (
	id_marca int not null auto_increment,
    marca varchar(25) not null,
    primary key(id_marca),
    unique key(marca)
);

create table modelos(
	id_modelo int not null auto_increment primary key,
    modelo varchar(35) not null,
    fk_marca int not null,
    foreign key(fk_marca) references marcas(id_marca)
);

create table coches(
	id_coche int not null auto_increment primary key,
    matricula varchar(15) not null unique,
    color varchar(15) not null,
    precio_alq decimal(10,2) not null,
    fk_modelo int not null,
    foreign key(fk_modelo) references modelos(id_modelo)
);

create table clientes(
	id_cliente int not null auto_increment primary key,
    nombre varchar(45) not null,
    dni varchar(15) not null unique,
    telefono varchar(15) not null,
    direccion varchar(45) not null
);

create table reservas(
	id_reserva int not null auto_increment primary key,
    fecha_inicio date not null,
    fecha_fin date,
    precio_total decimal(10,2) not null,
    fk_cliente int not null,
    foreign key(fk_cliente) references clientes(id_cliente)
);

create table avales(
	fk_cliente int not null,
    fk_reserva int not null,
    porcentaje decimal(5,2) not null,
    primary key(fk_cliente, fk_reserva),
    foreign key(fk_cliente) references clientes(id_cliente),
    foreign key(fk_reserva) references reservas(id_reserva)
);

create table coches_por_reserva(
	fk_coche int not null,
    fk_reserva int not null,
    litros_gasolina decimal(8,2) not null,
    km_inicio int not null,
    km_fin int,
    precio decimal(10,2) not null,
    primary key(fk_coche, fk_reserva),
    foreign key(fk_coche) references coches(id_coche),
    foreign key(fk_reserva) references reservas(id_reserva)
);