package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Doacao;

public class DoacaoDao {

    public static Doacao insert(Doacao doacao) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;

        try {
            String query = "INSERT INTO DOACAO (DATA_DOACAO, TIPO_DOACAO, VALOR_PAGEMENTO, VALOR, ID_DOACAO, ID_FINANCA, TIPO_FINAN, ID_PRODUTO, TIPO_PROD, QUANTIDADE, DOACAO_TIPO, FK_DOADOR_CPF) "
                         + "VALUES ('" + doacao.getDataDoacao() + "', '" + doacao.getTipoDoacao() + "', '" + doacao.getValorPagamento() + "', '"
                         + doacao.getValor() + "', '" + doacao.getIdDoacao() + "', '" + doacao.getIdFinanca() + "', '" + doacao.getTipoFinanca() + "', '"
                         + doacao.getIdProduto() + "', '" + doacao.getTipoProduto() + "', '" + doacao.getQuantidade() + "', '"
                         + doacao.getDoacaoTipo() + "', '" + doacao.getDoadorCPF() + "')";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            return doacao;
        } catch (Exception e) {
            System.out.println("Erro ao inserir a doação! - " + e);
            e.printStackTrace();
            
            return doacao;
        } finally {
            if (statement != null) {
                statement.close();
            }
            conn.close();
        }
    }

    public static List<Doacao> getAll() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Doacao> list = new ArrayList<>();

        try {
            String query = "SELECT * FROM DOACAO";

            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Doacao doacao = new Doacao();
                doacao.setDataDoacao(rs.getString("DATA_DOACAO"));
                doacao.setTipoDoacao(rs.getString("TIPO_DOACAO"));
                doacao.setValorPagamento(rs.getString("VALOR_PAGEMENTO"));
                doacao.setValor(rs.getString("VALOR"));
                doacao.setIdDoacao(rs.getString("ID_DOACAO"));
                doacao.setIdFinanca(rs.getString("ID_FINANCA"));
                doacao.setTipoFinanca(rs.getString("TIPO_FINAN"));
                doacao.setIdProduto(rs.getString("ID_PRODUTO"));
                doacao.setTipoProduto(rs.getString("TIPO_PROD"));
                doacao.setQuantidade(rs.getString("QUANTIDADE"));
                doacao.setDoacaoTipo(rs.getString("DOACAO_TIPO"));
                doacao.setDoadorCPF(rs.getString("FK_DOADOR_CPF"));

                list.add(doacao);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar as doações! - " + e);
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            conn.close();
        }

        return list;
    }

    public static boolean delete(String idDoacao) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;

        try {
            String query = "DELETE FROM DOACAO WHERE ID_DOACAO = '" + idDoacao + "'";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir a doação! - " + e);
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
            conn.close();
        }
    }

    public static Doacao update(Doacao doacao) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;

        try {
            String query = "UPDATE DOACAO SET DATA_DOACAO = '" + doacao.getDataDoacao() + "', TIPO_DOACAO = '" + doacao.getTipoDoacao()
                         + "', VALOR_PAGEMENTO = '" + doacao.getValorPagamento() + "', VALOR = '" + doacao.getValor() + "', ID_FINANCA = '"
                         + doacao.getIdFinanca() + "', TIPO_FINAN = '" + doacao.getTipoFinanca() + "', ID_PRODUTO = '"
                         + doacao.getIdProduto() + "', TIPO_PROD = '" + doacao.getTipoProduto() + "', QUANTIDADE = '"
                         + doacao.getQuantidade() + "', DOACAO_TIPO = '" + doacao.getDoacaoTipo() + "', FK_DOADOR_CPF = '"
                         + doacao.getDoadorCPF() + "' WHERE ID_DOACAO = '" + doacao.getIdDoacao() + "'";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            return doacao;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a doação! - " + e);
            e.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                statement.close();
            }
            conn.close();
        }
    }
}
