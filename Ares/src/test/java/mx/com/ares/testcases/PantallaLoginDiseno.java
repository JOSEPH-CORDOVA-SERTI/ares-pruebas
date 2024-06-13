package mx.com.ares.testcases;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;

import mx.com.ares.base.Base;

public class PantallaLoginDiseno extends Base{
	String mensajeiniciarSesion = "Iniciar sesión";
	String mensajeRegistro = "¿No tienes cuenta en Feenicia? Regístrate aquí.";
	String mensajeUsuario = "Usuario";
	String mensajeContrasena = "Contraseña";
	String mensajeIngresar = "Ingresar";
	String mensajeOlvideMiContrasena = "Olvidé mi contraseña";
	
	@BeforeClass
	public void openBrowser() {
		navegador.get("https://feenicia.net/Fnza_SSO/Account/signin");	
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Mensajes Pantalla")
	public void mensajeIniciarSesion() throws Exception {
		String IniciaSesion = navegador.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div/div/div/h2")).getText();
		AssertJUnit.assertEquals(IniciaSesion, mensajeiniciarSesion);
		String registro = navegador.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div/div/div/p[1]")).getText();
		AssertJUnit.assertEquals(registro, mensajeRegistro);
		String usuario = navegador.findElement(By.xpath("//*[@id=\"MainContent_divUsr\"]/label")).getText();
		AssertJUnit.assertEquals(usuario, mensajeUsuario);
		String contrasena = navegador.findElement(By.xpath("//*[@id=\"MainContent_divPass\"]/label")).getText();
		AssertJUnit.assertEquals(contrasena, mensajeContrasena);
		String Ingresar =Login.IngresarElement().getAttribute("Value");
		AssertJUnit.assertEquals(Ingresar, mensajeIngresar);
		String olvidarContra = navegador.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div/div/div/div[4]/div[2]/a")).getText();
		AssertJUnit.assertEquals(olvidarContra, mensajeOlvideMiContrasena);
	}
	@Test(description="Enlace facebook")
	public void enlaceFacebook() throws Exception {
	navegador.findElement(By.xpath("//*[@id=\"form1\"]/nav/div/div[2]/ul/li[1]/a/i")).click();
	System.out.println(navegador.getTitle());
	
	}
	
	@Test(description="Enlace instagram")
	public void enlaceInstagram() throws Exception {
	navegador.findElement(By.xpath("//*[@id=\"form1\"]/nav/div/div[2]/ul/li[3]/a/i")).click();
	System.out.println(navegador.getTitle());
	}
	
	@Test(description="Enlace twitter")
	public void enlaceTwitter() throws Exception {
	navegador.findElement(By.xpath("//*[@id=\"form1\"]/nav/div/div[2]/ul/li[2]/a/i")).click();
	System.out.println(navegador.getTitle());
	}
}
