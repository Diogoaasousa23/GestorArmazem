public class Transportadora {
    private String id;
    private String nome;
    private double capacidadePeso;
    private double capacidadeVolume;
    private boolean especial; // Indica se é transporte especial (para reciclagem)

    public Transportadora(String id, String nome, double capacidadePeso, double capacidadeVolume, boolean especial) {
        this.id = id;
        this.nome = nome;
        this.capacidadePeso = capacidadePeso;
        this.capacidadeVolume = capacidadeVolume;
        this.especial = especial;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void transportar(Mercadoria mercadoria, Armazem origem, Armazem destino) {
        if (capacidadePeso >= mercadoria.getPeso() && capacidadeVolume >= mercadoria.getVolume()) {
            if (origem.isReciclagem()) {
                System.out.println("Não é permitido mover mercadorias de um armazém de reciclagem.");
            } else {
                origem.removerMercadoria(mercadoria);
                destino.adicionarMercadoria(mercadoria);
                mercadoria.movimentar(destino, this); // Atualiza o histórico da mercadoria
                System.out.println("Transportadora " + nome + " moveu " + mercadoria.getDescricao() +
                        " de " + origem.getNome() + " para " + destino.getNome());
            }
        } else {
            System.out.println("Capacidade insuficiente na transportadora " + nome +
                    " para a mercadoria " + mercadoria.getDescricao());
        }
    }

    public double getCapacidadePeso() {
        return capacidadePeso;
    }
    
    public double getCapacidadeVolume() {
        return capacidadeVolume;
    }
    

    public boolean isEspecial() {
        return especial;
    }
}
