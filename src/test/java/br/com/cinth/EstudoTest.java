//PACOTES (PACKAGE)
package br.com.cinth;

// BIBLIOTECAS (LIB)
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

//CLASSE (CLASS)
public class EstudoTest {

    //ATRIBUTOS
    private static WebDriver driver;

    //FUNÇÕES + METODOS

    //ANTES DE TUDO
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //ANTES DO TESTE (BEFORE)
    @BeforeEach
    public void inicioTesteUnico() {
        driver = new ChromeDriver();
        driver.get("https://front.serverest.dev/login");
        driver.manage().window().maximize();
    }

    //DEPOIS DO TESTE (AFTER)
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    //TESTE
    @Test
    public void cadastrousuario() {
        driver.findElement(By.cssSelector(".font-robot")).click();
        assertThat(driver.getTitle(), is("Front - ServeRest"));
        assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();
        assertThat(driver.getTitle(), is("Front - ServeRest"));
        {
            WebElement element = driver.findElement(By.id("nome"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("Ci teste 03");
        driver.findElement(By.id("email")).click();
        {
            WebElement element = driver.findElement(By.id("email"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
        driver.findElement(By.id("email")).sendKeys("ci.teste.03@teste.com");
        {
            WebElement element = driver.findElement(By.id("password"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector(".alert")).click();
        //js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.cssSelector(".jumbotron")).click();
        driver.findElement(By.cssSelector("h1")).click();
        driver.findElement(By.cssSelector("h1")).click();
        assertThat(driver.getTitle(), is("Front - ServeRest"));
    }

}

