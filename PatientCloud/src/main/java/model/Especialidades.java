package model;

import javax.persistence.*;

@Entity
@Table (name="especialidades")
public class Especialidades {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int idEspecialidade;
 private  String descricaoEspecialidade;

 public Especialidades() {
 }

 public Especialidades(String descricaoEspecialidade) {
  this.descricaoEspecialidade = descricaoEspecialidade;
 }

 public int getIdEspecialidade() {
  return idEspecialidade;
 }

 public void setIdEspecialidade(int idEspecialidade) {
  this.idEspecialidade = idEspecialidade;
 }

 public String getDescricaoEspecialidade() {
  return descricaoEspecialidade;
 }

 public void setDescricaoEspecialidade(String descricaoEspecialidade) {
  this.descricaoEspecialidade = descricaoEspecialidade;
 }
}