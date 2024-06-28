//PACOTES (PACKAGE)
package br.com.cinth;

// BIBLIOTECAS (LIB)

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //DEPOIS DO TESTE (AFTER)
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    //TESTE
    @Test
    public void cadastrousuario() {
        assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), CoreMatchers.is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("Cintia teste 07");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("cintia.teste.07@teste.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("123456");
        assertThat(driver.findElement(By.cssSelector(".btn-primary")).getText(), CoreMatchers.is("Cadastrar"));
        driver.findElement(By.cssSelector(".btn-primary")).click();
        //js.executeScript("window.scrollTo(0,0)");
        assertThat(driver.getTitle(), CoreMatchers.is("Front - ServeRest"));
    }

}

