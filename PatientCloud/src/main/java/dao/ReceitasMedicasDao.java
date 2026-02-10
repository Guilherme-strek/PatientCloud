package dao;



import model.ReceitasMedicas;

import javax.persistence.EntityManager;
import java.util.List;

public class ReceitasMedicasDao {
    private EntityManager em;
    public ReceitasMedicasDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(ReceitasMedicas receitasMedicas) {
        em.persist(receitasMedicas);
    }

    public List<ReceitasMedicas> consultarTodos() {
        String jpql = "SELECT c from ReceitasMedicas c";
        return em.createQuery(jpql, ReceitasMedicas.class).getResultList();
    }

    public void alterar(ReceitasMedicas receitasMedicas) {
        em.merge(receitasMedicas);
    }

    public ReceitasMedicas consultarPorId(int id) {
        return em.find(ReceitasMedicas.class, id);
    }

    public void remover(ReceitasMedicas receitasMedicas) {
        em.merge(receitasMedicas);
        em.remove(receitasMedicas);
    }
}
