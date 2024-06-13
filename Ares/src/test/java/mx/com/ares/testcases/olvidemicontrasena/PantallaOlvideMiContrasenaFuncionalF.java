package mx.com.ares.testcases.olvidemicontrasena;

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

public class PantallaOlvideMiContrasenaFuncionalF extends Base {
	String mensajeCorreoExitoso = "Te hemos enviado un correo electrónico con las instrucciones para recuperar tu contraseña, por favor verifícalo.";
	String mensajeCaptcha = "Error en la validación captcha";
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://feenicia.net/Fnza_SSO/Account/signin");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form1\"]/div[3]/div/div/div/div[4]/div[2]/a")));
		navegador.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div/div/div/div[4]/div[2]/a")).click();	
	}
	
	@BeforeMethod
	public void limpiarCampos() {
		Contrasena.CorreoElement().clear();
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Recuperar contraseña de manera exitosa",enabled = false)
	public void EnvioExitoso() throws InterruptedException {
		Contrasena.CorreoElement().sendKeys(correoF);
        navegador.switchTo().frame(Contrasena.captcha());
        navegador.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-border")).click();
        Thread.sleep(2000);
        navegador.switchTo().defaultContent();
		Contrasena.btnRecuperarElement().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_lblSuccess\"]")));
		String mensajeExitoso = navegador.findElement(By.xpath("//*[@id=\"MainContent_lblSuccess\"]")).getText();
		AssertJUnit.assertEquals(mensajeExitoso, mensajeCorreoExitoso);
	}
	
	@Test(description="Recuperar contraseña con campo correo vacío y sin seleccionar captcha")
	public void Camposvacios() throws InterruptedException {
		Contrasena.btnRecuperarElement().click();
	    String mensajeError = Contrasena.CorreoElement().getAttribute("validationMessage");
	    AssertJUnit.assertTrue((mensajeError.contains("campo")));
	}
	
	@Test(description="Recuperar contraseña sin seleccionar captcha")
	public void SinCaptcha() throws InterruptedException {
		Contrasena.CorreoElement().sendKeys(correoF);
		Contrasena.btnRecuperarElement().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_lblFail\"]")));
		String mensajeErrorCaptcha = Contrasena.ecaptcha().getText();
	    AssertJUnit.assertEquals(mensajeErrorCaptcha,mensajeCaptcha);
	}
	
	@Test(description="Recuperar contraseña con campo correo electrónico con caracteres inválidos")
	public void CorreoCaracInv() throws InterruptedException {
		Contrasena.CorreoElement().sendKeys("userBereFyopmail.com");
		Contrasena.btnRecuperarElement().click();
	    String mensajeError = Contrasena.CorreoElement().getAttribute("validationMessage");
	    AssertJUnit.assertTrue((mensajeError.contains("formato")));
	}
}
