package alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;
    private String language;
    private Long downloadCount;
    private Long apiBookID;

    @ManyToOne
    private Author author;

    public Book () {}
    public Book (BooksData book, Author autor) {
        this.title = book.title();
        this.language = book.title();
        this.downloadCount = book.download_count();
        this.apiBookID = book.apiBookID();
        this.author = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Long getApiBookID() {
        return apiBookID;
    }

    public void setApiBookID(Long apiBookID) {
        this.apiBookID = apiBookID;
    }

    @Override
    public String toString() {

        return  "Título: " + getTitle() +
                " Autor: " + getAuthor().getName();

    }
}
