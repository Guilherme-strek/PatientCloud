package view;

import dao.RemediosDao;
import model.Remedios;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CadrastroRemedios {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityMAnager();
       RemediosDao remediosDao = new RemediosDao(em);
        List<Remedios> todos = remediosDao.consultarTodos();
        int tamb = todos.size();
        String resultado = "ID \t Descricao\t \n";
        for (int i = 0; i < tamb; i++) {
            resultado += todos.get(i).getIdRemedio() + "\t" + todos.get(i).getDescricaoRemedio()+"\n";
        }
        return resultado;
    }
}