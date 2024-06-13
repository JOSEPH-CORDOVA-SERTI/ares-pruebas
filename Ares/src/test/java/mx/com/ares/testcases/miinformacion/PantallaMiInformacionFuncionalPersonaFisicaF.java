package mx.com.ares.testcases.miinformacion;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mx.com.ares.base.Base;

public class PantallaMiInformacionFuncionalPersonaFisicaF extends Base{

	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Ejemplo123");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}

	@Test(description="Información de Contacto para persona Física exitoso", enabled = false)
	 public void InformacionContactoCorrecto() throws Exception {
			
			Select regimen = new Select( MiInformacion.SelectRegimenElement());
			regimen.selectByValue("2");
			regimen.selectByVisibleText("Persona Física");
			
			Thread.sleep(3000);
			
			MiInformacion.NombreElement().sendKeys(nombre);
			MiInformacion.CampoApellidoPaternoElement().sendKeys(apellidoP);
			MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
			MiInformacion.CampoTelefonoElement().sendKeys(telefono);
			
			MiInformacion.FechaNacimientoElement().click();

			Select mesNaci = new Select( MiInformacion.MesElement());
			mesNaci.selectByIndex(5);
			mesNaci.selectByVisibleText("Junio");
			Thread.sleep(3000);
			
			Select añoNaci = new Select( MiInformacion.AnElement());
			añoNaci.selectByIndex(61);
			añoNaci.selectByVisibleText("1989");
			
			Thread.sleep(3000);
			
			navegador.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/table/tbody/tr[2]/td[4]")).click();
			MiInformacion.BotonSiguienteInfContElement().click();
			
			Thread.sleep(4000);
			
			String pantallaFac= MiInformacion.PantallaFacturacionElement().getText();
			assertEquals(pantallaFac, "Datos Fiscales");
			
			String barraProgreso= MiInformacion.ProgresoElement().getText();
			assertEquals(barraProgreso, "25% Completado");
			
		}
	
	@Test(description="Opción régimen fiscal: Persona física con RFC a 13 dígitos incorrecto", enabled = false)
	public void InformacionFacturacionRFCTreceD() throws Exception {
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.rfcElement().sendKeys("GALJ800515XXX1");
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "RFC inválido");
	}
	
	@Test(description="Opción régimen fiscal: Persona fisica con RFC vacío", enabled = false)
	public void InformacionFacturacionSinRFC() throws Exception {
		navegador.navigate().refresh();
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "RFC inválido");
	}
	
	@Test(description="Opción régimen fiscal: Persona fisica con RFC de persona moral", enabled = false)
	public void InformacionFacturacionRFCMoral() throws Exception {
		navegador.navigate().refresh();
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.rfcElement().sendKeys("EJE123456ABC");
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "RFC inválido");
	}
	
	@Test(description="Opción régimen fiscal: Persona fisica con RFC ya registrado anteriormente", enabled = false)
	public void InformacionFacturacionRFCAnteriormente() throws Exception {
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.rfcElement().sendKeys("GALJ800515XXX");
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "RFC inválido");
	}
	
	
	@Test(description="Opción régimen fiscal: Persona Fisica Llenar formulario de pantalla facturación correctamente", enabled = false)
	 public void InformacionFacturacionCorrecto() throws Exception {
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.rfcElement().sendKeys(RFCFisica);
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    Thread.sleep(4000);
	}
	
	@Test(description="Opción régimen fiscal: Persona Fisica Llenar formulario de pantalla dirección correctamente", enabled = false)
	public void mensajeInformacionDireccionCorrecto() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("56600");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		MiInformacion.calleElement().sendKeys("Sheakespeare");
		MiInformacion.numeroExtElement().sendKeys("12");
		MiInformacion.numeroIntElement().sendKeys("123");
		MiInformacion.BotonSiguienteInfDireElement().click();
		Thread.sleep(4000);
	}
	
	@Test(description="Opción régimen fiscal: Persona Fisica Llenar formulario de pantalla Cuenta bancaria correctamente", enabled = false)
	public void mensajeInformacionBBancariaExitosa() throws Exception {
	    WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep4")));
	    Thread.sleep(1000);
	    MiInformacion.clabeElement().sendKeys("823498234812737459");
	    MiInformacion.cuentaElement().sendKeys("8897445641");
	    Select select = new Select(MiInformacion.bancoElement());
	    select.selectByValue("B138");
	    MiInformacion.BotonSiguienteInfBancElement().click();
	    Thread.sleep(4000);
	}
	
}


