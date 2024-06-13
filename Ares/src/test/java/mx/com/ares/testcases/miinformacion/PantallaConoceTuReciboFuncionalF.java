package mx.com.ares.testcases.miinformacion;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mx.com.ares.base.Base;

public class PantallaConoceTuReciboFuncionalF extends Base{
	String exitoso = "Se guardo correctamente";
	String formatoIncorrecto = "Los archivos con esta extensión no son permitidos";
	String nombreVacio = "Ingresa el nombre de tu comercio";
	String subidaExitosa = "!Se ha cargado el documento exitosamente!";
	String nombreComercio = "Jardinería";


	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Moral5");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"conditions-data\"]/h4")));
		WebElement botonReciboNuevo = navegador.findElement(By.xpath("//*[@id=\"btnReceipt\"]"));
		botonReciboNuevo.click();
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	@Test(description="Llenado exitoso de los datos en la sección conoce tu nuevo Recibo", enabled = true, priority = 3)
	public void ConoceTuReciboExitoso() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divRecibo\"]/h4")));	
		WebElement uploadButton = navegador.findElement(By.xpath("//*[@id=\"divRecibo\"]/div[1]/span[1]"));
		MiInformacion.nombreComercioElement().sendKeys(nombreComercio);	
        uploadButton.click();
        Thread.sleep(2000);
        Robot robot = new Robot();

        StringSelection stringSelection = new StringSelection("C:\\Proyectos\\Ares\\src\\test\\resources\\archivos para Pruebas\\wallpaper-1.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(2000);
        MiInformacion.botonGuardarImagenElement().click();
        Thread.sleep(2000);
        MiInformacion.botonGuardarReciboElement().click();
        
        ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.messenger-message-inner")));
        WebElement mensajeDiv1 = navegador.findElement(By.cssSelector("div.messenger-message-inner"));
        String textoMensaje1 = mensajeDiv1.getText();
		AssertJUnit.assertEquals(textoMensaje1, exitoso);
		
		Thread.sleep(2000);
		WebElement mensajeDiv = navegador.findElement(By.cssSelector("div.messenger-message-inner"));
        String textoMensaje = mensajeDiv.getText();
		AssertJUnit.assertEquals(textoMensaje, subidaExitosa);
	}
	
	@Test(description="Subir un archivo no permitido en imagen de portada o de perfil en la sección Conoce tu nuevo recibo", enabled = true, priority = 2)
	public void subirArchivoNoPermitido() throws Exception {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"conditions-data\"]/h4")));
		WebElement botonReciboNuevo = navegador.findElement(By.xpath("//*[@id=\"btnReceipt\"]"));
		botonReciboNuevo.click();
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divRecibo\"]/div[1]/span[1]")));
        WebElement uploadButton = navegador.findElement(By.xpath("//*[@id=\"divRecibo\"]/div[1]/span[1]"));
        uploadButton.click();
        Thread.sleep(2000);
        Robot robot = new Robot();

        StringSelection stringSelection = new StringSelection("C:\\Proyectos\\Ares\\src\\test\\resources\\archivos para Pruebas\\prueba1.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(2000);
        WebElement mensajeDiv = navegador.findElement(By.cssSelector("div.messenger-message-inner"));
        String textoMensaje = mensajeDiv.getText();
		AssertJUnit.assertEquals(textoMensaje, formatoIncorrecto);


	}
	@Test(description="Dejar el campo de nombre vacío en la sección Conoce tu nuevo recibo", enabled = true, priority = 1)
	public void NombreReciboVacio() throws Exception {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divRecibo\"]/h4")));
		MiInformacion.nombreComercioElement().clear();
		MiInformacion.botonGuardarReciboElement().click();
		WebElement mensajeDiv = navegador.findElement(By.cssSelector("div.messenger-message-inner"));
        String textoMensaje = mensajeDiv.getText();
		AssertJUnit.assertEquals(textoMensaje, nombreVacio);
	}
	
	@Test(description="Redireccionamientos correctos dentro del apartado legales en el footer de la página", enabled = true, priority = 4)
	public void linksFooter() throws Exception {
        String ventanaActual = navegador.getWindowHandle();
        WebElement avisoPrivacidadLink = navegador.findElement(By.linkText("Aviso de Privacidad"));
        avisoPrivacidadLink.click();
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        auxiliarEnlaces(ventanaActual, "https://www.feenicia.com/aviso-de-privacidad/");
        WebElement terminosCondLink = navegador.findElement(By.linkText("Términos y condiciones"));
        terminosCondLink.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        auxiliarEnlaces(ventanaActual, "https://www.feenicia.com/terminos-y-condiciones/");
        WebElement iosLink = navegador.findElement(By.xpath("//*[@id=\"text-2\"]/div/a[1]/img"));
        iosLink.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        auxiliarEnlaces(ventanaActual, "https://apps.apple.com/us/app/feenicia/id1146655842?l=es&ls=1");
        WebElement androidLink = navegador.findElement(By.xpath("//*[@id=\"text-2\"]/div/a[2]/img"));
        androidLink.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        auxiliarEnlaces(ventanaActual, "https://play.google.com/store/apps/details?id=com.serti.Android.Feenicia&hl=es");

	}
	
	private void auxiliarEnlaces(String ventanaActual, String url) {
		 // Obtener las ventanas disponibles
        Set<String> ventanas = navegador.getWindowHandles();
        // Iterar sobre las ventanas para encontrar la nueva
        String nuevaVentana = "";
        for (String ventana : ventanas) {
            if (!ventana.equals(ventanaActual)) {
                nuevaVentana = ventana;
                navegador.switchTo().window(nuevaVentana);
                break;
            }
        }
        String urlActual = navegador.getCurrentUrl();
        Assert.assertEquals(urlActual, url);

        // Cerrar la nueva ventana y volver a la original
        navegador.close();
        navegador.switchTo().window(ventanaActual);

        // Regresar al manejo de la ventana original
        navegador.switchTo().window(ventanaActual);
	}
	
}


