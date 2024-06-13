package mx.com.ares.testcases.miinformacion;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

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

public class PantallaMiInformacionFuncionalPersonaMoralF extends Base{

	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Moral5");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Opción régimen fiscal: Persona Moral sin Nombre", priority = 1, enabled = false)
	public void InformacionContactoSinNombre() throws Exception {
				
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByValue("1");
		regimen.selectByVisibleText("Persona Moral");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtAp")));
		
		MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
		MiInformacion.CampoApellidoPaternoElement().sendKeys(apellidoP);
		MiInformacion.CampoTelefonoElement().sendKeys(telefono);
		MiInformacion.BotonSiguienteInfContElement().click();
		
		
		
		String mensajeSinNombre= MiInformacion.MensajeSinNombreElement().getText();
		 //System.out.println(pantallaCompletaReg);
		Assert.assertEquals(mensajeSinNombre,"Nombre del contacto inválido.");
	}

	@Test(description="Información de Contacto para persona Moral exitoso", priority = 2, enabled = false)
	 public void InformacionContactoCorrecto() throws Exception {
			
			Select regimen = new Select( MiInformacion.SelectRegimenElement());
			regimen.selectByValue("1");
			regimen.selectByVisibleText("Persona Moral");
			
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
			
			
		}
	@Test(description="Opción régimen fiscal: Persona moral Razón social vacía", priority = 3, enabled = false)
	public void RazonSocialVacia() throws Exception {
		navegador.navigate().refresh();
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.rfcElement().sendKeys(RFCMoral);
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Razón social de la compañia inválida.");
	}
	@Test(description="Opción régimen fiscal: Persona moral con RFC de persona física", priority = 4, enabled = false)
	public void RFCDePersonaFisica() throws Exception {
		navegador.navigate().refresh();
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.rfcElement().sendKeys(RFCFisica);
	    MiInformacion.razonSocialElement().sendKeys("Taquería el Torito sureño");
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "RFC inválido.");
	}
	
	@Test(description="Opción régimen fiscal: Persona moral con RFC a 12 dígitos incorrecto", priority = 4, enabled = false)
	public void RFCDoceDigitosIncorrecto() throws Exception {
		navegador.navigate().refresh();
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.rfcElement().sendKeys("123456789101");
	    MiInformacion.razonSocialElement().sendKeys("Taquería el Torito sureño");
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "RFC inválido.");
	}
	@Test(description="Opción régimen fiscal: Persona moral con RFC registrado anteriormente", priority = 5, enabled = false)
	public void RFCRegistradoPreviamente() throws Exception {
		navegador.navigate().refresh();
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.rfcElement().sendKeys("");
	    MiInformacion.razonSocialElement().sendKeys("Taquería el Torito sureño");
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "RFC inválido.");
	}
	@Test(description="Opción régimen fiscal: Persona moral con RFC vacío", priority = 6, enabled = false)
	public void RFCVacio() throws Exception {
		navegador.navigate().refresh();
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.razonSocialElement().sendKeys("Taquería el Torito sureño");
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "RFC inválido.");
	}
	
	
	@Test(description="Opción régimen fiscal: Persona Moral Llenar formulario de pantalla facturación correctamente", priority = 7, enabled = false)
	 public void InformacionFacturacionCorrecto() throws Exception {
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.rfcElement().sendKeys(RFCMoral);
	    MiInformacion.razonSocialElement().sendKeys("Taquería el Torito sureño");
	    MiInformacion.CampoNombreComercioElement().sendKeys("Hola Mundo");
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	    Thread.sleep(4000);
	}
	
	@Test(description="Opción régimen fiscal: Persona Moral Llenar formulario de pantalla dirección correctamente", priority = 8, enabled = false)
	public void mensajeInformacionDireccionCorrecto() throws Exception {
		Thread.sleep(2000);
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
	@Test(description="Opción régimen fiscal: Persona Moral Llenar formulario de pantalla Cuenta bancaria correctamente", priority = 9, enabled = false)
	public void mensajeInformacionBancariaExitosa() throws Exception {
		Thread.sleep(2000);
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
	
	@Test(description="Descargar archivo de Terminos y condiciones", priority = 10, enabled = false)
	public void validarBotonDescargaPDF() {
	    // Obtener la ventana actual
	    String ventanaActual = navegador.getWindowHandle();

	    // Localizar el elemento del botón y hacer clic en él
	    WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnDownloadPDF")));
	    WebElement botonDescarga = navegador.findElement(By.id("btnDownloadPDF"));
	    botonDescarga.click();

	    // Esperar a que se abra la nueva pestaña
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	    // Obtener las ventanas disponibles
	    Set<String> ventanas = navegador.getWindowHandles();
	    // Iterar sobre las ventanas para encontrar la nueva
	    for (String ventana : ventanas) {
	        if (!ventana.equals(ventanaActual)) {
	            navegador.switchTo().window(ventana);
	            break;
	        }
	    }

	    // Verificar que la URL de la nueva ventana sea la del PDF esperado
	    String urlActual = navegador.getCurrentUrl();
	    Assert.assertTrue(urlActual.contains("Terminos_y_Condiciones-Feenicia.pdf"), "La nueva ventana no contiene la URL del PDF esperado");

	    // Cerrar la nueva ventana y volver a la original
	    navegador.close();
	    navegador.switchTo().window(ventanaActual);
	}
	
	@Test(description="Ingresar al enlace Aviso de privacidad en la sección T&C", priority = 11, enabled = false)
	public void validarEnlaceAvisoPrivacidad() {
		// Obtener la ventana actual
	    String ventanaActual = navegador.getWindowHandle();

	    // Localizar el elemento del enlace
	    WebElement enlaceAvisoPrivacidad = navegador.findElement(By.xpath("//a[contains(text(), 'Aviso de Privacidad.')]"));
	    enlaceAvisoPrivacidad.click();

	    // Esperar a que se abra la nueva pestaña
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	    // Obtener las ventanas disponibles
	    Set<String> ventanas = navegador.getWindowHandles();
	    // Iterar sobre las ventanas para encontrar la nueva
	    for (String ventana : ventanas) {
	        if (!ventana.equals(ventanaActual)) {
	            navegador.switchTo().window(ventana);
	            break;
	        }
	    }

	    // Verificar que la URL de la nueva ventana sea la del aviso de privacidad esperado
	    String urlActual = navegador.getCurrentUrl();
	    Assert.assertEquals(urlActual, "https://www.feenicia.com/aviso-de-privacidad/", "La nueva ventana no contiene la URL del aviso de privacidad esperado");

	    // Cerrar la nueva ventana y volver a la original
	    navegador.close();
	    navegador.switchTo().window(ventanaActual);
	}

	@Test(description="Aceptar términos y condiciones", priority = 12, enabled = false)
	public void AceptarTerminosYCondiciones() throws Exception {
		 	WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"conditions-data\"]/h4")));
		    WebElement dropdownContainer = navegador.findElement(By.xpath("//*[@id=\"btnNextStep5\"]"));
		    dropdownContainer.click();
		    Thread.sleep(4000);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"Form1\\\"]/div[4]/div[1]/div/div/div/div[2]/h2")));
		    WebElement mensajeElemento = navegador.findElement(By.xpath("//*[@id=\"Form1\"]/div[4]/div[1]/div/div/div/div[2]/h2"));
			String textoMensaje = mensajeElemento.getText();
			Assert.assertEquals(textoMensaje, "Gracias por completar tu registro en Feenicia");
	}
	
	
	
}


