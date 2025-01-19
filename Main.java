import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Armazem> armazens = new ArrayList<>();
    private static ArrayList<Mercadoria> mercadorias = new ArrayList<>();
    private static ArrayList<Transportadora> transportadoras = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Carregar dados de arquivos ao iniciar
        Persistencia.carregarDados(armazens, mercadorias, transportadoras);
        
        boolean sair = false;
        while (!sair) {
            // Exibir Menu
            System.out.println("\n--- Sistema de Gestão de Armazéns ---");
            System.out.println("1. Criar Armazém");
            System.out.println("2. Criar Mercadoria");
            System.out.println("3. Criar Transportadora");
            System.out.println("4. Adicionar Mercadoria ao Armazém");
            System.out.println("5. Remover Mercadoria do Armazém");
            System.out.println("6. Movimentar Mercadoria");
            System.out.println("7. Localizar mercadoria por tag IoT");
            System.out.println("8. Gerar Relatório de Mercadorias");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            switch (opcao) {
                case 1:
                    criarArmazen(scanner);
                    break;
                case 2:
                    criarMercadoria(scanner);
                    break;
                case 3:
                    criarTransportadora(scanner);
                    break;
                case 4:
                    adicionarMercadoriaAoArmazem(scanner);
                    break;
                case 5:
                    removerMercadoriaDoArmazem(scanner);
                    break;
                case 6:
                    movimentarMercadoria(scanner);
                    break;
                case 7:
                    localizarMercadoriaPorTag(scanner);
                    break;
                case 8:
                    gerarRelatorio(scanner);
                    break;
                case 0:
                    // Salvar dados antes de sair
                    Persistencia.salvarDados(armazens, mercadorias, transportadoras);
                    sair = true;
                    System.out.println("Adeus");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void criarArmazen(Scanner scanner) {
        System.out.print("Digite o nome do armazém: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a morada do armazém: ");
        String morada = scanner.nextLine();
        System.out.print("Digite a capacidade do armazém (em metros cúbicos): ");
        double capacidadeEspaco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
    
        System.out.print("Este é um armazém de reciclagem? (true/false): ");
        boolean reciclagem = scanner.nextBoolean();
        scanner.nextLine(); // Limpar o buffer
    
        Armazem armazem = new Armazem(nome, morada, capacidadeEspaco, reciclagem);
        armazens.add(armazem);
        System.out.println("Armazém criado com sucesso!");
    }
    
    // Função para criar mercadoria
    private static void criarMercadoria(Scanner scanner) {
        System.out.print("Digite o ID da mercadoria: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite a descrição da mercadoria: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o tipo da mercadoria (Normal, Frágil, Perecível): ");
        String tipo = scanner.nextLine();
        System.out.print("Digite o peso da mercadoria (em kg): ");
        double peso = scanner.nextDouble();
        System.out.print("Digite o volume da mercadoria (em metros cúbicos): ");
        double volume = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o tag IoT da mercadoria: ");
        String tagIoT = scanner.nextLine();
        Mercadoria mercadoria = new Mercadoria(id, descricao, tipo, peso, volume, tagIoT);
        mercadorias.add(mercadoria);
        System.out.println("Mercadoria criada com sucesso!");
    }
    // Função para criar transportadora
    private static void criarTransportadora(Scanner scanner) {
        System.out.print("Digite o ID da transportadora: ");
        String id = scanner.nextLine();
        System.out.print("Digite o nome da transportadora: ");
        String nome = scanner.nextLine(); // Solicitando o nome
        System.out.print("Digite a capacidade de peso da transportadora (em kg): ");
        double capacidadePeso = scanner.nextDouble();
        System.out.print("Digite a capacidade de volume da transportadora (em metros cúbicos): ");
        double capacidadeVolume = scanner.nextDouble();
        System.out.print("A transportadora é especial? (true/false): ");
        boolean especial = scanner.nextBoolean();
        scanner.nextLine(); // Limpar o buffer
    
        Transportadora transportadora = new Transportadora(id, nome, capacidadePeso, capacidadeVolume, especial);
        transportadoras.add(transportadora);
        System.out.println("Transportadora " + nome + " criada com sucesso!");
    }
    
    // Função para adicionar mercadoria ao armazém
    private static void adicionarMercadoriaAoArmazem(Scanner scanner) {
        System.out.println("\nSelecione um armazém para adicionar a mercadoria:");
        for (int i = 0; i < armazens.size(); i++) {
            System.out.println(i + 1 + ". " + armazens.get(i).getNome());
        }
        int armazemIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar o buffer
        if (armazemIndex >= 0 && armazemIndex < armazens.size()) {
            System.out.println("\nSelecione uma mercadoria para adicionar ao armazém:");
            for (int i = 0; i < mercadorias.size(); i++) {
                System.out.println(i + 1 + ". " + mercadorias.get(i).getDescricao());
            }
            int mercadoriaIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Limpar o buffer
            if (mercadoriaIndex >= 0 && mercadoriaIndex < mercadorias.size()) {
                Mercadoria mercadoria = mercadorias.get(mercadoriaIndex);
                Armazem armazem = armazens.get(armazemIndex);
                armazem.adicionarMercadoria(mercadoria);
            } else {
                System.out.println("Mercadoria não encontrada.");
            }
        } else {
            System.out.println("Armazém não encontrado.");
        }
    }
    // Função para remover mercadoria do armazém
    private static void removerMercadoriaDoArmazem(Scanner scanner) {
        System.out.println("\nSelecione um armazém para remover a mercadoria:");
        for (int i = 0; i < armazens.size(); i++) {
            System.out.println(i + 1 + ". " + armazens.get(i).getNome());
        }
        int armazemIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar o buffer
        if (armazemIndex >= 0 && armazemIndex < armazens.size()) {
            System.out.println("\nSelecione uma mercadoria para remover do armazém:");
            for (int i = 0; i < mercadorias.size(); i++) {
                System.out.println(i + 1 + ". " + mercadorias.get(i).getDescricao());
            }
            int mercadoriaIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Limpar o buffer
            if (mercadoriaIndex >= 0 && mercadoriaIndex < mercadorias.size()) {
                Mercadoria mercadoria = mercadorias.get(mercadoriaIndex);
                Armazem armazem = armazens.get(armazemIndex);
                armazem.removerMercadoria(mercadoria);
            } else {
                System.out.println("Mercadoria não encontrada.");
            }
        } else {
            System.out.println("Armazém não encontrado.");
        }
    }

    //Localizar mercadoria por tag IoT
    private static void localizarMercadoriaPorTag(Scanner scanner) {
        System.out.print("Digite o tag IoT da mercadoria: ");
        String tagIoT = scanner.nextLine();

        Mercadoria mercadoria = encontrarMercadoriaPorTag(tagIoT);
        if (mercadoria != null) {
            System.out.println("Mercadoria encontrada: " + mercadoria.getDescricao());
            System.out.println("Localização atual: " + (mercadoria.getArmazemAtual() != null ? mercadoria.getArmazemAtual().getNome() : "Desconhecida"));
        } else {
            System.out.println("Mercadoria com tag IoT " + tagIoT + " não encontrada.");
        }
    }

    private static Mercadoria encontrarMercadoriaPorTag(String tagIoT) {
        for (Mercadoria mercadoria : mercadorias) {
            if (mercadoria.getTagIoT().equals(tagIoT)) {
                return mercadoria;
            }
        }
        return null;
    }
 // Função para movimentar mercadoria
 private static void movimentarMercadoria(Scanner scanner) {
    System.out.println("\nSelecione uma mercadoria para movimentar:");
    for (int i = 0; i < mercadorias.size(); i++) {
        System.out.println(i + 1 + ". " + mercadorias.get(i).getDescricao());
    }
    int mercadoriaIndex = scanner.nextInt() - 1;
    scanner.nextLine(); // Limpar o buffer
    if (mercadoriaIndex >= 0 && mercadoriaIndex < mercadorias.size()) {
        System.out.println("Selecione o novo armazém para a mercadoria:");
        for (int i = 0; i < armazens.size(); i++) {
            System.out.println(i + 1 + ". " + armazens.get(i).getNome());
        }
        int armazemIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar o buffer
        if (armazemIndex >= 0 && armazemIndex < armazens.size()) {
            Armazem novoArmazem = armazens.get(armazemIndex);
            Mercadoria mercadoria = mercadorias.get(mercadoriaIndex);

            // Adicionar seleção de transportadora
            System.out.println("Selecione a transportadora para movimentar a mercadoria:");
            for (int i = 0; i < transportadoras.size(); i++) {
                System.out.println(i + 1 + ". " + transportadoras.get(i).getNome());
            }
            int transportadoraIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Limpar o buffer
            if (transportadoraIndex >= 0 && transportadoraIndex < transportadoras.size()) {
                Transportadora transportadora = transportadoras.get(transportadoraIndex);
                transportadora.transportar(mercadoria, mercadoria.getArmazemAtual(), novoArmazem);
            } else {
                System.out.println("Transportadora não encontrada.");
            }
        } else {
            System.out.println("Armazém não encontrado.");
        }
    } else {
        System.out.println("Mercadoria não encontrada.");
    }
}


    // Função para gerar relatório de mercadorias
    private static void gerarRelatorio(Scanner scanner) {
        Relatorio.gerarRelatorioMercadorias(mercadorias);
    }
}