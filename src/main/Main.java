package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Aluno;
import classes.Disciplina;
import constantes.StatusAluno;

public class Main {
    public static void main(String[] args) {
        
        List<Aluno> alunos = new ArrayList<Aluno>();

        List<Aluno> alunosAprovados = new ArrayList<Aluno>();
        List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();
        List<Aluno> alunosReprovados = new ArrayList<Aluno>();

        for (int qtd = 1; qtd <= 5; qtd++) {
                String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd + "? ");
                String matricula = JOptionPane.showInputDialog("Digite a matrícula: ");
                String idade = JOptionPane.showInputDialog("Qual a idade? ");
                String serie = JOptionPane.showInputDialog("Qual a serie?");
                String dataDeNascimento = JOptionPane.showInputDialog("Qual a data de nascimento? ");
                String turmaAluno = JOptionPane.showInputDialog("Qual a turma? ");
                String nomeDoPai = JOptionPane.showInputDialog("Nome do pai? ");
                String nomeDaMae = JOptionPane.showInputDialog("Nome da mãe? ");
                
                Aluno aluno1 = new Aluno();
                aluno1.setNome(nome);
                aluno1.setMatricula(matricula);
                aluno1.setIdade(Integer.valueOf(idade));
                aluno1.setSerie(serie);
                aluno1.setDataNascimento(dataDeNascimento);
                aluno1.setTurma(turmaAluno);
                aluno1.setNomePai(nomeDoPai);
                aluno1.setNomeMae(nomeDaMae);

                //Adicionar disciplinas do aluno
                for (int pos = 1; pos <= 1; pos++) {
                    String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ?");
                    String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + pos + " ?");

                    Disciplina disciplina = new Disciplina();
                    disciplina.setDisciplina(nomeDisciplina);
                    disciplina.setNota(Double.valueOf(notaDisciplina));

                    aluno1.getDisciplinas().add(disciplina);
                }

                //Remover disciplinas
                int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

                while (escolha == 0) {
                    int posicao = 1;
                    String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina 1, 2, 3 ou 4");
                    aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
                    posicao++;
                    escolha = JOptionPane.showConfirmDialog(null, "Deseja remover outra disciplina?");
                }

            alunos.add(aluno1);
        }
        //Obter media e resultado
        for (int pos = 0; pos < alunos.size(); pos++) {
            Aluno aluno = alunos.get(pos);
            
            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Média do aluno: " + aluno.calcularMedia());
            System.out.println("Resultado: " + aluno.verificaAprovacao());      

            for (int posd = 0; posd < aluno.getDisciplinas().size(); posd++) {
                Disciplina disc = aluno.getDisciplinas().get(posd);
                System.out.println("Materia: " + disc.getDisciplina() + " Nota: " + disc.getNota());
            }
            System.out.println("-----------------------------------------------");
        }

        //Separa os alunos em 3 tipos de classificações
        for (Aluno aluno : alunos) {
            if (aluno.verificaAprovacao().equalsIgnoreCase(StatusAluno.APROVADO)) {
                alunosAprovados.add(aluno);
            }
            else if (aluno.verificaAprovacao().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                alunosRecuperacao.add(aluno);
            }
            else if (aluno.verificaAprovacao().equalsIgnoreCase(StatusAluno.REPROVADO)) {
                alunosReprovados.add(aluno);
            }
        }

        System.out.println("----------------Lista de Aprovados----------------");
        for (Aluno aluno : alunosAprovados) {
            System.out.println("Nome: " + aluno.getNome() + " Media: " + aluno.calcularMedia() + " Status: " + aluno.verificaAprovacao());
        }

        System.out.println("----------------Lista em Recuperação----------------");
        for (Aluno aluno : alunosRecuperacao) {
            System.out.println("Nome: " + aluno.getNome() + " Media: " + aluno.calcularMedia() + " Status: " + aluno.verificaAprovacao());
        }

        System.out.println("----------------Lista de Reprovados----------------");
        for (Aluno aluno : alunosReprovados) {
            System.out.println("Nome: " + aluno.getNome() + " Media: " + aluno.calcularMedia() + " Status: " + aluno.verificaAprovacao());
        }
    }
}
