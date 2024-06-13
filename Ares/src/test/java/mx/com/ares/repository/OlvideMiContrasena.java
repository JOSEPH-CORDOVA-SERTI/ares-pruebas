package mx.com.ares.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OlvideMiContrasena {
	
	public OlvideMiContrasena(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(id="MainContent_txtUsername")
	WebElement correo;
	
	@FindBy(id="txtUsername")
	WebElement correoPl;
	
	@FindBy(id="MainContent_Submit")
	WebElement btnRecuperar;
	
	@FindBy(id="MainContent_Button1")
	WebElement btnRecuperarPl;
	
	@FindBy(xpath="//*[@id=\"form1\"]/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/iframe")
	WebElement captcha;
	
	@FindBy(xpath="//*[@id=\"MainContent_lblFail\"]")
	WebElement errorCaptcha;
	
	@FindBy(xpath="//*[@id=\"form1\"]/div[3]/div/div/div/h2") 
	WebElement TituloRecuperar;
	
	@FindBy(xpath="//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/h3")
	WebElement TituloRecuperarIn;
	
	@FindBy(xpath="//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h3")
	WebElement TituloRecuperarT;
	
	@FindBy(xpath="//*[@id=\"form1\"]/div[3]/div/div/div/div[2]/p[1]")
	WebElement Descripcion;
	
	@FindBy(xpath="//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/p")
	WebElement DescripcionIn;
	
	@FindBy(xpath="//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div/div[2]/div[1]/p")
	WebElement DescripcionT;
	
	@FindBy(xpath="//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div/div[1]/div/p") 
	WebElement DescripcionBA;
	
	@FindBy(xpath="//*[@id=\"form1\"]/div[3]/div/div/div/div[2]/div[1]/label")
	WebElement mensajeCorreo;
	
	@FindBy(xpath="//*[@id=\"form1\"]/div[3]/div/div/div/div[2]/p[2]") 
	WebElement mensajeCuenta;
	
	@FindBy(xpath="//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/div[2]/div/div[3]/div[2]/div/p") 
	WebElement mensajeCuentaIn;

	@FindBy(xpath="//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div/div[4]/div/a/strong") 
	WebElement mensajeCuentaT;


	
	
	public WebElement CorreoElement() {
		return correo;
	}
	
	public WebElement btnRecuperarElement() {
		return btnRecuperar;
	}
	
	public WebElement CorreoElementPl() {
		return correoPl;
	}
	
	public WebElement btnRecuperarElementPl() {
		return btnRecuperarPl;
	}
	
	public WebElement captcha() {
		return captcha;
	}
	
	public WebElement ecaptcha() {
		return errorCaptcha;
	}
	
	public WebElement TituloRecuperar() {
		return TituloRecuperar;
	}
	
	public WebElement TituloRecuperarIn() {
		return TituloRecuperarIn;
	}
	
	public WebElement TituloRecuperarT() {
		return TituloRecuperarT;
	}
	
	public WebElement Descripcion() {
		return Descripcion;
	}
	
	public WebElement DescripcionIn() {
		return DescripcionIn;
	}
	
	public WebElement DescripcionT() {
		return DescripcionT;
	}
	
	public WebElement DescripcionBA() {
		return DescripcionBA;
	}


	public WebElement mensajeCorreo() {
		return mensajeCorreo;
	}
	
	public WebElement mensajeCuenta() {
		return mensajeCuenta;
	}
	
	public WebElement mensajeCuentaIn() {
		return mensajeCuentaIn;
	}
	
	public WebElement mensajeCuentaT() {
		return mensajeCuentaT;
	}
}
