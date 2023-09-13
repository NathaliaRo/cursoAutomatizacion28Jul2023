package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaInicio {
	
	@FindBy (partialLinkText="Sign")
	WebElement inkSignIn; 
	
	@FindBy (css="#search_query_top")
	WebElement txtBuscador;
	

	public paginaInicio (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
		public void hacerClicEnSignIn () {
		 inkSignIn.click();
		 
		}
		 
	 public void escribirPalabraAbuscar (String palabra) {
		 txtBuscador.sendKeys (palabra);
	 }
	 
	 public void hacerBusqueda () {
		 txtBuscador.sendKeys(Keys.ENTER);
	 }
		 
	
	}

