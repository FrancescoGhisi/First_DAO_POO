package model;

import dao.AlunoDAO;

import javax.swing.*;
import java.util.ArrayList;

public class Aluno extends Pessoa {
    private String curso;
    private int fase;

    public Aluno() {
        this(0, 0, "", "", 0);
    }

    public Aluno(String curso, int fase) {
        this.curso = curso;
        this.fase = fase;
    }

    public Aluno(int id, int idade, String nome, String curso, int fase) {
        super(id, idade, nome);
        this.curso = curso;
        this.fase = fase;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public void fazerAniversario() {
        super.fazerAniversario();
    }

    @Override
    public void mostrarDados() {
        System.out.println("ID: " + super.getId());
        System.out.println("Nome: " + super.getNome());
        System.out.println("Idade: " + super.getIdade());
        System.out.println("Curso: " + curso);
        System.out.println("Fase: " + fase);
        System.out.println("Fase Final: " + super.getFaseFinal());
    }

    public boolean verificarFormando() {
        if (this.fase == 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarFormando(int fase) {
        if (fase == 10) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList getMinhaLista() {
        return AlunoDAO.getMinhaLista();
    }

    public void insertAlunoBD(Aluno objeto) {
        Aluno objetoAluno = new Aluno();
        objetoAluno.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do aluno:")));
        objetoAluno.setNome(JOptionPane.showInputDialog("Digite o Nome do aluno:"));
        objetoAluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno:")));
        objetoAluno.setCurso(JOptionPane.showInputDialog("Digite o curso do aluno:"));
        objetoAluno.setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a fase do aluno:")));
        AlunoDAO.getMinhaLista().add(objetoAluno);
        System.out.println("Aluno adicionado com sucesso!");
    }

    public int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < AlunoDAO.getMinhaLista().size(); i++) {
            if (AlunoDAO.getMinhaLista().get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    public void leitura(Aluno objetoAluno) {
        int chaveProcura = (Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno: ")));
        int achei = -1;
        int i = objetoAluno.procuraIndice(chaveProcura);
        if (achei != i) {
            System.out.println("Nome  :" + AlunoDAO.getMinhaLista().get(i).getNome());
            System.out.println("Idade :" + AlunoDAO.getMinhaLista().get(i).getIdade());
            achei = 1;
        }
        if (achei != 1) {
            System.out.println("Não encontrei o aluno com o id: " + chaveProcura);
        }
    }

    public void atualizar(Aluno objetoAluno) {
        int chaveAlteracao = (Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno a ser atualizado: ")));
        int achei = -1;
        int i = objetoAluno.procuraIndice(chaveAlteracao);
        if (achei != i) {
            AlunoDAO.getMinhaLista().get(i).setCurso(JOptionPane.showInputDialog("Digite o curso: "));
            AlunoDAO.getMinhaLista().get(i).setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a fase: ")));
            achei = 1;
        }
        if (achei != 1) {
            System.out.println("Não encontrei o aluno com o id: " + chaveAlteracao);
        }
    }

    public void listagemAlunos() {
        System.out.println("Listagem de alunos");
        for (int i = 0; i < AlunoDAO.getMinhaLista().size(); i++) {
            AlunoDAO.getMinhaLista().get(i).mostrarDados();
            System.out.println();
        }
    }

    public void excluirAluno(Aluno objetoAluno) {
        int chaveExclusao = (Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno a ser excluído: ")));
        int achei = -1;
        int i = objetoAluno.procuraIndice(chaveExclusao);
        if (achei != i) {
            AlunoDAO.getMinhaLista().remove(i);
            achei = i;
        }
        if (achei != -1) {
            System.out.println("Aluno de ID: " + chaveExclusao + " excluido!");
        } else {
            System.out.println("Não encontrei o aluno com o id " + chaveExclusao);
        }
    }

    public void menuPrincipal(Aluno objetoAluno) {
        int opcao = -1;
        while (opcao != 9) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    Menu de opções:
                    1 - Create (Criar)
                    2 - Read (Leitura)
                    3 - Update (Atualizar)
                    4 - Delete (Apagar)
                    5 - Listar Tudo
                    9 - Sair"""));
            switch (opcao) {
                case 1 -> objetoAluno.insertAlunoBD(objetoAluno);
                case 2 -> objetoAluno.leitura(objetoAluno);
                case 3 -> objetoAluno.atualizar(objetoAluno);
                case 4 -> objetoAluno.excluirAluno(objetoAluno);
                case 5 -> objetoAluno.listagemAlunos();
                case 9 -> System.out.println("Saindo do programa!");
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}