package mx.com.ares.testcases.producto;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import mx.com.ares.base.Base;

public class PantallaProductosDisenoFe extends Base {
	String mensajeCorreoExitoso = "Te hemos enviado un correo electrónico con las instrucciones para recuperar tu contraseña, por favor verifícalo.";
	String mensajeCaptcha = "Error en la validación captcha";
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://feenicia.net/Fnza_SSO/Account/signin");
		Login.UsuarioElement().sendKeys("Moral1");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();	
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Diseño de la sección Productos sin haber agregado uno previamente",enabled = false, priority = 1)
	public void EnvioExitoso() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		Thread.sleep(2000);
		//Productos.SeccionProductos();
		Contrasena.CorreoElement().sendKeys(correoF);
        navegador.switchTo().frame(Contrasena.captcha());
        navegador.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-border")).click();
        Thread.sleep(2000);
        navegador.switchTo().defaultContent();
		Contrasena.btnRecuperarElement().click();
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_lblSuccess\"]")));
		String mensajeExitoso = navegador.findElement(By.xpath("//*[@id=\"MainContent_lblSuccess\"]")).getText();
		AssertJUnit.assertEquals(mensajeExitoso, mensajeCorreoExitoso);
	}
	//@Test(description="Diseño de la sección agrega un producto",enabled = false, priority = )
	//@Test(description="Diseño de la sección Productos con un producto",enabled = false, priority = )
	
	
	
	
	
	
}
