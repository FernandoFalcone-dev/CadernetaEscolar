package classes;

import java.util.Objects;

public class Disciplina {
    private double nota;
    private String disciplina;
    

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Disciplina)) {
            return false;
        }
        Disciplina disciplina = (Disciplina) o;
        return nota == disciplina.nota && Objects.equals(disciplina, disciplina.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nota, disciplina);
    }


    @Override
    public String toString() {
        return "{" +
            " nota='" + getNota() + "'" +
            ", disciplina='" + getDisciplina() + "'" +
            "}";
    }


}

