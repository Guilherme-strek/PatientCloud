package dao;

import model.Especialidades;
import model.Remedios;

import javax.persistence.EntityManager;
import java.util.List;

public class EspecialidadesDao {
    private EntityManager em;
    public EspecialidadesDao(EntityManager em){
        this.em = em;
    }
    public List<Especialidades> consultarTodos(){
        String jpql= "SELECT c from Especialidades c";
        return em.createQuery(jpql,Especialidades.class).getResultList();
    }
    public Especialidades consultarPorId(int id) {
        return em.find(Especialidades.class, id);
    }
}
