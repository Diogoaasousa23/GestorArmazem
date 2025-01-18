import java.io.*;
import java.util.ArrayList;

public class Relatorio {

    // Gera o relatório de mercadorias e seus históricos
    public static void gerarRelatorioMercadorias(ArrayList<Mercadoria> mercadorias) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_mercadorias.txt"))) {
            for (Mercadoria mercadoria : mercadorias) {
                writer.write("ID: " + mercadoria.getId() + "\n");
                writer.write("Descrição: " + mercadoria.getDescricao() + "\n");
                writer.write("Tipo: " + mercadoria.getTipo() + "\n");
                writer.write("Peso: " + mercadoria.getPeso() + "\n");
                writer.write("Volume: " + mercadoria.getVolume() + "\n");
                writer.write("Tag IoT: " + mercadoria.getTagIoT() + "\n");
                writer.write("Armazém Atual: " + (mercadoria.getArmazemAtual() != null ? mercadoria.getArmazemAtual().getNome() : "Não alocada") + "\n");
                writer.write("Histórico de Movimentações:\n");
                for (String h : mercadoria.getHistorico()) {
                    writer.write(h + "\n");
                }
                writer.write("\n");
            }
            System.out.println("Relatório de mercadorias gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de mercadorias: " + e.getMessage());
        }
    }

    // Gera o relatório de rastreabilidade de uma mercadoria
    public static void gerarRastreabilidadeMercadoria(Mercadoria mercadoria) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rastreabilidade_mercadoria_" + mercadoria.getId() + ".txt"))) {
            writer.write("Rastreabilidade da Mercadoria " + mercadoria.getDescricao() + "\n");
            writer.write("ID: " + mercadoria.getId() + "\n");
            writer.write("Tag IoT: " + mercadoria.getTagIoT() + "\n");
            writer.write("Histórico de Movimentações:\n");
            for (String h : mercadoria.historico) {
                writer.write(h + "\n");
            }
            writer.write("\n");
            System.out.println("Relatório de rastreabilidade gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de rastreabilidade: " + e.getMessage());
        }
    }

    // Gera o relatório de armazéns
    public static void gerarRelatorioArmazens(ArrayList<Armazem> armazens) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_armazens.txt"))) {
            for (Armazem armazem : armazens) {
                writer.write("Nome: " + armazem.getNome() + "\n");
                writer.write("Capacidade: " + armazem.getCapacidadeEspaco() + "\n");
                writer.write("Tipo: " + (armazem.isReciclagem() ? "Reciclagem" : "Comum") + "\n");
                writer.write("Mercadorias:\n");
                for (Mercadoria mercadoria : armazem.getMercadorias()) {
                    writer.write(" - " + mercadoria.getDescricao() + "\n");
                }
                writer.write("\n");
            }
            System.out.println("Relatório de armazéns gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de armazéns: " + e.getMessage());
        }
    }

    // Gera o relatório de transportadoras
    public static void gerarRelatorioTransportadoras(ArrayList<Transportadora> transportadoras) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_transportadoras.txt"))) {
            for (Transportadora transportadora : transportadoras) {
                writer.write("Nome: " + transportadora.getNome() + "\n");
                writer.write("ID: " + transportadora.getId() + "\n");
                writer.write("Capacidade de Peso: " + transportadora.getCapacidadePeso() + "\n");
                writer.write("Capacidade de Volume: " + transportadora.getCapacidadeVolume() + "\n");
                writer.write("Especial: " + (transportadora.isEspecial() ? "Sim" : "Não") + "\n");
                writer.write("\n");
            }
            System.out.println("Relatório de transportadoras gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de transportadoras: " + e.getMessage());
        }
    }
}
