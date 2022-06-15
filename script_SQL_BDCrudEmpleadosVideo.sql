create database VideoCrudEmpleados;
use VideoCrudEmpleados;

create table Empleados(
codigoEmpleado int(6) not null primary key auto_increment,
nombre varchar(45) not null,
apellido varchar(45) not null,
edad int(3) not null,
sueldo double(8,2) not null);

describe empleados;

insert into empleados(nombre,apellido,edad,sueldo) values
("Carlos","Villareal",28,2500.25);

select * from empleados;

describe empleados;
insert into empleados(nombre,apellido,edad,sueldo) values
("Pedro","Ramirez",30,1200.50),
("Juan","Vasquez",25,2400.35),
("Sara","Gomez",33,3000.20);
select * from empleados;

/*delete from empleados where codigoEmpleado>=0;*/

/* si quieres reiniciar el id auto incrementado*/
/*alter table empleados auto_increment = 0;*/

