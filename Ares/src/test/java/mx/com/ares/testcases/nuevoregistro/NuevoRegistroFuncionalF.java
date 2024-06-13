package mx.com.ares.testcases.nuevoregistro;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import mx.com.ares.base.Base;

public class NuevoRegistroFuncionalF extends Base {

		 String correo = "Feenqa113@yopmail.com";
		 String usuario = "Feenqa113";
	
		@BeforeClass
		public void openBrowser() {
			navegador.get("https://feenicia.net/Fnza_SSO/Account/signin");		
			NuevoRegistro.RegistrateAquiElement().click();
			

		}
		@BeforeMethod
		public void limpiarCampos() {
			NuevoRegistro.CorreoElement().clear();
			NuevoRegistro.UsuarioElement().clear();
			NuevoRegistro.ContrasenaElement().clear();
		}
		
		@AfterClass
		public void cerrarNavegador() {
			navegador.close();
		}
		
		@Test(description="Ingresar al enlace regístrate aquí")
		public void IngresarNuevoRegistro() throws Exception {
		
			//NuevoRegistro.RegistrateAquiElement().click();
			Thread.sleep(4000);
			String pantalla = NuevoRegistro.MensajePantallaElement().getText();
			
			AssertJUnit.assertEquals(pantalla, "Nuevo registro");
		}

		@Test(description="Pre-registro de usuario Exitoso", enabled = false)
		public void PreRegistroExitoso() throws Exception {
		
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasena);
			
			
			NuevoRegistro.RegistrateAquiElement().click();
			Thread.sleep(4000);
			String pantalla = NuevoRegistro.MensajePantallaElement().getText();
			
