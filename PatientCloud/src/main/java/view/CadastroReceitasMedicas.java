package view;


import dao.ConsultasDao;
import dao.ReceitasMedicasDao;
import dao.RemediosDao;
import model.Consultas;
import model.ReceitasMedicas;
import model.Remedios;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.List;

public class CadastroReceitasMedicas {
    public static void cadastrar() {
        EntityManager em = JPAUtil.getEntityMAnager();
        ReceitasMedicasDao receitasMedicasDao = new ReceitasMedicasDao(em);
        int idConsultas= Integer.parseInt(JOptionPane.showInputDialog("Digite o id da consulta"));
        int  idRemedio=Integer.parseInt(JOptionPane.showInputDialog("Digite o id do remedio"));
        String dose=JOptionPane.showInputDialog("Digite a dose do remedio");
        ReceitasMedicas receitasMedicas= new ReceitasMedicas(idConsultas,idRemedio,dose);
        em.getTransaction().begin();
        receitasMedicasDao.cadastrar(receitasMedicas);
        em.getTransaction().commit();
        em.close();
    }
    public static String consultar(){
        EntityManager em = JPAUtil.getEntityMAnager();
        ReceitasMedicasDao receitasMedicasDao = new ReceitasMedicasDao(em);
        ConsultasDao consultasDao = new ConsultasDao(em);
        RemediosDao remediosDao = new RemediosDao(em);
        List<ReceitasMedicas> todos = receitasMedicasDao.consultarTodos();
        int tamb = todos.size();
        String resultado = "ID \t Consultas \t Remedio  \t Dose\n";
        for (int i = 0; i < tamb; i++) {
            Consultas consultas= consultasDao.consultarPorId(todos.get(i).getIdConsulta());
            Remedios remedios=remediosDao.consultarPorId(todos.get(i).getIdRemedio());
            resultado+=todos.get(i).getIdreceitaMedicas()+"\t"+ todos.get(i).getIdConsulta()+"\t"+ todos.get(i).getIdRemedio()+"\t"+todos.get(i).getDose()+"\n";
        }
        return resultado;
    }
    public static void alterar(int id) {
        EntityManager em = JPAUtil.getEntityMAnager();
        ReceitasMedicasDao receitasMedicasDao = new ReceitasMedicasDao(em);
        int idConsultas= Integer.parseInt(JOptionPane.showInputDialog("Digite o id da consulta"));
        int  idRemedio=Integer.parseInt(JOptionPane.showInputDialog("Digite o id do remedio"));
        String dose=JOptionPane.showInputDialog("Digite a dose do remedio");
        ReceitasMedicas receitasMedicas=receitasMedicasDao.consultarPorId(id);
        em.getTransaction().begin();
        receitasMedicas.setIdConsulta(idConsultas);
        receitasMedicas.setIdRemedio(idRemedio);
        receitasMedicas.setDose(dose);
    }
    public static void excluir(int id){
        EntityManager em = JPAUtil.getEntityMAnager();
        ReceitasMedicasDao receitasMedicasDao = new ReceitasMedicasDao(em);
        ReceitasMedicas receitasMedicas=receitasMedicasDao.consultarPorId(id);
        em.getTransaction().begin();
        receitasMedicasDao.remover(receitasMedicas);
        em.getTransaction().commit();//valida a exclusão
        em.close();
    }
}