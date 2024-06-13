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

public class PantallaMiInformacionFacturacionDisenoF extends Base{
	String titulo = "Datos Fiscales";
	String telefono = "Teléfono";
	String correo = "Correo electrónico";
	String giro = "Giro de comercio";
	String nombreC = "Nombre del comercio";
	String alerta = "Recuerda que para poder transferir el monto de tus ventas es necesario que completes el registro.";


	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Fact1234");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	@Test(description="Mensajes en la sección Mi información Contacto")
	public void mensajeInformacionContacto() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divbilling")));
		String mensajeTitulo = navegador.findElement(By.xpath("//*[@id=\"divbilling\"]/h4")).getText();
		AssertJUnit.assertEquals(mensajeTitulo, titulo);
		String mensajeNombre = navegador.findElement(By.xpath("//*[@id=\"divbilling\"]/div/div[3]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajeNombre, telefono);
		String mensajeApellidoP = navegador.findElement(By.xpath("//*[@id=\"divbilling\"]/div/div[3]/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeApellidoP, correo);
		String mensajeApellidoM = navegador.findElement(By.xpath("//*[@id=\"divbilling\"]/div/div[5]/label")).getText();
		AssertJUnit.assertEquals(mensajeApellidoM, giro);
		String mensajeRegimen = navegador.findElement(By.xpath("//*[@id=\"divbilling\"]/div/div[6]/label")).getText();
		AssertJUnit.assertEquals(mensajeRegimen, nombreC);
		String mensajeAlerta = navegador.findElement(By.xpath("//*[@id=\"alertaRegistro\"]")).getText();
		AssertJUnit.assertEquals(mensajeAlerta, alerta);
	}
	
	
}


