drop database if exists acesso;
create database acesso;

use acesso;

create table usuario (
	id int primary key not null auto_increment,
    nome varchar(200) not null,
    cpf char(11) unique not null,
    tag int unique not null
);

create table sala (
	id int primary key not null auto_increment,
    nome varchar(200) unique not null,
    numero int unique not null
);

create table permissao (
	id_usuario int not null,
    id_sala int not null,
    horario datetime not null default now(),
    primary key(id_usuario, id_sala),
    foreign key(id_usuario) references usuario(id)
		on update cascade on delete restrict,
	foreign key(id_sala) references sala(id)
		on update cascade on delete restrict
);

select * from usuario;
select * from sala;
select * from permissao;
