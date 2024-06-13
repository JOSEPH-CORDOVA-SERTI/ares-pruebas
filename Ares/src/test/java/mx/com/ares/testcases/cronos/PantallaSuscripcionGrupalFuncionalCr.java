package mx.com.ares.testcases.cronos;
import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PantallaSuscripcionGrupalFuncionalCr extends Base {
	private Random randomNumbers = new Random();
    String filePath = "Ares/src/test/resources/archivos para Pruebas/SampleCSV_Cronos.csv";
    String filePath2 = "C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\SampleCSV_Cronos.csv";
	
    String filepath3="..\\..\\resources\\archivos para Pruebas\\SampleCSV_Cronos.csv";
    String expectedColor= "rgb(244, 68, 85)";
    String pathDirectory="C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\Downloads";
    String fileDownloaded="C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\Downloads\\subscription_group_template.csv";
    String fileDownloaded2="C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\Downloads\\subscriptions_group_1717440890730.csv";
    
    
    
     String notiRecurrencia = "La recurrencia solo puede estar entre 1 y 999";
     String notiArchivo = "Por favor, selecciona un archivo.";
     String notiExtension = "El encabezado del archivo enviado no es correcto, se espera: \"NOMBRE EN TARJETA, NUMERO DE TARJETA, MES, ANIO, CVV, EMAIL, REFERENCIA\" CODIGO: G002";
     String notiVacio = "El archivo enviado se encuentra vacio. CODIGO: G002";
     String notiCorrecto = "Procesando archivo, al finalizar recibiras un correo electronico con el estado del proceso.";
    
     String notiFiltroSinResultados = "La solicitud enviada no obtuvo ningun resultado. CODIGO: G004";
    
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://feenicia.net/cronos-web/login");
		navegador.manage().window().maximize();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getUserName()));
		Cronos.getUserName().sendKeys(usuarioCronos);
		Cronos.getPassword().sendKeys(contrasena);
		Cronos.getBtnLogin().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		Cronos.getAgregarGrupal().click();
		
	}
	
	

	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Agregar suscripción grupal sin seleccionar Tipo de plan",priority = 1, enabled = true)
	public void cp051(){
		 JavascriptExecutor js = (JavascriptExecutor) navegador;
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,"Agregar suscripción grupal");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		
		Cronos.getRecurrencia().clear();
		Cronos.getDateInicio().clear();
		Cronos.getMonto().clear();
		Cronos.getInputReintentos().clear();

		Cronos.getReferencia().clear();
		Cronos.getInputReintentos().clear();
		
		
		Cronos.getRecurrencia().sendKeys("14");
		Cronos.getDateInicio().sendKeys("2024-05-30");
		Cronos.getMonto().sendKeys("500");
		Cronos.getInputReintentos().sendKeys("2");
		Cronos.getReferencia().sendKeys("pruebacronos"+randomNumbers.nextInt());
		Cronos.getInputDragandDrop().sendKeys("C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\SampleCSV_Cronos.csv");
		Cronos.getLabelReferencia().click();
		Cronos.getBtnIniciar().click();
		
		
		
		ewait.until(ExpectedConditions.attributeContains(Cronos.getDesplegableTipoDePlan(), "class", "is-invalid"));
		
		
		String classAttributeTipoPlan = Cronos.getDesplegableTipoDePlan().getAttribute("class");
	    Assert.assertTrue(classAttributeTipoPlan.contains("is-invalid"), "La clase no contiene 'is-invalid'");  
	    
	  
	}
	
	
	@Test(description="Agregar suscripción grupal con recurrencia igual a cero",priority = 2, enabled = true)
	public void cp052(){
		JavascriptExecutor js = (JavascriptExecutor) navegador;
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,"Agregar suscripción grupal");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		
		Select selectMes = new Select(Cronos.getDesplegableTipoDePlan());
	    selectMes.selectByValue("PLAN_ANNUAL");
		Cronos.getRecurrencia().clear();
		Cronos.getDateInicio().clear();
		Cronos.getMonto().clear();
		Cronos.getInputReintentos().clear();
		Cronos.getReferencia().clear();
	
		
		Cronos.getRecurrencia().sendKeys("0");
		Cronos.getDateInicio().sendKeys("2024-05-30");
		Cronos.getMonto().sendKeys("500");
		Cronos.getInputReintentos().sendKeys("2");
		Cronos.getReferencia().sendKeys("pruebacronos"+randomNumbers.nextInt());
		Cronos.getInputDragandDrop().sendKeys("C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\SampleCSV_Cronos.csv");
		Cronos.getLabelReferencia().click();
		Cronos.getBtnIniciar().click();
		ewait.until(ExpectedConditions.attributeContains(Cronos.getRecurrencia(), "class", "is-invalid"));
		
	
		
		String classAttributeTipoPlan = Cronos.getRecurrencia().getAttribute("class");
	    Assert.assertTrue(classAttributeTipoPlan.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    
		
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionAgregar()));
		String notificacion = Cronos.getNotificacionAgregar().getText();
	    Assert.assertEquals(notificacion, notiRecurrencia);
      
	}
	
	@Test(description="Agregar suscripción grupal  con recurrencia igual a mil",priority = 3, enabled = true)
	public void cp053(){
		
		
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,"Agregar suscripción grupal");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		
		Select selectMes = new Select(Cronos.getDesplegableTipoDePlan());
	    selectMes.selectByValue("PLAN_ANNUAL");
		Cronos.getRecurrencia().clear();
		Cronos.getDateInicio().clear();
		Cronos.getMonto().clear();
		Cronos.getInputReintentos().clear();
		Cronos.getReferencia().clear();
	
		
		Cronos.getRecurrencia().sendKeys("1000");
		Cronos.getDateInicio().sendKeys("2024-05-30");
		Cronos.getMonto().sendKeys("500");
		Cronos.getInputReintentos().sendKeys("2");
		Cronos.getReferencia().sendKeys("pruebacronos"+randomNumbers.nextInt());
		Cronos.getInputDragandDrop().sendKeys("C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\SampleCSV_Cronos.csv");
		Cronos.getLabelReferencia().click();
		Cronos.getBtnIniciar().click();
		ewait.until(ExpectedConditions.attributeContains(Cronos.getRecurrencia(), "class", "is-invalid"));
		
	
		
		String classAttributeTipoPlan = Cronos.getRecurrencia().getAttribute("class");
	    Assert.assertTrue(classAttributeTipoPlan.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    
		
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionAgregar()));
		String notificacion = Cronos.getNotificacionAgregar().getText();
	    Assert.assertEquals(notificacion, notiRecurrencia);
		
		
	}
	@Test(description="Agregar suscripción grupal dejando la referencia vacía",priority = 4, enabled = true)
	public void cp054(){
		
		navegador.navigate().refresh();
		
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,"Agregar suscripción grupal");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		
		Select selectMes = new Select(Cronos.getDesplegableTipoDePlan());
	    selectMes.selectByValue("PLAN_ANNUAL");
		Cronos.getRecurrencia().clear();
		Cronos.getDateInicio().clear();
		Cronos.getMonto().clear();
		Cronos.getInputReintentos().clear();
		
		
		Cronos.getRecurrencia().sendKeys("1");
		Cronos.getDateInicio().sendKeys("2024-05-30");
		Cronos.getMonto().sendKeys("500");
		Cronos.getInputReintentos().sendKeys("2");
		
		Cronos.getInputDragandDrop().sendKeys("C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\SampleCSV_Cronos.csv");
		
		
		Cronos.getLabelReferencia().click();
		Cronos.getBtnIniciar().click();
		
		
		ewait.until(ExpectedConditions.attributeContains(Cronos.getReferencia(), "class", "is-invalid"));
		
		
		String classAttributeTipoPlan = Cronos.getReferencia().getAttribute("class");
	    Assert.assertTrue(classAttributeTipoPlan.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    
	
		
		
		
		
		
		
		
	}
	@Test(description="Agregar suscripción grupal  con fecha de inicio de un día anterior",priority = 5, enabled = true)
	public void cp055(){
		LocalDate currentDate = LocalDate.now();
		LocalDate yesterdayDate = currentDate.minusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = yesterdayDate.format(formatter);
		
		navegador.navigate().refresh();
		
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,"Agregar suscripción grupal");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		
		Select selectMes = new Select(Cronos.getDesplegableTipoDePlan());
	    selectMes.selectByValue("PLAN_ANNUAL");
		Cronos.getRecurrencia().clear();
		Cronos.getDateInicio().clear();
		Cronos.getMonto().clear();
		Cronos.getInputReintentos().clear();
		
		
		Cronos.getRecurrencia().sendKeys("1");
		Cronos.getDateInicio().sendKeys(formattedDate);
		Cronos.getMonto().sendKeys("500");
		Cronos.getInputReintentos().sendKeys("2");
		
		Cronos.getInputDragandDrop().sendKeys("C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\SampleCSV_Cronos.csv");
		
		String classAttributeTipoPlan = Cronos.getCalendario().getAttribute("class");
	    Assert.assertTrue(classAttributeTipoPlan.contains("off"), "La clase no contiene 'off'");
	    
	    Cronos.getLabelReferencia().click();
		
		Cronos.getBtnIniciar().click();
		
	
		
	
		
		
		
	
		
		
	}
	@Test(description="Agregar suscripción grupal  sin subir un archivo",priority = 6, enabled = true)
	public void cp056(){
		
		
		navegador.navigate().refresh();
		
	
		
		
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,"Agregar suscripción grupal");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		
		Select selectMes = new Select(Cronos.getDesplegableTipoDePlan());
	    selectMes.selectByValue("PLAN_ANNUAL");
		Cronos.getRecurrencia().clear();
		Cronos.getDateInicio().clear();
		Cronos.getMonto().clear();
		Cronos.getInputReintentos().clear();
		Cronos.getReferencia().clear();
	
		
		Cronos.getRecurrencia().sendKeys("1");
		Cronos.getDateInicio().sendKeys("2024-05-30");
		Cronos.getMonto().sendKeys("500");
		Cronos.getInputReintentos().sendKeys("2");
		Cronos.getReferencia().sendKeys("pruebacronos"+randomNumbers.nextInt());
		//Cronos.getInputDragandDrop().sendKeys("C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\SampleCSV_Cronos.csv");
		Cronos.getLabelReferencia().click();
		Cronos.getBtnIniciar().click();
		
		
	
		
	
	    
		//String borderColor = (String) js.executeScript("return window.getComputedStyle(arguments[0]).borderColor;",Cronos.getRecurrencia());
		//Assert.assertEquals(borderColor,expectedColor);
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionAgregar()));
		String notificacion = Cronos.getNotificacionAgregar().getText();
	    Assert.assertEquals(notificacion, notiArchivo);
		
	
		
	}
	@Test(description="Descargar el formato csv",priority = 7, enabled = true)
	public void cp057(){
		navegador.navigate().refresh();
		
	       
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getLinkDescargarFormato()));
		clearDirectory(pathDirectory);
		Cronos.getLinkDescargarFormato().click();
		
		
		 try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		
		
		 
	    File downloadedFile = new File(fileDownloaded);
	    Assert.assertTrue(downloadedFile.exists(), "¡Error! La descarga ha fallado o el archivo no se ha encontrado.");

		 
		
		
		
		
		
		
		
	}
	@Test(description="Agregar suscripción grupal  subiendo un archivo de formato inválido",priority = 8, enabled = true)
	public void cp058(){
		navegador.navigate().refresh();
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,"Agregar suscripción grupal");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		
		Select selectMes = new Select(Cronos.getDesplegableTipoDePlan());
	    selectMes.selectByValue("PLAN_ANNUAL");
		Cronos.getRecurrencia().clear();
		Cronos.getDateInicio().clear();
		Cronos.getMonto().clear();
		Cronos.getInputReintentos().clear();
		Cronos.getReferencia().clear();
	
		
		Cronos.getRecurrencia().sendKeys("1");
		Cronos.getDateInicio().sendKeys("2024-05-30");
		Cronos.getMonto().sendKeys("500");
		//Cronos.getInputReintentos().sendKeys("2");
		Cronos.getReferencia().sendKeys("pruebacronos"+randomNumbers.nextInt());
		Cronos.getInputDragandDrop().sendKeys("C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\Sudadera.jpg");
		Cronos.getLabelReferencia().click();
		Cronos.getBtnIniciar().click();
		
		
	
		
	
	    
		//String borderColor = (String) js.executeScript("return window.getComputedStyle(arguments[0]).borderColor;",Cronos.getRecurrencia());
		//Assert.assertEquals(borderColor,expectedColor);
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionAgregar()));
		String notificacion = Cronos.getNotificacionAgregar().getText();
	    Assert.assertEquals(notificacion, notiExtension);
		
	}
	@Test(description="Agregar suscripción grupal  subiendo un archivo csv vacío",priority = 9, enabled = true)
	public void cp059(){
		navegador.navigate().refresh();
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,"Agregar suscripción grupal");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		
		Select selectMes = new Select(Cronos.getDesplegableTipoDePlan());
	    selectMes.selectByValue("PLAN_ANNUAL");
		Cronos.getRecurrencia().clear();
		Cronos.getDateInicio().clear();
		Cronos.getMonto().clear();
		Cronos.getInputReintentos().clear();
		Cronos.getReferencia().clear();
	
		
		Cronos.getRecurrencia().sendKeys("1");
		Cronos.getDateInicio().sendKeys("2024-05-30");
		Cronos.getMonto().sendKeys("500");
		//Cronos.getInputReintentos().sendKeys("2");
		Cronos.getReferencia().sendKeys("pruebacronos"+randomNumbers.nextInt());
		Cronos.getInputDragandDrop().sendKeys("C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\Sample_empty.csv");
		Cronos.getLabelReferencia().click();
		Cronos.getBtnIniciar().click();
		

	
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionAgregar()));
		String notificacion = Cronos.getNotificacionAgregar().getText();
	    Assert.assertEquals(notificacion, notiVacio);
		
		
	}
	@Test(description="Agregar suscripción grupal correctamente",priority = 10, enabled = true)
	public void cp060(){
		
		navegador.navigate().refresh();
		String titulo=Cronos.getTitleGrupal().getText();
		Assert.assertEquals(titulo,"Agregar suscripción grupal");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		
		Select selectMes = new Select(Cronos.getDesplegableTipoDePlan());
	    selectMes.selectByValue("PLAN_ANNUAL");
		Cronos.getRecurrencia().clear();
		Cronos.getDateInicio().clear();
		Cronos.getMonto().clear();
		Cronos.getInputReintentos().clear();
		Cronos.getReferencia().clear();
	
		
		Cronos.getRecurrencia().sendKeys("1");
		Cronos.getDateInicio().sendKeys("2024-05-30");
		Cronos.getMonto().sendKeys("500");
		//Cronos.getInputReintentos().sendKeys("2");
		Cronos.getReferencia().sendKeys("pruebacronos"+randomNumbers.nextInt());
		Cronos.getInputDragandDrop().sendKeys("C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\Sample.csv");
		Cronos.getLabelReferencia().click();
		Cronos.getBtnIniciar().click();
		
		
	
		
	
	    
		//String borderColor = (String) js.executeScript("return window.getComputedStyle(arguments[0]).borderColor;",Cronos.getRecurrencia());
		//Assert.assertEquals(borderColor,expectedColor);
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionAgregar()));
		String notificacion = Cronos.getNotificacionAgregar().getText();
	    Assert.assertEquals(notificacion, notiCorrecto);
	}
	
	@Test(description="Consultar suscripciones Grupales mediante un filtro por referencia válida",priority = 11, enabled = true)
	public void cp062(){
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String referenciaValida=Cronos.getReferencia1().getText();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroReferencia().sendKeys(referenciaValida);
		
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String tabla=Cronos.getReferencia1().getText();
		Assert.assertEquals(tabla,referenciaValida);
		
		
	}
	@Test(description="Consultar suscripciones Grupales mediante un filtro por referencia inválida",priority = 12, enabled = true)
	public void cp063(){
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
	
		String referenciaValida="invalidainvalida1234567890";
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroReferencia().sendKeys(referenciaValida);
		
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getNotiConsultarGrupal()));
		String notificacion=Cronos.getNotiConsultarGrupal().getText();
		Assert.assertEquals(notificacion, notiFiltroSinResultados);
		
		
	}
	@Test(description="Consultar suscripciones Grupales mediante un filtro por monto válido",priority = 13, enabled = true)
	public void cp064(){
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String referenciaValida=Cronos.getReferencia1().getText();
		String montoValido="1500";
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroMonto().sendKeys(montoValido);
		
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String tabla=Cronos.getReferencia1().getText();
		Assert.assertEquals(tabla,referenciaValida);
		
		
		
		
		
		
	}
	@Test(description="Consultar suscripciones Grupales mediante un filtro por monto inválido",priority = 14, enabled = true)
	public void cp065(){
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
	
		String montoInValido="0";
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroMonto().sendKeys(montoInValido);
		
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getNotiConsultarGrupal()));
		String notificacion=Cronos.getNotiConsultarGrupal().getText();
		Assert.assertEquals(notificacion, notiFiltroSinResultados);
		
		
	}
	
	
	
	@Test(description="Consultar suscripciones Grupales mediante un filtro con Fecha fin inválida y fecha de inicio válida",priority = 17, enabled = true)
	public void cp068(){
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
	
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroFechaInicio().sendKeys("2024-05-31");
		Cronos.getFiltroFechaFin().sendKeys("2010-06-10");
		
		Cronos.getFiltroMonto().click();
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getNotiConsultarGrupal()));
		String notificacion=Cronos.getNotiConsultarGrupal().getText();
		Assert.assertEquals(notificacion, notiFiltroSinResultados);
		
		
		
		
		
		
		
		
		
	}
	
	@Test(description="Consultar suscripciones Grupales mediante un filtro con Fecha fin inválida y fecha de inicio inválida",priority = 18, enabled = true)
	public void cp069(){
		
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();

		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroFechaInicio().sendKeys("2010-05-31");
		Cronos.getFiltroFechaFin().sendKeys("2010-06-10");
		
		Cronos.getFiltroMonto().click();
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getNotiConsultarGrupal()));
		String notificacion=Cronos.getNotiConsultarGrupal().getText();
		Assert.assertEquals(notificacion, notiFiltroSinResultados);
		
		
	}
	
	@Test(description="Consultar suscripciones Grupales mediante un filtro con fecha inicio válida ",priority = 19, enabled = true)
	public void cp070(){
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
	
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String referenciaValida=Cronos.getReferencia1().getText();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroFechaInicio().sendKeys("2024-05-31");
		Cronos.getFiltroMonto().click();
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String tabla=Cronos.getReferencia1().getText();
		//Assert.assertEquals(tabla,referenciaValida);
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
	}
	
	@Test(description="Consultar suscripciones Grupales mediante un filtro por Fecha de registro válida",priority = 20, enabled = true)
	public void cp071(){
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String referenciaValida=Cronos.getReferencia1().getText();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroFechaRegistro().sendKeys("2024-05-31");
		Cronos.getFiltroMonto().click();
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String tabla=Cronos.getReferencia1().getText();
		//Assert.assertEquals(tabla,referenciaValida);
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
	}


	@Test(description="Consultar suscripciones grupales borrando en filtro",priority = 22, enabled = true)
	public void cp073(){
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String referenciaValida=Cronos.getReferencia1().getText();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getBtnBorrarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		String tabla=Cronos.getReferencia1().getText();
		//Assert.assertEquals(tabla,referenciaValida);
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
		
	}
	@Test(description="Consultar suscripciones grupales cambiando la cantidad de resultados a mostrar",priority = 23, enabled = true)
	public void cp074(){
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Select selectMes = new Select(Cronos.getDesplegableMostrar());
	    selectMes.selectByValue("25");
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia25()));
		
		Assert.assertNotNull(Cronos.getReferencia25(), "No se muestran adecuadamente las 25 referencias");
		
	}
	@Test(description="Descargar el archivo csv de suscripciones",priority = 24, enabled = true)
	public void cp075(){
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getGrupalsideBar()));
		Cronos.getGrupalsideBar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarGrupal()));
		Cronos.getConsultarGrupal().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		clearDirectory(pathDirectory);
		Cronos.getBtnDescargar().click();
		
		
		
		
		 try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		
		
		 
		 File downloadDir = new File(pathDirectory);
	     Assert.assertTrue(isDirectoryNotEmpty(downloadDir), "¡Error! La descarga ha fallado o el archivo no se ha encontrado.");
	     clearDirectory(pathDirectory);
		
		
	}
	
	/*
	@Test(description="Visualizar suscripción grupal Cancelada",priority = 25, enabled = false)
	public void cp076(){
		
	}
	@Test(description="Visualizar suscripción grupal  Activa",priority = 26, enabled = false)
	public void cp077(){
		
	}
	
	@Test(description="Visualizar pantalla de suscripción Grupal Finalizada",priority = 27, enabled = false)
	public void cp078(){
		
	}
	@Test(description="Visualizar etiqueta de suscripción Grupal Finalizada",priority = 28, enabled = false)
	public void cp079(){
		
	}
	
	@Test(description="Visualizar pantalla de suscripción Grupal Cancelada",priority = 29, enabled = false)
	public void cp080(){
		
	}
	@Test(description="Visualizar Pantalla de suscripción Grupal Cancelada",priority = 30, enabled = false)
	public void cp081(){
		
	}
	@Test(description="Visualizar Pantalla de suscripción Grupal Activa",priority = 31, enabled = false)
	public void cp082(){
		
	}
	@Test(description="Visualizar etiqueta de suscripción Grupal Activa",priority = 32, enabled = false)
	public void cp083(){
		
	}
	@Test(description="Anular la cancelación de suscripción grupal Activa",priority = 33, enabled = false)
	public void cp084(){
		
	}
	@Test(description="Cancelar suscripción grupal Activa",priority = 34, enabled = false)
	public void cp085(){
		
	}
	@Test(description="Renovar suscripción grupal  Activa",priority = 35, enabled = false)
	public void cp086(){
		
	}
	*/
	
	
	
	
	
	
	
	private boolean isDirectoryNotEmpty(File directory) {
	        return directory.isDirectory() && directory.list().length > 0;
	    }
	
	public static void clearDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
        
            File[] files = directory.listFiles();

      
            for (File file : files) {
             
                if (file.isDirectory()) {
               
                    clearDirectory(file.getAbsolutePath());
                } else {
                
                    file.delete();
                }
            }
        }
    }
	
	
	
	
	
	
}
