import java.io.*;
import java.util.ArrayList;

public class Mercadoria {
    private int id;
    private String descricao;
    private String tipo;
    private double peso;
    private double volume;
    private String tagIoT; // Identificador único da mercadoria
    private Armazem armazemAtual; // Armazém onde a mercadoria está
    ArrayList<String> historico; // Histórico de movimentações

    // Construtor
    public Mercadoria(int id, String descricao, String tipo, double peso, double volume, String tagIoT) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.peso = peso;
        this.volume = volume;
        this.tagIoT = tagIoT;
        this.armazemAtual = null; // Inicialmente não está em nenhum armazém
        this.historico = new ArrayList<>(); // Inicialização do histórico
    }

    // Getters
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getTipo() { return tipo; }
    public double getPeso() { return peso; }
    public double getVolume() { return volume; }
    public String getTagIoT() { return tagIoT; }
    public Armazem getArmazemAtual() { return armazemAtual; }

    // Método de movimentação da mercadoria
    public void movimentar(Armazem novoArmazem, Transportadora transportadora) {
        this.armazemAtual = novoArmazem;
        String movimentacao = "Movida para " + novoArmazem.getNome() + " via transportadora " + transportadora.getNome();
        historico.add(movimentacao);
        System.out.println("Mercadoria movida para o armazém: " + novoArmazem.getNome());
    }

    // Setter para o armazém
    public void setArmazem(Armazem armazem) {
        this.armazemAtual = armazem;
    }

    // Adiciona uma nova movimentação ao histórico
    public void adicionarHistorico(String movimentacao) {
        historico.add(movimentacao);
    }

    // Getter para o histórico
    public ArrayList<String> getHistorico() {
        return historico;
    }

    // Método para salvar os dados da mercadoria em um arquivo
    public void salvar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("mercadoria_" + id + ".txt"))) {
            writer.write("ID: " + id + "\n");
            writer.write("Descrição: " + descricao + "\n");
            writer.write("Tipo: " + tipo + "\n");
            writer.write("Peso: " + peso + "\n");
            writer.write("Volume: " + volume + "\n");
            writer.write("Tag IoT: " + tagIoT + "\n");
            writer.write("Armazém Atual: " + (armazemAtual != null ? armazemAtual.getNome() : "Não alocada") + "\n");
            writer.write("Histórico de Movimentações:\n");
            for (String h : historico) {
                writer.write(h + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar a mercadoria: " + e.getMessage());
        }
    }
}
