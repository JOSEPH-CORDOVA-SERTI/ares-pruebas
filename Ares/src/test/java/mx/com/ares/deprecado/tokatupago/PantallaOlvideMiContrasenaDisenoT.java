package mx.com.ares.deprecado.tokatupago;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mx.com.ares.base.Base;

public class PantallaOlvideMiContrasenaDisenoT extends Base {
	String descripcion = "Escribe el correo electrónico con el cual te registraste y te enviaremos la información necesaria para reestablecerla.";
	String cuenta = "Iniciar sesión";
	String titulo = "Recuperar contraseña";
	String mensajeBoton = "Recuperar contraseña";
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://toka.feenicia.net/Fnza_SSO/Account/login?aplic=toka_tu_pago");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div[5]/div/a[1]/strong")));
		navegador.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div/div/div/div/div/div[5]/div/a[1]/strong")).click();	
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Mensajes pantalla")
	public void Mensajes() throws InterruptedException {
		AssertJUnit.assertEquals(Contrasena.TituloRecuperarT().getText(), titulo);
		AssertJUnit.assertEquals(Contrasena.DescripcionT().getText(), descripcion);
		AssertJUnit.assertEquals(Contrasena.mensajeCuentaT().getText(), cuenta);
		//Assert.assertEquals(msgButon, mensajeBoton);
	}
	
	
}
