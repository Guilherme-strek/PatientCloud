package view;

import dao.EspecialidadesDao;
import dao.MedicoDao;
import dao.PacienteDao;
import model.Especialidades;
import model.Medicos;
import model.Pacientes;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CadastroMedicos {
    public static void cadastrar() {
        EntityManager em = JPAUtil.getEntityMAnager();
        MedicoDao medicoDao = new MedicoDao(em);
        String nomeMedico = JOptionPane.showInputDialog("Digite o nome do medico");
        String cpf = JOptionPane.showInputDialog("Digite o cpf do medico");
        String telefone = JOptionPane.showInputDialog("Digite o telefone");
        String email = JOptionPane.showInputDialog("Digite o email");
        Date data;
        String resultado = JOptionPane.showInputDialog(null, "Data de Nacimento (ex:ano/mes/dia)");
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        int CRM = Integer.parseInt(JOptionPane.showInputDialog("Digite o CRM do medico"));
        resultado = CadrastroEspecialidade.consultar();
        int idEspecialidade = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolhe a especialidade do medico pelo id"));
        Medicos medicos = new Medicos(nomeMedico, cpf, telefone, email, data, CRM, idEspecialidade);
        em.getTransaction().begin();
        medicoDao.cadastrar(medicos);
        em.getTransaction().commit();
        em.close();
    }
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityMAnager();
        MedicoDao medicoDao = new MedicoDao(em);
        EspecialidadesDao especialidadesDao= new EspecialidadesDao(em);
        List<Medicos> todos = medicoDao.consultarTodos();
        int tamb = todos.size();
        String resultado = "ID \t Nome \t Cpf \t Telefone \t Email \t Data de Nascimento \t Crm \t Especialidade\n";
        for (int i = 0; i < tamb; i++) {
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            Especialidades especialidades = especialidadesDao.consultarPorId(todos.get(i).getIdEspecialidade());
            resultado += todos.get(i).getIdMedico() + "\t" + todos.get(i).getNomeMedico() + "\t" + todos.get(i).getCpf()+"\t" + todos.get(i).getTelefone() +"\t"+
                    todos.get(i).getEmail() +"\t" +sdfData.format(todos.get(i).getDateNacimento())+"\t"+todos.get(i).getCRM() +"\t"+especialidades.getDescricaoEspecialidade() + "\n";
        }
        return resultado;
    }
    public static void alterar(int id) {
        EntityManager em = JPAUtil.getEntityMAnager();
        MedicoDao medicoDao = new MedicoDao(em);
        String nomeMedico = JOptionPane.showInputDialog("Digite o nome do medico");
        String cpf = JOptionPane.showInputDialog("Digite o cpf do medico");
        String telefone = JOptionPane.showInputDialog("Digite o telefone");
        String email = JOptionPane.showInputDialog("Digite o email");
        Date data;
        String resultado = JOptionPane.showInputDialog(null, "Data de Nacimento (ex:ano/mes/dia)");
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        int CRM = Integer.parseInt(JOptionPane.showInputDialog("Digite o CRM do medico"));
        Medicos medicos= medicoDao.consultarPorId(id);
        em.getTransaction().begin();
        medicoDao.alterar(medicos);
        medicos.setNomeMedico(nomeMedico);
        medicos.setCpf(cpf);
        medicos.setTelefone(telefone);
        medicos.setEmail(email);
        medicos.setDateNacimento(data);
        medicos.setCRM(CRM);

    }
    public static void excluir(int id){
        EntityManager em = JPAUtil.getEntityMAnager();
        MedicoDao medicoDao = new MedicoDao(em);
        Medicos medicos= medicoDao.consultarPorId(id);
        em.getTransaction().begin(); //inicializa a transação
        medicoDao.remover(medicos);// excluir do banco de dados
        em.getTransaction().commit();//valida a exclusão
        em.close();//encerra a transação
    }
}