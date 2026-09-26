public class Main {
    public static void main(String[] args) {
        Cliente pf = new ClientePF("Victor", "victor@hotmail.com", "1199999-0000", "123.456.789-00");
        Cliente pj = new ClientePJ("Uber", "administracao@uber.com", "1133333-4444", "12.345.678/0001-99");

        System.out.println(pf.getNome() + ": limite " + pf.limiteDeLocacoes() + " locações");
        System.out.println(pj.getNome() + ": limite " + pj.limiteDeLocacoes() + " locações");

        Veiculo carro = new Veiculo("ABC-1234", "Fiat Uno", 100.0);

        CategoriaVeiculo economicos = new CategoriaVeiculo("Econômicos");
        economicos.adicionarVeiculo(carro);
        System.out.println("\nCategoria '" + economicos.getNome() + "' tem "
                + economicos.getVeiculos().size() + " veículo(s).");

        Locacao locacao = new Locacao(pf, carro);
        System.out.println("\nLocado " + carro.getModelo() + " para " + locacao.getCliente().getNome());

        try {
            Veiculo carroRecusado = new Veiculo("XYZ-9876", "Chevrolet Onix", 100.0);
            Locacao locacaoRecusada = new Locacao(pj, carroRecusado);
            System.out.println("Locação recusada: " + locacaoRecusada.getCliente().getNome());
        } catch (IllegalStateException e) {
            System.out.println("Recusado (invariante): " + e.getMessage());
        }
        locacao.devolver();
        System.out.println("Após devolução, valor total: R$ " + locacao.getValorTotal());
        System.out.println("Disponível novamente? " + carro.isDisponivel());
    }
}
