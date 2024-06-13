package mx.com.ares.testcases.miinformacion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mx.com.ares.base.Base;

public class PantallaConoceTuReciboDisenoF extends Base{
	String titulo = "Ahora con el nuevo recibo Feenicia, ¡tus clientes te conocerán más!";
	String subtitulo = "Sube la foto de Perfil y de Portada de tu negocio tal y como lo haces en redes sociales";
	String nombre = "Escribe el nombre que aparecerá en tus recibos";
	String portada = "Selecciona la foto de portada de tu recibo";
	String perfil = "Seleccionar foto de perfil";
	String vistaP = "Vista previa del recibo";
	String guardar = "Guardar" ;
	


	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Moral5");
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
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"conditions-data\"]/h4")));
		WebElement botonReciboNuevo = navegador.findElement(By.xpath("//*[@id=\"btnReceipt\"]"));
		botonReciboNuevo.click();
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divRecibo")));
		String mensajeTitulo = navegador.findElement(By.xpath("//*[@id=\"divRecibo\"]/h4")).getText();
		AssertJUnit.assertEquals(mensajeTitulo, titulo);
		String mensajeSubtitulo = navegador.findElement(By.xpath("//*[@id=\"divRecibo\"]/p")).getText();
		AssertJUnit.assertEquals(mensajeSubtitulo, subtitulo);
		String mensajeNombre = navegador.findElement(By.xpath("//*[@id=\"divRecibo\"]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajeNombre, nombre);
		WebElement botonPortadaRecibo = navegador.findElement(By.xpath("//span[contains(text(), 'Selecciona la foto de portada de tu recibo')]"));
	    String textoBotonPortadaRecibo = botonPortadaRecibo.getText();
	    AssertJUnit.assertEquals(textoBotonPortadaRecibo, portada); 
	    WebElement botonFotoPerfil = navegador.findElement(By.xpath("//span[contains(text(), 'Seleccionar foto de perfil')]"));
	    String textoBotonFotoPerfil = botonFotoPerfil.getText();
	    AssertJUnit.assertEquals(textoBotonFotoPerfil, perfil);
	    WebElement linkVistaPreviaRecibo = navegador.findElement(By.id("btnPreview"));
	    String textoLinkVistaPreviaRecibo = linkVistaPreviaRecibo.getText();
	    AssertJUnit.assertEquals(textoLinkVistaPreviaRecibo, vistaP);
	    WebElement botonGuardar = navegador.findElement(By.id("btnSaveCommerceName"));
	    String textoBotonGuardar = botonGuardar.getText();
	    AssertJUnit.assertEquals(textoBotonGuardar, guardar);

	}
	
	
}


