package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Aluno;
import classes.Disciplina;
import classes.Login;
import classes.Pessoa;
import constantes.StatusAluno;

public class Main {
    public static void main(String[] args) {

        Login login = new Login();
        String usuario = JOptionPane.showInputDialog("Usuario: ");
        login.setUsuario(usuario);
        String senha = JOptionPane.showInputDialog("Senha: ");
        login.setSenha(senha);


        if (login.getUsuario().equalsIgnoreCase("admin") && login.getSenha().equalsIgnoreCase("admin")){
            List<Aluno> alunos = new ArrayList<Aluno>();

            HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

            for (int qtd = 1; qtd <= 3; qtd++) {
                    String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd + "? ");
                    String cpf = JOptionPane.showInputDialog("Número do cpf: ");
                    String rg = JOptionPane.showInputDialog("Número do rg: ");
                    String matricula = JOptionPane.showInputDialog("Digite a matrícula: ");
                    String idade = JOptionPane.showInputDialog("Qual a idade? ");
                    String serie = JOptionPane.showInputDialog("Qual a serie?");
                    String dataDeNascimento = JOptionPane.showInputDialog("Qual a data de nascimento? ");
                    String turmaAluno = JOptionPane.showInputDialog("Qual a turma? ");
                    
                    Aluno aluno1 = new Aluno();
                    Pessoa pessoa1 = new Pessoa();
                    pessoa1.setNome(nome);
                    pessoa1.setIdade(Integer.valueOf(idade));
                    pessoa1.setDataNascimento(dataDeNascimento);
                    pessoa1.setCpf(Long.valueOf(cpf));
                    pessoa1.setRegistroGeral(Long.valueOf(rg));
                    
                    aluno1.setMatricula(matricula);
                    aluno1.setSerie(serie);
                    aluno1.setTurma(turmaAluno);
                    aluno1.setPessoa(pessoa1);
                    

                    //Adiciona disciplinas do aluno
                    for (int pos = 1; pos <= 3; pos++) {
                        String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ?");
                        String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + pos + " ?");

                        Disciplina disciplina = new Disciplina();
                        disciplina.setDisciplina(nomeDisciplina);
                        disciplina.setNota(Double.valueOf(notaDisciplina));

                        aluno1.getDisciplinas().add(disciplina);
                    }

                    //Remove disciplinas
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

            maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
            maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
            maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

            //Obtem media e resultado
            for (int pos = 0; pos < alunos.size(); pos++) {
                Aluno aluno = alunos.get(pos);
                
                System.out.println("Aluno: " + aluno.getPessoa().getNome());
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
                    maps.get(StatusAluno.APROVADO).add(aluno);
                }
                else if (aluno.verificaAprovacao().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                    maps.get(StatusAluno.RECUPERACAO).add(aluno);
                }
                else if (aluno.verificaAprovacao().equalsIgnoreCase(StatusAluno.REPROVADO)) {
                    maps.get(StatusAluno.REPROVADO).add(aluno);
                }
            }

            //Imprime listas
            System.out.println("----------------Lista de Aprovados----------------");
            for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
                System.out.println("Nome: " + aluno.getPessoa().getNome() + " Media: " + aluno.calcularMedia() + " Status: " + aluno.verificaAprovacao());
            }

            System.out.println("----------------Lista em Recuperação----------------");
            for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
                System.out.println("Nome: " + aluno.getPessoa().getNome() + " Media: " + aluno.calcularMedia() + " Status: " + aluno.verificaAprovacao());
            }

            System.out.println("----------------Lista de Reprovados----------------");
            for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
                System.out.println("Nome: " + aluno.getPessoa().getNome() + " Media: " + aluno.calcularMedia() + " Status: " + aluno.verificaAprovacao());
            }
        }
    }
}
