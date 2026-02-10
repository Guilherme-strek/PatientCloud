package dao;

import model.Medicos;
import model.Pacientes;

import javax.persistence.EntityManager;
import java.util.List;

public class MedicoDao {
    private EntityManager em;
    public MedicoDao(EntityManager em){
        this.em = em;
    }
    public void cadastrar(Medicos medico) {
        em.persist(medico);
    }
    public List<Medicos> consultarTodos() {
        String jpql = "SELECT c from Medicos c";
        return em.createQuery(jpql, Medicos.class).getResultList();
    }

    public void alterar(Medicos medico) {
        em.merge(medico);
    }

    public Medicos consultarPorId(int id) {
        return em.find(Medicos.class, id);
    }

    public void remover(Medicos medico) {
        em.merge(medico);
        em.remove(medico);
    }
}
