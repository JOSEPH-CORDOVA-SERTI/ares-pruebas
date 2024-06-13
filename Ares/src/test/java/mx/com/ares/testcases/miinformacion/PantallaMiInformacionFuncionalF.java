package mx.com.ares.testcases.miinformacion;


import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mx.com.ares.base.Base;

public class PantallaMiInformacionFuncionalF extends Base{


	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Automatizacion123");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
    @BeforeMethod
	public void limpiarCampos() {
		MiInformacion.NombreElement().clear();
		MiInformacion.CampoApellidoPaternoElement().clear();
		MiInformacion.CampoApellidoMaternoElement().clear();
		MiInformacion.CampoTelefonoElement().clear();	
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Ingresar al modulo mi información")
	public void IngresarModuloIformacion() throws Exception {
				
		String pantallaCompletaReg = MiInformacion.PantallaCompletarRegElement().getAttribute("baseURI");
		Assert.assertEquals(pantallaCompletaReg,"https://www.feenicia.net/Fnza_SSO/User/Register");

	}
	
	@Test(description="Opción régimen fiscal: Sin RFC con campos vacíos en pantalla información de contacto")
	public void ModuloIformacionContactoVacio() throws Exception {
		
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByIndex(2);
		regimen.selectByVisibleText("Sin RFC");
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnNextStep1\"]")));
		MiInformacion.BotonSiguienteInfContElement().click();
		
		String mensajeCamposvacios= MiInformacion.MensjaCamposVaciosElement().getText();
		
		Assert.assertEquals(mensajeCamposvacios,"Nombre del contacto inválido.");
	}
	
	
	@Test(description="Opción régimen fiscal: Sin RFC sin Nombre")
	public void InformacionContactoSinNombre() throws Exception {
				
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByIndex(2);
		regimen.selectByVisibleText("Sin RFC");
		//String textoregimen =regimen.getFirstSelectedOption().getText();
	   
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtAp")));
		
		MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
		MiInformacion.CampoApellidoPaternoElement().sendKeys(apellidoP);
		MiInformacion.CampoTelefonoElement().sendKeys(telefono);
		MiInformacion.BotonSiguienteInfContElement().click();
		
		
		
		String mensajeSinNombre= MiInformacion.MensajeSinNombreElement().getText();
		 //System.out.println(pantallaCompletaReg);
		Assert.assertEquals(mensajeSinNombre,"Nombre del contacto inválido.");
	}
	
	
	
	@Test(description="Opción régimen fiscal: Sin RFC sin Apellido paterno")
	public void InformacionContactoSinApellido() throws Exception {
		
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByIndex(2);
		regimen.selectByVisibleText("Sin RFC");
		
		Thread.sleep(3000);
		
		MiInformacion.NombreElement().sendKeys(nombre);
		MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
		MiInformacion.CampoTelefonoElement().sendKeys(telefono);
		MiInformacion.BotonSiguienteInfContElement().click();
		
		String mensajeSinApellidoP= MiInformacion.MensajeSinApellidoPElement().getText();
		 //System.out.println(pantallaCompletaReg);
		Assert.assertEquals(mensajeSinApellidoP,"Apellido Paterno del contacto inválido.");
	}
	
	@Test(description="Opción régimen fiscal: Sin RFC con numero telefónico a 11 dígitos")
	public void InformacionContactoTelOnceDigitos() throws Exception {
		
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByIndex(2);
		regimen.selectByVisibleText("Sin RFC");
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtNombre")));
		
		MiInformacion.NombreElement().sendKeys(nombre);
		MiInformacion.CampoApellidoPaternoElement().sendKeys(apellidoP);
		MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
		MiInformacion.CampoTelefonoElement().sendKeys(telefono);
		
		String campoText= MiInformacion.CampoTelefonoElement().getAttribute("maxlength");
		
		//System.out.println(campoText);
		Assert.assertEquals(campoText,"10");
	}
	
	
	@Test(description="Opción régimen fiscal: Con RFC con numero telefónico a 6 dígitos")
	public void InformacionContactoTelefonoMenorDiez() throws Exception {
		
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByIndex(2);
		regimen.selectByVisibleText("Sin RFC");
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtNombre")));
		
		MiInformacion.NombreElement().sendKeys(nombre);
		MiInformacion.CampoApellidoPaternoElement().sendKeys(apellidoP);
		MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
		MiInformacion.CampoTelefonoElement().sendKeys(telefonoNumMen);
		MiInformacion.BotonSiguienteInfContElement().click();
		
		String mensajeTel= MiInformacion.MensajeTelefonoElement().getText();
		 //System.out.println(pantallaCompletaReg);
		Assert.assertEquals(mensajeTel,"Número Telefónico inválido.");
	}
	
	@Test(description="Opción régimen fiscal: Sin RFC con campo número telefónico vacío")
	public void InformacionContactoTelefonoVacio() throws Exception {
		
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByIndex(2);
		regimen.selectByVisibleText("Sin RFC");
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtNombre")));
		
		MiInformacion.NombreElement().sendKeys(nombre);
		MiInformacion.CampoApellidoPaternoElement().sendKeys(apellidoP);
		MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
		MiInformacion.BotonSiguienteInfContElement().click();
		
		String mensajeTel= MiInformacion.MensajeTelefonoElement().getText();
		 //System.out.println(pantallaCompletaReg);
		Assert.assertEquals(mensajeTel,"Número Telefónico inválido.");
	}
	
	
	 
	@Test(description="Opción régimen fiscal: Sin RFC con fecha actual en campo fecha de nacimiento")
	public void InformacionContactoFechaNaciFechaActual() throws Exception {
		
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByIndex(2);
		regimen.selectByVisibleText("Sin RFC");
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtNombre")));
		
		MiInformacion.NombreElement().sendKeys(nombre);
		MiInformacion.CampoApellidoPaternoElement().sendKeys(apellidoP);
		MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
		
		MiInformacion.FechaNacimientoElement().click();

		Select mesNaci = new Select( MiInformacion.MesElement());
		mesNaci.selectByIndex(8);
		mesNaci.selectByVisibleText("Septiembre");
		
		
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/table/thead/tr[1]/th[2]/select[2]")));
		
		
		Select anNaci = new Select( MiInformacion.AnElement());
		anNaci.selectByIndex(95);
		anNaci.selectByVisibleText("2023");
		
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/table/tbody/tr[4]/td[4]")));
		
		
		navegador.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/table/tbody/tr[4]/td[4]")).click();
		
		
		String fechaNacimiento= MiInformacion.FechaNacimientoElement().getAttribute("value");
		 //System.out.println(fechaNacimiento);
		 MiInformacion.CampoTelefonoElement().sendKeys(telefono);
		Assert.assertEquals(fechaNacimiento,"Sep 20, 2023");
		MiInformacion.BotonSiguienteInfContElement().click();
		
		String mensajeFechaNac= MiInformacion.MensajeTelefonoElement().getText();
		// System.out.println(mensajeFechaNac);
		Assert.assertEquals(mensajeFechaNac,"El usuario de registro debe ser mayor de edad.");
		
		}
		

	@Test(description="Opción régimen fiscal: Sin RFC con fecha que no pase los 18 años de edad en campo Fecha de nacimiento")
	public void InformacionContactoFechaNaciMenorEdad() throws Exception {
		
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByIndex(2);
		regimen.selectByVisibleText("Sin RFC");
		
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtNombre")));
		
		MiInformacion.NombreElement().sendKeys(nombre);
		MiInformacion.CampoApellidoPaternoElement().sendKeys(apellidoP);
		MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
		
		MiInformacion.FechaNacimientoElement().click();

		Select mesNaci = new Select( MiInformacion.MesElement());
		mesNaci.selectByIndex(7);
		mesNaci.selectByVisibleText("Agosto");
		
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/table/thead/tr[1]/th[2]/select[2]")));
		
		
		Select anNaci = new Select( MiInformacion.AnElement());
		anNaci.selectByIndex(83);
		anNaci.selectByVisibleText("2011");
		
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/table/tbody/tr[4]/td[4]")));
		
		navegador.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/table/tbody/tr[3]/td[4]")).click();
		
		
		String fechaNacimiento= MiInformacion.FechaNacimientoElement().getAttribute("value");
		 System.out.println(fechaNacimiento);
		 MiInformacion.CampoTelefonoElement().sendKeys(telefono);
	
		MiInformacion.BotonSiguienteInfContElement().click();
		
		String mensajeFechaNac= MiInformacion.MensajeTelefonoElement().getText();
		 System.out.println(mensajeFechaNac);
		Assert.assertEquals(mensajeFechaNac,"El usuario de registro debe ser mayor de edad.");
		
		}
	
	
		
	
	@Test(description="Opción régimen fiscal: Sin RFC Llenar formulario de pantalla información de contacto correctamente", enabled = false)
	public void InformacionContactoCorrecto() throws Exception {
		
		Select regimen = new Select( MiInformacion.SelectRegimenElement());
		regimen.selectByIndex(2);
		regimen.selectByVisibleText("Sin RFC");
		
		Thread.sleep(3000);
		
		MiInformacion.NombreElement().sendKeys(nombre);
		MiInformacion.CampoApellidoPaternoElement().sendKeys(apellidoP);
		MiInformacion.CampoApellidoMaternoElement().sendKeys(apellidoM);
		MiInformacion.CampoTelefonoElement().sendKeys(telefono);
		
		MiInformacion.FechaNacimientoElement().click();

		Select mesNaci = new Select( MiInformacion.MesElement());
		mesNaci.selectByIndex(5);
		mesNaci.selectByVisibleText("Junio");
		Thread.sleep(3000);
		
		Select añoNaci = new Select( MiInformacion.AnElement());
		añoNaci.selectByIndex(61);
		añoNaci.selectByVisibleText("1989");
		
		Thread.sleep(3000);
		
		navegador.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/table/tbody/tr[2]/td[4]")).click();
		MiInformacion.BotonSiguienteInfContElement().click();
		
		Thread.sleep(4000);
		
		String pantallaFac= MiInformacion.PantallaFacturacionElement().getText();
		assertEquals(pantallaFac, "Datos Fiscales");
		
		String barraProgreso= MiInformacion.ProgresoElement().getText();
		assertEquals(barraProgreso, "25% Completado");
		
		
	}

	
	
}


