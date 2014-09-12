create database Jerry;
use Jerry;
create table usuarios(id int primary key, nombre varchar(30), apellidopa varchar(30), apellidoma varchar(30), correo varchar(30), contrasenna varchar(30), tipo int);
create table categorias(id int primary key, nombre varchar(30), numhijos int, padre int);
create table producto(id int primary key, nombre varchar(30), descripcion text, costocompra float, costoventa float, cantidad int, categoria int, foreign key(categoria) references categorias(id));
create table compras(id int primary key, idusuario int, fecha datetime, total decimal, foreign key (idusuario) references usuarios(id));
create table cada_venta(id int primary key, idcompra int, idproducto int, cantidad int, foreign key (idcompra) references compras(id), foreign key(idproducto) references producto(id));
select * from usuarios;
insert into producto values(1, 'Discos', 'El Camino', 'Disco chido',100.0, 159.59, 10, 'Musica', 1);
insert into usuarios values(1, 'Rafael', 'Miranda', 'Villegas', 'rafayotuel@gmail.com', '1234', 1);
delimiter //
create procedure usuarioscreate(nombre1 varchar(30), apellidopa1 varchar(30), apellidoma1 varchar(30), correo1 varchar(30), contrasenna1 varchar(30), tipo1 int)
begin
	declare id1 int;
	set id1 = (select max(id) from usuarios);
	insert into usuarios values(id1 + 1, nombre1, apellidopa1, apellidoma1, correo1, contrasenna1, tipo1);
end;
//

delimiter //
create procedure categoriascreate(nombre1 varchar(30), padre1 int)
begin
	declare id1 int;
	declare hijos int;
	set hijos = (select numhijos from categorias where id=padre1) + 1;
	set id1 = (select max(id) from categorias);
	insert into categorias values(id1 + 1, nombre1, 0, padre1);
	UPDATE categorias SET numhijos=hijos WHERE id=padre1;
end;
//

delimiter //
create procedure productocreate(nombre1 varchar(30), descripcion1 text, costocompra1 decimal, costoventa1 decimal, cantidad1 int, categoria1 int)
begin
	declare id1 int;
	set id1 = (select max(id) from producto);
	insert into producto values(id1 + 1, nombre1, descripcion1, costocompra1, costoventa1, cantidad1, imagen1, categoria1);
end;
//
call usuarioscreate('Rafa', 'Miranda', 'Villegas', 123@456.9, 123, 1 );
call categoriascreate('Rafa', 1);
call productocreate('Disco', 'Disco padre', 4234.3, 1234.3, 3, 1);

