package mx.com.ares.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NuevoRegistro {
	
	public NuevoRegistro(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(id="MainContent_txtMail")
	WebElement Correo;
	
	@FindBy(xpath="//*[@id=\"txtMail\"]")
	WebElement CorreoIn;
	
	@FindBy(id="MainContent_txtUser")
	WebElement Usuario;
	
	@FindBy(xpath="//*[@id=\"txtUser\"]")
	WebElement UsuarioIn;
	
	@FindBy(id="MainContent_password")
	WebElement Contrasena;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement ContrasenaIn;
	
	@FindBy(id="btnRegistrar")
	WebElement Registrar;
	
	@FindBy(xpath = "//*[@id=\"form1\"]/div[3]/div/div/div/p[1]/a")
	WebElement RegistrateAqui;
	
	@FindBy(xpath = "//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/p/a")
	WebElement RegistrateAquiIn;

	@FindBy(xpath = "//*[@id=\"form1\"]/div[3]/div/div/div/h2")
	WebElement MensajePantalla;
	
	@FindBy(xpath = "//*[@id=\"MainContent_divRegister\"]/h3")
	WebElement MensajePantallaIn;
	
	@FindBy(xpath = "//*[@id=\"MainContent_lblFail\"]")
    WebElement MensajeSinCaptcha;
	
	@FindBy(xpath = "//*[@id=\"MainContent_lblFail\"]")
    WebElement MensajeCorreoYaRegistrado;
	
	@FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    WebElement Captcha;  
	
	@FindBy(xpath = "/html/body/form/div[3]/div/div/div/div[6]/div/div/div/iframe")
    WebElement IFrameCaptcha;
	
	@FindBy(xpath = "/html/body/form/main/div[1]/div/div/div/div/div/div/div/div[6]/div/div/iframe")
    WebElement IFrameCaptchaPl;
	
	@FindBy(xpath = "//*[@id=\"MainContent_lblFail\"]")
    WebElement MensajeUsuarioYaRegistrado;

	@FindBy(xpath = "//*[@id=\"8char\"]")
    WebElement CaracterMinContrasena;
	
	@FindBy(xpath = "//*[@id=\"special\"]")
    WebElement CaracterEspecial;
	
	@FindBy(xpath = "//*[@id=\"num\"]")
    WebElement UnNumero;
	
	@FindBy(xpath = "//*[@id=\"ucase\"]")
    WebElement CaracterMayuscula;
	
	@FindBy(xpath = "//*[@id=\"lcase\"]")
    WebElement CaracterMinuscula;
	
	@FindBy(xpath = "//*[@id=\"form1\"]/div[3]/div/div/div/div[7]/div[2]/p/a[1]")
    WebElement TerminosyCondiciones;
	
	@FindBy(xpath = "//*[@id=\"MainContent_divRegister\"]/div[5]/small/a[1]")
    WebElement TerminosyCondicionesIn;
	
	@FindBy(xpath = "//*[@id=\"form1\"]/div[3]/div/div/div/div[7]/div[2]/p/a[2]")
    WebElement AvisoPrivacidad;
	
	@FindBy(xpath = "//*[@id=\"MainContent_divRegister\"]/div[5]/small/a[2]")
    WebElement AvisoPrivacidadIn;
	
	@FindBy(id="MainContent_lblFail")
    WebElement MensajeContrasenaMayor;
	
	
	@FindBy(id="//*[@id=\"MainContent_lblFail\"]")
    WebElement MensajeUsuarioInvalid;
	
	@FindBy(xpath = "//*[@id=\"pwd-container\"]/div/div[1]/div[1]/div/div[2]/div/p/a")
	WebElement RegistrateAquiPl;
	
	@FindBy(id="txtConfirmMail")
	WebElement ConfirmarCorreoPl;
	
	@FindBy(id="txtMail")
	WebElement CorreoPl;
	
	@FindBy(id="txtUser")
	WebElement UsuarioPl;
	
	@FindBy(id="password")
	WebElement ContrasenaPl;
	
	@FindBy(id="checkAccept")
	WebElement AceptarTyCPl;
	
	public WebElement AceptarTyCElement() {
		return AceptarTyCPl;
	}
	
	public WebElement ContrasenaPlElement() {
		return ContrasenaPl;
	}
	
	public WebElement UsuarioPlElement() {
		return UsuarioPl;
	}
	
	public WebElement CorreoPlElement() {
		return CorreoPl;
	}
	
	public WebElement ConfirmarCorreoPlElement() {
		return ConfirmarCorreoPl;
	}
	
	public WebElement RegistrateAquiPlElement() {
		return RegistrateAquiPl;
	}
	
	public WebElement MensajeUsuarioInvalidElement() {
		return MensajeUsuarioInvalid;
	}
	
	public WebElement MensajeContrasenaMayorElement() {
		return MensajeContrasenaMayor;
	}
	
	public WebElement AvisoPrivacidadElement() {
		return AvisoPrivacidad;
	}
	
	public WebElement TerminosyCondicionesElement() {
		return TerminosyCondiciones;
	}
	
	public WebElement AvisoPrivacidadElementIn() {
		return AvisoPrivacidadIn;
	}
	
	public WebElement TerminosyCondicionesElementIn() {
		return TerminosyCondicionesIn;
	}
	public WebElement UnNumero() {
		return UnNumero;
	}
	public WebElement CaracterMinusculaElement() {
		return CaracterMinuscula;
	}
	public WebElement CaracterMayusculaElement() {
		return CaracterMayuscula;
	}
	
	public WebElement CaracterEspecialElement() {
		return CaracterEspecial;
	}
	
	public WebElement CaracterMinContrasenaElement() {
		return CaracterMinContrasena;
	}
	public WebElement CorreoElement() {
		return Correo;
	}
	
	public WebElement CorreoElementIn() {
		return CorreoIn;
	}
	public WebElement UsuarioElement() {
		return Usuario;
	}
	public WebElement UsuarioElementIn() {
		return UsuarioIn;
	}
	public WebElement ContrasenaElement() {
		return Contrasena;
	}
	public WebElement ContrasenaElementIn() {
		return ContrasenaIn;
	}
	public WebElement RegistrarElement() {
		return Registrar;
	}
	public WebElement RegistrateAquiElement() {
		return RegistrateAqui;
	}
	public WebElement RegistrateAquiElementIn() {
		return RegistrateAquiIn;
	}
	public WebElement MensajePantallaElement() {
		return MensajePantalla;
	}
	public WebElement MensajePantallaElementIn() {
		return MensajePantallaIn;
	}
	
	public WebElement MensajeSinCaptchaElement() {
		return MensajeSinCaptcha;
	}
	public WebElement MensajeCorreoYaRegistradoElement() {
		return MensajeCorreoYaRegistrado;
	}
	public WebElement CaptchaElement() {
		return Captcha;
	}
	
	public WebElement IFrameCaptchaElement() {
		return IFrameCaptcha;
	}
	
	public WebElement IFrameCaptchaPlElement() {
		return IFrameCaptchaPl;
	}
	
	public WebElement MensajeUsuarioYaRegistradoElement() {
		return MensajeUsuarioYaRegistrado;
	}

	
}
