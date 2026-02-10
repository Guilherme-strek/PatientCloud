package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medicos")
public class Medicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedico;
    private String nomeMedico;
    private String cpf;
    private String telefone;
    private String email;
    private Date dateNacimento;
    private int CRM;
    private int idEspecialidade;

    public Medicos() {
    }

    public Medicos( String nomeMedico, String cpf, String telefone, String email, Date dateNacimento, int CRM, int idEspecialidade) {
        this.nomeMedico = nomeMedico;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dateNacimento = dateNacimento;
        this.CRM = CRM;
        this.idEspecialidade = idEspecialidade;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNacimento() {
        return dateNacimento;
    }

    public void setDateNacimento(Date dateNacimento) {
        this.dateNacimento = dateNacimento;
    }

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
}
