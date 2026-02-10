package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main implements ActionListener {
    JFrame janela;
    JMenuItem jmiPacientesCad, jmiPacientesCons, jmiPacienteAlt, jmiPacienteExc, jmiMedicoCad, jmiMedicoCons, jmiMedicoAlt, jmiMedicoExc,
            jmiDoencasCad, jmiDoencasCons, jmiDoencasAlt, jmiDoencasExc,
            jmiConsultaCad, jmiConsultaCons, jmiConsultaAlt, jmiConsultaExc,jmiReceitasMedicaCad, jmiReceitasMedicaCons,jmiReceitasMedicaAlt,
            jmiReceitasMedicaExc,jmiRemediosCons, jmiSalasMedicaCons,
            jmiPlanoSaudeCons, jmiEspecialidadeCons, jmiFinalizar;

    public Main() {
        janela = new JFrame("Patient Cloud");
        janela.setSize(400, 200);
        janela.setLocationRelativeTo(null);
        janela.getContentPane().setBackground(new Color(17, 59, 225, 152));
        JMenuBar jMenuBar = new JMenuBar();
        janela.setJMenuBar(jMenuBar);
        jMenuBar.setBackground(new Color(89, 147, 198));
        JMenu jmCadrastar = new JMenu("Cadrastar ");
        JMenu jmConsultar = new JMenu("Consultar");
        JMenu jmAlterar = new JMenu("Alterar");
        JMenu jmExcluir = new JMenu("Excluir");
        JMenu jmSair = new JMenu("Sair");
        //instanciar o menu item ===>
        jmiPacientesCad = new JMenuItem("Paciente");
        jmiPacientesCons = new JMenuItem("Paciente");
        jmiPacienteAlt = new JMenuItem("Paciente");
        jmiPacienteExc = new JMenuItem("Paciente");
        jmiMedicoCad = new JMenuItem("Medico");
        jmiMedicoCons = new JMenuItem("Medico");
        jmiMedicoAlt = new JMenuItem("Medico");
        jmiMedicoExc = new JMenuItem("Medico");
        jmiDoencasCad = new JMenuItem("Doenças");
        jmiDoencasCons = new JMenuItem("Doenças");
        jmiDoencasAlt = new JMenuItem("Doenças");
        jmiDoencasExc = new JMenuItem("Doenças");
        jmiConsultaCad = new JMenuItem("Consulta");
        jmiConsultaCons = new JMenuItem("Consulta");
        jmiConsultaAlt=new JMenuItem("Consultas");
        jmiConsultaExc= new JMenuItem("Consultas");
        jmiReceitasMedicaCad=new JMenuItem("Receitas Medicas");
        jmiReceitasMedicaCons= new JMenuItem("Receitas Medicas");
        jmiReceitasMedicaAlt= new JMenuItem("Receitas Medicas");
        jmiReceitasMedicaExc= new JMenuItem("Receitas Medicas");
        jmiRemediosCons=new JMenuItem("Remedios");
        jmiSalasMedicaCons = new JMenuItem("Salas Medicas");
        jmiPlanoSaudeCons = new JMenuItem("Plano Saudes");
        jmiEspecialidadeCons = new JMenuItem("Especialidade");
        jmiFinalizar = new JMenuItem("Finalizar");
        // adicionar Menu á barra de menu
        jMenuBar.add(jmCadrastar);
        jMenuBar.add(jmConsultar);
        jMenuBar.add(jmAlterar);
        jMenuBar.add(jmExcluir);
        jMenuBar.add(jmSair);
        // adicionar MenuItem ao Menu ===> aqui
       jmCadrastar.add(jmiPacientesCad);
       jmConsultar.add(jmiPacientesCons);
       jmAlterar.add(jmiPacienteAlt);
       jmExcluir.add(jmiPacienteExc);
       jmCadrastar.add(jmiMedicoCad);
       jmConsultar.add(jmiMedicoCons);
       jmAlterar.add(jmiMedicoAlt);
       jmExcluir.add(jmiMedicoExc);
       jmCadrastar.add(jmiDoencasCad);
       jmConsultar.add(jmiDoencasCons);
       jmAlterar.add(jmiDoencasAlt);
       jmExcluir.add(jmiDoencasExc);
       jmCadrastar.add(jmiConsultaCad);
        jmConsultar.add(jmiConsultaCons);
        jmAlterar.add(jmiConsultaAlt);
        jmExcluir.add(jmiConsultaExc);
        jmCadrastar.add(jmiReceitasMedicaCad);
        jmConsultar.add(jmiReceitasMedicaCons);
        jmAlterar.add(jmiReceitasMedicaAlt);
        jmExcluir.add(jmiReceitasMedicaExc);
        jmConsultar.add( jmiRemediosCons);
        jmConsultar.add(jmiSalasMedicaCons);
        jmConsultar.add(jmiPlanoSaudeCons);
        jmConsultar.add( jmiEspecialidadeCons);
       jmSair.add(jmiFinalizar);
       //adicionar ação ao botao
        jmiPacientesCad.addActionListener(this);
        jmiPacientesCons.addActionListener(this);
        jmiPacienteAlt.addActionListener(this);
        jmiPacienteExc.addActionListener(this);
        jmiMedicoCad.addActionListener(this);
        jmiMedicoCons.addActionListener(this);
        jmiMedicoAlt.addActionListener(this);
        jmiMedicoExc.addActionListener(this);
        jmiDoencasCad.addActionListener(this);
        jmiDoencasCons.addActionListener(this);
        jmiDoencasAlt.addActionListener(this);
        jmiDoencasExc.addActionListener(this);
        jmiConsultaCad.addActionListener(this);
        jmiConsultaCons.addActionListener(this);
        jmiConsultaAlt.addActionListener(this);
        jmiConsultaExc.addActionListener(this);
        jmiReceitasMedicaCad.addActionListener(this);
        jmiReceitasMedicaCons.addActionListener(this);
        jmiReceitasMedicaAlt.addActionListener(this);
        jmiReceitasMedicaExc.addActionListener(this);
        jmiRemediosCons.addActionListener(this);
        jmiSalasMedicaCons.addActionListener(this);
        jmiPlanoSaudeCons.addActionListener(this);
        jmiEspecialidadeCons.addActionListener(this);
        jmiFinalizar.addActionListener(this);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String resultado="";//consulta
        int id=0;//alterar e deleção
        CadrastroDoencas cadrastroDoencas = new CadrastroDoencas();
        if (e.getSource()== jmiFinalizar){
            System.exit(0);
        } else if (e.getSource()==jmiDoencasCad) {
            CadrastroDoencas.cadastrar();
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso");
        } else if (e.getSource()==jmiDoencasCons) {
            resultado=CadrastroDoencas.consultar();
            JTextArea areaTexto=new JTextArea(10,50);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(null,painel,"Consulta Doença",2);
        } else if (e.getSource()==jmiDoencasExc) {
            resultado=CadrastroDoencas.consultar();
            JTextArea areaTexto=new JTextArea(10,50);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja excluir",1));
            CadrastroDoencas.excluir(id);
            JOptionPane.showMessageDialog(null,"Resgistro excluído com sucesso");
        } else if (e.getSource()==jmiDoencasAlt){
            resultado=CadrastroDoencas.consultar();
            JTextArea areaTexto=new JTextArea(10,50);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja alterar",1));
            CadrastroDoencas.alterar(id);
            JOptionPane.showMessageDialog(null,"Resgistro alterar  com sucesso");
        } else if (e.getSource()==jmiRemediosCons) {
            resultado=CadrastroRemedios.consultar();
            JTextArea areaTexto=new JTextArea(10,50);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(null,painel,"Consulta Remedios",2);

        }else if (e.getSource()==jmiEspecialidadeCons) {
            resultado=CadrastroEspecialidade.consultar();
            JTextArea areaTexto=new JTextArea(10,50);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(null,painel,"Consulta Especialidade",2);

        } else if (e.getSource()==jmiPlanoSaudeCons) {
            resultado=CadrastroPlanosSaude.consultar();
            JTextArea areaTexto=new JTextArea(10,50);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(null,painel,"Consulta Plano de Saúde",2);
        } else if (e.getSource()==jmiSalasMedicaCons) {
            resultado=CadrastroSalasMedica.consultar();
            JTextArea areaTexto=new JTextArea(10,50);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(null,painel,"Consulta Salas Medicas",2);
        } else if (e.getSource()==jmiPacientesCad){
            CadastroPaciente.cadastrar();
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso");

        } else if (e.getSource()==jmiPacientesCons) {
        resultado=CadastroPaciente.consultar();
            JTextArea areaTexto=new JTextArea(10,50);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(null,painel,"Consulta do Paciente",2);
        } else if (e.getSource()==jmiPacienteAlt) {
            resultado=CadastroPaciente.consultar();
            JTextArea areaTexto=new JTextArea(10,50);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja alterar",1));
            CadastroPaciente.alterar(id);
            JOptionPane.showMessageDialog(null,"Resgistro alterar  com sucesso");
        } else if (e.getSource()==jmiPacienteExc) {
            resultado=CadastroPaciente.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja excluir",1));
            CadastroPaciente.excluir(id);
            JOptionPane.showMessageDialog(null,"Resgistro excluído com sucesso");
        } else if (e.getSource()==jmiMedicoCad) {
            CadastroMedicos.cadastrar();
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso");
        } else if (e.getSource()==jmiMedicoCons) {
            resultado=CadastroMedicos.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(null,painel,"Consulta do Medico",2);
        } else if (e.getSource()==jmiMedicoAlt) {
           resultado=CadastroMedicos.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja alterar",1));
            CadastroMedicos.alterar(id);
            JOptionPane.showMessageDialog(null,"Resgistro alterar  com sucesso");
        } else if (e.getSource()==jmiMedicoExc) {
            resultado=CadastroMedicos.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja excluir",1));
            CadastroMedicos.excluir(id);
            JOptionPane.showMessageDialog(null,"Resgistro excluído com sucesso");
        } else if (e.getSource()==jmiConsultaCad) {
            CadastroConsultas.cadastrar();
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso");
        } else if (e.getSource()==jmiConsultaCons) {
            resultado=CadastroConsultas.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(null,painel,"Consulta",2);
        } else if (e.getSource()==jmiConsultaAlt){
            resultado=CadastroConsultas.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja alterar",1));
            CadastroConsultas.alterar(id);
            JOptionPane.showMessageDialog(null,"Resgistro alterar  com sucesso");
        } else if (e.getSource()==jmiConsultaExc) {
            resultado=CadastroConsultas.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja excluir",1));
            CadastroConsultas.excluir(id);
            JOptionPane.showMessageDialog(null,"Resgistro excluído com sucesso");
        } else if (e.getSource()==jmiReceitasMedicaCad){
            CadastroReceitasMedicas.cadastrar();
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso");
        } else if (e.getSource()==jmiReceitasMedicaCons){
            resultado=CadastroReceitasMedicas.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(null,painel,"Consulta da recietas medicas",2);
        } else if (e.getSource()==jmiReceitasMedicaAlt) {
            resultado=CadastroReceitasMedicas.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja alterar",1));
            CadastroReceitasMedicas.alterar(id);
            JOptionPane.showMessageDialog(null,"Resgistro alterar  com sucesso");
        } else if (e.getSource()==jmiReceitasMedicaExc){
            resultado=CadastroReceitasMedicas.consultar();
            JTextArea areaTexto=new JTextArea(20,60);
            areaTexto.setText(resultado);
            areaTexto.setEditable(false);
            JScrollPane painel= new JScrollPane(areaTexto);
            id=Integer.parseInt(JOptionPane.showInputDialog(null,painel,"Digite o id que deseja excluir",1));
            CadastroReceitasMedicas.excluir(id);
            JOptionPane.showMessageDialog(null,"Resgistro excluído com sucesso");

        }
    }
}