package mx.com.ares.testcases.ventadispositivo;


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


public class PantallaVentaDispositivoFuncionalF extends Base {
	
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");
		navegador.manage().window().maximize();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("MainContent_userLogin")));
		Login.UsuarioElement().clear();
		Login.ContrasenaElement().clear();
		Login.UsuarioElement().sendKeys(usuarioF);
		Login.ContrasenaElement().sendKeys(contrasena);
		Login.IngresarElement().click();
		
	}
	
	@BeforeMethod
	public void limpiarCampos() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("dropdownMenu1")));
		navegador.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).click();
		navegador.findElement(By.id("aDeviceSale")).click();
	
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Venta Dispositivo, tarjeta VISA")
	public void ventaDisVISA() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnPayInLine")));
		VentaDispositivo.PagarenLinea().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaDispositivo.tarjetahabiente().sendKeys(usuarioF);
		VentaDispositivo.tarjeta().sendKeys(tarjetaVisa);
		VentaDispositivo.cvv().sendKeys("123");
		VentaDispositivo.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaDispositivo.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaDispositivo.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta Dispositivo, tarjeta MC")
	public void ventaDisMC() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnPayInLine")));
		VentaDispositivo.PagarenLinea().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaDispositivo.tarjetahabiente().sendKeys(usuarioF);
		VentaDispositivo.tarjeta().sendKeys(tarjetaMC);
		VentaDispositivo.cvv().sendKeys("123");
		VentaDispositivo.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaDispositivo.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaDispositivo.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta Dispositivo, tarjeta Valeras")
	public void ventaDisValeras() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnPayInLine")));
		VentaDispositivo.PagarenLinea().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaDispositivo.tarjetahabiente().sendKeys(usuarioF);
		VentaDispositivo.tarjeta().sendKeys(tarjetaValeras);
		VentaDispositivo.cvv().sendKeys("123");
		VentaDispositivo.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaDispositivo.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaDispositivo.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta Dispositivo, tarjeta AMEX")
	public void ventaDisAmex() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnPayInLine")));
		VentaDispositivo.PagarenLinea().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaDispositivo.tarjetahabiente().sendKeys(usuarioF);
		VentaDispositivo.tarjeta().sendKeys(tarjetaAMEX);
		VentaDispositivo.cvv().sendKeys("123");
		VentaDispositivo.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaDispositivo.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaDispositivo.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta Dispositivo2, tarjeta VISA")
	public void ventaDisVISA2() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnPayInLine")));
		VentaDispositivo.iNumBlue().sendKeys("2");
		VentaDispositivo.Agregar().click();
		VentaDispositivo.PagarenLinea().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaDispositivo.tarjetahabiente().sendKeys(usuarioF);
		VentaDispositivo.tarjeta().sendKeys(tarjetaVisa);
		VentaDispositivo.cvv().sendKeys("123");
		VentaDispositivo.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaDispositivo.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaDispositivo.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}


}
