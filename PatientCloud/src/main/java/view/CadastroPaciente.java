package view;

import dao.PacienteDao;
import dao.PlanosSaudeDao;
import model.Pacientes;
import model.PlanosSaude;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CadastroPaciente {

    public static void cadastrar() {
        EntityManager em = JPAUtil.getEntityMAnager();
        PacienteDao pacienteDao = new PacienteDao(em);
        String nomePaciente = JOptionPane.showInputDialog("Digite seu nome ");
        String cpf = JOptionPane.showInputDialog("Digite o seu CPF");
        System.out.println(cpf);
        String genero = JOptionPane.showInputDialog("Digite o seu genero (M/F)");
        Date data;
         String resultado = JOptionPane.showInputDialog(null,"Data de Nacimento (ex:ano/mes/dia)");
        try {
            data= new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        }catch (ParseException ex) {
            throw new RuntimeException(ex);
        }

        String fone = JOptionPane.showInputDialog("Digite o telefone do paciente");
        String email = JOptionPane.showInputDialog("Digite o email do paciente");
        resultado = CadrastroPlanosSaude.consultar();
        int idPlanoSaude = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha o plano de saude pelo id"));
        //instaciar a classe

        Pacientes pacientes = new Pacientes(nomePaciente, cpf, genero, data, fone, email, idPlanoSaude);
        em.getTransaction().begin();
        pacienteDao.cadastrar(pacientes);
        em.getTransaction().commit();
        em.close();
    }

    public static String consultar() {
        EntityManager em = JPAUtil.getEntityMAnager();
        PlanosSaudeDao planosSaudeDao = new PlanosSaudeDao(em);
        PacienteDao pacienteDao = new PacienteDao(em);
        List<Pacientes> todos = pacienteDao.consultarTodos();
        int tamb = todos.size();
        String resultado = "ID \t Nome\t CPF \t Genero \t Data Nacimento \t Telefone \t Email\t Plano de Saude\n";
        for (int i = 0; i < tamb; i++) {
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            PlanosSaude planosSaude = planosSaudeDao.consultarPorId(todos.get(i).getIdPlanoSaude());
                resultado += todos.get(i).getIdPaciente() +  "\t" + todos.get(i).getNomePaciente() +"\t" + todos.get(i).getCpf() +"\t" +
                        todos.get(i).getGenero() + "\t" +sdfData.format(todos.get(i).getDataNaci()) + "\t" +
                       todos.get(i).getFone() +  "\t" + todos.get(i).getEmail() +  "\t" + planosSaude.getNomePlano() + "\n";
            }
        return resultado;
    }

    public static void excluir(int id) {
        EntityManager em = JPAUtil.getEntityMAnager();
        PacienteDao pacienteDao = new PacienteDao(em);
        Pacientes pacientes = pacienteDao.consultarPorId(id);
        em.getTransaction().begin(); //inicializa a transação
        pacienteDao.remover(pacientes);// excluir do banco de dados
        em.getTransaction().commit();//valida a exclusão
        em.close();//encerra a transação
    }

    public static void alterar(int id) {
        EntityManager em = JPAUtil.getEntityMAnager();
        PacienteDao pacienteDao = new PacienteDao(em);
        String nomePaciente = JOptionPane.showInputDialog("Digite seu nome");
        String cpf = JOptionPane.showInputDialog("Digite o seu CPF");
        String genero = JOptionPane.showInputDialog("Digite o seu genero (M/F)");
        Date data;
        String resultado = JOptionPane.showInputDialog(null,"Data de Nacimento (ex:ano/mes/dia)");
        try {
            data= new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        }catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        String fone = JOptionPane.showInputDialog("Digite o telefone do paciente");
        String email = JOptionPane.showInputDialog("Digite o email do paciente");
        Pacientes pacientes = pacienteDao.consultarPorId(id);
        em.getTransaction().begin();
        pacienteDao.alterar(pacientes);
        pacientes.setNomePaciente(nomePaciente);
        pacientes.setCpf(cpf);
        pacientes.setGenero(genero);
        pacientes.setDataNaci(data);
        pacientes.setFone(fone);
        pacientes.setEmail(email);
        em.getTransaction().commit();
        em.close();
    }
}