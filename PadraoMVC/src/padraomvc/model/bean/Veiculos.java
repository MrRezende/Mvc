package padraomvc.model.bean;

public class Veiculos {
    private int id;
    private String marca;
    private String modelo;
    private String ano;

    public Veiculos(int id) {
        this.id = id;
    }

    public Veiculos(String modelo) {
        this.modelo = modelo;
    }

    public Veiculos(int id, String modelo) {
        this.id = id;
        this.modelo = modelo;
    }

    public Veiculos(String modelo, String marca, String ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
    }

    public Veiculos(int id, String marca, String modelo, String ano) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

}
