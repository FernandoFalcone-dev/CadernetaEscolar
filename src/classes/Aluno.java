package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {
    private String nome;
    private int idade;
    private String matricula;
    private String serie;
    private String turma;
    private String dataNascimento;
    private String nomePai;
    private String nomeMae;

    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
    
    public Aluno() {
        
    }

    public Aluno(String nome, int idade, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomePai() {
        return this.nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return this.nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }


    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    

    @Override
    public String toString() {
        return 
            "\nnome='" + getNome() + "'" +
            "\nidade='" + getIdade() + "'" +
            "\nmatricula='" + getMatricula() + "'" +
            "\nturma='" + getTurma() + "'" +
            "\ndataNascimento='" + getDataNascimento() + "'" +
            "\nnomePai='" + getNomePai() + "'" +
            "\nnomeMae='" + getNomeMae() + "'" +
            "\nserie='" + getSerie() + "'"
            ;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aluno)) {
            return false;
        }
        Aluno aluno = (Aluno) o;
        return Objects.equals(nome, aluno.nome) && idade == aluno.idade && Objects.equals(matricula, aluno.matricula) && Objects.equals(serie, aluno.serie) && Objects.equals(turma, aluno.turma) && Objects.equals(dataNascimento, aluno.dataNascimento) && Objects.equals(nomePai, aluno.nomePai) && Objects.equals(nomeMae, aluno.nomeMae) && Objects.equals(disciplinas, aluno.disciplinas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, matricula, serie, turma, dataNascimento, nomePai, nomeMae, disciplinas);
    }


    
    public double calcularMedia(){
        double somaNotas = 0;
        for (Disciplina disciplina : disciplinas) {
            somaNotas += disciplina.getNota();
        }

        return somaNotas / disciplinas.size();
    }

    public String alunoAprovado() {
        double media = this.calcularMedia();
        if (media >= 50) {
            if (media >= 70) {
                return "Aluno está aprovado";
            } else {
                return "Aluno está em recuperação";
            }
        }
        return "Aluno está reprovado";
    }

}

    
