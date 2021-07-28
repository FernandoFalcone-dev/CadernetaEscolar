package classes;

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
    public String toString() {
        return "{" +
            " nota='" + getNota() + "'" +
            ", disciplina='" + getDisciplina() + "'" +
            "}";
    }


}

