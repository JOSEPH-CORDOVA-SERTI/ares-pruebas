package mx.com.ares.testcases.miinformacion;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mx.com.ares.base.Base;

public class PantallaMiInformacionFacturacionFuncionalIn extends Base{


	@BeforeClass
	public void openBrowser() {
		navegador.get("https://qa.serti.tech/Fnza_SSO/Account/Login?aplic=inbursa");	
		
		Login.UsuarioElement().sendKeys("auto12345");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	@Test(description="Opción régimen fiscal: Sin RFC con campos vacíos en pantalla Facturación")
	public void ModuloInformacionFacturacionVacia() throws Exception {
		Thread.sleep(3000);
		MiInformacion.CampoTelefonoFactElement().clear();
		MiInformacion.CampoNombreComercioElement().clear();
		MiInformacion.botonSiguienteInfFactElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje,"Seleccionar giro de comercio");

	}
	@Test(description="Opción régimen fiscal: Sin RFC con número telefónico a 11 dígitos")
	public void InformacionFacturacionTelefonoMayorDiez() throws Exception {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep2")));
		String campoText= MiInformacion.CampoTelefonoFactElement().getAttribute("maxlength");
		Assert.assertEquals(campoText,"10");
	}
	@Test(description="Opción régimen fiscal: Sin RFC sin seleccionar giro del comercio")
	public void ModuloInformacionFacturacionSinGiroComercio() throws Exception {
		Thread.sleep(3000);
		MiInformacion.CampoNombreComercioElement().clear();
		MiInformacion.botonSiguienteInfFactElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje,"Seleccionar giro de comercio");

	}
	@Test(description="Opción régimen fiscal: Sin RFC con campo nombre del comercio vacio")
	public void ModuloInformacionFacturacionNombreComercioVacio() throws Exception {
	    Thread.sleep(3000);
	    MiInformacion.CampoNombreComercioElement().clear();
	    
	    // Esperar a que el dropdown esté disponible y se abra
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("chosen-results")));
	    
	    // Seleccionar la opción deseada directamente del dropdown
	    WebElement dropdown = navegador.findElement(By.className("chosen-results"));
	    List<WebElement> options = dropdown.findElements(By.tagName("li"));
	    
	    // Iterar sobre las opciones y seleccionar la deseada
	    for (WebElement option : options) {
	        if (option.getText().equals("Seleccionar giro de comercio")) {
	            option.click();
	            break;
	        }
	    }

	    MiInformacion.botonSiguienteInfFactElement().click();
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
	    String textoMensaje = mensajeElemento.getText();
	    Assert.assertEquals(textoMensaje,"Seleccionar giro de comercio");
	}

	//@Test(description="Opción régimen fiscal: Sin RFC con campo telefono vacio")
	//@Test(description="Llenar formulario de pantalla facturación correctamente Opción régimen fiscal: Sin RFC")
	
}


