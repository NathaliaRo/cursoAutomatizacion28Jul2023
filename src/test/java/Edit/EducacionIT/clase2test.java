package Edit.EducacionIT;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class clase2test {
	//Commentary den an line
	/*Commentary large
	 * 
	 */
 String url= "http://www.automationpractice.pl/index.php";
 
 @Test

 public void buscarProductoFirefox () {
	 // paso1: Definer que navegador quiero usar
	 WebDriver navegador = new FirefoxDriver ();
	 
	 // paso2: Abrir el navegador en la pagina de prueba
	 navegador.get(url);
	 
	 // paso3: Escribir el producto a buscar 
	 WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
	 txtBuscador.sendKeys("dress");
	 
	 // paso4: Hacer la busqueda
	 txtBuscador.sendKeys(Keys.ENTER);
	 
	 // paso5: Cerrar el navegador
	 
 }

 

 @Test

public void buscarProductoChrome () {
	 // paso1: Definer que navegador quiero usar
	 WebDriver navegador = new ChromeDriver();
	 
	 // paso2: Abrir el navegador en la pagina de prueba
	 navegador.get(url);
	 
	 // paso3: Escribir el producto a buscar 
	 WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
	 txtBuscador.sendKeys("dress");
	 
	 // paso4: Hacer la busqueda
	 txtBuscador.sendKeys(Keys.ENTER);
	 
	 // paso5: Cerrar el navegador
	 
}

}





