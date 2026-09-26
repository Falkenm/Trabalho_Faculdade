public class ClientePF extends Cliente {
    public ClientePF(String nome, String email, String telefone, String cpf) {
        super(nome, email, telefone, cpf);
    }

    @Override
    public int limiteDeLocacoes() {
        return 2;
    }
}
