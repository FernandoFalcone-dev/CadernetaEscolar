package classes;

public class Diretor {
    private String registroEducacao;
    private Integer tempoDirecao;
    private String titulacao;

    private Pessoa pessoaDir;


    public String getRegistroEducacao() {
        return this.registroEducacao;
    }

    public void setRegistroEducacao(String registroEducacao) {
        this.registroEducacao = registroEducacao;
    }

    public Integer getTempoDirecao() {
        return this.tempoDirecao;
    }

    public void setTempoDirecao(Integer tempoDirecao) {
        this.tempoDirecao = tempoDirecao;
    }

    public String getTitulacao() {
        return this.titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Pessoa getPessoaDir() {
        return this.pessoaDir;
    }

    public void setPessoaDir(Pessoa pessoaDir) {
        this.pessoaDir = pessoaDir;
    }

}
