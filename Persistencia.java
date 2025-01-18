import java.io.*;
import java.util.ArrayList;

public class Persistencia {

    // Salvar os armazéns, mercadorias e transportadoras
    public static void salvarDados(ArrayList<Armazem> armazens, ArrayList<Mercadoria> mercadorias, ArrayList<Transportadora> transportadoras) {
        try (ObjectOutputStream armazemOut = new ObjectOutputStream(new FileOutputStream("armazens.dat"));
             ObjectOutputStream mercadoriaOut = new ObjectOutputStream(new FileOutputStream("mercadorias.dat"));
             ObjectOutputStream transportadoraOut = new ObjectOutputStream(new FileOutputStream("transportadoras.dat"))) {
            
            armazemOut.writeObject(armazens);
            mercadoriaOut.writeObject(mercadorias);
            transportadoraOut.writeObject(transportadoras);
            
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Carregar os armazéns, mercadorias e transportadoras
    @SuppressWarnings("unchecked")
    public static void carregarDados(ArrayList<Armazem> armazens, ArrayList<Mercadoria> mercadorias, ArrayList<Transportadora> transportadoras) {
        try (ObjectInputStream armazemIn = new ObjectInputStream(new FileInputStream("armazens.dat"));
             ObjectInputStream mercadoriaIn = new ObjectInputStream(new FileInputStream("mercadorias.dat"));
             ObjectInputStream transportadoraIn = new ObjectInputStream(new FileInputStream("transportadoras.dat"))) {

            ArrayList<Armazem> armazemList = (ArrayList<Armazem>) armazemIn.readObject();
            armazens.addAll(armazemList);
            armazens.addAll((ArrayList<Armazem>) armazemIn.readObject());
            mercadorias.addAll((ArrayList<Mercadoria>) mercadoriaIn.readObject());
            transportadoras.addAll((ArrayList<Transportadora>) transportadoraIn.readObject());
            
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}
