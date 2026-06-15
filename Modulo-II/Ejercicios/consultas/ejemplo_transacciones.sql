create database if not exists 000_teoria_tx;
use 000_teoria_tx;

drop table if exists cuentas;

create table cuentas(
	id_cuenta int auto_increment primary key,
    cod_pais char(2) not null default 'ES',
    dig_control tinyint not null check(dig_control between 0 and 99) default 0,
    cuenta char(20) not null unique key,
    saldo decimal(12, 2) not null default 0,
    check (char_length(cuenta) = 20)
);

insert into cuentas (dig_control, cuenta, saldo) values (45, '12345678901234567001', 1000);
insert into cuentas (dig_control, cuenta, saldo) values (34, '12345678901234567002', 2000);
insert into cuentas (dig_control, cuenta, saldo) values (29, '12345678901234567003', 3000);
insert into cuentas (dig_control, cuenta, saldo) values (97, '12345678901234567004', 4000);

select * from cuentas;

-- ---------

select @@autocommit;
set autocommit = 0;

start transaction;
update cuentas set saldo = 0 where id_cuenta = 1;
update cuentas set saldo = 0 where id_cuenta = 2;
update cuentas set saldo = 0 where id_cuenta = 33;
update cuentas set saldo = 0 where id_cuenta = 4;
-- commit;
rollback;

start transaction;
update cuentas set saldo = 1000 where id_cuenta = 1;
commit;

select * from cuentas;


