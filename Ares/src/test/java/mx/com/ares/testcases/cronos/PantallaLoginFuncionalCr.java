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


public class PantallaLoginFuncionalCr extends Base {
	
	private String notificacionError = "Las credenciales proporcionadas no son validas, o el comercio se encuentra inactivo.";
	
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
	
	
	@Test(description="Login dejando el campo de comercio vacío", priority = 2)
	public void loginCampoComercioVacio() {
		navegador.navigate().refresh();
		Cronos.getPassword().sendKeys(contrasena);
		Cronos.getBtnLogin().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.attributeContains(Cronos.getUserName(), "class", "is-invalid"));
		String classAttribute = Cronos.getUserName().getAttribute("class");
	    Assert.assertTrue(classAttribute.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	@Test(description="Login dejando el campo de contraseña vacío", priority = 3)
	public void loginCampoPasswordVacio() {
		navegador.navigate().refresh();
		Cronos.getUserName().sendKeys(usuarioCronos);
		Cronos.getBtnLogin().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.attributeContains(Cronos.getPassword(), "class", "is-invalid"));
		String classAttribute = Cronos.getPassword().getAttribute("class");
	    Assert.assertTrue(classAttribute.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	@Test(description="Login dejando ambos campos vacíos", priority = 1)
	public void loginDosCamposVacios() {
		Cronos.getBtnLogin().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.attributeContains(Cronos.getPassword(), "class", "is-invalid"));
		ewait.until(ExpectedConditions.attributeContains(Cronos.getUserName(), "class", "is-invalid"));
		String classAttribute = Cronos.getPassword().getAttribute("class");
	    Assert.assertTrue(classAttribute.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    String classAttribute2 = Cronos.getUserName().getAttribute("class");
	    Assert.assertTrue(classAttribute2.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	@Test(description="Login con contraseña incorrecta", priority = 4)
	public void loginCredencialesIncorrectas() {
		navegador.navigate().refresh();
		Cronos.getUserName().sendKeys(usuarioCronos);
		Cronos.getPassword().sendKeys(contrasena + "*");
		Cronos.getBtnLogin().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionLogin()));
		String mensaje = Cronos.getNotificacionLogin().getText();
		Assert.assertEquals(mensaje, notificacionError);
	}
	
	@Test(description="Login con comercio incorrecto", priority = 5)
	public void loginComercioIncorrecto() {
		navegador.navigate().refresh();
		Cronos.getUserName().sendKeys(usuarioCronos + "*");
		Cronos.getPassword().sendKeys(contrasena);
		Cronos.getBtnLogin().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionLogin()));
		String mensaje = Cronos.getNotificacionLogin().getText();
		Assert.assertEquals(mensaje, notificacionError);
	}
	
	@Test(description="Login con comercio inactivo", priority = 6)
	public void loginComercioInactivo() {
		navegador.navigate().refresh();
		Cronos.getUserName().sendKeys(usuarioInCronos);
		Cronos.getPassword().sendKeys(contrasena);
		Cronos.getBtnLogin().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionLogin()));
		String mensaje = Cronos.getNotificacionLogin().getText();
		Assert.assertEquals(mensaje, notificacionError);
	}
	
	@Test(description="Login exitoso", priority = 7)
	public void loginExitoso() {
		Cronos.getUserName().sendKeys(usuarioCronos);
		Cronos.getPassword().sendKeys(contrasena);
		Cronos.getBtnLogin().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getTitleDashboard()));
		String mensaje = Cronos.getTitleDashboard().getText();
		Assert.assertEquals(mensaje, "Dashboard");
	}
	

}
