package model;

import javax.persistence.*;

@Entity
@Table(name="planossaude")
public class PlanosSaude {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlanoSaude;
    private String nomePlano;

    public PlanosSaude() {
    }

    public PlanosSaude(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public int getIdPlanoSaude() {
        return idPlanoSaude;
    }

    public void setIdPlanoSaude(int idPlanoSaude) {
        this.idPlanoSaude = idPlanoSaude;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }
}