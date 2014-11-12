# Converted with pg2mysql-1.9
# Converted on Sat, 08 Nov 2014 08:07:21 -0500
# Lightbox Technologies Inc. http://www.lightbox.ca

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone="+00:00";

CREATE TABLE cliente
(
  nome varchar(45),
  telefone_fixo varchar(15),
  telefone_celular varchar(15),
  sexo varchar(10),
  usuario varchar(20),
  senha varchar(20),
  data_nascimento date,
  cpf bigint NOT NULL,
  administrador TINYINT(1),
  cliente_id int(11) auto_increment NOT NULL
, PRIMARY KEY(`cliente_id`)
) ;

CREATE TABLE endereco
(
  rua varchar(45),
  setor varchar(45),
  complemento varchar(90),
  cidade varchar(45),
  estado varchar(20),
  cep int(11) NOT NULL,
  cliente_id bigint,
  endereco_id int(11) NOT NULL
) ;

CREATE TABLE produto
(
  nome varchar(150),
  preco numeric(12,2) DEFAULT 0,
  descricao varchar(200),
  codigo int(11) NOT NULL,
  produto_id int(11) auto_increment NOT NULL
, PRIMARY KEY(`produto_id`)
);