package classes;


public class Pessoa {
    private String nome;
    private Integer idade;
    private String dataNascimento;
    private Long registroGeral;
    private Long cpf;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public Long getRegistroGeral() {
        return this.registroGeral;
    }

    public void setRegistroGeral(Long registroGeral) {
        this.registroGeral = registroGeral;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

}
