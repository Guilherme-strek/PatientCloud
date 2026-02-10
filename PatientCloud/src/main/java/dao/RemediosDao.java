package dao;

import model.Remedios;

import javax.persistence.EntityManager;
import java.util.List;

public class RemediosDao {
    private EntityManager em;
    public RemediosDao(EntityManager em){
        this.em = em;
    }
    public List<Remedios> consultarTodos(){
        String jpql= "SELECT c from Remedios c";
        return em.createQuery(jpql,Remedios.class).getResultList();
    }
    public Remedios consultarPorId(int id) {
        return em.find(Remedios.class, id);
    }
}