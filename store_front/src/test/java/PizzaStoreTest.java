import java.util.List;

import org.hibernate.SessionFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.pizza_planet.model.Pizza;
import com.pizza_planet.repo.PizzaStore;
import com.pizza_planet.util.HibernateUtil;
public class PizzaStoreTest {
    private static SessionFactory sessionFactory;
    private static PizzaStore pizzaStore;

    @BeforeAll
    public static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        pizzaStore = new PizzaStore(sessionFactory);
    }

    @Test
    public void testFindAll() {
        List<Pizza> pizzas = pizzaStore.findAll();
        assertNotNull(pizzas);
        assertFalse(pizzas.isEmpty());
    }

    @Test
    public void testFindByName() {
        Pizza pizza = pizzaStore.findByName("Margherita");
        assertNotNull(pizza);
        assertEquals("Margherita", pizza.getName());
    }
    @Test
    public void testFindById() {
        Pizza pizza = pizzaStore.findById(1);
        assertNotNull(pizza);
        assertEquals(1, pizza.getId());
    }
    

}
