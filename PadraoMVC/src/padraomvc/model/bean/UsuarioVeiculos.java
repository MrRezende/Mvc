package padraomvc.model.bean;

import java.io.Serializable;

public class UsuarioVeiculos implements Serializable {

    private int id;
    private int idU;
    private int idV;
    private String obs;
    private Object usu;
    private Object vei;

    public UsuarioVeiculos(int id) {
        this.id = id;
    }

    public UsuarioVeiculos(String obs) {
        this.obs = obs;
    }

    public UsuarioVeiculos(int idU, int idV, String obs) {
        this.idU = idU;
        this.idV = idV;
        this.obs = obs;
    }

    public UsuarioVeiculos(int id, int idU, int idV, String obs) {
        this.id = id;
        this.idU = idU;
        this.idV = idV;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Object getUsu() {
        return usu;
    }

    public void setUsu(Object usu) {
        this.usu = usu;
    }

    public Object getVei() {
        return vei;
    }

    public void setVei(Object vei) {
        this.vei = vei;
    }

    @Override
    public String toString() {
        return "UsuarioVeiculos{" + "id=" + id + ", idU=" + idU + ", idV=" + idV + ", obs=" + obs + '}';
    }

}
