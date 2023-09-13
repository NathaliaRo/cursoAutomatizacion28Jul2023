package Edit.EducacionIT;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




import com.github.javafaker.Faker;

import Utilidades.CapturaEvidencia;




public class Clase5Test {
	String url = "http://www.automationpractice.pl/index.php";
	WebDriver driver;
	String directorioEvidencias = "..\\EducacionIT\\Evidencias\\";
	String nombreDocumento = "Documento de Evidencias - AutomationPractice.dock";
	File pantalla;
	
	
	
	
	@BeforeSuite 
	public void abrirNavegador () {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
 
	
@Test (description = "CP01-Ir a contactanos", priority=10)  

public void contactar () throws InvalidFormatException, IOException, InterruptedException {
	
	//Capturar Evidencias
	CapturaEvidencia.escribirTituloEnDocumento(
			directorioEvidencias + nombreDocumento,
			"DocumentoEvidencias - Contact us",
			20);
	
	CapturaEvidencia.capturarPantallaEnDocumento(
			driver, 
			directorioEvidencias +"img.jpg",
			directorioEvidencias + nombreDocumento,
			"paso1: pantalla principal");
	
	//hacer click en contact us
	WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
	lnkContact.click();
	
	CapturaEvidencia.capturarPantallaEnDocumento(
			driver, 
			directorioEvidencias +"img.jpg",
			directorioEvidencias + nombreDocumento,
			"paso2: luego de hacer click en contact us");
	
	
	
	// escoger opciones de la lista
	Select listSubject = new Select(driver.findElement(By.cssSelector("#id_contact")));
	listSubject.selectByVisibleText("Customer service  ");
	
    String email = "correo" + Math.random() + "@gmail.com";
	
	Faker faker = new Faker ();
	String email1 = faker.internet().emailAddress();
	
	//email
	WebElement txtEmail = driver.findElement(By.name("from"));
	txtEmail.sendKeys(email1);
	
	//order reference
	WebElement txtOrder = driver.findElement(By.xpath("//input[@id='id_order']"));
	txtOrder.sendKeys("123abc");
	
	// carga de archivo
	WebElement filAdjunto = driver.findElement(By.name("fileUpload"));
    filAdjunto.sendKeys("C:\\Users\\User\\Documents\\addIntegerData.txt");
	
	//campo de texto
	WebElement txtMessage = driver.findElement(By.tagName("textarea"));
	txtMessage.sendKeys("mensaje de contacto del cliente");
	
	CapturaEvidencia.capturarPantallaEnDocumento(
			driver, 
			directorioEvidencias +"img.jpg",
			directorioEvidencias + nombreDocumento,
			"paso3: Luego de Completar el Formulario");
	
	//boton send
	WebElement btnSend = driver.findElement(By.xpath("//button[@id='submitMessage']"));
	btnSend.click();
	
	CapturaEvidencia.capturarPantallaEnDocumento(
			driver, 
			directorioEvidencias +"img.jpg",
			directorioEvidencias + nombreDocumento,
			"paso4: Luego de Enviar el Formulario de Contacto");
	
}
	
	
	@Test (description="CP02 - Buscar Palabra",priority=1)
	
	public void buscarPalabra () throws IOException {
		//capturar evidencia: pantalla inicial
	    pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File (directorioEvidencias + "01_PantallaInicial.jpg"));
	
		
		
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
        //capturar evidencia: palabra a buscar
	    pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File (directorioEvidencias + "02_PalabraABuscar.jpg"));
	    
	    	
	    
		txtBuscador.sendKeys(Keys.ENTER);
		
		//captura evidencia: resultado de la busqueda
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File (directorioEvidencias + "03_ResultadoBusqueda.jpg"));
	
		    	
		
	
		
		
	
	}
	
	@AfterSuite 
	public void cerrarNavegador () {
		driver.close();

		
	}
	
}
	
	
	
	
	
	
	
	
	



	



	
	


