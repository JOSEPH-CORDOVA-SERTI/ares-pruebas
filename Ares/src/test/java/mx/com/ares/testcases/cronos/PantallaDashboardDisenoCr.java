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


public class PantallaDashboardDisenoCr extends Base{

	
	
	String coloresperado="rgb(73, 80, 87)";
	
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://feenicia.net/cronos-web/login");
		navegador.manage().window().maximize();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getUserName()));
		Cronos.getUserName().sendKeys(usuarioCronos);
		Cronos.getPassword().sendKeys(contrasena);
		Cronos.getBtnLogin().click();
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getGrafica1()));
		Cronos.getDateInicio().sendKeys("2024-05-01");
		Cronos.getDatefin().sendKeys("2024-05-31");
		Cronos.getBtnBuscar().click();
	}
	

	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="navBar")
	public void navBar(){
		
		JavascriptExecutor js = (JavascriptExecutor) navegador;
		
		Assert.assertNotNull(Cronos.getNavBarDashBoard(), "El elemento navbar no existe.");
		Assert.assertNotNull(Cronos.getMenuHamburguesa(), "El menu hamburguesa  no existe.");
		WebElement element = navegador.findElement(By.cssSelector("body > div.wrapper > div > nav"));

		String color = (String) js.executeScript("return window.getComputedStyle(arguments[0]).color;",element);
		Assert.assertEquals(color,coloresperado,"el color no es el correcto");
	     
		Assert.assertNotNull(Cronos.getDropdownNavBarDashBoard(), "El elemento dropdown no existe.");
		
	}
	@Test(description="sideBar")
	public void sideBar(){
		String Titulo = Cronos.getTitleMainSideBar().getText();
		Assert. assertTrue(Titulo.contains("feenicia"), "El texto no contiene 'feenicia'.");
		Assert. assertTrue(Titulo.contains("cronos"), "El texto no contiene 'cronos'.");
		
		String Comercio = Cronos.getTitleSideBar().getText();
		Assert.assertEquals(Comercio, "Comercio");
		
		String Dashboard = Cronos.getSidebarDashboard().getText();
		Assert.assertEquals(Dashboard, "Dashboard");
		
		String Suscripciones = Cronos.getTitle2Sidebar().getText();
		Assert.assertEquals(Suscripciones, "Suscripciones");
		
		String Individual = Cronos.getDesplegableIndividual().getText();
		Assert.assertEquals(Individual, "Individual");
		
		String Grupal = Cronos.getGrupalsideBar().getText();
		Assert.assertEquals(Grupal, "Grupal");
		
		
		
	}
	@Test(description="Dashboard")
	public void Dashboard() {
		
		String mensaje = Cronos.getTitleDashboard().getText();
		Assert.assertEquals(mensaje, "Dashboard");
		
		String label1=Cronos.getLabelInicio().getText();
		Assert.assertEquals(label1, "Inicio");
		
		Assert.assertNotNull(Cronos.getDateInicio(), "El elemento date no existe.");
		
		
		String label2=Cronos.getLabelFin().getText();
		Assert.assertEquals(label2, "Fin");
		Assert.assertNotNull(Cronos.getDatefin(), "El elemento date no existe.");
	
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.textToBePresentInElement(Cronos.getTitleAprobadas(), "Aprobadas"));
		
		String campo1=Cronos.getTitleTransacciones().getText();
	
		Assert.assertEquals(campo1,"Transacciones");
		Assert.assertNotNull(Cronos.getNumberTransacciones(), "El elemento transaccion no existe.");
	
	
	           
		
	       
	    String campo2=Cronos.getTitleAprobadas().getText();
	    Assert.assertEquals(campo2,"Aprobadas");
	    Assert.assertNotNull(Cronos.getNumberAprobadas(), "El elemento Aprobadas no existe.");
	      

	     
		
		
	
		
		String campo3=Cronos.getTitleRechazadas().getText();
		Assert.assertEquals(campo3, "Rechazadas");
		Assert.assertNotNull(Cronos.getNumberRechazadas(), "El elemento rechazadas no existe.");
	
		
		String campo4=Cronos.getTitlePromedio().getText();
		Assert.assertEquals(campo4, "Monto promedio");
		Assert.assertNotNull(Cronos.getNumberPromedio(), "El elemento Monto Promedio no existe.");
	
		String campo5=Cronos.getTitleAprobado().getText();
		Assert.assertEquals(campo5, "Total aprobado");
		Assert.assertNotNull(Cronos.getNumberAprobado(), "El elemento Total Aprobado no existe.");
	
		String campo6=Cronos.getTitleReintentos().getText();
		Assert.assertEquals(campo6, "Reintentos");
		Assert.assertNotNull(Cronos.getNumberReintentos(), "El elemento Reintentos no existe.");
	
		
		Assert.assertNotNull(Cronos.getGrafica1(), "El elemento grafica1 no existe.");
		
		Assert.assertNotNull(Cronos.getGrafica2(), "El elemento grafica2 no existe.");
		
	}
	
	
}
