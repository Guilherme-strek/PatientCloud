package view;

import dao.EspecialidadesDao;
import dao.PlanosSaudeDao;
import model.Especialidades;
import model.PlanosSaude;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CadrastroPlanosSaude {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityMAnager();
        PlanosSaudeDao planosSaudeDao = new PlanosSaudeDao(em);
        List<PlanosSaude> todos = planosSaudeDao.consultarTodos();
        int tamb = todos.size();
        String resultado = "ID \t Nome do Plano\t \n";
        for (int i = 0; i < tamb; i++) {
            resultado += todos.get(i).getIdPlanoSaude() + "\t" + todos.get(i).getNomePlano()+"\n";
        }
        return resultado;
    }
}
