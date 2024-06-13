package mx.com.ares.deprecado.tokatupago;

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

public class PantallaOlvideMiContrasenafuncionalT extends Base {
	String mensajeCorreoExitoso = "Te hemos enviado un correo electrónico con las instrucciones para recuperar tu contraseña, por favor verifícalo.";
	String mensajeCaptcha = "Error en la validación captcha";
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://toka.feenicia.net/Fnza_SSO/Account/Login?aplic=toka_tu_pago");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div[5]/div/a[1]/strong")));
		navegador.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div[5]/div/a[1]/strong")).click();	
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
		Contrasena.CorreoElementPl().sendKeys(correoF);
        navegador.switchTo().frame(Contrasena.captcha());
        navegador.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-border")).click();
        Thread.sleep(2000);
        navegador.switchTo().defaultContent();
		Contrasena.btnRecuperarElementPl().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_lblSuccess\"]")));
		String mensajeExitoso = navegador.findElement(By.xpath("//*[@id=\"MainContent_lblSuccess\"]")).getText();
		AssertJUnit.assertEquals(mensajeExitoso, mensajeCorreoExitoso);
	}
	
	@Test(description="Recuperar contraseña con campo correo vacío y sin seleccionar captcha")
	public void Camposvacios() throws InterruptedException {
		Contrasena.btnRecuperarElement().click();
	    String mensajeError = navegador.findElement(By.xpath("//*[@id=\"divFail\"]")).getText();
	    AssertJUnit.assertEquals(mensajeError,"Ingrese un usuario o correo electrónico");
	}
	
	@Test(description="Recuperar contraseña sin seleccionar captcha")
	public void SinCaptcha() throws InterruptedException {
		Contrasena.CorreoElementPl().sendKeys(correoF);
		Contrasena.btnRecuperarElement().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_lblSuccess\"]")));
		String mensajeExitoso = navegador.findElement(By.xpath("//*[@id=\"MainContent_lblSuccess\"]")).getText();
		AssertJUnit.assertEquals(mensajeExitoso, mensajeCorreoExitoso);
	}
	
	@Test(description="Recuperar contraseña con campo correo electrónico con caracteres inválidos")
	public void CorreoCaracInv() throws InterruptedException {
		Contrasena.CorreoElementPl().sendKeys("userBereFyopmail.com");
		Contrasena.btnRecuperarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"El correo es inválido");
	}
}
