public class Veiculo {
    private final String placa;
    private final String modelo;
    private double valorDiaria;
    private boolean disponivel;

    public Veiculo(String placa, String modelo, double valorDiaria) {
        if (placa == null || placa.isBlank())
            throw new IllegalArgumentException("Placa é obrigatória.");
        if (modelo == null || modelo.isBlank())
            throw new IllegalArgumentException("Modelo é obrigatório.");
        if (valorDiaria <= 0)
            throw new IllegalArgumentException("Valor da diária deve ser positivo.");

        this.placa = placa;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
        this.disponivel = true; // todo veículo começa disponível
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public double getValorDiaria() { return valorDiaria; }
    public boolean isDisponivel() { return disponivel; }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria <= 0)
            throw new IllegalArgumentException("Valor da diária inválido.");
        this.valorDiaria = valorDiaria;
    }

    public void alugar() {
        if (!disponivel)
            throw new IllegalStateException("Veículo já está alugado: " + placa);
        disponivel = false;
    }


    public void devolver() {
        if (disponivel)
            throw new IllegalStateException("Veículo não está alugado: " + placa);
        disponivel = true;
    }
}
