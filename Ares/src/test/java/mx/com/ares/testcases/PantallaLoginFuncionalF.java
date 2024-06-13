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

public class PantallaLoginFuncionalF extends Base{

	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://feenicia.net/Fnza_SSO/Account/signin");
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
		
		Login.UsuarioElement().sendKeys(usuarioF);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdownMenu1\"]")));
		navegador.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).click();
		navegador.findElement(By.xpath("//*[@id=\"hplSessionOut\"]")).click();
	}

	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con usuario incorrecto")
	public void usuarioIncorrecto() throws Exception {
		Login.UsuarioElement().sendKeys(usuarioF+"a");
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña incorrecta, favor de validar.");
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con contraseña incorrecta")
	public void contrasenaIncorrecto() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioF);
		Login.ContrasenaElement().sendKeys(contrasena+"1");
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Usuario o Contraseña incorrecta, favor de validar");
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con usuario vacío")
	public void usuarioVacio() throws Exception {
		Login.UsuarioElement().clear();
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Por favor escriba el nombre de usuario");
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con contraseña vacía")
	public void contrasenaVacio() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioF);
		Login.ContrasenaElement().clear();
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Por favor escriba la contraseña");
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="Inicio de sesión con campos vacíos")
	public void camposVacios() throws Exception {
		Login.UsuarioElement().clear();
		Login.ContrasenaElement().clear();
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Por favor escriba el nombre de usuario");
	}
	
	@Test(description="Inicio de sesión, con correo electrónico en usuario")
	public void loginCorreoExitoso() throws Exception {
		
		Login.UsuarioElement().sendKeys(correoF);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdownMenu1\"]")));
		navegador.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).click();
		navegador.findElement(By.xpath("//*[@id=\"hplSessionOut\"]")).click();
	}
	
	@Test(dependsOnMethods={"LoginExitoso"},description="inicio de sesión con usuario inactivo")
	public void usuarioInactivo() throws Exception {
		Login.UsuarioElement().clear();
		Login.UsuarioElement().sendKeys(usuarioInactivoF);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		String mensajeError = Login.UserIncorrectoElement().getText();
		AssertJUnit.assertEquals(mensajeError,"Ocurrio un error interno, favor de comunicarse con su administrador.");
	}
}
