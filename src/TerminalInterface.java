import java.util.Scanner;

public class TerminalInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicialização de leitores e livros
        Person[] readers = new Person[2];
        readers[0] = new Person("Marcos", 21, "M");
        readers[1] = new Person("Maria", 25, "F");

        Book[] books = new Book[3];
        books[0] = new Book("POO na prática", "Allan Stieg", 300, readers[0]);
        books[1] = new Book("Web Designer", "Marcos Pasquim", 500, readers[1]);
        books[2] = new Book("A volta sem ir", "Jonas Confuso", 800, readers[0]);

        boolean running = true;

        while (running) {
            // ==========================================
            // TELA 1: SELEÇÃO DE LIVROS (INTERFACE EM PORTUGUÊS)
            // ==========================================
            System.out.println("\n==================================================");
            System.out.println("              BIBLIOTECA DE LIVROS                ");
            System.out.println("==================================================");
            System.out.println("Escolha qual livro você deseja ler:\n");

            for (int i = 0; i < books.length; i++) {
                System.out.println("[" + (i + 1) + "] " + books[i].getTitle());
                System.out.println("    Autor: " + books[i].getAuthor() + " | " + books[i].getTotalPages() + " páginas");
                System.out.println("    Leitor: " + books[i].getReader().getName() + " (" + books[i].getReader().getAge() + " anos, " + books[i].getReader().getGender() + ")\n");
            }

            System.out.println("[0] Sair do sistema");
            System.out.println("--------------------------------------------------");
            System.out.print("Digite o número do livro: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                running = false;
                System.out.println("\nSaindo da biblioteca... Até logo!");
            } else {
                try {
                    int index = Integer.parseInt(choice) - 1;
                    if (index >= 0 && index < books.length) {
                        openReadingScreen(books[index], scanner);
                    } else {
                        System.out.println("\n❌ Opção inválida! Escolha um número entre 1 e " + books.length + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n❌ Entrada inválida! Digite apenas números inteiros.");
                }
            }
        }

        scanner.close();
    }

    // ==========================================
    // TELA 2: TELA DE LEITURA (INTERFACE EM PORTUGUÊS)
    // ==========================================
    private static void openReadingScreen(Book book, Scanner scanner) {
        if (!book.isOpen()) {
            book.open();
        }

        boolean reading = true;
        String statusMessage = "📖 Livro aberto e pronto para leitura!";

        while (reading) {
            System.out.println("\n==================================================");
            System.out.println("LIVRO: " + book.getTitle().toUpperCase());
            System.out.println("AUTOR: " + book.getAuthor() + " | LEITOR: " + book.getReader().getName());
            System.out.println("==================================================");

            String state = book.isOpen() ? "ABERTO" : "FECHADO";
            System.out.println("ESTADO: [" + state + "]");
            System.out.println("--------------------------------------------------");
            System.out.println(">>> PÁGINA ATUAL: " + book.getCurrentPage() + " de " + book.getTotalPages() + " <<<");
            
            displayProgressBar(book.getCurrentPage(), book.getTotalPages());
            System.out.println("--------------------------------------------------");

            if (statusMessage != null && !statusMessage.isEmpty()) {
                System.out.println(statusMessage);
                System.out.println("--------------------------------------------------");
                statusMessage = "";
            }

            System.out.println("[1] Avançar 1 página  (->)");
            System.out.println("[2] Voltar 1 página   (<-)");
            System.out.println("[3] Folhear (ir para página específica)");
            System.out.println("[4] " + (book.isOpen() ? "Fechar livro" : "Abrir livro"));
            System.out.println("[5] Ver detalhes completos");
            System.out.println("[0] Voltar ao menu de livros");
            System.out.println("--------------------------------------------------");
            System.out.print("Escolha uma ação: ");

            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    if (!book.isOpen()) {
                        statusMessage = "⚠️ O livro está FECHADO! Abra o livro na opção [4] para avançar páginas.";
                    } else if (book.getCurrentPage() >= book.getTotalPages()) {
                        statusMessage = "🛑 DELIMITAÇÃO: Você já está na última página (" + book.getTotalPages() + " de " + book.getTotalPages() + ")! Não é possível avançar mais.";
                    } else {
                        book.advancePage();
                        statusMessage = "⏩ Você avançou para a página " + book.getCurrentPage() + ".";
                    }
                    break;

                case "2":
                    if (!book.isOpen()) {
                        statusMessage = "⚠️ O livro está FECHADO! Abra o livro na opção [4] para voltar páginas.";
                    } else if (book.getCurrentPage() <= 0) {
                        statusMessage = "🛑 DELIMITAÇÃO: Você já está no início do livro (página 0 de " + book.getTotalPages() + ")! Não é possível voltar mais.";
                    } else {
                        book.backPage();
                        statusMessage = "⏪ Você retornou para a página " + book.getCurrentPage() + ".";
                    }
                    break;

                case "3":
                    if (!book.isOpen()) {
                        statusMessage = "⚠️ O livro está FECHADO! Abra o livro antes de folhear.";
                    } else {
                        System.out.print("Digite o número da página (0 a " + book.getTotalPages() + "): ");
                        String pageInput = scanner.nextLine().trim();
                        try {
                            int page = Integer.parseInt(pageInput);
                            if (page > book.getTotalPages()) {
                                statusMessage = "🛑 DELIMITAÇÃO (Slide 37): A página " + page + " ultrapassa o total (" + book.getTotalPages() + ")!\n   -> Regra aplicada: a página atual foi zerada para 0.";
                            } else if (page < 0) {
                                statusMessage = "🛑 DELIMITAÇÃO: Número negativo inválido! Página mantida em 0.";
                            } else {
                                statusMessage = "📖 Você folheou para a página " + page + ".";
                            }
                            book.browse(page);
                        } catch (NumberFormatException e) {
                            statusMessage = "❌ Entrada inválida! Digite apenas números inteiros.";
                        }
                    }
                    break;

                case "4":
                    if (book.isOpen()) {
                        book.close();
                        statusMessage = "📕 Você fechou o livro.";
                    } else {
                        book.open();
                        statusMessage = "📖 Você abriu o livro.";
                    }
                    break;

                case "5":
                    System.out.println("\n--- DETALHES DO LIVRO ---");
                    System.out.println(book.details());
                    System.out.println("Pressione ENTER para continuar lendo...");
                    scanner.nextLine();
                    break;

                case "0":
                    reading = false;
                    System.out.println("\nRetornando à seleção de livros...");
                    break;

                default:
                    statusMessage = "❌ Opção inválida! Escolha uma das opções disponíveis.";
                    break;
            }
        }
    }

    private static void displayProgressBar(int current, int total) {
        int barLength = 20;
        int filled = total > 0 ? (int) (((double) current / total) * barLength) : 0;
        if (filled > barLength) filled = barLength;

        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < filled) {
                bar.append("=");
            } else if (i == filled) {
                bar.append(">");
            } else {
                bar.append(" ");
            }
        }
        bar.append("]");

        double percentage = total > 0 ? ((double) current / total) * 100 : 0.0;
        System.out.printf("Progresso: %s %.1f%%\n", bar.toString(), percentage);
    }
}
