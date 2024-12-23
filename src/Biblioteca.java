import java.util.ArrayList;
import java.util.stream.Collectors;

public class Biblioteca {

    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarEmprestimo(String isbn, int idUsuario) {
        Livro livro = null;

        for (Livro l : livros) {
            if (l.getIsbn().equals(isbn)) {
                livro = l;
                break;
            }
        }

        Usuario usuario = null;

        for (Usuario u : usuarios) {
            if (u.getId() == idUsuario) {
                usuario = u;
                break;  // Encontra o usuário e sai do loop
            }
        }

        if (livro != null && usuario != null) {

            if (!livro.isDisponivel()) {
                System.out.println("O livro não está disponível.");
                return;
            }

            if (usuario.getLivrosEmprestados().size() >= 3) {
                System.out.println("O usuário já tem 3 livros emprestados. Limite de empréstimos simultâneos atingido.");
                return;
            }

            livro.emprestar();
            usuario.adicionarLivro(livro);
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    public void realizarDevolucao(String isbn, int idUsuario) {
        Livro livro = null;

        for (Livro l : livros) {
            if (l.getIsbn().equals(isbn)) {
                livro = l;
                break;
            }
        }

        Usuario usuario = null;

        for (Usuario u : usuarios) {
            if (u.getId() == idUsuario) {
                usuario = u;
                break;
            }
        }

        if (livro != null && usuario != null) {

            boolean temLivroEmprestado = false;
            for (Livro l : usuario.getLivrosEmprestados()) {
                if (l.equals(livro)) {
                    temLivroEmprestado = true;
                    break;
                }
            }

            if (!temLivroEmprestado) {
                System.out.println("O usuário não tem este livro emprestado.");
                return;
            }

            usuario.removerLivro(livro);
            livro.devolver();
            System.out.println("Devolução realizada com sucesso!");
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    public void exibirLivrosDisponiveis() {
        ArrayList<Livro> livrosDisponiveis = (ArrayList<Livro>) livros.stream()
                .filter(livro -> livro.isDisponivel())
                .collect(Collectors.toList());

        livrosDisponiveis.forEach(livro -> livro.exibirDetalhes());
    }
}
