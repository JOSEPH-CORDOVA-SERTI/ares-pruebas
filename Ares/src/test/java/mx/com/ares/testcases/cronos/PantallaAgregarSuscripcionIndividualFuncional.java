package mx.com.ares.testcases.cronos;


import java.io.File;
import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import mx.com.ares.base.Base;


public class PantallaAgregarSuscripcionIndividualFuncional extends Base {
	
	private Random randomNumbers = new Random();
	private String notiRecurrencia = "La recurrencia solo puede estar entre 1 y 999";
	private String notificacionExitosa = "Operacion exitosa.";
	private String titleSus = "Datos del plan";
	
	
     String notiArchivo = "Por favor, selecciona un archivo.";
     String notiExtension = "El encabezado del archivo enviado no es correcto, se espera: \"NOMBRE EN TARJETA, NUMERO DE TARJETA, MES, ANIO, CVV, EMAIL, REFERENCIA\" CODIGO: G002";
     String notiVacio = "El archivo enviado se encuentra vacio. CODIGO: G002";
     String notiCorrecto = "Procesando archivo, al finalizar recibiras un correo electronico con el estado del proceso.";
     
   
     
   String pathDirectory="C:\\programas\\Ares\\src\\test\\resources\\archivos para Pruebas\\Downloads";
    
