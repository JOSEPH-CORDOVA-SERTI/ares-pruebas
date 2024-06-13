package mx.com.ares.testcases.olvidemicontrasena;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import mx.com.ares.base.Base;

public class PantallaOlvideMiContrasenaFuncionalBA extends Base {
	String mensajeCorreoExitoso = "Te hemos enviado un correo electrónico con las instrucciones para recuperar tu contraseña, por favor verifícalo.";
	String mensajeCaptcha = "Error en la validación captcha";
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/login?aplic=banco_azteca");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div[5]/div/a")));
		navegador.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div[5]/div/a")).click();		
	}
	
	@BeforeMethod
	public void limpiarCampos() {
		Contrasena.CorreoElementPl().clear();
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Recuperar contraseña de manera exitosa", enabled = false)
	public void EnvioExitoso() throws InterruptedException {
		WebElement campoCorreo = navegador.findElement(By.id("txtUsername"));
		campoCorreo.sendKeys(correoBA);
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
	    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MainContent_lblFail")));
	    
	    WebElement mensajeErrorElemento = navegador.findElement(By.id("MainContent_lblFail"));
	    String mensajeError = mensajeErrorElemento.getText();
	    
	    Assert.assertTrue(mensajeError.contains("Ingrese un usuario o correo electrónico"));
	}


	//El test funciona correctamente, sin embargo los captcha no tienen un correcto funcionamiento en la 
	//página web de Banco Azteca.
	@Test(description="Recuperar contraseña sin seleccionar captcha", enabled = false)
	public void SinCaptcha() throws InterruptedException {
		Contrasena.CorreoElementPl().sendKeys(correoBA);
		Contrasena.btnRecuperarElement().click();
		WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MainContent_lblSuccess")));
	    
	    WebElement mensajeErrorElemento = navegador.findElement(By.id("MainContent_lblSuccess"));
	    String mensajeError = mensajeErrorElemento.getText();
	    
	    Assert.assertTrue(mensajeError.contains("Error en la validación captcha"));
	}
	
	@Test(description="Recuperar contraseña con campo correo electrónico con caracteres inválidos")
	public void CorreoCaracInv() throws InterruptedException {
		Contrasena.CorreoElementPl().sendKeys("userBereFyopmail.com");
		Contrasena.btnRecuperarElement().click();
		WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger-message-inner")));
	    
	    WebElement mensajeErrorElemento = navegador.findElement(By.cssSelector(".messenger-message-inner"));
	    String mensajeError = mensajeErrorElemento.getText();
	    
	    Assert.assertTrue(mensajeError.contains("El correo es inválido"));
	}
}
