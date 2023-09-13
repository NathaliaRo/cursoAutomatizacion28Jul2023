package Edit.EducacionIT;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;


public class Clase4Test {
String url = "http://www.automationpractice.pl/index.php";

@Test
public void registrarUsuario () {
	// paso 1: Definir que navegador vamos a usar 
	WebDriver driver = new ChromeDriver() ; 
	
	// paso 2: Abrir la pagina de prueba
	driver.get(url);
	driver.manage ().window ().maximize (); 
	driver.manage ().deleteAllCookies ();
	
	// paso 3: Hacer click en "sign In"
	WebElement InkSignIn = driver.findElement(By.partialLinkText("Sign"));
	InkSignIn.click ();
	
	String email = "correo" + Math.random() + "@gmail.com";
	
	Faker faker = new Faker ();
	String email1 = faker.internet().emailAddress();
	
	
	
	
	
	// paso 4: Escribir el correo y hacer click en "Create An Account"
	WebElement txtEmail = driver.findElement(By.name("email_create"));
	txtEmail.sendKeys(email1);
	
	WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']")); 
	btnCreate.click (); 
	
	// Espera 
	WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(15));
	wait.until (ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
	
	
	// paso 5: Completar el formulario
	WebElement radTitle = driver.findElement(By.id("id_gender1"));
	radTitle.click ();
	
	String firstname = faker.name().firstName();
	
	WebElement txtFirstName = driver.findElement(By.cssSelector("#customer_firstname"));
	txtFirstName.sendKeys (firstname);
	
	String lastname = faker.name().lastName();
	
	WebElement txtLastName = driver.findElement(By.name("customer_lastname"));
	txtLastName.sendKeys (lastname);
	
	WebElement txtModifiedEmail = driver.findElement(By.xpath("//input[@id='email']"));
	txtModifiedEmail.clear(); // Borra contenido actual del campo
	txtModifiedEmail.sendKeys(email1); // Escribe el nuevo valor del campo
	
	WebElement txtPassword = driver.findElement(By.cssSelector("#passwd"));
	txtPassword.sendKeys("193q5wt");
	
	Select selDays = new Select (driver.findElement(By.cssSelector("#days")));
	selDays.selectByVisibleText ("18  "); 
	
	Select selMonths = new Select (driver.findElement(By.id("months")));
	selMonths.selectByValue ("6");
	
	Select selYears = new Select (driver.findElement(By.name("years")));
	selYears.selectByIndex(30);
	
	WebElement chknews = driver.findElement(By.xpath("//input[@id='newsletter']"));
	chknews.click (); 
	
	// paso 6: Hacer click en register
	WebElement btnRegister = driver.findElement(By.id("submitAccount"));
	btnRegister.click();
	
	
	
	
	
	
	
	
}

}
