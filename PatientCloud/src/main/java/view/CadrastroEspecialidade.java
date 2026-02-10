package view;

import dao.EspecialidadesDao;
import dao.RemediosDao;
import model.Especialidades;
import model.Remedios;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CadrastroEspecialidade {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityMAnager();
       EspecialidadesDao especialidadesDao = new EspecialidadesDao(em);
        List<Especialidades> todos = especialidadesDao.consultarTodos();
        int tamb = todos.size();
        String resultado = "ID \t Descricao\t \n";
        for (int i = 0; i < tamb; i++) {
            resultado += todos.get(i).getIdEspecialidade() + "\t" + todos.get(i).getDescricaoEspecialidade()+"\n";
        }
        return resultado;
    }
}