     String notiFiltroSinResultados = "La solicitud enviada no obtuvo ningun resultado. CODIGO: G004";
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://feenicia.net/cronos-web/login");
		navegador.manage().window().maximize();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getUserName()));
		Cronos.getUserName().clear();
		Cronos.getPassword().clear();
		Cronos.getUserName().sendKeys(usuarioCronos);
		Cronos.getPassword().sendKeys(contrasena);
		Cronos.getBtnLogin().click();
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getAgregarIndividual()));
		Cronos.getAgregarIndividual().click();
		
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	//cp008
	@Test(description="Agregar suscripción Individual exitosamente", priority = 14 , enabled = true)
	public void suscripcionExitosa() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		Select selectPlan = new Select(Cronos.getDesplegableTipoDePlan());
        List<WebElement> opciones = selectPlan.getOptions();
        Random rand = new Random();
        int indexAleatorio = rand.nextInt(opciones.size());
        if (indexAleatorio == 0) {
            indexAleatorio = 1;
        }
        selectPlan.selectByIndex(indexAleatorio);
		Cronos.getReferencia().sendKeys("PruebaSelenium"+ randomNumbers.nextInt());
		Cronos.getNombreTarjeta().sendKeys(nombreTarjeta);
		Cronos.getNumeroTarjeta().sendKeys(tarjetaVisa);
        Select selectMes = new Select(Cronos.getMesExp());
        selectMes.selectByValue("09");
        Select selectAnio = new Select(Cronos.getAnioExp());
        selectAnio.selectByValue("25");
        Cronos.getCvvOpcional().sendKeys("1234");
        Cronos.getEmailOpcional().sendKeys(correoConfirmacionP);
		Cronos.getBtnIniciar().click();
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionAgregar()));
		String mensaje = Cronos.getNotificacionAgregar().getText();
		Assert.assertEquals(mensaje, notificacionExitosa);
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getTitleDatosSuscripcion()));
		String mensaje2 = Cronos.getTitleDatosSuscripcion().getText();
		Assert.assertEquals(mensaje2, titleSus);
	}
	
	
	//cp009
	@Test(description="Agregar suscripción Individual con los datos vacíos", priority = 13, enabled = true)
	public void suscripcionConCamposVacios() {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		Cronos.getBtnIniciar().click();
		ewait.until(ExpectedConditions.attributeContains(Cronos.getDesplegableTipoDePlan(), "class", "is-invalid"));
		String classAttributeTipoPlan = Cronos.getDesplegableTipoDePlan().getAttribute("class");
	    Assert.assertTrue(classAttributeTipoPlan.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    String classAttributeReferencia = Cronos.getReferencia().getAttribute("class");
	    Assert.assertTrue(classAttributeReferencia.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    String classAttributeNombreTarjeta = Cronos.getNombreTarjeta().getAttribute("class");
	    Assert.assertTrue(classAttributeNombreTarjeta.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    String classAttributeNumeroTarjeta = Cronos.getNumeroTarjeta().getAttribute("class");
	    Assert.assertTrue(classAttributeNumeroTarjeta.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    String classAttributeAnioExp = Cronos.getAnioExp().getAttribute("class");
	    Assert.assertTrue(classAttributeAnioExp.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    String classAttributeMesExp = Cronos.getMesExp().getAttribute("class");
	    Assert.assertTrue(classAttributeMesExp.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	//cp010
	@Test(description="Agregar suscripción Individual sin seleccionar Tipo de plan", priority = 1, enabled = true)
	public void suscripcionSinTipoPlan() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		Cronos.getReferencia().sendKeys("PruebaSelenium"+ randomNumbers.nextInt());
		Cronos.getNombreTarjeta().sendKeys(nombreTarjeta);
		Cronos.getNumeroTarjeta().sendKeys(tarjetaVisa);
        Select selectMes = new Select(Cronos.getMesExp());
        selectMes.selectByValue("05");
        Select selectAnio = new Select(Cronos.getAnioExp());
        selectAnio.selectByValue("28");
		Cronos.getBtnIniciar().click();
		ewait.until(ExpectedConditions.attributeContains(Cronos.getDesplegableTipoDePlan(), "class", "is-invalid"));
		String classAttributeTipoPlan = Cronos.getDesplegableTipoDePlan().getAttribute("class");
	    Assert.assertTrue(classAttributeTipoPlan.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	

		
	}
	
	//cp011
		@Test(description="Agregar suscripción Individual con recurrencia igual a cero", priority = 2, enabled = true)
		public void suscripcionConRecurrenciaCero() {
			WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
			ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
			Select selectPlan = new Select(Cronos.getDesplegableTipoDePlan());
	        List<WebElement> opciones = selectPlan.getOptions();
	        Random rand = new Random();
	        int indexAleatorio = rand.nextInt(opciones.size());
	        if (indexAleatorio == 0) {
	            indexAleatorio = 1;
	        }
	        selectPlan.selectByIndex(indexAleatorio);
	        Cronos.getRecurrencia().clear();
	        Cronos.getRecurrencia().sendKeys("0");
			Cronos.getBtnIniciar().click();
			ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionAgregar()));
			String classAttributeTipoPlan = Cronos.getNotificacionAgregar().getText();
		    Assert.assertEquals(classAttributeTipoPlan, notiRecurrencia);
		}

	//cp0012
	@Test(description="Agregar suscripción Individual con recurrencia igual a mil", priority = 3, enabled = true)
	public void suscripcionConRecurrenciaMil() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		Select selectPlan = new Select(Cronos.getDesplegableTipoDePlan());
        List<WebElement> opciones = selectPlan.getOptions();
        Random rand = new Random();
        int indexAleatorio = rand.nextInt(opciones.size());
        if (indexAleatorio == 0) {
            indexAleatorio = 1;
        }
        selectPlan.selectByIndex(indexAleatorio);
        Cronos.getRecurrencia().clear();
        Cronos.getRecurrencia().sendKeys("1000");
		Cronos.getBtnIniciar().click();
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getNotificacionAgregar()));
		String classAttributeTipoPlan = Cronos.getNotificacionAgregar().getText();
	    Assert.assertEquals(classAttributeTipoPlan, notiRecurrencia);
	}
	
	
	//cp013
		@Test(description="Agregar suscripción Individual con fecha de inicio de un día anterior", priority = 12, enabled = true)
		public void suscripcionConFechaInicioAnterior() {
			WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
			ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
	        LocalDate fechaActual = LocalDate.now();
	        WebElement campoFechaInicio = navegador.findElement(By.id("startDate"));
	        campoFechaInicio.click();
	        WebElement calendario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.table-condensed")));
	        validarDiasDeshabilitados(calendario, fechaActual);
		}
		
	
	//cp014
	@Test(description="Agregar suscripción Individual dejando el Monto vacío", priority = 4, enabled = true)
	public void suscripcionConMontoVacio() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		Cronos.getRecurrencia().clear();
        Cronos.getRecurrencia().sendKeys("10");
        Cronos.getMonto().clear();
		Cronos.getMonto().sendKeys("0");
		Cronos.getBtnIniciar().click();
	    ewait.until(ExpectedConditions.attributeContains(Cronos.getMonto(), "class", "is-invalid"));
	    String classAttributeMonto = Cronos.getMonto().getAttribute("class");
	    Assert.assertTrue(classAttributeMonto.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	
	//cp015
	@Test(description="Agregar suscripción Individual  dejando la referencia vacía", priority = 5, enabled = true)
	public void suscripcionConReferenciaVacia() {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		Select selectPlan = new Select(Cronos.getDesplegableTipoDePlan());
        List<WebElement> opciones = selectPlan.getOptions();
        Random rand = new Random();
        int indexAleatorio = rand.nextInt(opciones.size());
        if (indexAleatorio == 0) {
            indexAleatorio = 1;
        }
        selectPlan.selectByIndex(indexAleatorio);
        Cronos.getNombreTarjeta().sendKeys(nombreTarjeta);
		Cronos.getNumeroTarjeta().sendKeys(tarjetaVisa);
        Select selectMes = new Select(Cronos.getMesExp());
        selectMes.selectByValue("05");
        Select selectAnio = new Select(Cronos.getAnioExp());
        selectAnio.selectByValue("28");
		Cronos.getBtnIniciar().click();
	    ewait.until(ExpectedConditions.attributeContains(Cronos.getReferencia(), "class", "is-invalid"));
	    String classAttributeReferencia = Cronos.getReferencia().getAttribute("class");
	    Assert.assertTrue(classAttributeReferencia.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	
	//cp16
	@Test(description="Agregar suscripción Individual dejando el nombre vacío", priority = 6, enabled = true)
	public void suscripcionConNombreTarjetaVacio() {
		navegador.navigate().refresh();
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
		Select selectPlan = new Select(Cronos.getDesplegableTipoDePlan());
        List<WebElement> opciones = selectPlan.getOptions();
        Random rand = new Random();
        int indexAleatorio = rand.nextInt(opciones.size());
        if (indexAleatorio == 0) {
            indexAleatorio = 1;
        }
        selectPlan.selectByIndex(indexAleatorio);
		Cronos.getReferencia().sendKeys("PruebaSelenium"+ randomNumbers.nextInt());
		Cronos.getBtnIniciar().click();
	    ewait.until(ExpectedConditions.attributeContains(Cronos.getNombreTarjeta(), "class", "is-invalid"));
	    String classAttributeNombreTarjeta = Cronos.getNombreTarjeta().getAttribute("class");
	    Assert.assertTrue(classAttributeNombreTarjeta.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	
	//cp017
	@Test(description="Agregar suscripción Individual  dejando el número de tarjeta vacío", priority = 7, enabled = true)
	public void suscripcionConNumeroTarjetaVacio() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
        Cronos.getNombreTarjeta().sendKeys(nombreTarjeta);
		Cronos.getBtnIniciar().click();
	    ewait.until(ExpectedConditions.attributeContains(Cronos.getNumeroTarjeta(), "class", "is-invalid"));
	    String classAttributeNumeroTarjeta = Cronos.getNumeroTarjeta().getAttribute("class");
	    Assert.assertTrue(classAttributeNumeroTarjeta.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	
	//cp018
	@Test(description="Agregar suscripción Individual sin seleccionar mes y año de expiración", priority = 8, enabled = true)
	public void suscripcionSinFechaExp() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
        Cronos.getNumeroTarjeta().sendKeys(tarjetaVisa);
		Cronos.getBtnIniciar().click();
	    ewait.until(ExpectedConditions.attributeContains(Cronos.getAnioExp(), "class", "is-invalid"));
	    String classAttributeAnio = Cronos.getAnioExp().getAttribute("class");
	    Assert.assertTrue(classAttributeAnio.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    String classAttributeMes = Cronos.getMesExp().getAttribute("class");
	    Assert.assertTrue(classAttributeMes.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	//cp019
	@Test(description="Agregar suscripción Individual con CVV de 5 dígitos", priority = 10, enabled = true)
	public void suscripcionConCVV5Digitos() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
        Cronos.getNumeroTarjeta().sendKeys(tarjetaVisa);
	    String maxLengthAttributeValue = Cronos.getCvvOpcional().getAttribute("maxLength");
	    Assert.assertEquals(maxLengthAttributeValue, "4", "El atributo maxLength no es 4");
	    Cronos.getCvvOpcional().sendKeys("1234");
	    Assert.assertEquals(Cronos.getCvvOpcional().getAttribute("value").length(), 4, "La longitud del valor del campo CVV no es 4");
	    Cronos.getCvvOpcional().sendKeys("56789");
	    Assert.assertEquals(Cronos.getCvvOpcional().getAttribute("value").length(), 4, "Se ingresaron más de 4 dígitos en el campo CVV");
	}
	
	//cp020
	@Test(description="Agregar suscripción Individual con CVV de 1 dígito", priority = 9, enabled = true)
	public void suscripcionConCVV1Digito() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
        Cronos.getCvvOpcional().sendKeys("1");
		Cronos.getBtnIniciar().click();
		ewait.until(ExpectedConditions.attributeContains(Cronos.getCvvOpcional(), "class", "is-invalid"));
		String classAttributeCVV = Cronos.getCvvOpcional().getAttribute("class");
	    Assert.assertTrue(classAttributeCVV.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	}
	
	
	//cp021
	@Test(description="Agregar suscripción Individual  con correo electrónico inválido", priority = 11, enabled = true)
	public void suscripcionConCorreoInvalido() {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Cronos.getBtnIniciar()));
        Cronos.getEmailOpcional().sendKeys("userSanMayopmail.com");
		Cronos.getBtnIniciar().click();
		ewait.until(ExpectedConditions.attributeContains(Cronos.getEmailOpcional(), "class", "is-invalid"));
		String classAttributeCorreo = Cronos.getEmailOpcional().getAttribute("class");
	    Assert.assertTrue(classAttributeCorreo.contains("is-invalid"), "La clase no contiene 'is-invalid'");
	    
	}
	

	
	@Test(description="Consultar suscripciones Individuales mediante un filtro por referencia válida", priority = 23, enabled = true)
	public void cp23() {
		
		navegador.navigate().refresh();
		
		
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
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
	
	@Test(description="Consultar suscripciones Individuales mediante un filtro por referencia inválida", priority = 24, enabled = true)
	public void cp24() {
		
		navegador.navigate().refresh();
		
		
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroReferencia().sendKeys("invalida-asdffgh21234654");
		
		Cronos.getBtnAplicarFiltro().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getNotiConsultarGrupal()));
		String notificacion=Cronos.getNotiConsultarGrupal().getText();
		Assert.assertEquals(notificacion, notiFiltroSinResultados);
		
		
	}
	
	
	@Test(description="Consultar suscripciones Individuales mediante un filtro por monto válido", priority = 25, enabled = true)
	public void cp25() {
		navegador.navigate().refresh();
		
		
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
		
		
		String montoValido="100";
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroMonto().sendKeys(montoValido);
		
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		Assert.assertNotNull(Cronos.getReferencia1(),"no existen resultados del filtro");
		
		
		
		
	}
	
	
	@Test(description="Consultar suscripciones Individuales mediante un filtro por monto inválido", priority = 26, enabled = true)
	public void cp26() {
		
		navegador.navigate().refresh();
		
		
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
		
		
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
	
	@Test(description="Consultar suscripciones Individuales mediante un filtro por suscripción grupal válida", priority = 27, enabled = true)
	public void cp27() {
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
	
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroGrupal().sendKeys("76");
		
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
	
		Assert.assertNotNull(Cronos.getReferencia1(),"no existen resultados del filtro");
		
		
	}
	@Test(description="Consultar suscripciones Individuales mediante un filtro por suscripción grupal inválida", priority = 28, enabled = true)
	public void cp28() {
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
	
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroGrupal().sendKeys("0");
		
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getNotiConsultarGrupal()));
		String notificacion=Cronos.getNotiConsultarGrupal().getText();
		Assert.assertEquals(notificacion, notiFiltroSinResultados);
		
		
		
	}
	
	@Test(description="Consultar suscripciones Individuales mediante un filtro con Fecha fin inválida y fecha de inicio válida", priority = 29, enabled = true)
	public void cp29() {
		
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
		
		
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
	
	
	@Test(description="Consultar suscripciones Individuales mediante un filtro con Fecha fin inválida y fecha de inicio inválida", priority = 30, enabled = true)
	public void cp30() {
		
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
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
	
	@Test(description="Consultar suscripciones Individuales mediante un filtro con fecha inicio válida", priority = 31, enabled = true)
	public void cp31() {
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
	
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroFechaInicio().sendKeys("2024-06-03");
		Cronos.getFiltroMonto().click();
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
	

		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
		
		
		
		
	}
	
	@Test(description="Consultar suscripciones Individuales mediante un filtro por Fecha de registro válida", priority = 32, enabled = true)
	public void cp32() {
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));

		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroFechaRegistro().sendKeys("2024-06-03");
		Cronos.getFiltroMonto().click();
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
		
		
	}
	
	@Test(description="Consultar suscripciones Individuales mediante un filtro por Fecha de registro inválida", priority = 33, enabled = true)
	public void cp33() {
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		

		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		Cronos.getFiltroFechaRegistro().sendKeys("2024-05-31");
		Cronos.getFiltroMonto().click();
		Cronos.getBtnAplicarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getNotiConsultarGrupal()));
		String notificacion=Cronos.getNotiConsultarGrupal().getText();
		Assert.assertEquals(notificacion, notiFiltroSinResultados);
		
		
		
	}
	
	@Test(description="Consultar suscripciones Individuales borrando el filtro", priority = 34, enabled = true)
	public void cp34() {
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFiltroReferencia()));
		
		Cronos.getBtnBorrarFiltro().click();
		
		
	
	
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
	}
	
	@Test(description="Consultar suscripciones Individuales cambiando la cantidad de resultados a mostrar", priority = 35, enabled = true)
	public void cp35() {
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Select selectMes = new Select(Cronos.getDesplegableMostrar());
	    selectMes.selectByValue("25");
	
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia25()));
		
		Assert.assertNotNull(Cronos.getReferencia25(), "No se muestran adecuadamente las 25 referencias");
		
		
		
	}
	
	@Test(description="Descargar el archivo csv de suscripciones Individuales", priority = 36, enabled = true)
	public void cp36() {
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		
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
	
		
		
		
		
	}
	

		
	@Test(description="Visualizar etiqueta de suscripción Individual Finalizada", priority = 38, enabled = true)
	public void cp38() {
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEstadoIndividual()));
		Select selectStatus = new Select(Cronos.getEstadoIndividual());
	    selectStatus.selectByValue("SUBS_TERMINATED");
		
		Cronos.getBtnAplicarFiltro().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
		String etiqueta=Cronos.getEtiquetaIndividual().getText();
		Assert.assertEquals(etiqueta,"Finalizada");
		
		
	}
	
	
	
	@Test(description="Visualizar etiqueta de suscripción Individual Pendiente", priority = 40, enabled = true)
	public void cp40() {
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEstadoIndividual()));
		Select selectStatus = new Select(Cronos.getEstadoIndividual());
	    selectStatus.selectByValue("SUBS_PENDING");
		
	
		Cronos.getBtnAplicarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
		String etiqueta=Cronos.getEtiquetaIndividual().getText();
		Assert.assertEquals(etiqueta,"Pendiente");
		
		
		
		
	}
	
	
	
	@Test(description="Visualizar etiqueta de suscripción Individual Cancelada", priority = 42, enabled = true)
	public void cp42() {
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEstadoIndividual()));
		Select selectStatus = new Select(Cronos.getEstadoIndividual());
	    selectStatus.selectByValue("SUBS_CANCELED");
		
	
		Cronos.getBtnAplicarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
		String etiqueta=Cronos.getEtiquetaIndividual().getText();
		Assert.assertEquals(etiqueta,"Cancelada");
		
	}
	@Test(description="Visualizar etiqueta de suscripción Individual Suspendida", priority = 43, enabled = true)
	public void cp43() {
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEstadoIndividual()));
		Select selectStatus = new Select(Cronos.getEstadoIndividual());
	    selectStatus.selectByValue("SUBS_SUSPENDED");
		
	
		Cronos.getBtnAplicarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
		String etiqueta=Cronos.getEtiquetaIndividual().getText();
		Assert.assertEquals(etiqueta,"Suspendida");
		
	}


	@Test(description="Visualizar etiqueta de suscripción Individual Activa", priority = 46, enabled = true)
	public void cp46() {
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEstadoIndividual()));
		Select selectStatus = new Select(Cronos.getEstadoIndividual());
	    selectStatus.selectByValue("SUBS_ACTIVE");
		
	
		Cronos.getBtnAplicarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Assert.assertNotNull(Cronos.getReferencia1(), "No se muestran adecuadamente el resultado del filtro");
		
		String etiqueta=Cronos.getEtiquetaIndividual().getText();
		Assert.assertEquals(etiqueta,"Activa");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test(description="Anular la cancelación de una suscripción Individual  Activa", priority = 47, enabled = true)
	public void cp47() {
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEstadoIndividual()));
		Select selectStatus = new Select(Cronos.getEstadoIndividual());
	    selectStatus.selectByValue("SUBS_ACTIVE");
		
	
		Cronos.getBtnAplicarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getVisualizarSuscripcionIndividual()));
		
		Cronos.getVisualizarSuscripcionIndividual().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnCancelarSubVisualizada()));
		Cronos.getBtnCancelarSubVisualizada().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnCancelarCancelar()));
		Cronos.getBtnCancelarCancelar().click();
		
		String etiqueta=Cronos.getEtiquetaCancelada().getText();
		Assert.assertEquals(etiqueta,"Activa");
		
		
		
		
		
		
	}
	@Test(description="Cancelar suscripción Individual  Activa", priority = 48, enabled = true)
	public void cp48() {
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEstadoIndividual()));
		Select selectStatus = new Select(Cronos.getEstadoIndividual());
	    selectStatus.selectByValue("SUBS_ACTIVE");
		
	
		Cronos.getBtnAplicarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Cronos.getVisualizarSuscripcionIndividual().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnCancelarSubVisualizada()));
		Cronos.getBtnCancelarSubVisualizada().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnCancelarCancelar()));
		Cronos.getBtnConfirmarCancelar().click();
		ewait2.until(ExpectedConditions.textToBePresentInElement(Cronos.getEtiquetaCancelada(),"Cancelada"));
		String etiqueta=Cronos.getEtiquetaCancelada().getText();
		Assert.assertEquals(etiqueta,"Cancelada");
		
		
		
		
		
		
	}
	@Test(description="Anular la renovación suscripción Individual Activa", priority = 49, enabled = true)
	public void cp49() {
		
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEstadoIndividual()));
		Select selectStatus = new Select(Cronos.getEstadoIndividual());
	    selectStatus.selectByValue("SUBS_ACTIVE");
		
	
		Cronos.getBtnAplicarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Cronos.getVisualizarSuscripcionIndividual().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnRenovar()));
		Cronos.getBtnRenovar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnCancelarRenovar()));
		Cronos.getBtnCancelarRenovar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEtiquetaCancelada()));

		String etiqueta=Cronos.getEtiquetaCancelada().getText();
		Assert.assertEquals(etiqueta,"Activa");
		
		
		
		
	}
	@Test(description="Renovar suscripción Individual  Activa", priority = 50, enabled = true)
	public void cp50() {
		navegador.navigate().refresh();
		WebDriverWait ewait1 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		WebDriverWait ewait2 = new WebDriverWait(navegador, Duration.ofSeconds(100));
		
		ewait1.until(ExpectedConditions.visibilityOf(Cronos.getDesplegableIndividual()));
		Cronos.getDesplegableIndividual().click();
		
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getConsultarIndividual()));
		Cronos.getConsultarIndividual().click();
		
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnFiltrar()));
		Cronos.getBtnFiltrar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getEstadoIndividual()));
		Select selectStatus = new Select(Cronos.getEstadoIndividual());
	    selectStatus.selectByValue("SUBS_ACTIVE");
		
	
		Cronos.getBtnAplicarFiltro().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getReferencia1()));
		
		Cronos.getVisualizarSuscripcionIndividual().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnRenovar()));
		Cronos.getBtnRenovar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getBtnConfirmarRenovar()));
		Cronos.getBtnConfirmarRenovar().click();
		ewait2.until(ExpectedConditions.visibilityOf(Cronos.getFechaRenovacion()));
		Assert.assertNotNull(Cronos.getFechaRenovacion(),"No se renovo correctamente la suscripcion");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	 private void validarDiasDeshabilitados(WebElement calendario, LocalDate fechaActual) {
	        List<WebElement> dias = calendario.findElements(By.cssSelector("td"));
	        for (WebElement dia : dias) {
	            String claseDia = dia.getAttribute("class");
	            String textoDia = dia.getText();

	            if (!textoDia.isEmpty() && esNumero(textoDia)) {
	                int diaNumero = Integer.parseInt(textoDia);
	                if ((claseDia.contains("off") && diaNumero > 15) || (!claseDia.contains("off") && diaNumero < fechaActual.getDayOfMonth())) {
	                    Assert.assertTrue(claseDia.contains("disabled"), "El día " + textoDia + " no está deshabilitado.");
	                }
	            }
	        }
	    }

	    private boolean esNumero(String texto) {
	        try {
	            Integer.parseInt(texto);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
	
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
