public class Livro {

    private String titulo;
    private String autorDoLivro;
    private String isbn;
    private boolean disponivel;


    public Livro(String titulo, String autorDoLivro, String isbn) {
        this.titulo = titulo;
        this.autorDoLivro = autorDoLivro;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autorDoLivro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void exibirDetalhes() {
        System.out.println("Titulo: " + titulo + " Autor: " + autorDoLivro + " ISBN: " + isbn);
    }

    public void emprestar() {
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

}
