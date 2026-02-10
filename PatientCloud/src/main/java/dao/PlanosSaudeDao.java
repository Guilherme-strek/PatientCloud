package dao;

import model.Especialidades;
import model.PlanosSaude;

import javax.persistence.EntityManager;
import java.util.List;

public class PlanosSaudeDao {
    private EntityManager em;
    public PlanosSaudeDao(EntityManager em){
        this.em = em;
    }
    public List<PlanosSaude> consultarTodos(){
        String jpql= "SELECT c from PlanosSaude c";
        return em.createQuery(jpql,PlanosSaude.class).getResultList();
    }
    public PlanosSaude consultarPorId(int id) {
        return em.find(PlanosSaude.class, id);
    }
}