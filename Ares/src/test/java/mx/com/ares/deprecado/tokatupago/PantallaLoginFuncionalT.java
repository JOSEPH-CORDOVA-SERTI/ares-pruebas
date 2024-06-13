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

public class PantallaLoginFuncionalT extends Base{
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://toka.feenicia.net/Fnza_SSO/Account/Login?aplic=toka_tu_pago");
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
	
	@Test(description="Inicio de sesión exitoso")
	public void LoginExitoso() throws Exception {
		
		Login.UsuarioElement().sendKeys(usuarioT);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdownMenu1\"]")));
		navegador.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).click();
		navegador.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).click();
		navegador.findElement(By.xpath("//*[@id=\"hplSessionOut\"]")).click(); 
	}

	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con usuario incorrecto")
	public void usuarioIncorrecto() throws Exception {
		Login.UsuarioElement().sendKeys(usuarioT+"a");
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con contraseña incorrecta")
	public void contrasenaIncorrecto() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioT);
		Login.ContrasenaElement().sendKeys(contrasena+"1");
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con usuario vacío")
	public void usuarioVacio() throws Exception {
		Login.UsuarioElement().clear();
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UsuarioElement().getAttribute("validationMessage");
		AssertJUnit.assertTrue((mensajeError.contains("campo")));
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con contraseña vacía")
	public void contrasenaVacio() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioT);
		Login.ContrasenaElement().clear();
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Por favor escriba la contraseña");
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con campos vacíos")
	public void camposVacios() throws Exception {
		Login.UsuarioElement().clear();
		Login.ContrasenaElement().clear();
		Login.IngresarElement().click();
		String mensajeError = Login.UsuarioElement().getAttribute("validationMessage");
		AssertJUnit.assertTrue((mensajeError.contains("campo")));
	}
	
	@Test(description="Inicio de sesión, con correo electrónico en usuario")
	public void loginCorreoExitoso() throws Exception {
		
		Login.UsuarioElement().sendKeys(correoT);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		Thread.sleep(4000);
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="inicio de sesión con usuario inactivo")
	public void usuarioInactivo() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioInactivoT);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="inicio der sesión con usuario diferente aplic")
	public void usuarioAplic() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioInactivoI);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoMbElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña Incorrecto");
	}
}
