--Ejecutar primero
drop database empresa_db WITH (FORCE);

--Ejecutar segundo
create database empresa_db;

--para las siguientes instrucciones se debe cambiar la coneccion a la bae de datos recien creada

--crear tabla perfil
create table perfil(
    id integer,
    imagen varchar(50) not null,
    telefono varchar(12) not null,
    crearAT date,
    actualizarAT date,
    constraint perfil_pk primary key(id)
);

--crear tabla empresa
create table empresa(
    id integer,
    nombre varchar(50) not null unique,
    documento varchar(50) not null unique,
    telefono varchar(12) not null,
    direccion varchar(50) not null,
    crearAT date,
    actualizarAT date,
    constraint empresa_pk primary key(id)
);

--crear rol como tipo enum
create type rol as enum('Administrador','Operario');

--crear tabla empleado
create table empleado(
    id integer,
    email varchar(50) not null unique,
    rol_actual rol,
    idEmpresa integer not null,
    idPerfil integer not null,
    crearAT date,
    actualizarAT date,
    constraint empleado_pk primary key(id),
    constraint empleado_empresa_idEmpresa_fk foreign key(idEmpresa) references empresa(id),
    constraint empleado_perfil_idPerfil_fk foreign key(idPerfil) references perfil(id)
);

--crear tabla transaccion
create table transaccion(
    id integer,
    concepto varchar(200) not null unique, 
    monto float not null,
    idEmpleado integer not null,
    idEmpresa integer not null,
    crearAT date,
    actualizarAT date,
    constraint transaccion_pk primary key(id),
    constraint transaccion_empleado_idEmpleado_fk foreign key(idEmpleado) references empleado(id),
    constraint transaccion_empresa_idEmpresa_fk foreign key(idEmpresa) references empresa(id)
);
