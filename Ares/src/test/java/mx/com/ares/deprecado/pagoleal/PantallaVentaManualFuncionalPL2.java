package mx.com.ares.deprecado.pagoleal;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mx.com.ares.base.Base;

public class PantallaVentaManualFuncionalPL2 extends Base {
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/Login?aplic=pago_leal");
		navegador.manage().window().maximize();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("MainContent_userLogin")));
		Login.UsuarioElement().clear();
		Login.ContrasenaElement().clear();
		Login.UsuarioElement().sendKeys(usuarioP);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		
	}
	
	@BeforeMethod
	public void limpiarCampos() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.elementToBeClickable(By.id("aSales")));
		VentaManual.ventaManual().click();
	
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Venta manual, tarjeta VISA")
	public void ventaExitosaVISA() throws InterruptedException {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		navegador.findElement(By.xpath("/html/body/ul/li[1]/div/button")).click();
		VentaManual.montoFijo().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtMTotal")));
		VentaManual.monto().sendKeys("100");
		WebDriverWait ewait11 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait11.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtCardNumber")));
		VentaManual.tarjeta().sendKeys(tarjetaVisa);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.tarjetahabiente().sendKeys("Berenice");
		VentaManual.btnPagar().click();
		Thread.sleep(5000);
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		navegador.findElement(By.xpath("/html/body/ul/li[1]/div/button")).click();
		
	}
	
	@Test(description="Venta manual, tarjeta Master Card")
	public void ventaExitosaMC() throws InterruptedException {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		navegador.findElement(By.xpath("/html/body/ul/li[1]/div/button")).click();
		VentaManual.montoFijo().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtMTotal")));
		VentaManual.monto().sendKeys("100");
		WebDriverWait ewait11 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait11.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtCardNumber")));
		VentaManual.tarjeta().sendKeys(tarjetaMC);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.tarjetahabiente().sendKeys("Berenice");
		VentaManual.btnPagar().click();
		Thread.sleep(5000);
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		navegador.findElement(By.xpath("/html/body/ul/li[1]/div/button")).click();
		
	}
	
	@Test(description="Venta manual, tarjeta Valeras")
	public void ventaExitosaValeras() throws InterruptedException {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		navegador.findElement(By.xpath("/html/body/ul/li[1]/div/button")).click();
		VentaManual.montoFijo().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtMTotal")));
		VentaManual.monto().sendKeys("100");
		WebDriverWait ewait11 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait11.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtCardNumber")));
		VentaManual.tarjeta().sendKeys(tarjetaValeras);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.tarjetahabiente().sendKeys("Berenice");
		VentaManual.btnPagar().click();
		Thread.sleep(5000);
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		navegador.findElement(By.xpath("/html/body/ul/li[1]/div/button")).click();
		
	}
	
	@Test(description="Venta manual, tarjeta Amex")
	public void ventaExitosaAmex() throws InterruptedException {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		navegador.findElement(By.xpath("/html/body/ul/li[1]/div/button")).click();
		VentaManual.montoFijo().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtMTotal")));
		VentaManual.monto().sendKeys("100");
		WebDriverWait ewait11 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait11.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtCardNumber")));
		VentaManual.tarjeta().sendKeys(tarjetaAMEX);
		VentaManual.cvv().sendKeys("1234");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.tarjetahabiente().sendKeys("Berenice");
		VentaManual.btnPagar().click();
		Thread.sleep(5000);
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		navegador.findElement(By.xpath("/html/body/ul/li[1]/div/button")).click();
		
	}

	
}
