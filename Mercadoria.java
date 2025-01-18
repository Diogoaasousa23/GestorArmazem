public class Mercadoria {
    private int id;
    private String descricao;
    private String tipo;
    private double peso;
    private double volume;
    private String tagIoT; // Identificador único da mercadoria
    private Armazem armazemAtual; // Armazém onde a mercadoria está
    public Mercadoria(int id, String descricao, String tipo, double peso, double volume, String tagIoT) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.peso = peso;
        this.volume = volume;
        this.tagIoT = tagIoT;
        this.armazemAtual = null; // Inicialmente não está em nenhum armazém
    }
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getTipo() { return tipo; }
    public double getPeso() { return peso; }
    public double getVolume() { return volume; }
    public String getTagIoT() { return tagIoT; }
    public Armazem getArmazemAtual() { return armazemAtual; }
    public void movimentar(Armazem novoArmazem) {
        // Agora, em vez de usar uma String, o método vai usar um objeto Armazem
        this.armazemAtual = novoArmazem;
        System.out.println("Mercadoria movida para o armazém: " + novoArmazem.getNome());
    }
    
    // Método para definir o armazém da mercadoria
    public void setArmazem(Armazem armazem) {
        this.armazemAtual = armazem;
    }
}