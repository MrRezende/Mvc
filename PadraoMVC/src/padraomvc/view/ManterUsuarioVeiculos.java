package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerUsuarioVeiculos;
import padraomvc.model.bean.UsuarioVeiculos;
import padraomvc.util.ViewBasico;

public class ManterUsuarioVeiculos implements ViewBasico {
    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar ";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1 -> inserir();
            case 2 -> alterar();
            case 3 -> buscar();
            case 4 -> excluir();
            case 5 -> listar();
            default -> System.out.println("Opcao inválida");
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idV = Integer.parseInt(JOptionPane.showInputDialog("IDV"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioVeiculos veiEnt = new UsuarioVeiculos(idU, idV, obs);
        ControllerUsuarioVeiculos contVei = new ControllerUsuarioVeiculos();
        UsuarioVeiculos veiSaida = (UsuarioVeiculos) contVei.inserir(veiEnt);
        JOptionPane.showMessageDialog(null, veiSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idV = Integer.parseInt(JOptionPane.showInputDialog("IDV"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioVeiculos veiEnt = new UsuarioVeiculos(id, idU, idV, obs);
        ControllerUsuarioVeiculos contVei = new ControllerUsuarioVeiculos();
        UsuarioVeiculos veiSaida = (UsuarioVeiculos) contVei.alterar(veiEnt);
        JOptionPane.showMessageDialog(null, veiSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioVeiculos veiEnt = new UsuarioVeiculos(id);
        ControllerUsuarioVeiculos contVei = new ControllerUsuarioVeiculos();
        UsuarioVeiculos veiSaida = (UsuarioVeiculos) contVei.buscar(veiEnt);
        JOptionPane.showMessageDialog(null, veiSaida.toString());
        JOptionPane.showMessageDialog(null, veiSaida.getUsu().toString());
        JOptionPane.showMessageDialog(null, veiSaida.getVei().toString());

    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioVeiculos veiEnt = new UsuarioVeiculos(id);
        ControllerUsuarioVeiculos contVei = new ControllerUsuarioVeiculos();
        UsuarioVeiculos veiSaida = (UsuarioVeiculos) contVei.excluir(veiEnt);
        JOptionPane.showMessageDialog(null, veiSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioVeiculos veiEnt = new UsuarioVeiculos(obs);
        ControllerUsuarioVeiculos contVei = new ControllerUsuarioVeiculos();
        List<Object> listaVeiculos = contVei.listar(veiEnt);
        for (Object usuObj : listaVeiculos) {
            UsuarioVeiculos veiSaida = (UsuarioVeiculos) usuObj;
            JOptionPane.showMessageDialog(null, veiSaida.toString());
            JOptionPane.showMessageDialog(null, veiSaida.getUsu().toString());
            JOptionPane.showMessageDialog(null, veiSaida.getVei().toString());
        }
    }
}
