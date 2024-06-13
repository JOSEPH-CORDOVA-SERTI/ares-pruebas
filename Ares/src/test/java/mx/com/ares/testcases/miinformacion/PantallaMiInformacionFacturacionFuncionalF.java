package mx.com.ares.testcases.miinformacion;


import static org.testng.Assert.assertEquals;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mx.com.ares.base.Base;

public class PantallaMiInformacionFacturacionFuncionalF extends Base{


	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		navegador.manage().window().maximize();
		Login.UsuarioElement().sendKeys("Fact1234");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	


	@Test(description="Opción régimen fiscal: Sin RFC con campos vacíos en pantalla Facturación")
	public void InformacionFacturacionVacio() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		MiInformacion.CampoTelefonoFactElement().clear();
		MiInformacion.CampoNombreComercioElement().clear();
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep2")));
		MiInformacion.botonSiguienteFacturacionElement().click();
		String mensajefactVacio= MiInformacion.MensajeFactSinRFCVacioElement().getText();
		assertEquals(mensajefactVacio, "Número Telefónico inválido.");
	
		
	}
	
	
	@Test(description="Opción régimen fiscal: Sin RFC con número telefónico a 11 dígitos")
	public void InformacionFacturacionTelefonoMayorDiez() throws Exception {
				
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep2")));
		String campoText= MiInformacion.CampoTelFactElement().getAttribute("maxlength");
		Assert.assertEquals(campoText,"10");
	}
	
	
	@Test(description = "Llenar formulario de pantalla facturación correctamente Opción régimen fiscal: Sin RFC", enabled = false)
	public void InformacionFacturacionCorrecto() {
	    // Esperar a que el dropdown esté disponible y se abra
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));

	    // Hacer clic en el elemento para abrir el menú desplegable
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();

	    // Encontrar el campo de búsqueda dentro del dropdown y escribir el texto deseado
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    // Simular presionar la tecla "Enter"
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();
	}

	@Test(description="Opción régimen fiscal: Sin RFC con campo telefono vacio")
	public void InformacionFacturacionSinTelefono() {
	    // Esperar a que el dropdown esté disponible y se abra
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.CampoTelFactElement().clear();

	    // Hacer clic en el elemento para abrir el menú desplegable
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();

	    // Encontrar el campo de búsqueda dentro del dropdown y escribir el texto deseado
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    // Simular presionar la tecla "Enter"
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();

	    // Verificar el mensaje de error
	    WebElement mensajeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger-message-inner")));
	    String textoMensaje = mensajeElemento.getText();
	    Assert.assertEquals(textoMensaje, "Número Telefónico inválido.");
	}
	
	@Test(description="Opción régimen fiscal: Sin RFC con campo nombre del comercio vacio")
	public void InformacionFacturacionSinNombreComercio() {
	    // Esperar a que el dropdown esté disponible y se abra
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFdCategory_chosen")));
	    MiInformacion.CampoNombreComercioElement().clear();

	    // Hacer clic en el elemento para abrir el menú desplegable
	    WebElement dropdownContainer = navegador.findElement(By.id("ddlFdCategory_chosen"));
	    dropdownContainer.click();

	    // Encontrar el campo de búsqueda dentro del dropdown y escribir el texto deseado
	    WebElement searchInput = dropdownContainer.findElement(By.cssSelector(".chosen-search > input"));
	    searchInput.sendKeys("(BOUTIQUE ROPA - ESPECIAL), (BOUTIQUES - LENCERIAS)");
	    // Simular presionar la tecla "Enter"
	    searchInput.sendKeys(Keys.ENTER);
	    MiInformacion.botonSiguienteFacturacionElement().click();

	    // Verificar el mensaje de error
	    WebElement mensajeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger-message-inner")));
	    String textoMensaje = mensajeElemento.getText();
	    Assert.assertEquals(textoMensaje, "Nombre de comercio invalido.");
	}
		
	
}

