import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Relatorio {

    public static void gerarRelatorioMercadorias(ArrayList<Mercadoria> mercadorias) {
        try {
            FileWriter writer = new FileWriter(new File("relatorio_mercadorias.txt"));
            for (Mercadoria mercadoria : mercadorias) {
                writer.write("ID: " + mercadoria.getId() + "\n");
                writer.write("Descrição: " + mercadoria.getDescricao() + "\n");
                writer.write("Tipo: " + mercadoria.getTipo() + "\n");
                writer.write("Peso: " + mercadoria.getPeso() + "\n");
                writer.write("Volume: " + mercadoria.getVolume() + "\n");
                writer.write("Tag IoT: " + mercadoria.getTagIoT() + "\n");
                // Adiciona o nome do armazém onde a mercadoria está
                if (mercadoria.getArmazemAtual() != null) {
                    writer.write("Armazém: " + mercadoria.getArmazemAtual().getNome() + "\n");
                } else {
                    writer.write("Armazém: Não alocada\n");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Relatório gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório.");
        }
    }
}
