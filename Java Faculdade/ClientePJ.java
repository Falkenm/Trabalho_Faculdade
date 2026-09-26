public class ClientePJ extends Cliente {
    public ClientePJ(String nome, String email, String telefone, String cnpj) {
        super(nome, email, telefone, cnpj);
    }

    @Override
    public int limiteDeLocacoes() {
        return 5;
    }
}
