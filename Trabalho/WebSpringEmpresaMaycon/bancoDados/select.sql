SELECT nome, telefone_fixo, telefone_celular, sexo, usuario, senha, 
       data_nascimento, cpf, cliente_id, administrador
  FROM cliente;


SELECT rua, setor, complemento, cidade, estado, cep, cliente_id, endereco_id
  FROM endereco
  ORDER BY endereco_id DESC;


DELETE FROM endereco WHERE endereco_id = 2650;