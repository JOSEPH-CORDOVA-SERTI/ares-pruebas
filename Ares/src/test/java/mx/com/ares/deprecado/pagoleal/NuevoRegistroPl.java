package mx.com.ares.deprecado.pagoleal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NuevoRegistroPl {
	
	public NuevoRegistroPl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(id="txtMail")
	WebElement Correo;
	
	@FindBy(id="txtUser")
	WebElement Usuario;
	
	@FindBy(id="password")
	WebElement Contrasena;
	
	@FindBy(id="txtConfirmMail")
	WebElement ConfirmarCorreo;
	
	@FindBy(xpath="//*[@id=\"btnRegistrar\"]")
	WebElement Registrar;
	
	@FindBy(id="checkAccept")
	WebElement AceptarTyC;
	
	@FindBy(xpath = "//*[@id=\"form1\"]/div[3]/div/div/div/p[1]/a")
	WebElement RegistrateAqui;

	@FindBy(xpath = "//*[@id=\"MainContent_divRegister\"]/h3")
	WebElement MensajePantalla;
	
	@FindBy(xpath = "//*[@id=\"MainContent_lblFail\"]")
    WebElement MensajeSinCaptcha;
	
	@FindBy(xpath = "//*[@id=\"MainContent_lblFail\"]")
    WebElement MensajeCorreoYaRegistrado;
	
	@FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    WebElement Captcha;
	
	@FindBy(xpath = "/html/body/form/div[3]/div/div/div/div[6]/div/div/div/iframe")
    WebElement IFrameCaptcha;
	
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
	
	@FindBy(xpath = "//*[@id=\"form1\"]/div[3]/div/div/div/div[7]/div[2]/p/a[2]")
    WebElement AvisoPrivacidad;
	
	@FindBy(id="MainContent_lblFail")
    WebElement MensajeContrasenaMayor;
	
	
	@FindBy(id="//*[@id=\"MainContent_lblFail\"]")
    WebElement MensajeUsuarioInvalid;
	
	@FindBy(xpath = "//*[@id=\"pwd-container\"]/div/div[1]/div[1]/div/div[2]/div/p/a")
	WebElement RegistrateAquiPl;
	
	public WebElement AceptarTyCElement() {
		return AceptarTyC;
	}
	
	public WebElement ConfirmarCorreoElement() {
		return ConfirmarCorreo;
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
	
	public WebElement UsuarioElement() {
		return Usuario;
	}
	public WebElement ContrasenaElement() {
		return Contrasena;
	}
	public WebElement RegistrarElement() {
		return Registrar;
	}
	public WebElement RegistrateAquiElement() {
		return RegistrateAqui;
	}
	public WebElement MensajePantallaElement() {
		return MensajePantalla;
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
	public WebElement MensajeUsuarioYaRegistradoElement() {
		return MensajeUsuarioYaRegistrado;
	}

	
}
