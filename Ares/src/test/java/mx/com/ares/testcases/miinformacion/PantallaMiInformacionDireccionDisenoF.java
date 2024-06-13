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

public class PantallaMiInformacionDireccionDisenoF extends Base{
	String titulo = "Dirección de facturación";
	String pais = "País";
	String codigoP = "Código Postal";
	String estado = "Estado";
	String municipio = "Municipio";
	String colonia = "Colonia";
	String calle = "Calle";
	String numeroE = "Número Ext.";
	String numeroI = "Número Int.";
	String comprobante = "Comprobante de domicilio";
	String alerta = "Recuerda que para poder transferir el monto de tus ventas es necesario que completes el registro.";


	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Bancario123");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	@Test(description="Mensajes en la sección Mi información Direccion")
	public void mensajeInformacionDireccion() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divaddress")));
		String mensajeTitulo = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/h4")).getText();
		AssertJUnit.assertEquals(mensajeTitulo, titulo);
		String mensajePais = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/div/div[1]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajePais, pais);
		String mensajeCodigoP = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/div/div[1]/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeCodigoP, codigoP);
		String mensajeEstado = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/div/div[2]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajeEstado, estado);
		String mensajeMunicipio = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/div/div[2]/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeMunicipio, municipio);
		String mensajeColonia = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/div/div[3]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajeColonia, colonia);
		String mensajeCalle = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/div/div[3]/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeCalle, calle);
		String mensajeNumeroE = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/div/div[4]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajeNumeroE, numeroE);
		String mensajeNumeroI = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/div/div[4]/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeNumeroI, numeroI);
		String mensajeComprobante = navegador.findElement(By.xpath("//*[@id=\"divaddress\"]/div/div[4]/div[3]/label")).getText();
		AssertJUnit.assertEquals(mensajeComprobante, comprobante);
		String mensajeAlerta = navegador.findElement(By.xpath("//*[@id=\"alertaRegistro\"]")).getText();
		AssertJUnit.assertEquals(mensajeAlerta, alerta);
	}
	
	
}


