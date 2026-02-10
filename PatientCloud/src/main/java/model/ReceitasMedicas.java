package model;

import javax.persistence.*;

@Entity
@Table(name = "receitasmedicas")
public class ReceitasMedicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idreceitaMedicas;
    private int idConsulta;
    private int idRemedio;
    private String dose;

    public ReceitasMedicas() {
    }

    public ReceitasMedicas( int idConsulta, int idRemedio, String dose) {
        this.idConsulta = idConsulta;
        this.idRemedio = idRemedio;
        this.dose = dose;
    }

    public int getIdreceitaMedicas() {
        return idreceitaMedicas;
    }

    public void setIdreceitaMedicas(int idreceitaMedicas) {
        this.idreceitaMedicas = idreceitaMedicas;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdRemedio() {
        return idRemedio;
    }

    public void setIdRemedio(int idRemedio) {
        this.idRemedio = idRemedio;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
}