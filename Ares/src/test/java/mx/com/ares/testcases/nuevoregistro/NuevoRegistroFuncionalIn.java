package mx.com.ares.testcases.nuevoregistro;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import mx.com.ares.base.Base;

public class NuevoRegistroFuncionalIn extends Base {

		 String correo = "Feenqa113@yopmail.com";
		 String usuario = "Feenqa113";
	
		@BeforeClass
		public void openBrowser() {
			navegador.get("https://qa.serti.tech/Fnza_SSO/Account/Login?aplic=inbursa");		
			NuevoRegistro.RegistrateAquiElementIn().click();
			

		}
		@BeforeMethod
		public void limpiarCampos() {
			NuevoRegistro.CorreoElementIn().clear();
			NuevoRegistro.UsuarioElementIn().clear();
			NuevoRegistro.ContrasenaElementIn().clear();
		}
		
		@AfterClass
		public void cerrarNavegador() {
			navegador.close();
		}
		
		@Test(description="Ingresar al enlace regístrate aquí")
		public void IngresarNuevoRegistro() throws Exception {
		
			//NuevoRegistro.RegistrateAquiElement().click();
			Thread.sleep(4000);
			String pantalla = NuevoRegistro.MensajePantallaElementIn().getText();
			
			AssertJUnit.assertEquals(pantalla, "Nuevo Registro");
		}

		//Desactivado para no estar registrando usuarios cada vez que se ejecute la clase
		@Test(description="Pre-registro de usuario Exitoso", enabled = false)
		public void PreRegistroExitoso() throws Exception {
		
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.UsuarioElementIn().sendKeys(usuario);
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasena);
			
			
			NuevoRegistro.RegistrateAquiElement().click();
			Thread.sleep(4000);
			String pantalla = NuevoRegistro.MensajePantallaElement().getText();
			
