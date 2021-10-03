package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Таинственный остров", 100, "Жюль Верн");
    Product book1 = new Book(2, "Анна Каренина", 150, "Лев Толстой");
    Product smartphone = new Smartphone(3, "Samsung Galaxy", 20_000, "Samsung");
    Product book3 = new Book(3, "Мастер и Маргарита", 130, "Булгаков");

    @BeforeEach
    public void SetUp() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);
        manager.add(book3);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = {book};
        Product[] actual = manager.searchBy("Жюль Верн");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Анна Каренина");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneName() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Samsung Galaxy");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindSmartphoneManufacturer() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Жуль верн");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindIPhone() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("iPhone");
        assertArrayEquals(expected, actual);
    }
}
