package dao;

import model.Endereco;

/**
 *
 * @author Maycon Spirlandelli
 */
public interface EnderecoDAO {

    /**
     * Metodo para atualizar objeto endereco na tabela endereco.
     *
     * @param endereco
     * @throws EmpresaDAOException
     */
    void atualizar(Endereco endereco);

    /**
     * Metodo para excluir endereco da tabela endereco.
     *
     * @param endereco
     * @throws EmpresaDAOException
     */
    void excluir(Endereco endereco);

    /**
     * Metodo para adicionar objeto endereco na tabela endereco.
     *
     * @param endereco
     * @throws EmpresaDAOException
     */
    void salvar(Endereco endereco);

}
