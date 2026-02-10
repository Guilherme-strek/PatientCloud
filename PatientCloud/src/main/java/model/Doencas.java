package model;

import javax.persistence.*;

@Entity
@Table(name = "doencas")
public class Doencas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDoenca;
    private String descricaoDoenca, CID;

    public Doencas() {
    }


    public Doencas(String descricaoDoenca, String CID) {
        this.descricaoDoenca = descricaoDoenca;
        this.CID = CID;
    }

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    public String getDescricaoDoenca() {
        return descricaoDoenca;
    }

    public void setDescricaoDoenca(String descricaoDoenca) {
        this.descricaoDoenca = descricaoDoenca;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }
}
