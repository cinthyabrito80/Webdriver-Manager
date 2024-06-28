//PACOTES (PACKAGE)
package br.com.cinth;

// BIBLIOTECAS (LIB)
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

//CLASSE (CLASS)
public class CadastroTest {

    //ATRIBUTOS
    private static WebDriver driver;

    //FUNÇÕES + METODOS

    //ANTES DE TUDO
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //ANTES DO TESTE (BEFORE)
    @BeforeEach
    public void padraoCarregamento() {
        driver.get("https://front.serverest.dev/login");
    }

    //DEPOIS DO TESTE (AFTER)
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    //TESTE
    @Test
    @DisplayName("Realizar o cadastro de um novo usuario não sendo administrador")
    public void testCadastroUsuarioNovoNaoAdministrador() {
        assertEquals("Cadastre-se", driver.findElement(By.linkText("Cadastre-se")).getText(), "Texto esperado 'Cadastre-se', mas foi exibido outro texto");
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("Cintia teste 08");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("cintia.teste.08@teste.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("123456");
        assertEquals("Cadastrar", driver.findElement(By.cssSelector(".btn-primary")).getText(), "Texto esperado 'Cadastrar', mas foi exibido outro texto");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertEquals("Cadastro realizado com sucesso", driver.findElement(By.cssSelector("a.alert-link")).getText(), "Texto esperado 'Cadastro realizado com sucesso', mas foi exibido outro texto");
    }

    @Test
    @DisplayName("Realizar o cadastro de um novo usuario não sendo administrador")
    public void testCadastroUsuarioComoAdministrador() {}

    @Test
    @DisplayName("Realizar o cadastro de um novo usuario não sendo administrador")
    public void testUsuarioJaCadastrado() {}

}

