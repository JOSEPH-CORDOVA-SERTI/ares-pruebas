package mx.com.ares.testcases.olvidemicontrasena;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import mx.com.ares.base.Base;

public class PantallaOlvideMiContrasenaDisenoBA extends Base {
	String descripcion = "Escribe el correo electrónico con el cual te registraste y te enviaremos la información necesaria para reestablecerla.";
	String cuenta = "Ingrese su dirección de correo electrónico y le enviaremos un correo con instrucciones para restablecer su contraseña.";
	String titulo = "Recuperar contraseña";
	String mensajeBoton = "RECUPERAR CONTRASEÑA";
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/login?aplic=banco_azteca");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div[5]/div/a")));
		navegador.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div[5]/div/a")).click();	
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Mensajes pantalla")
	public void Mensajes() throws InterruptedException {
		AssertJUnit.assertEquals(Contrasena.TituloRecuperarT().getText(), titulo);
		AssertJUnit.assertEquals(Contrasena.DescripcionT().getText(), descripcion);
		AssertJUnit.assertEquals(Contrasena.DescripcionBA().getText(), cuenta);
		String msgButton =  navegador.findElement(By.xpath("/html/body/form/div[3]/div/div/div/div/div/div/div[3]/input")).getAttribute("value");
		Assert.assertEquals(msgButton, mensajeBoton);
		
	}
	
	
}
