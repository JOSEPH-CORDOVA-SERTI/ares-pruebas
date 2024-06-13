package mx.com.ares.testcases.miinformacion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import mx.com.ares.base.Base;

public class PantallaMiInformacionBancariaFuncionalF extends Base{

	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Usuario1234");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	@BeforeMethod
	public void limpiarCampos() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep4")));
		MiInformacion.clabeElement().clear();
		MiInformacion.cuentaElement().clear();
		Select select = new Select(MiInformacion.bancoElement());
        select.selectByValue("-1");

	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	@Test(description="Mensajes en la sección Mi información Bancaria")
	public void mensajeInformacionBancaria() throws Exception {
	    WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep4")));
	    MiInformacion.BotonSiguienteInfBancElement().click();
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger-message-inner")));
	    // Si la notificación está presente, el test pasa
	    Assert.assertTrue(true);
	}
	
	@Test(description="Opción régimen fiscal: Sin RFC con CLABE interbancaria menor a 18 dígitos")
	public void mensajeInformacionBBancariaClabeMenor() throws Exception {
	    WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep4")));
	    MiInformacion.clabeElement().sendKeys("123");
	    MiInformacion.BotonSiguienteInfBancElement().click();
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger-message-inner")));
	    // Si la notificación está presente, el test pasa
	    Assert.assertTrue(true);
	}
	@Test(description="Opción régimen fiscal: Sin RFC con número de cuenta menor a 7 dígitos")
	public void mensajeInformacionBBancariaNumCuentaMenor() throws Exception {
	    WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep4")));
	    MiInformacion.clabeElement().sendKeys("823498234812737459");
	    Select select = new Select(MiInformacion.bancoElement());
	    select.selectByValue("B138");
	    Thread.sleep(1000);
	    MiInformacion.cuentaElement().sendKeys("1234");
	    MiInformacion.BotonSiguienteInfBancElement().click();
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger-message-inner")));
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
	    Assert.assertEquals(textoMensaje , "El número de cuenta es inválida.");
	}
	@Test(description="Opción régimen fiscal: Sin RFC con campo CABLE vacío")
	public void mensajeInformacionBBancariaSinClabe() throws Exception {
	    WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep4")));
	    Select select = new Select(MiInformacion.bancoElement());
	    select.selectByValue("B138");
	    Thread.sleep(1000);
	    MiInformacion.cuentaElement().sendKeys("1234");
	    MiInformacion.BotonSiguienteInfBancElement().click();
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger-message-inner")));
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
	    Assert.assertEquals(textoMensaje , "La clabe interbancaria es inválida.");
	}
	
	@Test(description="Opción régimen fiscal: Sin RFC con campo número de cuenta vacío")
	public void mensajeInformacionBBancariaSinNumCuenta() throws Exception {
	    WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep4")));
	    Thread.sleep(1000);
	    MiInformacion.clabeElement().sendKeys("823498234812737459");
	    MiInformacion.BotonSiguienteInfBancElement().click();
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger-message-inner")));
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
	    Assert.assertEquals(textoMensaje , "El número de cuenta es inválida.");
	}
	
	@Test(description="Opción régimen fiscal: Sin RFC sin seleccionar Banco")
	public void mensajeInformacionBBancariaSinBanco() throws Exception {
		navegador.navigate().refresh();
	    WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep4")));
	    Thread.sleep(1000);
	    MiInformacion.clabeElement().sendKeys("823498234812737459");
	    MiInformacion.cuentaElement().sendKeys("8897445641");
	    MiInformacion.BotonSiguienteInfBancElement().click();
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger-message-inner")));
	    WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
	    Assert.assertEquals(textoMensaje , "Contacte al responsable del sitio web. Error: E001");
	}
	
	@Test(description="Opción régimen fiscal: Sin RFC Llenar formulario de pantalla Cuenta bancaria correctamente", enabled = false)
	public void mensajeInformacionBancariaExitosa() throws Exception {
	    WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep4")));
	    Thread.sleep(1000);
	    MiInformacion.clabeElement().sendKeys("823498234812737459");
	    MiInformacion.cuentaElement().sendKeys("8897445641");
	    Select select = new Select(MiInformacion.bancoElement());
	    select.selectByValue("B138");
	    MiInformacion.BotonSiguienteInfBancElement().click();
	}

	
	
}


