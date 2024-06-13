package mx.com.ares.testcases.nuevoregistro;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;

import mx.com.ares.base.Base;

public class PantallaRegistroDisenoIn  extends Base {

	String mensajeNuevoRegistro = "Nuevo Registro";
	String mensajeCrearCuenta= "Crea tu cuenta y empieza a recibir pagos de tus clientes con tarjetas de crédito, débito y vales. Si ya te registraste, inicia sesión aquí.";
	String mensajeCorreo ="Correo electrónico";
	String mensajeUsuario = "Usuario";
	String mensajeContrasena = "Contraseña";
	String mensajeCaracteresContrasena = "Los caracteres especiales pueden ser: $ @ ! % # * ? &";
	String mensajeMinuscula="Una minúscula";
	String mensajeMayuscula ="Una mayúscula";
	String mensajeNumero ="Un número";
	String mensajeCaracter = "Un caracter especial";
	String mensajeCaracterMin = "8 caracteres mínimo";
	String mensajeAviso = "Al hacer clic en Crear cuenta reconoces ser mayor de edad, así como haber leído y aceptado los Términos y condiciones de Inbursa y su Aviso de Privacidad.";
	String mensajeRegistrar = "Registrar";

	
	
	@BeforeClass
	public void openBrowser() {
		navegador.get("https://qa.serti.tech/Fnza_SSO/User/PreRegister?aplic=inbursa");		
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Mensaje Nuevo registro")
	public void mensajeIniciarSesion() throws Exception {
		String NuevoRegistro = navegador.findElement(By.xpath("//*[@id=\"MainContent_divRegister\"]/h3")).getText();
		AssertJUnit.assertEquals(NuevoRegistro, mensajeNuevoRegistro);
	}
	
	@Test(description="Mensaje para crear cuenta")
	public void mensajeRegistro() throws Exception {
		String MensajeYCrearegistro = navegador.findElement(By.xpath("//*[@id=\"MainContent_divRegister\"]/p[1]")).getText();
		AssertJUnit.assertEquals(MensajeYCrearegistro, mensajeCrearCuenta);
	}
	
	@Test(description = "Campo Correo")
	public void correo() throws Exception {
		String correo = navegador.findElement(By.xpath("//*[@id=\"MainContent_divRegister\"]/div[1]/div[2]/div/label")).getText();
		AssertJUnit.assertEquals(correo, mensajeCorreo);
	}
	
	
	@Test(description="Campo Usuario")
	public void usuario() throws Exception {
		String usuario = navegador.findElement(By.xpath("//*[@id=\"MainContent_divRegister\"]/div[1]/div[1]/div/label")).getText();
		AssertJUnit.assertEquals(usuario, mensajeUsuario);
	}
	
	@Test(description="Campo contraseña")
	public void contrasena() throws Exception {
		String contrasena = navegador.findElement(By.xpath("//*[@id=\"MainContent_divRegister\"]/div[1]/div[3]/label")).getText();
		AssertJUnit.assertEquals(contrasena, mensajeContrasena);
	}
	
	@Test(description="Texto caracteres contraseña")
	public void caracteresContrasena() throws Exception {
		String contrasena = navegador.findElement(By.xpath("//*[@id=\"MainContent_divRegister\"]/p[2]/span")).getText();
		AssertJUnit.assertEquals(contrasena, mensajeCaracteresContrasena);
	}
	
	@Test(description="Botón Registrar")
	public void registrar() throws Exception {
			String Registrar = NuevoRegistro.RegistrarElement().getAttribute("Value");
			AssertJUnit.assertEquals(Registrar, mensajeRegistrar);
	}
	
	@Test(description="Una Minuscula")
	public void unaMinuscula() throws Exception {
		String contrasenaMinuscula = navegador.findElement(By.xpath("//*[@id=\"lcase\"]")).getText();
		AssertJUnit.assertEquals(contrasenaMinuscula, mensajeMinuscula);
	}
	
	@Test(description="Una Mayuscula")
	public void unaMayuscula() throws Exception {
		String contrasenaMay = navegador.findElement(By.xpath("//*[@id=\"ucase\"]")).getText();
		AssertJUnit.assertEquals(contrasenaMay, mensajeMayuscula);
	}
	

	@Test(description="Un número")
	public void unaNumero() throws Exception {
		String contrasenaNum = navegador.findElement(By.xpath("//*[@id=\"num\"]")).getText();
		AssertJUnit.assertEquals(contrasenaNum, mensajeNumero);
	}
	
	
	@Test(description="Un caracter especial")
	public void unCaracter() throws Exception {
		String contrasenaCracter= navegador.findElement(By.xpath("//*[@id=\"special\"]")).getText();
		AssertJUnit.assertEquals(contrasenaCracter, mensajeCaracter);
	}
	

	@Test(description="Minimo 8 caracteres")
	public void caracteresMin() throws Exception {
		String contrasenaMin = navegador.findElement(By.xpath("//*[@id=\"8char\"]")).getText();
		AssertJUnit.assertEquals(contrasenaMin, mensajeCaracterMin);
	}

	@Test(description ="Teminos y condiciones y aviso de privacidad")
	public void TerminosAvisoPrivaciad() throws Exception {
		String terminosAviso = navegador.findElement(By.xpath("//*[@id=\"MainContent_divRegister\"]/div[5]/small")).getText();
		AssertJUnit.assertEquals(terminosAviso, mensajeAviso);
	}
	
	
}
	
