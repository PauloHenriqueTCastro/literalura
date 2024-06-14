package alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int birthYear;
    private int deathYear;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author() {}
    public Author(String name){
        this.name = name;
    }
    public Author(AuthorsData author) {
        this.name = author.name();
        this.birthYear = author.birth_year();
        this.deathYear = author.death_year();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            this.name = "Autor desconhecido";
        } else {
            this.name = name;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public void setBook(Book books) {
        this.books.add(books);
    }

    @Override
    public String toString() {

        return  "Nome: " + this.getName() +
                " Ano Nascimento: " + this.getBirthYear() +
                " Ano Morte: " + this.getDeathYear();

    }
}
