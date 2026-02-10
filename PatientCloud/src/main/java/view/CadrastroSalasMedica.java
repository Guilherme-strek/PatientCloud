package view;

import dao.EspecialidadesDao;
import dao.SalasMedicaDao;
import model.Especialidades;
import model.SalasMedica;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CadrastroSalasMedica {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityMAnager();
        SalasMedicaDao salasMedicaDao = new SalasMedicaDao(em);
        List<SalasMedica> todos = salasMedicaDao.consultarTodos();
        int tamb = todos.size();
        String resultado = "ID \t Descricao\t \n";
        for (int i = 0; i < tamb; i++) {
            resultado += todos.get(i).getIdSalaMedica() + "\t" + todos.get(i).getDescricaoSala()+"\n";
        }
        return resultado;
    }
}
