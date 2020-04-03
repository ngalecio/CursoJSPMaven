/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  certus3
 * Created: 14-mar-2020
 */

alter table producto add foto_base64 longtext 

update producto
set foto_base64 = null





select * from producto
            SELECT r.*,mp.descripcion as nombre_materiaprima 
                 FROM recetadetalle r,materiaprima mp 
                 where r.codigo_materiaprima = mp.codigo and r.codigo_producto =
select * from recetadetalle
create table recetadetalle
(
    codigo_producto varchar(20),
    codigo_materiaprima int,
    cantidad            numeric(11,2)
)

insert into recetadetalle(codigo_producto,codigo_materiaprima,cantidad)
values('PROD1',1,10),('PROD1',2,5),('PROD3',3,8)

insert into recetadetalle(codigo_producto,codigo_materiaprima,cantidad)
values('PROD1',3,100),('PROD1',4,12),('PROD1',5,45.34)

select * from tecnicadefabricacion

create table etapadetalle
(
    codigo_producto varchar(20),
    codigo_tecnicadefabricacion int,
    tiempo            numeric(11,2)
)

insert into etapadetalle(codigo_producto,codigo_tecnicadefabricacion,tiempo)
values('PROD1',1,2),('PROD1',2,4),('PROD1',3,10.5)

select * from etapadetalle

         select e.*,t.nombre as nombre_tecnicadefabricacion
                    from etapadetalle e,tecnicadefabricacion t 
                    where e.codigo_tecnicadefabricacion = t.codigo 


                    e.codigo_producto =

select * from tecnicadefabricacion

SELECT r.*,mp.descripcion as descripcion_materiaprima 
FROM recetadetalle r,materiaprima mp
where r.codigo_materiaprima = mp.codigo




select pro.*,pre.nombre as nombre_presentacion ,
                    cat.nombre as nombre_categoria
                    from producto pro,presentacion pre,categorias cat
                    where pro.codigo_presentacion = pre.codigo
                    and pro.codigo_categoria = cat.codigo

create table producto(
--id_producto         int auto_increment primary key,
codigo              varchar(20) primary key,
nombre              varchar(200),
descripcion         varchar(200),
lote                varchar(20),
codigo_categoria    int,
codigo_presentacion int,
rutafoto            varchar(100),
foto                blob)

insert into producto
(codigo,nombre,descripcion,lote,codigo_categoria,codigo_presentacion)
values
('PROD1','QUIMICO 1','PESTICIDA PARA BANANO','LOTE1',1,1),
('PROD2','QUIMICO 2','FUMIGACION PARA ARROZ ','LOTE2',2,2)


insert into producto
(codigo,nombre,descripcion,lote,codigo_categoria,codigo_presentacion)
values
('PROD3','PERFUME','LOCION CORPORAL ','LOTE2',2,2)
SELECT * FROM PRODUCTO

create table tecnicadefabricacion(
codigo int auto_increment primary key,
nombre varchar(200),
descripcion varchar(200),
tiempo  numeric(11,2),
costo   numeric(11,2),
factor  numeric(11,2)
)

insert into tecnicadefabricacion(nombre,descripcion,tiempo,costo,factor)
values 
('MEZCLAR MARGARINA','USAR BATIDORA POR 5MIN',5,2,0.25),
('BATIR HUEVOS','USAR BATIDORA POR 3MIN HASTA ESPONJOSO',3,3,0.55),
('HORNEAR','PONER EN EL HORNO POR 1 HORA',60,3,0.45)

SELECT * FROM tecnicadefabricacion


select m.*,u.nombre as nombre_unidaddemedida from materiaprima m,
 unidaddemedida u where m.codigo_unidaddemedida = u.codigo

drop table materiaprima

create table materiaprima(
codigo int auto_increment primary key,
nombre varchar(200),
descripcion varchar(200),
lote   varchar(10),
costo   numeric(11,2),
factor  numeric(11,2),
codigo_unidaddemedida int
)

insert into materiaprima(nombre,descripcion,lote,costo,factor,codigo_unidaddemedida)
values ('HARINA','POLVO BLANCO PARA MEZCLA','112',140.20,0.4,2)

insert into materiaprima(nombre,descripcion,lote,costo,factor,codigo_unidaddemedida)
values ('AZUCAR','PERMITE ENDULZAR ','L31213',7.5,0.3,1)

insert into materiaprima(nombre,descripcion,lote,costo,factor,codigo_unidaddemedida)
values ('MARGARINA','DE GRASA PARA LA MASA','L5412253',4.8,0.25,3)

insert into materiaprima(nombre,descripcion,lote,costo,factor,codigo_unidaddemedida)
values ('LECHE ENTERA','LIQUIDO COMPUESTO CON NUTRIENTES DE ORIGEN ANIMAL','KL01212',10.8,0.75,2)


SELECT * FROM materiaprima

select * from unidaddemedida



create table unidaddemedida(
codigo int auto_increment primary key,
nombre varchar(100)
)

insert into unidaddemedida(nombre) values('litros'),('gramos'),('libras')

create table presentacion(
codigo int auto_increment primary key,
nombre varchar(100))

insert into presentacion(nombre) values('Frasco 10gr'),('Botella 1 lit'),('Botella 8onzas')



drop table categorias

create table categorias(
    codigo int auto_increment primary key,
    nombre varchar(100)
)
insert into categorias(NOMBRE) values('PLASTICOS'),('COMIDA'),('VINO'),('ROPA')
select * from categorias 
select * from editoriales
create table editoriales(
    nit varchar(20) primary key,
    nombre varchar(100) unique,
    telefono varchar(15),
    direccion varchar(100),
    email     varchar(100),
    sitioweb  varchar(100)
)
drop table libros
go
create table libros(
    isbn varchar(20) primary key,
    titulo varchar(100) not null,
    descripcion varchar(255),
    nombre_autor  varchar(100),
    publicacion date,
    fecha_registro datetime,
    codigo_categoria int,
    nit_editorial varchar(20),
    foreign key(codigo_categoria) references categorias(codigo),
    foreign key(nit_editorial) references editoriales(nit)
    )
