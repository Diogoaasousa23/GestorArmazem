import java.util.ArrayList;

public class Armazem {
    private String nome;
    private String morada;  // Novo atributo morada
    private double capacidadeEspaco;
    private ArrayList<Mercadoria> mercadorias = new ArrayList<>();
    private boolean reciclagem;  // Indica se o armazém é de reciclagem

    // Modificação do construtor
    public Armazem(String nome, String morada, double capacidadeEspaco, boolean reciclagem) {
        this.nome = nome;
        this.morada = morada;  // Inicializando o campo morada
        this.capacidadeEspaco = capacidadeEspaco;
        this.mercadorias = new ArrayList<>();
        this.reciclagem = reciclagem;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;  // Getter para o campo morada
    }

    public boolean isReciclagem() {
        return reciclagem;
    }

    public double getCapacidadeEspaco() {
        return capacidadeEspaco;
    }

    public ArrayList<Mercadoria> getMercadorias() {
        return mercadorias;
    }

    // Método para adicionar mercadoria ao armazém
    public boolean adicionarMercadoria(Mercadoria mercadoria) {
        if (capacidadeEspaco >= mercadoria.getVolume()) {
            mercadorias.add(mercadoria);
            capacidadeEspaco -= mercadoria.getVolume();
            mercadoria.setArmazem(this); // Atualiza o armazém da mercadoria
            System.out.println("Mercadoria " + mercadoria.getDescricao() + " adicionada ao armazém.");
            return true;
        } else {
            System.out.println("Espaço insuficiente no armazém para a mercadoria " + mercadoria.getDescricao());
            return false;
        }
    }

    // Método para remover mercadoria do armazém
    public boolean removerMercadoria(Mercadoria mercadoria) {
        if (reciclagem) {
            // Armazéns de reciclagem não podem remover mercadorias
            System.out.println("Não é permitido remover mercadorias de um armazém de reciclagem.");
            return false;
        } else {
            if (mercadorias.remove(mercadoria)) {
                capacidadeEspaco += mercadoria.getVolume();
                System.out.println("Mercadoria " + mercadoria.getDescricao() + " removida do armazém.");
                return true;
            } else {
                System.out.println("Mercadoria não encontrada no armazém.");
                return false;
            }
        }
    }
}
