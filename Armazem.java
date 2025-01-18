import java.util.ArrayList;

public class Armazem {
    private String nome;
    private double capacidadeEspaco;
    private ArrayList<Mercadoria> mercadorias;
    private boolean reciclagem;  // Indica se o armazém é de reciclagem
    
    // Modificação do construtor
    public Armazem(String nome, String morada, double capacidadeEspaco, boolean reciclagem) {
        this.nome = nome;
        this.capacidadeEspaco = capacidadeEspaco;
        this.mercadorias = new ArrayList<>();
        this.reciclagem = reciclagem;
    }

    public String getNome() {
        return nome;
    }

    public boolean isReciclagem() {
        return reciclagem;
    }

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
