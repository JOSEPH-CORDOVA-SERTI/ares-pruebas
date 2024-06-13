package mx.com.ares.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiInformacion {
	
	public MiInformacion(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	@FindBy(xpath ="/html/body/ul/li[1]/div/div")
	WebElement MensjaCamposVacios;
	
	
	@FindBy(id = "Form1")
	WebElement PantallaCompletarReg;
	
	
	@FindBy(id = "btnNextStep1")
	WebElement BotonSiguienteInfCont;
	
	@FindBy(id = "btnNextStep2")
	WebElement BotonSiguienteInfFact;
	
	@FindBy(id = "btnNextStep3")
	WebElement BotonSiguienteInfDire;
	
	@FindBy(id = "btnNextStep4")
	WebElement BotonSiguienteInfBanc;
	
	@FindBy(id  = "selectRegimeType")
	WebElement SelectRegimen;
	
	@FindBy(xpath = "//*[@id=\"dtBirthday\"]")
	WebElement CampoFecha;
	
	@FindBy(id = "txtAp")
	WebElement CampoApellidoPaterno;
	
	@FindBy(id = "txtAm")
	WebElement CampoApellidoMaterno;
	
	@FindBy(id = "txtPhone")
	WebElement CampoTelefono;
	
	@FindBy(id = "txtNombre")
	WebElement Nombre;
	 
	@FindBy(id = "txtFdPhone")
	WebElement CampoTelefonoFact;
	
	@FindBy(id = "txtFdMail")
	WebElement CampoCorreoFact;
	
	@FindBy(xpath = "/html/body/ul/li[1]/div/div")
	WebElement MensajeSinApellidoP;
	
	@FindBy(xpath = "/html/body/ul/li[1]/div/div")
	WebElement MensajeSinNombre;
	
	@FindBy(xpath = "/html/body/ul/li[1]/div/div")
	WebElement MensajeTelefono;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/table/thead/tr[1]/th[2]/select[1]")
	WebElement MesNacimiento;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/table/thead/tr[1]/th[2]/select[2]")
	WebElement AnNacimiento;

	@FindBy(xpath = "//*[@id=\"dtBirthday\"]")
	WebElement FechaNacimiento;
	
	@FindBy(xpath = "/html/body/ul/li/div/div")
	WebElement FechaNacimientoMensaje;
	
	@FindBy(xpath = "/html/body/ul/li/div/div")
	WebElement MensajeFactSinRFCVacio;

	@FindBy(xpath = "//*[@id=\"divbilling\"]/h4")
	WebElement PantallaFacturacion;
	
	@FindBy(xpath = "//*[@id=\"divbilling\"]/progress")
	WebElement  Progreso;
	
	@FindBy(id = "btnNextStep2")
	WebElement botonSiguienteFacturacion;
	
	@FindBy(id="txtIdComerce")
	WebElement CampoNombreComercio;
	
	@FindBy(id="txtFdPhone")
	WebElement CampoTelFact;
	
	@FindBy(id="ddlFdCategory_chosen")
	WebElement GiroComFact;
	
	@FindBy(id="ddlFdCategory")
	WebElement SelecGiroFact;
	
	@FindBy(xpath="/html/body/ul/li/div/div")
	WebElement MensajeSinNombreComFac;
	
	@FindBy(id="txtAdCp")
	WebElement codigoPostal;
	
	@FindBy(id="txtAdState")
	WebElement estado;
	
	@FindBy(id="txtAdMunicipality")
	WebElement municipio;
	
	@FindBy(id="txtAdCol")
	WebElement colonia;
	
	@FindBy(id="txtAdStreet")
	WebElement calle;
	
	@FindBy(id="txtAdNumber")
	WebElement numeroExt;
	
	@FindBy(id="txtAdNumberInt")
	WebElement numeroInt;

	@FindBy(id="txtBankClabe")
	WebElement clabe;
	
	@FindBy(id="selectBank")
	WebElement banco;
	
	@FindBy(id="txtBankAccount")
	WebElement cuenta;
	
	@FindBy(id="txtFdRfc")
	WebElement rfc;
	
	@FindBy(id = "txtFdName")
	WebElement razonSocial;
	
	@FindBy(id = "nombreComercio")
	WebElement nombreComercio;
	
	@FindBy(id = "headerFile")
	WebElement fotoPortada;
	
	@FindBy(id = "fileProfilePicture2")
	WebElement fotoPerfil;
	
	@FindBy(id = "btnPreview")
	WebElement btnPreview;
	
	@FindBy(id = "btnSaveCommerceName")
	WebElement btnSaveCommerceName;
	
	@FindBy(id = "btnCrop2")
	WebElement btnCrop2;
	
	public WebElement botonGuardarImagenElement() {
		return btnCrop2;
	}
	
	public WebElement botonGuardarReciboElement() {
		return btnSaveCommerceName;
	}
	
	public WebElement botonPreviewElement() {
		return btnPreview;
	}
	
	public WebElement fotoPerfilElement() {
		return fotoPerfil;
	}
	
	public WebElement nombreComercioElement() {
		return nombreComercio;
	}
	
	public WebElement fotoPortadaElement() {
		return fotoPortada;
	}
	
	public WebElement razonSocialElement() {
		return razonSocial;
	}
	
	public WebElement rfcElement() {
		return rfc;
	}
	
	public WebElement clabeElement() {
		return clabe;
	}
	
	public WebElement bancoElement() {
		return banco;
	}
	
	public WebElement cuentaElement() {
		return cuenta;
	}

	public WebElement MensajeSinNombreComFacElement() {
		return MensajeSinNombreComFac;
	}
	
	public WebElement codigoPostalElement() {
		return codigoPostal;
	}
	
	public WebElement estadoElement() {
		return estado;
	}
	
	public WebElement municipioElement() {
		return municipio;
	}
	
	public WebElement coloniaElement() {
		return colonia;
	}
	
	public WebElement calleElement() {
		return calle;
	}
	
	public WebElement numeroExtElement() {
		return numeroExt;
	}
	
	public WebElement numeroIntElement() {
		return numeroInt;
	}
	
	
	public WebElement SelecGiroFactElement() {
		return SelecGiroFact;
	}
	
	public WebElement GiroComFactElement() {
		return GiroComFact;
	}
	
	public WebElement CampoTelFactElement() {
		return CampoTelFact;
	}
	
	
	public WebElement CampoNombreComercioElement() {
		return CampoNombreComercio;
	}
	
	
	public WebElement CampoTelefonoFactElement() {
		return CampoTelefonoFact;
	}
	
	public WebElement CampoCorreoFactElement() {
		return CampoCorreoFact;
	}
	
	
	public WebElement ProgresoElement() {
		return Progreso;
	}
	
	public WebElement botonSiguienteFacturacionElement() {
		return botonSiguienteFacturacion;
	}
	
	public WebElement botonSiguienteInfFactElement() {
		return BotonSiguienteInfFact;
	}
	
	public WebElement BotonSiguienteInfDireElement() {
		return BotonSiguienteInfDire;
	}
	
	public WebElement BotonSiguienteInfBancElement() {
		return BotonSiguienteInfBanc;
	}
	
	
	public WebElement PantallaFacturacionElement() {
		return PantallaFacturacion;
	}
	
	public WebElement MensajeFactSinRFCVacioElement() {
		return MensajeFactSinRFCVacio;
	}
	
	public WebElement MesElement() {
		return MesNacimiento;
	}
	
	public WebElement AnElement() {
		return AnNacimiento;
	}
	public WebElement FechaNacimientoElement() {
		return FechaNacimiento;
	}
	public WebElement MensajeTelefonoElement() {
		return MensajeTelefono;
	}
	
	public WebElement MensajeSinApellidoPElement() {
		return MensajeSinApellidoP;
	}
	public WebElement MensajeSinNombreElement() {
		return MensajeSinNombre;
	}
	
	public WebElement CampoFechaElement() {
		return CampoFecha;
	}
	public WebElement CampoTelefonoElement() {
		return CampoTelefono;
	}
	public WebElement CampoApellidoMaternoElement() {
		return CampoApellidoMaterno;
	}
	public WebElement CampoApellidoPaternoElement() {
		return CampoApellidoPaterno;
	}
	public WebElement SelectRegimenElement() {
		return SelectRegimen;
	}
	public WebElement NombreElement() {
		return Nombre;
	}
	
	public WebElement MensjaCamposVaciosElement() {
		return MensjaCamposVacios;
	}
	
	public WebElement PantallaCompletarRegElement() {
		return PantallaCompletarReg;
	}
	
	public WebElement BotonSiguienteInfContElement() {
		return BotonSiguienteInfCont;
	}
}
