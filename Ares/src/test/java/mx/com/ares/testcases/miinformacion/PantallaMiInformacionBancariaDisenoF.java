package mx.com.ares.testcases.miinformacion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mx.com.ares.base.Base;

public class PantallaMiInformacionBancariaDisenoF extends Base{
	String titulo = "Información para depósito bancario";
	String clabe = "Clabe";
	String banco = "Banco";
	String numCuenta = "Número de cuenta";
	String edoCuenta = "Estado de Cuenta";
	String alerta = "Recuerda que para poder transferir el monto de tus ventas es necesario que completes el registro.";


	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Usuario1234");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	@Test(description="Mensajes en la sección Mi información Bancaria")
	public void mensajeInformacionBancaria() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divbank")));
		String mensajeTitulo = navegador.findElement(By.xpath("//*[@id=\"divbank\"]/h4")).getText();
		AssertJUnit.assertEquals(mensajeTitulo, titulo);
		String mensajePais = navegador.findElement(By.xpath("//*[@id=\"divbank\"]/div/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajePais, clabe);
		String mensajeCodigoP = navegador.findElement(By.xpath("//*[@id=\"divbank\"]/div/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeCodigoP, banco);
		String mensajeEstado = navegador.findElement(By.xpath("//*[@id=\"divbank\"]/div/div[3]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajeEstado, numCuenta);
		String mensajeMunicipio = navegador.findElement(By.xpath("//*[@id=\"divbank\"]/div/div[3]/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeMunicipio, edoCuenta);
		String mensajeAlerta = navegador.findElement(By.xpath("//*[@id=\"alertaRegistro\"]")).getText();
		AssertJUnit.assertEquals(mensajeAlerta, alerta);
	}
	
	
}


