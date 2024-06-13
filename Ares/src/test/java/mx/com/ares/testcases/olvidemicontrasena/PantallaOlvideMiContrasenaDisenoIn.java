package mx.com.ares.testcases.olvidemicontrasena;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mx.com.ares.base.Base;

public class PantallaOlvideMiContrasenaDisenoIn extends Base {
	String descripcion = "Escribe el correo electrónico con el cual te registraste y te enviaremos la información necesaria para reestablecerla.";
	String cuenta = "Si ya tienes cuenta ingresa aquí.";
	String titulo = "Recuperar contraseña";
	String mensajeBoton = "Recuperar contraseña";
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://qa.serti.tech/Fnza_SSO/Account/Login?aplic=inbursa");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/div/div[3]/a")));
		navegador.findElement(By.xpath("//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/div/div[3]/a")).click();	
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Mensajes pantalla")
	public void Mensajes() throws InterruptedException {
		AssertJUnit.assertEquals(Contrasena.TituloRecuperarIn().getText(), titulo);
		AssertJUnit.assertEquals(Contrasena.DescripcionIn().getText(), descripcion);
		AssertJUnit.assertEquals(Contrasena.mensajeCuentaIn().getText(), cuenta);
		//Assert.assertEquals(msgButon, mensajeBoton);
	}
	
	
}
