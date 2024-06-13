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

public class PantallaSuscripcionGrupaldisenoCr extends Base {

	String tituloPage1="Agregar suscripción grupal";
	String tituloPage2="Datos del plan";
	String labelFile1="Verifica que el formato del archivo sea:";
	String labelFile2="CSV UTF-8 (delimitado por comas).";
	
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
	
	@Test(description="Agregar")
	public void agregar(){
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		Cronos.getAgregarGrupal().click();
		
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.textToBePresentInElement(Cronos.getLabelTipoPlan(),"Tipo de plan"));
		
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,tituloPage1);
		
		
		String datos=Cronos.getTitleDatos().getText();
		Assert.assertEquals(datos,tituloPage2);
		
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
		
		String campo5=Cronos.getLabelReintentos().getText();
		Assert.assertEquals(campo5,"Reintentos de pago");
		Assert.assertNotNull(Cronos.getInputReintentos(), "El elemento Reintentos de pago no existe.");
		
		String campo6=Cronos.getLabelReferencia().getText();
		Assert.assertEquals(campo6,"Referencia");
		Assert.assertNotNull(Cronos.getReferencia(), "El elemento Referencia no existe.");
		
		
		String iniciar=Cronos.getBtnIniciar().getText();
		Assert.assertEquals(iniciar,"Iniciar");
		
		String descargar=Cronos.getLinkDescargarFormato().getText();
		Assert.assertEquals(descargar,"Descargar formato");
		
		String label1=Cronos.getLabelArchivo().getText();
		Assert.assertEquals(label1,labelFile1);
		
		String label2=Cronos.getLabelCsv().getText();
		Assert.assertEquals(label2,labelFile2);
		
		
		Assert.assertNotNull(Cronos.getInputDragandDrop(), "El elemento  Drag and Drop no existe.");

	}
	
	
	@Test(description="Consultar")
	public void consultar(){
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
		String titulo=Cronos.getTitleConsultarGrupal().getText();
		Assert.assertEquals(titulo,"Suscripciones grupales");
		
		
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
		
		String Suscripciones=Cronos.getColumnasuscripcioneso().getText();
		Assert.assertEquals(Suscripciones,"SUSCRIPCIONES");
		
		String Procesado=Cronos.getColumnaProcesado().getText();
		Assert.assertEquals(Procesado,"PROCESADO");
		
		Assert.assertNotNull(Cronos.getListaPaginas(), "El elemento lista de paginas mostrar no existe.");
		
		
		
		
		
		
	}
	}

