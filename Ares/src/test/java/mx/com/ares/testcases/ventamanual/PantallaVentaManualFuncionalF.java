package mx.com.ares.testcases.ventamanual;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import mx.com.ares.base.Base;
import org.openqa.selenium.JavascriptExecutor;


public class PantallaVentaManualFuncionalF extends Base {
	
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
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("aSales")));
		VentaManual.ventaManual().click();
	
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Venta manual, tarjeta VISA")
	public void ventaExitosaVISA() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		Assert.assertEquals(VentaManual.checkMSI().getAttribute("disabled"), "true");
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaVisa);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta manual, tarjeta Master Card")
	public void ventaExitosaMC() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		Assert.assertEquals(VentaManual.checkMSI().getAttribute("disabled"), "true");
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaMC);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta manual, tarjeta Valeras")
	public void ventaExitosaValeras() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		Assert.assertEquals(VentaManual.checkMSI().getAttribute("disabled"), "true");
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaValeras);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta manual, tarjeta Amex")
	public void ventaExitosaAmex() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		Assert.assertEquals(VentaManual.checkMSI().getAttribute("disabled"), "true");
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaAMEX);
		VentaManual.cvv().sendKeys("1234");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta manual, con monto sin seleccionar afiliación")
	public void ventasinAfiliacion() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeError = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeError.contains("Seleccionar afiliación")));
		
	}
	
	@Test(description="Venta manual con campos Datos de pago vacíos")
	public void ventaDatosPagoVacios() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));

		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeError = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeError.contains("Escriba el nombre del tarjetahabiente tal como aparece en la tarjeta")));
		
	}
	
	@Test(description="Venta manual con campo \"Número de tarjeta\" vacío")
	public void ventaTarjetaVacia() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.cvv().sendKeys("1234");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("Ingresa el número de la tarjeta")));
		
	}
	
	@Test(description="Venta manual con campo \"cvv\" vacío")
	public void ventaCvvVacio() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaAMEX);
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("Ingrese el código de seguridad")));
		
	}
	
	@Test(description="Venta manual con campo número de tarjeta menor a 16 digitos")
	public void ventaTarjetaErronea() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys("528843913113");
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("El número de la tarjeta es incorrecto")));
		
	}
	
	@Test(description="Venta manual con campo con número cvv a dos digitos")
	public void ventaCvvErronea() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaMC);
		VentaManual.cvv().sendKeys("12");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("El código de seguridad tiene un valor incorrecto")));
		
	}
	
	@Test(description="Venta manual sin seleccionar mes")
	public void ventaSinMes() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaMC);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("Seleccione un mes")));
		
	}
	
	@Test(enabled = false,description="Venta manual sin seleccionar año")
	public void ventaSinAnio() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaMC);
		VentaManual.cvv().sendKeys("12");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("Seleccione un año")));
		
	}
	
	@Test(description="Venta manual 3 MSI, tarjeta VISA")
	public void ventaExitosaVISA3MSI() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("300");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.checkMSI().click();
		WebDriverWait ewaitt = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewaitt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("opc2")));
		Assert.assertEquals(VentaManual.opc2().getAttribute("disabled"), "true");
		Assert.assertEquals(VentaManual.opc3().getAttribute("disabled"), "true");
		Assert.assertEquals(VentaManual.opc4().getAttribute("disabled"), "true");
		VentaManual.opc1().click();
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaVisa);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta manual 6 MSI, tarjeta MC")
	public void ventaExitosaMC6MSI() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("600");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.checkMSI().click();
		WebDriverWait ewaitt = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewaitt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("opc3")));
		Assert.assertEquals(VentaManual.opc3().getAttribute("disabled"), "true");
		Assert.assertEquals(VentaManual.opc4().getAttribute("disabled"), "true");
		VentaManual.opc2().click();
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaMC);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta manual 9 MSI, tarjeta VISA")
	public void ventaExitosaVISA9MSI() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("900");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.checkMSI().click();
		WebDriverWait ewaitt = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewaitt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("opc4")));
		Assert.assertEquals(VentaManual.opc4().getAttribute("disabled"), "true");
		VentaManual.opc3().click();
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaVisa);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta manual 12 MSI, tarjeta MC")
	public void ventaExitosaMC12MSI() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("1200");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.checkMSI().click();
		WebDriverWait ewaitt = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewaitt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("opc4")));
		VentaManual.opc4().click();
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaVisa);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}
	
	@Test(description="Venta manual con letras en campo Número de tarjeta")
	public void ventaTarjetaLetras() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys("abcd");
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("El número de la tarjeta es incorrecto")));
		
	}
	
	@Test(description="Venta manual con letras en cvv")
	public void ventaCvvLetras() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaMC);
		VentaManual.cvv().sendKeys("abc");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("El código de seguridad tiene un valor incorrecto")));
		
	}
	
	@Test(description="Venta manual con números en campo Nombre")
	public void ventaNombreNumeros() {
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.monto().sendKeys("100");
		VentaManual.btnAceptar().click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		VentaManual.tarjetahabiente().sendKeys("123");
		VentaManual.tarjeta().sendKeys(tarjetaMC);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("El Nombre tiene caracteres no permitidos")));
		
	}
	
	
	@Test(description="Venta manual, listado de producto")
	public void ventaExitosaProductos() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sltAfiliation")));
		VentaManual.afiliacion().click();
		VentaManual.affSelececion().click();
		VentaManual.listaProductos().click();
		VentaManual.txtQuantity().sendKeys("1");

		// Hacer visible el dropdown
		((JavascriptExecutor)navegador).executeScript("document.getElementById('cbxConcept').style.display='block';");

		Select desplegable = new Select(navegador.findElement(By.id("cbxConcept")));
		desplegable.selectByVisibleText("Falda ondulada curvy"); 

		navegador.findElement(By.id("btnAdd")).click();

	    {
	      WebElement element = navegador.findElement(By.id("btnAdd"));
	      Actions builder = new Actions(navegador);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = navegador.findElement(By.tagName("body"));
	      Actions builder = new Actions(navegador);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    navegador.findElement(By.cssSelector(".text-right:nth-child(4) > #a_collapseOne > .btn")).click();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtName")));
		Assert.assertEquals(VentaManual.checkMSI().getAttribute("disabled"), "true");
		VentaManual.tarjetahabiente().sendKeys(usuarioF);
		VentaManual.tarjeta().sendKeys(tarjetaVisa);
		VentaManual.cvv().sendKeys("123");
		VentaManual.expMonth().click();
		navegador.findElement(By.xpath("//*[@id=\"sltMonth\"]/option[7]")).click();
		VentaManual.expYear().click();
		navegador.findElement(By.xpath("//*[@id=\"sltYear\"]/option[9]")).click();
		VentaManual.btnPagar().click();
		WebDriverWait ewait3 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li[1]/div")));
		String mensajeExitoso = VentaManual.ventaExitosa().getText();
		Assert.assertTrue((mensajeExitoso.contains("La transacción ha sido aprobada")));
		
	}

}
