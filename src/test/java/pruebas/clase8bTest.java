package pruebas;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.paginaInicio;
import paginas.paginaLogin;

public class clase8bTest {
	
	String url = "http://www.automationpractice.pl/index.php";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver (); 
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@Test (dataProvider = "Datos Login Excel")
	
	public void login (String email, String password) {
		paginaInicio inicio = new paginaInicio (driver);
		inicio.hacerClicEnSignIn();
		
		paginaLogin login = new paginaLogin (driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@DataProvider (name = "Datos Login Excel")
	public Object [][] obtenerDatosExcel () throws Exception {
		String ruta = "..\\EducacionIT\\DatosExcel.java\\Datos_Login25Jul.xlsm";
		String nombreHoja = "Hoja1";
		return DatosExcel.leerExcel(ruta, nombreHoja);
	}
		

		
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}

}
