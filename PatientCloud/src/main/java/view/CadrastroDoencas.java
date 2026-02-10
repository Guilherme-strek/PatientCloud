package view;

import dao.DoencasDao;
import model.Doencas;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.List;

public class CadrastroDoencas {
    public static void cadastrar() {
        EntityManager em = JPAUtil.getEntityMAnager();
        DoencasDao doencasDao = new DoencasDao(em);
        String descricaoDoencas = JOptionPane.showInputDialog("Digite a descrição doenças");
        String CID = JOptionPane.showInputDialog("Digite a doenção");
        //instaciar a classe
        Doencas doencas = new Doencas(descricaoDoencas, CID);

        em.getTransaction().begin();
        doencasDao.cadastrar(doencas);
        em.getTransaction().commit();
        em.close();
    }
    public static String consultar(){
        EntityManager em = JPAUtil.getEntityMAnager();
        DoencasDao doencasDao = new DoencasDao(em);
        List<Doencas> todos = doencasDao.consultarTodos();
        int tamb = todos.size();
        String resultado = "ID \t Descricao\t CID\n";
        for (int i =0;i<tamb;i++){
            resultado +=todos.get(i).getIdDoenca()+"\t"+ todos.get(i).getDescricaoDoenca()+"\t"+todos.get(i).getCID() +"\n";
        }
        return resultado;
    }
   public  static  void  excluir(int id){
       EntityManager em = JPAUtil.getEntityMAnager();
       DoencasDao doencasDao = new DoencasDao(em);
       Doencas doencas = doencasDao.consultarPorId(id);
       em.getTransaction().begin(); //inicializa a transação
       doencasDao.remover(doencas);// excluir do banco de dados
       em.getTransaction().commit();//valida a exclusão
       em.close();//encerra a transação
   }
public  static  void alterar(int id){
    EntityManager em = JPAUtil.getEntityMAnager();
    DoencasDao doencasDao = new DoencasDao(em);
    String descricaoDoencas = JOptionPane.showInputDialog("Digite a descrição doenças");
    String CID = JOptionPane.showInputDialog("Digite a doenção");
    Doencas doencas = doencasDao.consultarPorId(id);
    em.getTransaction().begin();
    doencasDao.alterar(doencas);
    doencas.setDescricaoDoenca(descricaoDoencas);
    doencas.setCID(CID);
    em.getTransaction().commit();
    em.close();
}
}