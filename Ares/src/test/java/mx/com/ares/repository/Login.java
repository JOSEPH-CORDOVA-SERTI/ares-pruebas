package mx.com.ares.repository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Login {
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(id="MainContent_userLogin")
	WebElement Usuario;
	
	@FindBy(id="MainContent_password")
	WebElement Contrasena;
	
	@FindBy(xpath="//*[@id=\"btnLogin\"]")
	WebElement Ingresar;
	
	@FindBy(xpath="//*[@id=\"dropdownMenu1\"]")
	WebElement usuarioInicio;
	
	@FindBy(xpath="//*[@id=\"MainContent_lblFail\"]")
	WebElement mensajeError;
	
	@FindBy(xpath="/html/body/ul/li/div/div")
	WebElement mensajeErrorMb;
	
	public WebElement UsuarioElement() {
		return Usuario;
	}
	
	public WebElement ContrasenaElement() {
		return Contrasena;
	}
	
	public WebElement IngresarElement() {
		return Ingresar;
	}
	
	public WebElement UserElement() {
		return usuarioInicio;
	}
	
	public WebElement UserIncorrectoElement() {
		return mensajeError;
	}
	
	public WebElement UserIncorrectoMbElement() {
		return mensajeErrorMb;
	}

}
