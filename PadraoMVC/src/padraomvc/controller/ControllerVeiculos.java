package padraomvc.controller;

import java.sql.SQLException;
import java.util.List;

import padraomvc.model.dao.DaoSistema;
import padraomvc.util.ControllerBasico;

public class ControllerVeiculos implements ControllerBasico {

    DaoSistema dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.buscar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoSistema();
        return dao.listar(obj);
    }
}