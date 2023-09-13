package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaLogin {
	
	@FindBy (id="email") 
	WebElement txtEmail; 
	
	@FindBy (css="#passwd")
	WebElement txtPassword;
	
	@FindBy (xpath="//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]/i[1]")
	WebElement btnLogin;
	
	
	public paginaLogin (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void escribirEmail (String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirPassword (String password) {
		txtPassword.sendKeys(password);
		
	}
	
	public void hacerClicEnLogin () {
		btnLogin.click();
	}

	public void ingresarCredenciales (String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
