create database atividade3;


CREATE TABLE `aluno` (
  `aluno_id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `numero_matricula` int(11) DEFAULT NULL,
  `ano_ingresso` int(11) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aluno_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `atividade3`.`aluno` 
CHANGE COLUMN `aluno_id` `aluno_id` INT(11) NOT NULL AUTO_INCREMENT ;


/* Atualizado em 14/11/14 */
CREATE TABLE `aluno` (
  `aluno_id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `numero_matricula` int(11) DEFAULT NULL,
  `ano_ingresso` int(11) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aluno_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;