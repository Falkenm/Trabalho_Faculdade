public abstract class Cliente {
    private final String nome;
    private final String email; 
    private final String telefone;
    private final String documento;


    public Cliente(String nome, String email, String telefone, String documento){
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome é Obrigatório");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("E-mail Inválido: " + email);
        if (telefone == null || telefone.isBlank())
            throw new IllegalArgumentException("Telefone é Obrigatório");
        if (documento == null || documento.isBlank())
            throw new IllegalArgumentException("Documento é Obrigatório");
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.documento = documento;
    
    }

    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getTelefone() {return telefone;}
    public String getDocumento() {return documento;}

    public abstract int limiteDeLocacoes();
}