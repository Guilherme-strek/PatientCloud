package model;

import javax.persistence.*;

@Entity
@Table (name = "salasmedica")
public class SalasMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalaMedica;
    private String descricaoSala;

    public SalasMedica() {
    }

    public SalasMedica(String descricaoSala) {
        this.descricaoSala = descricaoSala;
    }

    public int getIdSalaMedica() {
        return idSalaMedica;
    }

    public void setIdSalaMedica(int idSalaMedica) {
        this.idSalaMedica = idSalaMedica;
    }

    public String getDescricaoSala() {
        return descricaoSala;
    }

    public void setDescricaoSala(String descricaoSala) {
        this.descricaoSala = descricaoSala;
    }
}
