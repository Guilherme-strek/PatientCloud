package model;

import javax.persistence.*;

@Entity
@Table(name = "remedios")
public class Remedios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRemedio;
    private String descricaoRemedio;

    public Remedios() {
    }

    public Remedios(String descricaoRemedio) {
        this.descricaoRemedio = descricaoRemedio;
    }

    public int getIdRemedio() {
        return idRemedio;
    }

    public void setIdRemedios(int idRemedio) {
        this.idRemedio = idRemedio;
    }

    public String getDescricaoRemedio() {
        return descricaoRemedio;
    }

    public void setDescricaoRemedio(String descricaoRemedio) {
        this.descricaoRemedio = descricaoRemedio;
    }
}
