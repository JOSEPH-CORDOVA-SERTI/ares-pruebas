package mx.com.ares.testcases.cronos;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import mx.com.ares.base.Base;
import org.openqa.selenium.JavascriptExecutor;



public class PantallaLoginDisenoCr extends Base {
	

	String TextoFormulario1="Hecho con pasión y conocimiento en CDMX y TOL por SERTI y DELTA.";
	String TextoFormulario2="Feenicia | Mucho más que solo aceptar tarjetas.";
	String TextoFormulario3="Todos los derechos reservados.";

	
		
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://feenicia.net/cronos-web/login");
		navegador.manage().window().maximize();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getUserName()));
	}
	
	@BeforeMethod
	public void limpiarCampos() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getUserName()));
		Cronos.getUserName().clear();
		Cronos.getPassword().clear();
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Titulo feeniciacronos")
	public void tituloFeenicia() {
		String Titulo = Cronos.getTitleLogin().getText();
		Assert. assertTrue(Titulo.contains("feenicia"), "El texto no contiene 'feenicia'.");
		Assert. assertTrue(Titulo.contains("cronos"), "El texto no contiene 'cronos'.");
	}
	@Test(description="Campo Comercio")
	public void campoComercio() {
		String LabelComercio=Cronos.getLabelUser().getText();
		Assert.assertEquals(LabelComercio, "Comercio", "El texto no es 'Comercio'.");
		Assert.assertNotNull(Cronos.getUserName(), "El elemento input con id 'username' no existe.");
		String placeholder = Cronos.getUserName().getAttribute("placeholder");
		Assert.assertEquals(placeholder, "Comercio", "El placeholder no es 'Comercio'.");
	}
	@Test(description="Campo Contraseña")
	public void campoContraseña() {
		String LabelPassword=Cronos.getLabelPassword().getText();
		Assert.assertEquals(LabelPassword, "Contraseña", "El texto no es 'Contraseña'.");
		Assert.assertNotNull(Cronos.getPassword(), "El elemento input con id 'password' no existe.");
		String placeholder = Cronos.getPassword().getAttribute("placeholder");
		Assert.assertEquals(placeholder, "Contraseña", "El placeholder no es 'Contraseña'.");
	}
	@Test(description="Boton Ingresar")
	public void botonIngresar() {
		Assert.assertNotNull(Cronos.getBtnLogin(), "El botón 'Ingresar' no existe.");
		String BotonLogin=Cronos.getBtnLogin().getText();
		Assert.assertEquals(BotonLogin, "Ingresar", "El texto del botón no es 'Ingresar'.");
	}
	@Test(description="Texto login")
	public void textoLogin() {
		
		Assert.assertNotNull(Cronos.getTextLogin(), "El texto de Login no existe");
		String TextoLogin=Cronos.getTextLogin().getText();
		Assert. assertTrue(TextoLogin.contains(TextoFormulario1), "El texto de Login no es correcto");
		Assert. assertTrue(TextoLogin.contains(TextoFormulario2), "El texto de Login no es correcto");
		Assert. assertTrue(TextoLogin.contains(TextoFormulario3), "El texto de Login no es correcto");
	    String yearElemento = Cronos.getYearLogin().getText();
	    Assert.assertEquals(yearElemento,"2024", "El año actual no coincide con el año en el elemento.");

		
		
		
		
		
	}
	



}

