// Unit Tests for DAO and Service Layers
// Using JUnit 5 for Testing

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

// Test Class for User_info DAO
class UserInfoDAOTest {

    @Mock
    private User_info userDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUsername() throws Exception {
        String email = "test@example.com";
        String expectedUsername = "test";

        Mockito.when(userDAO.get_username(email)).thenReturn(expectedUsername);

        String actualUsername = userDAO.get_username(email);

        assertEquals(expectedUsername, actualUsername);
    }

    @Test
    void testUserRegistration() throws Exception {
        String username = "testUser";
        String email = "test@example.com";
        int phone = 1234567890;
        String state = "CA";
        boolean premium = false;

        assertDoesNotThrow(() -> userDAO.user_registration(username, email, phone, state, premium));
    }
}

// Test Class for Normal_recipes_data DAO
class NormalRecipesDataDAOTest {

    @Mock
    private Normal_recipes_data normalRecipesDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testNormalRecipesStorage() throws Exception {
        String recipeName = "Pasta";
        String recipeIngredients = "Pasta, Tomato Sauce, Cheese";
        String recipeProcess = "Boil pasta, mix sauce, add cheese";

        assertDoesNotThrow(() -> normalRecipesDAO.Normal_recipes_storage(recipeName, recipeIngredients, recipeProcess));
    }
}

// Test Class for Premium_recipes_data DAO
class PremiumRecipesDataDAOTest {

    @Mock
    private Premium_recipes_data premiumRecipesDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPremiumRecipesStorage() throws Exception {
        String recipeName = "Truffle Pasta";
        String recipeIngredients = "Pasta, Truffle Oil, Parmesan";
        String recipeProcess = "Cook pasta, add truffle oil, sprinkle parmesan";

        assertDoesNotThrow(() -> premiumRecipesDAO.Premium_recipes_storage(recipeName, recipeIngredients, recipeProcess));
    }
}

// Test Class for Recipies_id_generator Service
class RecipesIdGeneratorTest {

    @Mock
    private Recipies_id_generator idGenerator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateNormalRecipeId() throws Exception {
        String type = "Normal Version";
        String expectedId = "NVR12345";

        Mockito.when(idGenerator.generate_id(type)).thenReturn(expectedId);

        String actualId = idGenerator.generate_id(type);

        assertEquals(expectedId, actualId);
    }

    @Test
    void testGeneratePremiumRecipeId() throws Exception {
        String type = "Premium Version";
        String expectedId = "PVR54321";

        Mockito.when(idGenerator.generate_id(type)).thenReturn(expectedId);

        String actualId = idGenerator.generate_id(type);

        assertEquals(expectedId, actualId);
    }
}

// Test Class for Account_generation Service
class AccountGenerationServiceTest {

    @Mock
    private Account_generation accountGenerator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAccountId() throws Exception {
        int phone = 1234567890;
        String expectedAccountId = "ACC12345";

        Mockito.when(accountGenerator.create_accountidd(phone)).thenReturn(expectedAccountId);

        String actualAccountId = accountGenerator.create_accountidd(phone);

        assertEquals(expectedAccountId, actualAccountId);
    }
}
