drop database if exists 02_club_tenis;
create database 02_club_tenis;
use 02_club_tenis;

create table personas(
	id_persona int not null auto_increment primary key,
    nombre varchar(45) not null,
    nif varchar(15) not null unique
);

create table taquillas(
	id_taquilla int not null auto_increment primary key,
    nro_taquilla varchar(10) not null unique
);

create table pistas(
	id_pista int not null auto_increment primary key,
    nro_pista varchar(10) not null unique,
    iluminacion tinyint not null default 0,
	techada tinyint not null default 0
);

create table profesores(
	id_profesor int not null primary key,
    nro_federado varchar(20) not null unique,
    foreign key(id_profesor) references personas(id_persona)
);

create table socios(
	id_socio int not null primary key,
    nro_socio varchar(20) not null unique,
    fk_taquilla int not null unique,
    foreign key(id_socio) references personas(id_persona),
    foreign key(fk_taquilla) references taquillas(id_taquilla)
);

create table cursos(
	id_curso int not null primary key auto_increment,
    curso varchar(35) not null,
    fecha date not null,
    fk_profesor int not null,
    foreign key(fk_profesor) references profesores(id_profesor)
);

create table socios_curso(
	fk_socio int not null,
    fk_curso int not null,
    primary key(fk_socio, fk_curso),
    foreign key(fk_socio) references socios(id_socio),
    foreign key(fk_curso) references cursos(id_curso)
);

create table reservas(
	id_reserva int not null auto_increment primary key,
    nro_reserva varchar(20) not null unique,
    fecha date not null,
    hora time not null,
    fk_socio int not null,
    fk_pista int not null,
    foreign key(fk_socio) references socios(id_socio),
    foreign key(fk_pista) references pistas(id_pista)
);

create table socios_jugadore(
	fk_socio int not null,
    fk_reserva int not null,
    primary key(fk_socio, fk_reserva),
    foreign key(fk_socio) references socios(id_socio),
    foreign key(fk_reserva) references reservas(id_reserva)
);