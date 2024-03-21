package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerVeiculos;
import padraomvc.model.bean.Veiculos;
import padraomvc.util.ViewBasico;

public class ManterVeiculos implements ViewBasico {

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
        String marca = JOptionPane.showInputDialog("MARCA");
        String modelo = JOptionPane.showInputDialog("MODELO");
        String ano = JOptionPane.showInputDialog("ANO");
        Veiculos veiEnt = new Veiculos(marca, modelo, ano);
        ControllerVeiculos contVei = new ControllerVeiculos();
        Veiculos veiSaida = (Veiculos) contVei.inserir(veiEnt);
        JOptionPane.showMessageDialog(null, veiSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String marca = JOptionPane.showInputDialog("MARCA");
        String modelo = JOptionPane.showInputDialog("MODELO");
        String ano = JOptionPane.showInputDialog("ANO");
        Veiculos veiEnt = new Veiculos(id, marca, modelo, ano);
        ControllerVeiculos contVei = new ControllerVeiculos();
        Veiculos veiSaida = (Veiculos) contVei.alterar(veiEnt);
        JOptionPane.showMessageDialog(null, veiSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Veiculos veiEnt = new Veiculos(id);
        ControllerVeiculos contVei = new ControllerVeiculos();
        Veiculos veiSaida = (Veiculos) contVei.buscar(veiEnt);
        JOptionPane.showMessageDialog(null, veiSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Veiculos veiEnt = new Veiculos(id);
        ControllerVeiculos contVei = new ControllerVeiculos();
        Veiculos veiSaida = (Veiculos) contVei.excluir(veiEnt);
        JOptionPane.showMessageDialog(null, veiSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String modelo = JOptionPane.showInputDialog("MODELO");
        Veiculos veiEnt = new Veiculos(modelo);
        ControllerVeiculos contVei = new ControllerVeiculos();
        List<Object> listaVeiculos = contVei.listar(veiEnt);
        for (Object veiObj : listaVeiculos) {
            Veiculos veiSaida = (Veiculos) veiObj;
            JOptionPane.showMessageDialog(null, veiSaida.toString());
        }
    }

}