			Assert.assertEquals(pantalla, "Nuevo Registro");
		}
		
		
		@Test(description="Pre-registro de usuario con campos vacíos y sin seleccionar captcha")
		public void PreRegistroCamposVacios() throws Exception {
			
			String btnDeshabilitado = NuevoRegistro.RegistrarElement().getAttribute("className");
			AssertJUnit.assertEquals(btnDeshabilitado,"btn btn-lg btn-primary btn-block disabled");
		}
		
		
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
		
			NuevoRegistro.CorreoElement().sendKeys(correo);
			String campoCorreo= NuevoRegistro.CorreoElement().getAttribute("value");
			String btnDeshabilitado = NuevoRegistro.RegistrarElement().getAttribute("className");
			Assert.assertNotNull(campoCorreo);
			AssertJUnit.assertEquals(btnDeshabilitado,"btn btn-lg btn-primary btn-block disabled");
		}
		
		@Test(description="Pre-registro de usuario con campo usuario lleno")
		public void PreRegistroCampoUsuarioLleno() throws Exception {
		
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			String campoUsuario= NuevoRegistro.UsuarioElement().getAttribute("value");
			String btnDeshabilitado = NuevoRegistro.RegistrarElement().getAttribute("className");
			Assert.assertNotNull(campoUsuario);
			AssertJUnit.assertEquals(btnDeshabilitado,"btn btn-lg btn-primary btn-block disabled");
			
		}
		
		@Test(description="Pre-registro de usuario con campo contrasena lleno")
		public void PreRegistroCampoContrasenaLleno() throws Exception {
		
			NuevoRegistro.ContrasenaElement().sendKeys(contrasena);
			String campoContrasena= NuevoRegistro.ContrasenaElement().getAttribute("value");
			String btnDeshabilitado = NuevoRegistro.RegistrarElement().getAttribute("className");
			Assert.assertNotNull(campoContrasena);
			AssertJUnit.assertEquals(btnDeshabilitado,"btn btn-lg btn-primary btn-block disabled");
		}
		
		@Test(description="Pre-Registro de usuario con campo correo vacio")
		public void PreRegistroCamposCorreoVacio() throws Exception {
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasena);
			NuevoRegistro.CorreoElement().clear();
			NuevoRegistro.RegistrarElement().click();
			String mensajeError = NuevoRegistro.CorreoElement().getAttribute("validationMessage");
			AssertJUnit.assertTrue((mensajeError.contains("campo")));

		}
		
		
		@Test(description="Pre-Registro de usuario con campo usuario vacio")
		public void PreRegistroCampoUsuarioVacio() throws Exception {
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasena);
			NuevoRegistro.UsuarioElement().clear();
			NuevoRegistro.RegistrarElement().click();
			String mensajeError = NuevoRegistro.UsuarioElement().getAttribute("validationMessage");
			AssertJUnit.assertTrue((mensajeError.contains("campo")));

		}
		
		@Test(description="Pre-Registro de usuario con campo contrasena vacio")
		public void PreRegistroCampoContrasenaVacio() throws Exception {
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasena);
			NuevoRegistro.ContrasenaElement().clear();
			NuevoRegistro.RegistrarElement().click();
			String mensajeError = NuevoRegistro.ContrasenaElement().getAttribute("validationMessage");
			AssertJUnit.assertTrue((mensajeError.contains("campo")));
		}
		
		@Test(description="Pre-Registro de usuario sin seleccionar captcha", enabled = false)
		public void PreRegistroSinCaptcha() throws Exception {
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasena);		
			NuevoRegistro.RegistrarElement().click(); 
			String menSinCptacha = NuevoRegistro.MensajeSinCaptchaElement().getText();
			AssertJUnit.assertEquals(menSinCptacha, "No ha seleccionado el captcha");
		}
		
		
		@Test(description="Pre-registro de usuario con correo registrado anteriormente", enabled = false)
		public void PreRegistroConCorreoRegistradoAnteriormente() throws Exception {
			
			String correoReg= "feen_qa4@yopmail.com";
			NuevoRegistro.CorreoElement().sendKeys(correoReg);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasena);
			WebElement iFrame =NuevoRegistro.IFrameCaptchaElement();
	        navegador.switchTo().frame(iFrame);
	        
	        // Ahora puede hacer clic en la casilla de verificación de reCaptcha ahora.
	        WebElement iFrame_checkbox = NuevoRegistro.CaptchaElement();
	        iFrame_checkbox.click();
	        Thread.sleep(1000);
	        navegador.switchTo().defaultContent();
	        
			NuevoRegistro.RegistrarElement().click();
			String menCorreoYaRegistrado= NuevoRegistro.MensajeCorreoYaRegistradoElement().getText();
			AssertJUnit.assertEquals(menCorreoYaRegistrado, "El correo ya se encuentra registrado");
		}
		
		@Test(description="Pre-registro de usuario con usuario registrado anteriormente", enabled = false)
		public void PreRegistroConUsuarioRegistradoAnteriormente() throws Exception {
			
			String usuarioReg= "feen_qa4";
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuarioReg);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasena);
			
			WebElement iFrame =NuevoRegistro.IFrameCaptchaElement();
	        navegador.switchTo().frame(iFrame);
	        
	        // Ahora puede hacer clic en la casilla de verificación de reCaptcha ahora.
	        WebElement iFrame_checkbox = NuevoRegistro.CaptchaElement();
	        iFrame_checkbox.click();
	        Thread.sleep(3000);
	        navegador.switchTo().defaultContent();
	        
			NuevoRegistro.RegistrarElement().click();
			String menUsuarioYaRegistrado= NuevoRegistro.MensajeUsuarioYaRegistradoElement().getText();
			AssertJUnit.assertEquals(menUsuarioYaRegistrado, "El usuario ya esta registrado");
		}		
		
		@Test(description="Pre-registro con campo contrasena con menos de 8 caracteres")
		public void PreRegistroConContrasenaMenosDe8Caracteres() throws Exception {
			
			String contrasenaMenor= "Demo*2";
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasenaMenor);
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"text-info passok");
			AssertJUnit.assertEquals(Mayuscula,"text-info passok");
			AssertJUnit.assertEquals(Numero,"text-info passok");
			AssertJUnit.assertEquals(CaracterEspecial,"text-info passok");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"");
		}
		
		
		@Test(description="Pre-registro con campo contrasena con más de 30 caracteres", enabled = false)
		public void PreRegistroConContrasena31Caracteres() throws Exception {
			
			String contrasenaMayor= "Demo*2023pruebasqa123654789QAPRU";
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasenaMayor);
			
			WebElement iFrame =NuevoRegistro.IFrameCaptchaElement();
	        navegador.switchTo().frame(iFrame);
	        
	        // Ahora puede hacer clic en la casilla de verificación de reCaptcha ahora.
	        WebElement iFrame_checkbox = NuevoRegistro.CaptchaElement();
	        iFrame_checkbox.click();
	        Thread.sleep(3000);
	        navegador.switchTo().defaultContent();
	        
			NuevoRegistro.RegistrarElement().click();
			String menContrasenaMayor= NuevoRegistro.MensajeContrasenaMayorElement().getText();
			AssertJUnit.assertEquals(menContrasenaMayor, "El password no es valido");
		}
		
		
		@Test(description="Pre-registro con caracter especial inválido en campo usuario", enabled = false)
		public void PreRegistroConCarcterInvalidoUsuario() throws Exception {
			
			String usuarioInvalido= "feen*20qa";
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuarioInvalido);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasena);
			
			
	        
			NuevoRegistro.RegistrarElement().click();
			String mensajeUsuarioInvalid= NuevoRegistro.MensajeUsuarioInvalidElement().getText();
			AssertJUnit.assertEquals(mensajeUsuarioInvalid, "El usuario es invalido");
		}
		
		
		@Test(description="Pre-registro con campo contrasena sin mayusculas")
		public void PreRegistroConContrasenaSinMayuscula() throws Exception {
			
			String contrasenaSinMayuscula ="demo*2023";
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasenaSinMayuscula);
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"text-info passok");
			AssertJUnit.assertEquals(Mayuscula,"");
			AssertJUnit.assertEquals(Numero,"text-info passok");
			AssertJUnit.assertEquals(CaracterEspecial,"text-info passok");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"text-info passok");
		}
		
		@Test(description="Pre-registro con campo contrasena sin minuscula")
		public void PreRegistroConContrasenaSinMinuscula() throws Exception {
			
			String contrasenaSinMinuscula ="DEMO*2023";
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasenaSinMinuscula);	
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"");
			AssertJUnit.assertEquals(Mayuscula,"text-info passok");
			AssertJUnit.assertEquals(Numero,"text-info passok");
			AssertJUnit.assertEquals(CaracterEspecial,"text-info passok");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"text-info passok");
		}
		
		@Test(description="Pre-registro con campo contrasena sin numero")
		public void PreRegistroConContrasenaSinNumero() throws Exception {
			
			String contrasenaSinNumero ="Demo*prueba";
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasenaSinNumero);
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"text-info passok");
			AssertJUnit.assertEquals(Mayuscula,"text-info passok");
			AssertJUnit.assertEquals(Numero,"");
			AssertJUnit.assertEquals(CaracterEspecial,"text-info passok");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"text-info passok");
		}
		
		@Test(description="Pre-registro con campo contrasena sin caracter especial")
		public void PreRegistroConContrasenaSinCaracterEspecial() throws Exception {
			
			String contrasenaSinCaracterEspecial ="Demo2023";
			NuevoRegistro.CorreoElement().sendKeys(correo);
			NuevoRegistro.UsuarioElement().sendKeys(usuario);
			NuevoRegistro.ContrasenaElement().sendKeys(contrasenaSinCaracterEspecial);	
			String Minuscula= NuevoRegistro.CaracterMinusculaElement().getAttribute("className");
			String Mayuscula = NuevoRegistro.CaracterMayusculaElement().getAttribute("className");
			String Numero = NuevoRegistro.UnNumero().getAttribute("className");
			String CaracterEspecial = NuevoRegistro.CaracterEspecialElement().getAttribute("className");
			String MinimoOchoCaracteres = NuevoRegistro.CaracterMinContrasenaElement().getAttribute("className");
			AssertJUnit.assertEquals(Minuscula,"text-info passok");
			AssertJUnit.assertEquals(Mayuscula,"text-info passok");
			AssertJUnit.assertEquals(Numero,"text-info passok");
			AssertJUnit.assertEquals(CaracterEspecial,"");
			AssertJUnit.assertEquals(MinimoOchoCaracteres,"text-info passok");
		}
		
		
		@Test(description="Visualización de los Terminos y Condiciones")
		public void VisualizarTeminosCondiciones() throws Exception {
			
			NuevoRegistro.TerminosyCondicionesElement().click();
			Thread.sleep(4000);
			String urlTC = NuevoRegistro.TerminosyCondicionesElement().getAttribute("href");
			AssertJUnit.assertEquals(urlTC, "https://feenicia.com/terminos-y-condiciones/");
		}
		
		
		@Test(description="Visualización del Aviso de Privacidad ")
		public void VisualizarAvisoPrivacidad() throws Exception {
			
			NuevoRegistro.AvisoPrivacidadElement().click();
			Thread.sleep(4000);
			String urlAP = NuevoRegistro.AvisoPrivacidadElement().getAttribute("href");
			AssertJUnit.assertEquals(urlAP, "https://www.feenicia.com/aviso-de-privacidad/");
		}
		
		
}


