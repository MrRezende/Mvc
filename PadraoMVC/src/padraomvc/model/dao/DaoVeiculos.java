package padraomvc.model.dao;

import padraomvc.util.DaoBasico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Veiculos;
import padraomvc.util.ConexaoDb;

public class DaoVeiculos implements DaoBasico {

    private final Connection c;

    public DaoVeiculos() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        Veiculos sisEnt = (Veiculos) obj;
        String sql = "insert into veiculos" + " (id, marca, modelo, ano)" + " values (?,?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, sisEnt.getId());
        stmt.setString(2, sisEnt.getMarca());
        stmt.setString(3, sisEnt.getModelo());
        stmt.setString(4, sisEnt.getAno());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            sisEnt.setId(id);
        }
        stmt.close();
        return sisEnt;
    }

    @Override
    public Object alterar(Object obj) throws SQLException {
        Veiculos veiEnt = (Veiculos) obj;
        String sql = "UPDATE Veiculos SET marca = ?, modelo = ?, ano = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, veiEnt.getId());
        stmt.setString(2, veiEnt.getMarca());
        stmt.setString(3, veiEnt.getModelo());
        stmt.setString(4, veiEnt.getAno());
        // executa
        stmt.execute();
        stmt.close();
        return veiEnt;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        Veiculos veiEnt = (Veiculos) obj;
        String sql = "delete from Veiculos WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, veiEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return veiEnt;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        Veiculos veiEnt = (Veiculos) obj;
        String sql = "select * from veiculos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, veiEnt.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        Veiculos veiSaida = null;
        while (rs.next()) {
            // criando o objeto Usuario
            veiSaida = new Veiculos(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        return veiSaida;
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException {
        Veiculos sisEnt = (Veiculos) obj;
        // usus: array armazena a lista de registros
        List<Object> veis = new ArrayList<>();

        String sql = "select * from eiculos where marca like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%" + sisEnt.getMarca() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Usuario
            Veiculos vei = new Veiculos(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            veis.add(vei);
        }

        rs.close();
        stmt.close();
        return veis;
    }
}
