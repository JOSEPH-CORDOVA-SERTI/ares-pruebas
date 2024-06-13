package mx.com.ares.testcases;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;

import mx.com.ares.base.Base;

public class PantallaLoginDisenoIn extends Base{
	String mensajeiniciarSesion = "Iniciar sesión";
	String mensajeRegistro = "¿No tienes cuenta ? Regístrate aquí.";
	String mensajeUsuario = "Usuario";
	String mensajeContrasena = "Contraseña";
	String mensajeIngresar = "Ingresar";
	String mensajeOlvideMiContrasena = "Olvidé mi contraseña";
	String mensajeLegales = "© 2022 Inbursa. Todos los derechos reservados. Todas las marcas y los logotipos son propiedad de sus respectivos dueños y se utilizan con fines de identificación únicamente, sin implicar el aval de productos ni una asociación con Inbursa.";
	
	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/Login?aplic=inbursa");		
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Mensajes pantalla")
	public void mensajeIniciarSesion() throws Exception {
		String IniciaSesion = navegador.findElement(By.xpath("//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/h3")).getText();
		AssertJUnit.assertEquals(IniciaSesion, mensajeiniciarSesion);
		String registro = navegador.findElement(By.xpath("//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/p")).getText();
		AssertJUnit.assertEquals(registro, mensajeRegistro);
		String usuario = navegador.findElement(By.xpath("//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/div/div[1]/div/label")).getText();
		AssertJUnit.assertEquals(usuario, mensajeUsuario);
		String contrasena = navegador.findElement(By.xpath("//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/div/div[2]/label")).getText();
		AssertJUnit.assertEquals(contrasena, mensajeContrasena);
		String Ingresar =Login.IngresarElement().getAttribute("Value");
		AssertJUnit.assertEquals(Ingresar, mensajeIngresar);
		String olvidarContra = navegador.findElement(By.xpath("//*[@id=\"Form1\"]/main/div/div/div/div/div/div/div/div/div[3]/a")).getText();
		AssertJUnit.assertEquals(olvidarContra, mensajeOlvideMiContrasena);
		String legales = navegador.findElement(By.xpath("/html/body/footer/div/div/div/p")).getText();
		AssertJUnit.assertEquals(legales, mensajeLegales);
		
	}
	
}
