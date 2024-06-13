package mx.com.ares.testcases;


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

public class PantallaLoginFuncionalIn extends Base{

	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/Login?aplic=inbursa");
		navegador.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void limpiarCampos() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("MainContent_userLogin")));
		Login.UsuarioElement().clear();
		Login.ContrasenaElement().clear();
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Inicio de sesión exitoso", priority = 9)
	public void LoginExitoso() throws Exception {
		
		Login.UsuarioElement().sendKeys(usuarioI);
		Login.ContrasenaElement().sendKeys(contrasenaIn);
		Login.IngresarElement().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divcontactInformation\"]/h5")));
		String texto = navegador.findElement(By.xpath("//*[@id=\"divcontactInformation\"]/h5")).getText();
		AssertJUnit.assertEquals(texto,"Información personal o de contacto");
	}

	@Test(description="Inicio de sesión con usuario incorrecto", priority = 1)
	public void usuarioIncorrecto() throws Exception {
		Login.UsuarioElement().sendKeys(usuarioI+"a");
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
	
	@Test(description="Inicio de sesión con contraseña incorrecta", priority = 2)
	public void contrasenaIncorrecto() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioI);
		Login.ContrasenaElement().sendKeys(contrasena+"1");
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
	
	@Test(description="Inicio de sesión con usuario vacío", priority = 3)
	public void usuarioVacio() throws Exception {
		Login.UsuarioElement().clear();
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UsuarioElement().getAttribute("validationMessage");
		AssertJUnit.assertTrue((mensajeError.contains("campo")));
	}
	
	@Test(description="Inicio de sesión con contraseña vacía", priority = 4)
	public void contrasenaVacio() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioI);
		Login.ContrasenaElement().clear();
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Por favor escriba la contraseña");
	}
	
	@Test(description="Inicio de sesión con campos vacíos",  priority = 5)
	public void camposVacios() throws Exception {
		Login.UsuarioElement().clear();
		Login.ContrasenaElement().clear();
		Login.IngresarElement().click();
		String mensajeError = Login.UsuarioElement().getAttribute("validationMessage");
		AssertJUnit.assertTrue((mensajeError.contains("campo")));
	}
	
	@Test(description="Inicio de sesión, con correo electrónico en usuario", priority = 6)
	public void loginCorreoExitoso() throws Exception {
		
		Login.UsuarioElement().sendKeys(correoI);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
	
	@Test(description="inicio de sesión con usuario inactivo", priority = 7)
	public void usuarioInactivo() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioInactivoI);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
	
	@Test(description="inicio de sesión con otro aplic", priority = 8)
	public void usuarioAplic() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioP);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
}
