package mx.com.ares.testcases.cronos;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import mx.com.ares.base.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PantallasuscripcionIndividualDisenocr extends Base{
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://feenicia.net/cronos-web/login");
		navegador.manage().window().maximize();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getUserName()));
		Cronos.getUserName().sendKeys(usuarioCronos);
		Cronos.getPassword().sendKeys(contrasena);
		Cronos.getBtnLogin().click();
	
		
	}
	
	

	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	@Test(description="Agregar Datos del plan")
	public void agregar(){
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getAgregarIndividual()));
		Cronos.getAgregarIndividual().click();
		
		WebDriverWait ewait3 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait3.until(ExpectedConditions.textToBePresentInElement(Cronos.getLabelTipoPlan(),"Tipo de plan"));
		
		
		
		
		
		String titulo=Cronos.getTitleAgrgarIndividual().getText();
		Assert.assertEquals(titulo,"Agregar suscripción");
		
		
		String datos=Cronos.getTitleDatos().getText();
		Assert.assertEquals(datos,"Datos del plan");
			
		String campo1=Cronos.getLabelTipoPlan().getText();
		Assert.assertEquals(campo1,"Tipo de plan");
		Assert.assertNotNull(Cronos.getDesplegableTipoDePlan(), "El elemento  elige un plan no existe.");
		
		String campo2=Cronos.getLabelRecurrencia().getText();
		Assert.assertEquals(campo2,"Recurrencia");
		Assert.assertNotNull(Cronos.getRecurrencia(), "El elemento  elige un plan no existe.");
		
		String campo3=Cronos.getLabelInicioGrupal().getText();
		Assert.assertEquals(campo3,"Inicio");
		Assert.assertNotNull(Cronos.getFechaDeInicio(), "El elemento Inicio no existe.");

		String campo4=Cronos.getLabelMonto().getText();
		Assert.assertEquals(campo4,"Monto");
		Assert.assertNotNull(Cronos.getMonto(), "El elemento Monto no existe.");
		

		String campo6=Cronos.getLabelReintentos().getText();
		Assert.assertEquals(campo6,"Referencia");
		Assert.assertNotNull(Cronos.getReferencia(), "El elemento Referencia no existe.");
		
		
		
		
		
	}
	@Test(description="Agregar Datos bancarios")
	public void agregarBancarios(){
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getAgregarIndividual()));
		Cronos.getAgregarIndividual().click();
		
		
		String titulo=Cronos.getTitleAgrgarIndividual().getText();
		Assert.assertEquals(titulo,"Agregar suscripción");
		
		
		String datos=Cronos.getTitleDatosBancarios().getText();
		Assert.assertEquals(datos,"Datos bancarios");
			

		
		String campo2=Cronos.getLabelNombreTarjeta().getText();
		Assert.assertEquals(campo2,"Nombre en tarjeta");
		Assert.assertNotNull(Cronos.getNombreTarjeta(), "El elemento  elige un plan no existe.");
		
		String campo3=Cronos.getLabelNumeroTarjeta().getText();
		Assert.assertEquals(campo3,"Número de tarjeta");
		Assert.assertNotNull(Cronos.getNumeroTarjeta(), "El elemento Inicio no existe.");

		String campo4=Cronos.getLabelexpiracion().getText();
		Assert.assertEquals(campo4,"Expiración");
		Assert.assertNotNull(Cronos.getAnioExp(), "El elemento Monto no existe.");
		Assert.assertNotNull(Cronos.getMesExp(), "El elemento Monto no existe.");
		

		String campo6=Cronos.getLabelCVV().getText();
		Assert.assertEquals(campo6,"CVV - (opcional)");
		Assert.assertNotNull(Cronos.getCvvOpcional(), "El elemento Referencia no existe.");
		
		String campo7=Cronos.getLabelEmail().getText();
		Assert.assertEquals(campo7,"Correo electrónico - (opcional)");
		Assert.assertNotNull(Cronos.getEmailOpcional(), "El elemento Referencia no existe.");
		
		
		
		
	}
	
	@Test(description="Consultar")
	public void consultar(){
		
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
		String titulo=Cronos.getTitleConsultarGrupal().getText();
		Assert.assertEquals(titulo,"Suscripciones");
		
		
		WebDriverWait ewait3 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait3.until(ExpectedConditions.textToBePresentInElement(Cronos.getLabelMostrar(),"Mostrar"));
		
		String btn1=Cronos.getBtnFiltrar().getText();
		Assert.assertEquals(btn1,"Filtrar");
		
		String btn2=Cronos.getBtnDescargar().getText();
		Assert.assertEquals(btn2,"Descargar");
		
		String LabelDesplegable=Cronos.getLabelMostrar().getText();
		Assert.assertEquals(LabelDesplegable,"Mostrar");
		
		Assert.assertNotNull(Cronos.getDesplegableMostrar(), "El desplegable mostrar no existe.");
		
		String ID=Cronos.getColumnaID().getText();
		Assert.assertEquals(ID,"ID");
		
		String Referencia=Cronos.getColumnaReferencia().getText();
		Assert.assertEquals(Referencia,"REFERENCIA");
		
		String Plan=Cronos.getColumnaPlan().getText();
		Assert.assertEquals(Plan,"PLAN");
		
		String Monto=Cronos.getColumnaMonto().getText();
		Assert.assertEquals(Monto,"MONTO");
		
		String Inicio=Cronos.getColumnaInicio().getText();
		Assert.assertEquals(Inicio,"INICIO");
		
		String Fin=Cronos.getColumnaFin().getText();
		Assert.assertEquals(Fin,"FIN");
		
		String Registro=Cronos.getColumnaRegistro().getText();
		Assert.assertEquals(Registro,"REGISTRO");
		
		Assert.assertNotNull(Cronos.getListaPaginas(), "El elemento lista de paginas mostrar no existe.");
		
		
		
		
		
		
		
		
	}
}
