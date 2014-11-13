create database atividade3;

alunoCREATE TABLE `aluno` (
  `aluno_id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `numero_matricula` int(11) DEFAULT NULL,
  `ano_ingresso` int(11) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aluno_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
