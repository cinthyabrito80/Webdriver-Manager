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
public class LoginTest {

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
    @DisplayName("Login realizado com sucesso")
    public void testLoginRealizadoComSucesso() {

    }

    @Test
    @DisplayName("Email e ou senha invalido")
    public void testEmailEOuSenhaInvalido() {}

    @Test
    @DisplayName("Campo senha não pode ficar em branco")
    public void testCampoSenhaNotNull() {}

    @Test
    @DisplayName("Campo email não pode ficar em branco")
    public void testCampoEmailNotNull() {}

}

