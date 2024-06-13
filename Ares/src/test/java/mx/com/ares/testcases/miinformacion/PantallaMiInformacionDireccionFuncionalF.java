package mx.com.ares.testcases.miinformacion;

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

public class PantallaMiInformacionDireccionFuncionalF extends Base{

	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Bancario123");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	 @BeforeMethod
		public void limpiarCampos() {
		 	WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
			ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
			MiInformacion.codigoPostalElement().clear();
			MiInformacion.calleElement().clear();
			MiInformacion.numeroExtElement().clear();
			MiInformacion.numeroIntElement().clear();
		}
	
	
	@Test(description="Opción régimen fiscal: Sin RFC con campos vacíos en pantalla Dirección")
	public void mensajeInformacionDireccionCamposVacios() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.BotonSiguienteInfDireElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Estado inválido");

	}
	
	@Test(description="Opción régimen fiscal: Sin RFC solo con información en campo estado")
	public void mensajeInformacionDireccionConCampoEstado() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		WebElement selectElement = navegador.findElement(By.id("txtAdState"));
		Select select = new Select(selectElement);
		select.selectByValue("9");
		MiInformacion.BotonSiguienteInfDireElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Calle inválida.");

	}
	
	
	@Test(description="Opción régimen fiscal: Sin RFC con código postal a 3 dígitos")
	public void mensajeInformacionDireccionConCPostalTresD() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("123");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		MiInformacion.BotonSiguienteInfDireElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Estado inválido");

	}
	@Test(description="Opción régimen fiscal: Sin RFC con código correcto")
	public void mensajeInformacionDireccionConCpostalCorrecto() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("56600");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Select stateSelect = new Select(navegador.findElement(By.id("txtAdState")));
		WebElement selectedStateOption = stateSelect.getFirstSelectedOption();
		String selectedStateValue = selectedStateOption.getAttribute("value");
		Assert.assertNotEquals(selectedStateValue, "", "No se ha seleccionado un estado");

		Select municipalitySelect = new Select(navegador.findElement(By.id("txtAdMunicipality")));
		WebElement selectedMunicipalityOption = municipalitySelect.getFirstSelectedOption();
		String selectedMunicipalityValue = selectedMunicipalityOption.getAttribute("value");
		Assert.assertNotEquals(selectedMunicipalityValue, "", "No se ha seleccionado un municipio");

		Select colonySelect = new Select(navegador.findElement(By.id("txtAdCol")));
		WebElement selectedColonyOption = colonySelect.getFirstSelectedOption();
		String selectedColonyValue = selectedColonyOption.getAttribute("value");
		Assert.assertNotEquals(selectedColonyValue, "", "No se ha seleccionado una colonia");

	}
	@Test(description="Opción régimen fiscal: Sin RFC con campo municipio vacío")
	public void mensajeInformacionDireccionSinMunicipio() throws Exception {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("56600");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Select select = new Select(MiInformacion.municipioElement());
		select.selectByValue("Otro");
		MiInformacion.BotonSiguienteInfDireElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Municipio inválido.");

	}
	@Test(description="Opción régimen fiscal: Sin RFC con campo colonia vacío")
	public void mensajeInformacionDireccionSinColonia() throws Exception {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("56600");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Select select = new Select(MiInformacion.coloniaElement());
		select.selectByValue("Otro");
		MiInformacion.BotonSiguienteInfDireElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Colonia inválida.");

	}
	@Test(description="Opción régimen fiscal: Sin RFC con campo calle vacío")
	public void mensajeInformacionDireccionSinCalle() throws Exception {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("56600");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		MiInformacion.BotonSiguienteInfDireElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Calle inválida.");

	}
	@Test(description="Opción régimen fiscal: Sin RFC con campo número exterior vacío")
	public void mensajeInformacionDireccionSinNumeroExt() throws Exception {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("56600");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		MiInformacion.calleElement().sendKeys("Sheakespeare");
		MiInformacion.BotonSiguienteInfDireElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Número externo inválido.");

	}
	@Test(description="Opción régimen fiscal: Sin RFC con campo número interior vacío", enabled = false)
	public void mensajeInformacionDireccionSinNumeroInt() throws Exception {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("56600");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		MiInformacion.calleElement().sendKeys("Sheakespeare");
		MiInformacion.numeroExtElement().sendKeys("12");
		MiInformacion.BotonSiguienteInfDireElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Número interno inválido.");

	}
	@Test(description="Opción régimen fiscal: Sin RFC subir documento de comprobante de domicilio", enabled = false)
	public void mensajeInformacionDireccionComprobante() throws Exception {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("56600");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		MiInformacion.calleElement().sendKeys("Sheakespeare");
		MiInformacion.numeroExtElement().sendKeys("12");
		MiInformacion.BotonSiguienteInfDireElement().click();
		WebElement mensajeElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
		String textoMensaje = mensajeElemento.getText();
		Assert.assertEquals(textoMensaje, "Número externo inválido.");

	}
	@Test(description="Opción régimen fiscal: Sin RFC Llenar formulario de pantalla dirección correctamente", enabled = false)
	public void mensajeInformacionDireccionCorrecto() throws Exception {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNextStep3")));
		MiInformacion.codigoPostalElement().sendKeys("56600");
		MiInformacion.codigoPostalElement().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		MiInformacion.calleElement().sendKeys("Sheakespeare");
		MiInformacion.numeroExtElement().sendKeys("12");
		MiInformacion.numeroIntElement().sendKeys("123");
		MiInformacion.BotonSiguienteInfDireElement().click();

	}

	
	
}


