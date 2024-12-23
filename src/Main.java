import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Biblioteca!");

        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");

            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Realizar empréstimo.");
            System.out.println("4 - Realizar devolução.");
            System.out.println("5 - Exibir livros disponíveis.");
            System.out.println("6 - Sair.");

            int opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoEscolhida) {
                case 1:
                    System.out.println("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o ISBN do livro: ");
                    String isbnLivro = scanner.next();
                    Livro livro = new Livro(titulo, autor, isbnLivro);
                    biblioteca.cadastrarLivro(livro);
                    break;
                case 2:
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o ID do usuário:");
                    int idUsuario = scanner.nextInt();
                    Usuario usuario = new Usuario(nome, idUsuario);
                    biblioteca.cadastrarUsuario(usuario);
                    break;
                case 3:
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.next();
                    System.out.println("Digite o ID do usuário:");
                    int id = scanner.nextInt();
                    biblioteca.realizarEmprestimo(isbn, id);
                    break;
                case 4:
                    System.out.println("Digite o ISBN do livro:");
                    String isbn2 = scanner.next();
                    System.out.println("Digite o ID do usuário:");
                    int id2 = scanner.nextInt();
                    biblioteca.realizarDevolucao(isbn2, id2);
                    break;
                case 5:
                    System.out.println("Livros disponíveis:");
                    biblioteca.exibirLivrosDisponiveis();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}