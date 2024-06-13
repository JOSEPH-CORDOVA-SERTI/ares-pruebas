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


public class PantallaDashboardFuncionalCr extends Base {
	String ExpectedURL="https://www.highcharts.com/?credits";
	String ExpectedURLFeenicia="https://www.feenicia.com/";
	
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
		Cronos.getDateInicio().clear();
		Cronos.getDatefin().clear();
		Cronos.getDateInicio().sendKeys("2024-05-01");
		Cronos.getDatefin().sendKeys("2024-05-31");
		Cronos.getBtnBuscar().click();
	}
	

	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	@Test(description="Ingresar link Highcharts.com del footer del gráfico circular",enabled=false)
	public void cp88(){
		
	
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getGrafica1()));
	
		String texto=Cronos.getGrafica1link().getText();
		
	
		String UrlActual=navegador.getCurrentUrl();
		
		ewait.until(ExpectedConditions.urlToBe(ExpectedURL));

		Assert.assertEquals(texto,"Highcharts.com");
		
		
		
	}
	
	@Test(description="Ingresar link Highcharts.com del footer del gráfico lineal",enabled=false)
	public void cp89(){
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getGrafica2()));
		
		Cronos.getGrafica2link().click();
		String UrlActual=navegador.getCurrentUrl();
		
		ewait.until(ExpectedConditions.urlToBe(ExpectedURL));

		Assert.assertEquals(UrlActual,ExpectedURL);
	}
	
	
	@Test(description="Ingresar al link Feenicia.com del footer de la página")
	public void cp90(){
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getLinkFeenicia()));
		
		Cronos.getLinkFeenicia().click();
		String UrlActual=navegador.getCurrentUrl();
		
		ewait.until(ExpectedConditions.urlToBe(ExpectedURLFeenicia));

		Assert.assertEquals(UrlActual,ExpectedURLFeenicia);
		
	}
	/*
	@Test(description="Ocultar número de transacciones rechazados en la gráfica lineal",enabled=false)
	public void cp91(){
		
	}
	@Test(description="Ocultar número de transacciones aprobados en la gráfica lineal",enabled=false)
	public void cp92(){
		
	}
	@Test(description="Ocultar información en gráfica circular",enabled=false)
	public void cp93(){
		
	}
	
	*/
	
}
