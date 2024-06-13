package mx.com.ares.deprecado.pagoleal;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;

import mx.com.ares.base.Base;

public class PantallaLoginDisenoPl extends Base{
	String mensajeiniciarSesion = "Iniciar sesión";
	String mensajeRegistro = "¿No tienes cuenta en Pago Leal ? Regístrate aquí.";
	String mensajeUsuario = "Usuario";
	String mensajeContrasena = "Contraseña";
	String mensajeIngresar = "Ingresar";
	String mensajeOlvideMiContrasena = "Olvidé mi contraseña";
	
	@BeforeClass
	public void openBrowser() {
		navegador.get("https://qa.serti.tech/Fnza_SSO/Account/Login?aplic=pago_leal");		
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Mensajes pantalla")
	public void mensajeIniciarSesion() throws Exception {
		String IniciaSesion = navegador.findElement(By.xpath("//*[@id=\"pwd-container\"]/div/div[1]/div[1]/div/div[1]/div/h3")).getText();
		AssertJUnit.assertEquals(IniciaSesion, mensajeiniciarSesion);
		String registro = navegador.findElement(By.xpath("//*[@id=\"pwd-container\"]/div/div[1]/div[1]/div/div[2]/div/p")).getText();
		AssertJUnit.assertEquals(registro, mensajeRegistro);
		String usuario = navegador.findElement(By.xpath("//*[@id=\"pwd-container\"]/div/div[1]/div[2]/label")).getText();
		AssertJUnit.assertEquals(usuario, mensajeUsuario);
		String contrasena = navegador.findElement(By.xpath("//*[@id=\"pwd-container\"]/div/div[2]/div[1]/label")).getText();
		AssertJUnit.assertEquals(contrasena, mensajeContrasena);
		String Ingresar =Login.IngresarElement().getAttribute("Value");
		AssertJUnit.assertEquals(Ingresar, mensajeIngresar);
		String olvidarContra = navegador.findElement(By.xpath("//*[@id=\"pwd-container\"]/div/div[2]/div[3]/a")).getText();
		AssertJUnit.assertEquals(olvidarContra, mensajeOlvideMiContrasena);
	}

	@Test(description="Enlace facebook",enabled=false)
	public void enlaceFacebook() throws Exception {
	navegador.findElement(By.xpath("//*[@id=\"form1\"]/nav/div/div[2]/ul/li[1]/a/i")).click();
	System.out.println(navegador.getTitle());
		//Assert.assertEquals(olvidarContra, mensajeOlvideMiContrasena);
	}
}
