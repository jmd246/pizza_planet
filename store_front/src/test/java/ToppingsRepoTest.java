import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.pizza_planet.model.Category;
import com.pizza_planet.model.Topping;
import com.pizza_planet.repo.ToppingStore;
import com.pizza_planet.util.HibernateUtil;


public class ToppingsRepoTest {
    private static SessionFactory sessionFactory;
    private static ToppingStore toppingStore;


    @BeforeAll
    public static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        toppingStore = new ToppingStore(sessionFactory);
    }

    @AfterAll
    public static void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    public void testFindAll() {
        List<Topping> toppings = toppingStore.findAll();
        assertNotNull(toppings);
        assertFalse(toppings.isEmpty());
    }

    @Test
    public void testFindByCategory() {
        List<Topping> meatToppings = toppingStore.findByCategory("MEAT");
        assertNotNull(meatToppings);
        assertFalse(meatToppings.isEmpty());
        for (Topping topping : meatToppings) {
            assertEquals(Category.MEAT, topping.getCategory());
        }
    }
}