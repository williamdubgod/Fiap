package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.ContaBancaria;

public class ContaBancariaDao {

    public static ContaBancaria insert(ContaBancaria contaBancaria) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;

        try {
            String query = "INSERT INTO CONTA_BANCARIA (CODIGO_VERIFICACAO, AGENCIA, NUMERO_DO_CARTAO, CONTA, ID_CONTA_BANCARIA) "
                         + "VALUES ('" + contaBancaria.getCodVerificacao() + "', '" + contaBancaria.getAgencia() + "', '"
                         + contaBancaria.getNumCartao() + "', '" + contaBancaria.getConta() + "', '" + contaBancaria.getId() + "')";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            return contaBancaria;
        } catch (Exception e) {
            System.out.println("Erro ao inserir a conta bancária! - " + e);
            e.printStackTrace();
            
            return contaBancaria;
        } finally {
            if (statement != null) {
                statement.close();
            }
            conn.close();
        }
    }

    public static List<ContaBancaria> getAll() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<ContaBancaria> list = new ArrayList<>();

        try {
            String query = "SELECT * FROM CONTA_BANCARIA";

            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                ContaBancaria contaBancaria = new ContaBancaria();
                contaBancaria.setCodVerificacao(rs.getString("CODIGO_VERIFICACAO"));
                contaBancaria.setAgencia(rs.getString("AGENCIA"));
                contaBancaria.setNumCartao(rs.getString("NUMERO_DO_CARTAO"));
                contaBancaria.setConta(rs.getString("CONTA"));
                contaBancaria.setId(rs.getString("ID_CONTA_BANCARIA"));

                list.add(contaBancaria);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar as contas bancárias! - " + e);
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

    public static boolean delete(String id) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;

        try {
            String query = "DELETE FROM CONTA_BANCARIA WHERE ID_CONTA_BANCARIA = '" + id + "'";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir a conta bancária! - " + e);
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
            conn.close();
        }
    }

    public static ContaBancaria update(ContaBancaria contaBancaria) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;

        try {
            String query = "UPDATE CONTA_BANCARIA SET CODIGO_VERIFICACAO = '" + contaBancaria.getCodVerificacao()
                         + "', AGENCIA = '" + contaBancaria.getAgencia() + "', NUMERO_DO_CARTAO = '" + contaBancaria.getNumCartao()
                         + "', CONTA = '" + contaBancaria.getConta() + "' WHERE ID_CONTA_BANCARIA = '" + contaBancaria.getId() + "'";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            return contaBancaria;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a conta bancária! - " + e);
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
