package classes;

import java.util.ArrayList;
import java.util.List;

import constantes.StatusAluno;

public class Aluno {
    private String matricula;
    private String serie;
    private String turma;

    private Pessoa pessoa;

    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
    
    public Aluno() {
        
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTurma() {
        return this.turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }


    @Override
    public String toString() {
        return "{" +
            " matricula='" + getMatricula() + "'" +
            ", serie='" + getSerie() + "'" +
            ", turma='" + getTurma() + "'" +
            ", pessoa='" + getPessoa() + "'" +
            ", disciplinas='" + getDisciplinas() + "'" +
            "}";
    }

    
    public double calcularMedia(){
        double somaNotas = 0;
        for (Disciplina disciplina : disciplinas) {
            somaNotas += disciplina.getNota();
        }

        return somaNotas / disciplinas.size();
    }

    public String verificaAprovacao() {
        double media = this.calcularMedia();
        if (media >= 50) {
            if (media >= 70) {
                return StatusAluno.APROVADO;
            } else {
                return StatusAluno.RECUPERACAO;
            }
        }
        return StatusAluno.REPROVADO;
    }

}

    
