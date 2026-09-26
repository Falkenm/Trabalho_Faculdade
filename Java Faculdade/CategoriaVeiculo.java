import java.util.ArrayList;
import java.util.List;

public class CategoriaVeiculo {
    private final String nome;
    private final List<Veiculo> veiculos = new ArrayList<>(); // AGREGAÇÃO

    public CategoriaVeiculo(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome da categoria é obrigatório.");
        this.nome = nome;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo != null && !veiculos.contains(veiculo)) {
            veiculos.add(veiculo); 
        }
    }

    public String getNome() { return nome; }
    public List<Veiculo> getVeiculos() { return List.copyOf(veiculos); }
}
