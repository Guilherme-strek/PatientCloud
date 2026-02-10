package dao;

import model.Especialidades;
import model.SalasMedica;

import javax.persistence.EntityManager;
import java.util.List;

public class SalasMedicaDao {
    private EntityManager em;
    public SalasMedicaDao(EntityManager em){
        this.em = em;
    }
    public List<SalasMedica> consultarTodos(){
        String jpql= "SELECT c from SalasMedica c";
        return em.createQuery(jpql,SalasMedica.class).getResultList();
    }
    public SalasMedica consultarPorId(int id) {
        return em.find(SalasMedica.class, id);
    }
}
