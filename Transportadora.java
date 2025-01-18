public class Transportadora {
    private String id;
    private double capacidadePeso;
    private double capacidadeVolume;
    private boolean especial; // Indica se é transporte especial (para reciclagem)

    public Transportadora(String id, double capacidadePeso, double capacidadeVolume, boolean especial) {
        this.id = id;
        this.capacidadePeso = capacidadePeso;
        this.capacidadeVolume = capacidadeVolume;
        this.especial = especial;
    }

    public void transportar(Mercadoria mercadoria, Armazem origem, Armazem destino) {
        // Verifica se a transportadora tem capacidade suficiente
        if (capacidadePeso >= mercadoria.getPeso() && capacidadeVolume >= mercadoria.getVolume()) {
            // Verifica se o armazém de origem é de reciclagem
            if (origem.isReciclagem()) {
                System.out.println("Não é permitido mover mercadorias de um armazém de reciclagem.");
            } else {
                // Se o armazém de origem não for de reciclagem, realiza a remoção e adição de mercadorias
                origem.removerMercadoria(mercadoria);
                destino.adicionarMercadoria(mercadoria);
                System.out.println("Transportadora " + id + " moveu " + mercadoria.getDescricao() + " de " + origem.getNome() + " para " + destino.getNome());
            }
        } else {
            System.out.println("Capacidade insuficiente na transportadora para a mercadoria " + mercadoria.getDescricao());
        }
    }

    public boolean isEspecial() {
        return especial;
    }
}
