package dao;


import model.Pacientes;


import javax.persistence.EntityManager;
import java.util.List;

public class PacienteDao {
    private EntityManager em;
    public PacienteDao(EntityManager em){
        this.em = em;
    }
    public void cadastrar(Pacientes pacientes) {
        em.persist(pacientes);
    }

    public List<Pacientes> consultarTodos() {
        String jpql = "SELECT c from Pacientes c";
        return em.createQuery(jpql, Pacientes.class).getResultList();
    }

    public void alterar(Pacientes pacientes) {
        em.merge(pacientes);
    }

    public Pacientes consultarPorId(int id) {
        return em.find(Pacientes.class, id);
    }

    public void remover(Pacientes pacientes) {
        em.merge(pacientes);
        em.remove(pacientes);
    }
}