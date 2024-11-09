drop table SeminarioS21.Canchas;
create table SeminarioS21.Canchas
(
	canchaId integer,
    tipoCancha Varchar(50),
    nombreCancha Varchar(50),
    techadaInd Varchar(50),
    unique index (canchaId)
);

create table SeminarioS21.Turnos
(
	fecha date,
    hora time,
    canchaId integer,
    nombre varchar(50),
    apellido varchar(50),
    unique index(fecha, hora)
);

create table SeminarioS21.Jugadores
(
	documentoId integer,
    nombre varchar(59),
    apellido varchar(50),
    categoriaId integer,
    unique index(documentoId)
);

create table SeminarioS21.Torneos
(
	torneoId integer,
    fecha date,
    categoriaId integer,
    unique index(torneoId)
);

select *
from
	SeminarioS21.Canchas;
    
select *
from
	SeminarioS21.Turnos;
    
select *
from
	SeminarioS21.Jugadores;

select *
from
	seminarioS21.Torneos;
    

select 
	cast(fecha as char(10)) as fecha,
    cast(hora as char(10)) as hora,
    canchaId,
    nombre,
    apellido
from seminarioS21.Turnos;
    