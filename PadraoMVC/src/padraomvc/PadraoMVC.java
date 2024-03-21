/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package padraomvc;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import padraomvc.view.ManterSistema;
import padraomvc.view.ManterUsuario;
import padraomvc.view.ManterUsuarioSistema;

/**
 *
 * @author LAB 211
 */
public class PadraoMVC {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Sistema \n 3 - UsuarioSistema";

        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0 -> {
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
            }
            case 1 -> {
                ManterUsuario mu = new ManterUsuario();
                mu.menu();
            }
            case 2 -> {
                ManterSistema ms = new ManterSistema();
                ms.menu();
            }
            case 3 -> {
                ManterUsuarioSistema mus = new ManterUsuarioSistema();
                mus.menu();
            }
            default -> System.out.println("Opção inválido");
        }
    }
    
}
