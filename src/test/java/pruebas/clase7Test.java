package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.paginaInicio;
import paginas.paginaLogin;

public class clase7Test {
	
	String url = "http://www.automationpractice.pl/index.php";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver (); 
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@Test
	
	public void login () {
		paginaInicio inicio = new paginaInicio (driver);
		inicio.hacerClicEnSignIn();
		
		paginaLogin login = new paginaLogin (driver);
		login.escribirEmail("correo@gmail.com");
		login.escribirPassword("4r6t8h");
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		paginaInicio inicio = new paginaInicio(driver);
		inicio.escribirPalabraAbuscar("dress");
		inicio.hacerBusqueda();
	}
	
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
	


	}


