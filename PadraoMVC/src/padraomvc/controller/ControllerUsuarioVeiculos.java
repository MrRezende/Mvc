package padraomvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import padraomvc.model.bean.UsuarioVeiculos;
import padraomvc.model.bean.Veiculos;
import padraomvc.model.bean.Usuario;
import padraomvc.model.dao.DaoUsuarioVeiculos;
import padraomvc.util.ControllerBasico;

public class ControllerUsuarioVeiculos implements ControllerBasico {

    DaoUsuarioVeiculos dao;
    ControllerUsuario contUsu;
    ControllerVeiculos contVei;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculos();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculos();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculos();
        UsuarioVeiculos objSaida = (UsuarioVeiculos) dao.buscar(obj);
        Object usu = new Usuario(objSaida.getIdU());
        Object vei = new Veiculos(objSaida.getIdV());
        contUsu = new ControllerUsuario();
        contVei = new ControllerVeiculos();
        objSaida.setUsu(contUsu.buscar(usu));
        objSaida.setVei(contVei.buscar(vei));
        return objSaida;
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculos();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculos();
        List<Object> listaAux = dao.listar(obj);
        List<Object> lista = new ArrayList<>();
        for (Object objlista : listaAux) {
            lista.add(buscar(objlista));
        }
        return lista;
    }

}