			Assert.assertEquals(pantalla, "Nuevo Registro");
		}
		
		
		@Test(description="Pre-registro de usuario con campos vacíos y sin seleccionar captcha")
		public void PreRegistroCamposVacios() throws Exception {
			
			String btnDeshabilitado = NuevoRegistro.RegistrarElement().getAttribute("className");
			AssertJUnit.assertEquals(btnDeshabilitado,"btn btn-principal btn-block mt-4 disabled");
		}
		
		//Problemas con el captcha
		@Test(description="Pre-registro de usuario con campos vacíos y seleccionar captcha", enabled = false)
		public void PreRegistroCamposVaciosConCaptcha() throws Exception {
			
			WebElement iFrame =NuevoRegistro.IFrameCaptchaElement();
	        navegador.switchTo().frame(iFrame);
	        
	        // Ahora puede hacer clic en la casilla de verificación de reCaptcha ahora.
	        WebElement iFrame_checkbox = NuevoRegistro.CaptchaElement();
	        iFrame_checkbox.click();
	        Thread.sleep(1000);
	        navegador.switchTo().defaultContent();
	        
			//NuevoRegistro.RegistrarElement().click();
			String message = NuevoRegistro.CorreoElement().getAttribute("validationMessage");
			AssertJUnit.assertTrue((message.contains("campo")));
			
			
			String btnDeshabilitado = NuevoRegistro.RegistrarElement().getAttribute("className");
			AssertJUnit.assertEquals(btnDeshabilitado,"btn btn-lg btn-primary btn-block disabled");
		}


		@Test(description="Pre-registro de usuario con campo correo lleno")
		public void PreRegistroCampoCorreoLleno() throws Exception {
		
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			String campoCorreo= NuevoRegistro.CorreoElementIn().getAttribute("value");
			String btnDeshabilitado = NuevoRegistro.RegistrarElement().getAttribute("className");
			Assert.assertNotNull(campoCorreo);
			AssertJUnit.assertEquals(btnDeshabilitado,"btn btn-principal btn-block mt-4 disabled");
		}
		
		@Test(description="Pre-registro de usuario con campo usuario lleno")
		public void PreRegistroCampoUsuarioLleno() throws Exception {
		
			NuevoRegistro.UsuarioElementIn().sendKeys(usuario);
			String campoUsuario= NuevoRegistro.UsuarioElementIn().getAttribute("value");
			String btnDeshabilitado = NuevoRegistro.RegistrarElement().getAttribute("className");
			Assert.assertNotNull(campoUsuario);
			AssertJUnit.assertEquals(btnDeshabilitado,"btn btn-principal btn-block mt-4 disabled");
			
		}
		
		@Test(description="Pre-registro de usuario con campo contrasena lleno")
		public void PreRegistroCampoContrasenaLleno() throws Exception {
		
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasena);
			String campoContrasena= NuevoRegistro.ContrasenaElementIn().getAttribute("value");
			String btnDeshabilitado = NuevoRegistro.RegistrarElement().getAttribute("className");
			Assert.assertNotNull(campoContrasena);
			AssertJUnit.assertEquals(btnDeshabilitado,"btn btn-principal btn-block mt-4 disabled");
		}
		
		@Test(description="Pre-Registro de usuario con campo correo vacio")
		public void PreRegistroCamposCorreoVacio() throws Exception {
			NuevoRegistro.UsuarioElementIn().sendKeys("Qa123");
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasena);
			NuevoRegistro.RegistrarElement().click();
			WebElement mensajeElemento = navegador.findElement(By.xpath("//*[@id=\"msgInfo\"]"));
			String textoMensaje = mensajeElemento.getText();
			AssertJUnit.assertEquals(textoMensaje ,"");

		}
		
		
		@Test(description="Pre-Registro de usuario con campo usuario vacio")
		public void PreRegistroCampoUsuarioVacio() throws Exception {
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasena);
			NuevoRegistro.RegistrarElement().click();
			WebElement mensajeElemento = navegador.findElement(By.xpath("//div[@class='messenger-message-inner']"));
			String textoMensaje = mensajeElemento.getText();
			AssertJUnit.assertEquals(textoMensaje , "Introduzca un usuario");

		}
		
		@Test(description="Pre-Registro de usuario con campo contrasena vacio")
		public void PreRegistroCampoContrasenaVacio() throws Exception {
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.UsuarioElementIn().sendKeys("Qa123");
			NuevoRegistro.RegistrarElement().click();
			WebElement mensajeElemento = navegador.findElement(By.xpath("//div[@class='messenger-message-inner']"));
			String textoMensaje = mensajeElemento.getText();
			AssertJUnit.assertEquals(textoMensaje , "La contraseña es invalida");
		}
		
		
		@Test(description="Pre-registro de usuario con correo registrado anteriormente")
		public void PreRegistroConCorreoRegistradoAnteriormente() throws Exception {
			
			String correoReg= "feen_qa4@yopmail.com";
			NuevoRegistro.CorreoElementIn().sendKeys(correoReg);
			NuevoRegistro.UsuarioElementIn().sendKeys("Qa123");
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasena);
			NuevoRegistro.RegistrarElement().click();
			WebElement mensajeElemento = navegador.findElement(By.xpath("/html/body/ul/li/div/div"));
			String textoMensaje = mensajeElemento.getText();
			AssertJUnit.assertEquals(textoMensaje, "El correo ya se encuentra registrado");
		}
		
		@Test(description="Pre-registro de usuario con usuario registrado anteriormente")
		public void PreRegistroConUsuarioRegistradoAnteriormente() throws Exception {
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.UsuarioElementIn().sendKeys("inbursaqa1");
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasena);
			NuevoRegistro.RegistrarElement().click();
			WebElement mensajeElemento = navegador.findElement(By.xpath("/html/body/ul/li[1]/div/div"));
			String textoMensaje = mensajeElemento.getText();
			AssertJUnit.assertEquals(textoMensaje, "El usuario seleccionado no esta disponible, pruebe con otro usuario");
		}		
		
		@Test(description="Pre-registro con campo contrasena con menos de 8 caracteres")
		public void PreRegistroConContrasenaMenosDe8Caracteres() throws Exception {
			
			String contrasenaMenor= "Demo*2";
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.UsuarioElementIn().sendKeys(usuario);
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasenaMenor);
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(Mayuscula,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(Numero,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(CaracterEspecial,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"list-inline-item");
		}
		
		
		@Test(description="Pre-registro con caracter especial inválido en campo usuario")
		public void PreRegistroConCarcterInvalidoUsuario() throws Exception {
			
			String usuarioInvalido= "feen*20qa";
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.UsuarioElementIn().sendKeys(usuarioInvalido);
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasena);   
			NuevoRegistro.RegistrarElement().click();
			WebElement mensajeElemento = navegador.findElement(By.xpath("//div[@class='messenger-message-inner']"));
			String textoMensaje = mensajeElemento.getText();
			AssertJUnit.assertTrue(textoMensaje.contains("El usuario no debe ser mayor de 32 caracteres."));
		}
		
		
		@Test(description="Pre-registro con campo contrasena sin mayusculas")
		public void PreRegistroConContrasenaSinMayuscula() throws Exception {
			
			String contrasenaSinMayuscula ="demo*2023";
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.UsuarioElementIn().sendKeys(usuario);
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasenaSinMayuscula);
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(Mayuscula,"list-inline-item");
			AssertJUnit.assertEquals(Numero,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(CaracterEspecial,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"list-inline-item text-info passok");
		}
		
		@Test(description="Pre-registro con campo contrasena sin minuscula")
		public void PreRegistroConContrasenaSinMinuscula() throws Exception {
			
			String contrasenaSinMinuscula ="DEMO*2023";
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.UsuarioElementIn().sendKeys(usuario);
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasenaSinMinuscula);	
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"list-inline-item");
			AssertJUnit.assertEquals(Mayuscula,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(Numero,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(CaracterEspecial,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"list-inline-item text-info passok");
		}
		
		@Test(description="Pre-registro con campo contrasena sin numero")
		public void PreRegistroConContrasenaSinNumero() throws Exception {
			
			String contrasenaSinNumero ="Demo*prueba";
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.UsuarioElementIn().sendKeys(usuario);
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasenaSinNumero);
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(Mayuscula,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(Numero,"list-inline-item");
			AssertJUnit.assertEquals(CaracterEspecial,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"list-inline-item text-info passok");
		}
		
		@Test(description="Pre-registro con campo contrasena sin caracter especial")
		public void PreRegistroConContrasenaSinCaracterEspecial() throws Exception {
			
			String contrasenaSinCaracterEspecial ="Demo2023";
			NuevoRegistro.CorreoElementIn().sendKeys(correo);
			NuevoRegistro.UsuarioElementIn().sendKeys(usuario);
			NuevoRegistro.ContrasenaElementIn().sendKeys(contrasenaSinCaracterEspecial);	
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(Mayuscula,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(Numero,"list-inline-item text-info passok");
			AssertJUnit.assertEquals(CaracterEspecial,"list-inline-item");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"list-inline-item text-info passok");
		}
		
		
		@Test(description="Visualización de los Terminos y Condiciones")
		public void VisualizarTeminosCondiciones() throws Exception {
			Thread.sleep(4000);
			String urlTC = NuevoRegistro.TerminosyCondicionesElementIn().getAttribute("href");
			AssertJUnit.assertEquals(urlTC, "https://qa.serti.tech/Fnza_SSO/User/terminos_condicionesInbursa");
		}
		
		
		@Test(description="Visualización del Aviso de Privacidad ")
		public void VisualizarAvisoPrivacidad() throws Exception {
			Thread.sleep(4000);
			String urlAP = NuevoRegistro.AvisoPrivacidadElementIn().getAttribute("href");
			AssertJUnit.assertEquals(urlAP, "https://www.feenicia.com/aviso-de-privacidad");
		}
		
		
}


