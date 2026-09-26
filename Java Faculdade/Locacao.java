import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {
    private final Cliente cliente;    
    private final Veiculo veiculo;
    private final LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    private double valorTotal;
    private boolean devolvido;

    public Locacao(Cliente cliente, Veiculo veiculo) {
        if (cliente == null || veiculo == null)
            throw new IllegalArgumentException("Locação precisa de cliente e veículo.");
        if (!veiculo.isDisponivel())
            throw new IllegalStateException("Veículo já está alugado: " + veiculo.getPlaca());

        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataRetirada = LocalDate.now();
        this.devolvido = false;

        veiculo.alugar();
    }

    public void devolver() {
        if (devolvido)
            throw new IllegalStateException("Locação já foi devolvida.");
        this.dataDevolucao = LocalDate.now();

        long dias = ChronoUnit.DAYS.between(dataRetirada, dataDevolucao);
        if (dias <= 0) dias = 1;
        this.valorTotal = dias * veiculo.getValorDiaria();

        veiculo.devolver(); 
        devolvido = true;
    }

    public double getValorTotal() {
        if (!devolvido)
            throw new IllegalStateException("Valor só disponível após devolução.");
        return valorTotal;
    }

    public Cliente getCliente() { return cliente; }
    public Veiculo getVeiculo() { return veiculo; }
    public LocalDate getDataRetirada() { return dataRetirada; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public boolean isDevolvido() { return devolvido; }
}
