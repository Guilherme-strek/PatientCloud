package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pacientes")
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;
    private String nomePaciente;
    private String cpf;
    private String genero;
    private Date dataNaci;
    private  String fone;
    private  String email;
    private  int idPlanoSaude;

    public Pacientes() {
    }

    public Pacientes(String nomePaciente, String cpf, String genero,Date  dataNaci, String fone, String email, int idPlanoSaude) {
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.genero = genero;
        this.dataNaci = dataNaci;
        this.fone = fone;
        this.email = email;
        this.idPlanoSaude = idPlanoSaude;
    }
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataNaci() {
        return dataNaci;
    }

    public void setDataNaci(Date dataNaci) {
        this.dataNaci = dataNaci;
    }
    public int getIdPlanoSaude() {
        return idPlanoSaude;
    }

    public void setIdPlanoSaude(int idPlanoSaude) {
        this.idPlanoSaude = idPlanoSaude;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}