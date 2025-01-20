import java.io.*;
import java.util.ArrayList;

public class Persistencia {

    // Método para salvar os dados
    public static void salvarDados(ArrayList<Armazem> armazens, ArrayList<Mercadoria> mercadorias, ArrayList<Transportadora> transportadoras) {
        try {
            // Salvar armazéns
            BufferedWriter writerArmazens = new BufferedWriter(new FileWriter("armazens.txt"));
            for (Armazem armazem : armazens) {
                writerArmazens.write(armazem.getNome() + "," + armazem.getMorada() + "," + armazem.getCapacidadeEspaco() + "," + armazem.isReciclagem() + "\n");
            }
            writerArmazens.close();

            // Salvar mercadorias
            BufferedWriter writerMercadorias = new BufferedWriter(new FileWriter("mercadorias.txt"));
            for (Mercadoria mercadoria : mercadorias) {
                writerMercadorias.write(mercadoria.getId() + "," + mercadoria.getDescricao() + "," + mercadoria.getTipo() + "," + mercadoria.getPeso() + "," + mercadoria.getVolume() + "," + mercadoria.getTagIoT() + "\n");
            }
            writerMercadorias.close();

            // Salvar transportadoras
            BufferedWriter writerTransportadoras = new BufferedWriter(new FileWriter("transportadoras.txt"));
            for (Transportadora transportadora : transportadoras) {
                writerTransportadoras.write(transportadora.getId() + "," + transportadora.getNome() + "," + transportadora.getCapacidadePeso() + "," + transportadora.getCapacidadeVolume() + "," + transportadora.isEspecial() + "," + transportadora.isInterna() + "\n");
            }
            writerTransportadoras.close();

            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Método para carregar os dados
    public static void carregarDados(ArrayList<Armazem> armazens, ArrayList<Mercadoria> mercadorias, ArrayList<Transportadora> transportadoras) {
        try {
            // Carregar armazéns
            BufferedReader readerArmazens = new BufferedReader(new FileReader("armazens.txt"));
            String linha;
            while ((linha = readerArmazens.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                String morada = dados[1];
                double capacidadeEspaco = Double.parseDouble(dados[2]);
                boolean reciclagem = Boolean.parseBoolean(dados[3]);
                armazens.add(new Armazem(nome, morada, capacidadeEspaco, reciclagem));
            }
            readerArmazens.close();

            // Carregar mercadorias
            BufferedReader readerMercadorias = new BufferedReader(new FileReader("mercadorias.txt"));
            while ((linha = readerMercadorias.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String descricao = dados[1];
                String tipo = dados[2];
                double peso = Double.parseDouble(dados[3]);
                double volume = Double.parseDouble(dados[4]);
                String tagIoT = dados[5];
                mercadorias.add(new Mercadoria(id, descricao, tipo, peso, volume, tagIoT));
            }
            readerMercadorias.close();

            // Carregar transportadoras
            BufferedReader readerTransportadoras = new BufferedReader(new FileReader("transportadoras.txt"));
            while ((linha = readerTransportadoras.readLine()) != null) {
                String[] dados = linha.split(",");
                String id = dados[0];
                String nome = dados[1];
                double capacidadePeso = Double.parseDouble(dados[2]);
                double capacidadeVolume = Double.parseDouble(dados[3]);
                boolean especial = Boolean.parseBoolean(dados[4]);
                boolean interna = Boolean.parseBoolean(dados[5]);
                transportadoras.add(new Transportadora(id, nome, capacidadePeso, capacidadeVolume, especial, interna));
            }
            readerTransportadoras.close();

            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}
