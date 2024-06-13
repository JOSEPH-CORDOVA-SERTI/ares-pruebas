package mx.com.ares.testcases.miinformacion;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mx.com.ares.base.Base;

public class PantallaMiInformacionDisenoF extends Base{
	String titulo = "Información Personal o de contacto";
	String nombre = "Nombre de representante legal";
	String apellidoP = "Apellido Paterno";
	String apellidoM = "Apellido Materno";
	String regimenF = "Régimen Fiscal";
	String fecha = "Fecha de Nacimiento";
	String telefono = "Teléfono (10 dígitos)";
	String identificacion = "Identificación Oficial";


	@BeforeClass
	public void openBrowser() {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");	
		
		Login.UsuarioElement().sendKeys("Automatizacion123");
		Login.ContrasenaElement().sendKeys("Qa654321*");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	
	@Test(description="Mensajes en la sección Mi información Contacto")
	public void mensajeInformacionContacto() throws Exception {
		String mensajeTitulo = navegador.findElement(By.xpath("//*[@id=\"divcontactInformation\"]/h4")).getText();
		AssertJUnit.assertEquals(mensajeTitulo, titulo);
		String mensajeNombre = navegador.findElement(By.xpath("//*[@id=\"divcontactInformation\"]/div/div[3]/label")).getText();
		AssertJUnit.assertEquals(mensajeNombre, nombre);
		String mensajeApellidoP = navegador.findElement(By.xpath("//*[@id=\"divcontactInformation\"]/div/div[4]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajeApellidoP, apellidoP);
		String mensajeApellidoM = navegador.findElement(By.xpath("//*[@id=\"divcontactInformation\"]/div/div[4]/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeApellidoM, apellidoM);
		String mensajeRegimen = navegador.findElement(By.xpath("//*[@id=\"divcontactInformation\"]/div/div[1]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajeRegimen, regimenF);
		String mensajeFecha = navegador.findElement(By.xpath("//*[@id=\"divcontactInformation\"]/div/div[1]/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeFecha, fecha);
		String mensajeTel = navegador.findElement(By.xpath("//*[@id=\"divcontactInformation\"]/div/div[5]/div[1]/label")).getText();
		AssertJUnit.assertEquals(mensajeTel, telefono);
		String mensajeIdent = navegador.findElement(By.xpath("//*[@id=\"divcontactInformation\"]/div/div[5]/div[2]/label")).getText();
		AssertJUnit.assertEquals(mensajeIdent, identificacion);
	}
	
	
}


