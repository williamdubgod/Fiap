package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Doador;

public class DoadorDao {

    public static Doador insert(Doador doador) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;

        try {
            String query = "INSERT INTO DOADOR (TELEFONE, NOME, SOBRENOME, CPF, EMAIL, CEP, LOGRADOURO, LOCALIDADE, BAIRRO) "
                         + "VALUES ('" + doador.getTelefone() + "', '" + doador.getNome() + "', '" + doador.getSobrenome() + "', '"
                         + doador.getCpf() + "', '" + doador.getEmail() + "', '" + doador.getCep() + "', '"
                         + doador.getLogradouro() + "', '" + doador.getLocalidade() + "', '" + doador.getBairro() + "')";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            return doador;
        } catch (Exception e) {
            System.out.println("Erro ao inserir o doador! - " + e);
            e.printStackTrace();
            
            return doador;
        } finally {
            if (statement != null) {
                statement.close();
            }
            conn.close();
        }
    }

    public static List<Doador> getAll() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Doador> list = new ArrayList<>();

        try {
            String query = "SELECT * FROM DOADOR";

            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Doador doador = new Doador();
                doador.setTelefone(rs.getString("TELEFONE"));
                doador.setNome(rs.getString("NOME"));
                doador.setSobrenome(rs.getString("SOBRENOME"));
                doador.setCpf(rs.getString("CPF"));
                doador.setEmail(rs.getString("EMAIL"));
                doador.setCep(rs.getString("CEP"));
                doador.setLogradouro(rs.getString("LOGRADOURO"));
                doador.setLocalidade(rs.getString("LOCALIDADE"));
                doador.setBairro(rs.getString("BAIRRO"));

                list.add(doador);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar os doadores! - " + e);
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

    public static boolean delete(String cpf) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;

        try {
            String query = "DELETE FROM DOADOR WHERE CPF = '" + cpf + "'";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir o doador! - " + e);
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
            conn.close();
        }
    }

    public static Doador update(Doador doador) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = null;

        try {
            String query = "UPDATE DOADOR SET TELEFONE = '" + doador.getTelefone() + "', NOME = '" + doador.getNome()
                         + "', SOBRENOME = '" + doador.getSobrenome() + "', CEP = '" + doador.getCep() + "', LOGRADOURO = '"
                         + doador.getLogradouro() + "', LOCALIDADE = '" + doador.getLocalidade() + "', BAIRRO = '"
                         + doador.getBairro() + "' WHERE CPF = '" + doador.getCpf() + "'";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            return doador;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o doador! - " + e);
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
