package dao;

import model.Doencas;

import javax.persistence.EntityManager;
import java.util.List;

public class DoencasDao {
    private EntityManager em;

    //construtor-nome igual a classe
    public DoencasDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Doencas doencas) {
        em.persist(doencas);
    }

    public List<Doencas> consultarTodos() {
        String jpql = "SELECT c from Doencas c";
        return em.createQuery(jpql, Doencas.class).getResultList();
    }

    public void alterar(Doencas doencas) {
        em.merge(doencas);
    }

    public Doencas consultarPorId(int id) {
        return em.find(Doencas.class, id);
    }

    public void remover(Doencas doencas) {
        em.merge(doencas);
        em.remove(doencas);
    }
}
