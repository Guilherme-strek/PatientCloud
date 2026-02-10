package dao;

import model.Consultas;
import javax.persistence.EntityManager;
import java.util.List;

public class ConsultasDao {
    private EntityManager em;
    public ConsultasDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Consultas consultas) {
        em.persist(consultas);
    }

    public List<Consultas> consultarTodos() {
        String jpql = "SELECT c from Consultas c";
        return em.createQuery(jpql, Consultas.class).getResultList();
    }

    public void alterar(Consultas consultas) {
        em.merge(consultas);
    }

    public Consultas consultarPorId(int id) {
        return em.find(Consultas.class, id);
    }

    public void remover(Consultas consultas) {
        em.merge(consultas);
        em.remove(consultas);
    }
}