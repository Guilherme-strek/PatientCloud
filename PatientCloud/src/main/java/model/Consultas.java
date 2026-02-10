package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consultas")
public class Consultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;
    private Date dataConsulta;
    private int idSalaMedica;
    private int idPaciente;
    private int idDoenca;
    private int idMedico;

    public Consultas() {
    }

    public Consultas(Date dataConsulta, int idSalaMedica, int idPaciente, int idDoenca, int idMedico) {
        this.dataConsulta = dataConsulta;
        this.idSalaMedica = idSalaMedica;
        this.idPaciente = idPaciente;
        this.idDoenca = idDoenca;
        this.idMedico = idMedico;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public int getIdSalaMedica() {
        return idSalaMedica;
    }

    public void setIdSalaMedica(int idSalaMedica) {
        this.idSalaMedica = idSalaMedica;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
}
