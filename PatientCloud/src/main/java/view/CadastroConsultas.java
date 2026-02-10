package view;

import dao.*;
import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CadastroConsultas {
    public static void cadastrar(){
        EntityManager em = JPAUtil.getEntityMAnager();
        ConsultasDao consultasDao = new ConsultasDao(em);
        Date data;
        String resultado = JOptionPane.showInputDialog(null, "Data de Nacimento (ex:ano/mes/dia)");
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        int idSalaMedica= Integer.parseInt(JOptionPane.showInputDialog("Digite o id da sala medica"));
        int  idPaciente=Integer.parseInt(JOptionPane.showInputDialog("Digite o id do paciente"));
        int idDoenca=Integer.parseInt(JOptionPane.showInputDialog("Digite o id da doenca"));
        int idMedico=Integer.parseInt(JOptionPane.showInputDialog("Digite o id do medico"));
        Consultas consultas = new Consultas(data,idSalaMedica,idPaciente,idDoenca,idMedico);
        em.getTransaction().begin();
        consultasDao.cadastrar(consultas);
        em.getTransaction().commit();
        em.close();
    }
    public static String consultar(){
        EntityManager em = JPAUtil.getEntityMAnager();
        ConsultasDao consultasDao = new ConsultasDao(em);
        SalasMedicaDao salasMedicaDao=new SalasMedicaDao(em);
        PacienteDao pacienteDao =new PacienteDao(em);
        DoencasDao doencasDao =new DoencasDao(em);
       MedicoDao medicoDao= new MedicoDao(em);
        List<Consultas> todos = consultasDao.consultarTodos();
        int tamb = todos.size();
        String resultado = "ID \t Data \t Sala Medica \t Paciente  \t Doenças \t Medicos\n";
        for (int i = 0; i < tamb; i++) {
            SalasMedica salasMedica= salasMedicaDao.consultarPorId(todos.get(i).getIdSalaMedica());
            Pacientes pacientes=pacienteDao.consultarPorId(todos.get(i).getIdPaciente());
            Doencas doencas=doencasDao.consultarPorId(todos.get(i).getIdDoenca());
            Medicos medicos = medicoDao.consultarPorId(todos.get(i).getIdMedico());
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            resultado+=todos.get(i).getIdConsulta() +  "\t"+ sdfData.format(todos.get(i).getDataConsulta())+ "\t" +salasMedica.getDescricaoSala()+"\t" +pacientes.getNomePaciente() +"\t" +
                    doencas.getCID() + "\t" + medicos.getNomeMedico()+"\n";
        }
        return resultado;
    }
    public static void alterar(int id) {
        EntityManager em = JPAUtil.getEntityMAnager();
        ConsultasDao consultasDao = new ConsultasDao(em);
        String resultado = JOptionPane.showInputDialog(null, "Data de Nacimento (ex:ano/mes/dia)");
        Date data;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        int idSalaMedica= Integer.parseInt(JOptionPane.showInputDialog("Digite o id da sala medica"));
        int  idPaciente=Integer.parseInt(JOptionPane.showInputDialog("Digite o id do paciente"));
        int idDoenca=Integer.parseInt(JOptionPane.showInputDialog("Digite o id da doenca"));
        int idMedico=Integer.parseInt(JOptionPane.showInputDialog("Digite o id do medico"));
      Consultas consultas= consultasDao.consultarPorId(id);
        em.getTransaction().begin();
        consultas.setDataConsulta(data);
        consultas.setIdSalaMedica(idSalaMedica);
        consultas.setIdPaciente(idPaciente);
        consultas.setIdDoenca(idDoenca);
        consultas.setIdMedico(idMedico);
    }
    public static void excluir(int id){
        EntityManager em = JPAUtil.getEntityMAnager();
        ConsultasDao consultasDao = new ConsultasDao(em);
        Consultas consultas=consultasDao.consultarPorId(id);
        em.getTransaction().begin(); //inicializa a transação
        consultasDao.remover(consultas);// excluir do banco de dados
        em.getTransaction().commit();//valida a exclusão
        em.close();
    }
}
