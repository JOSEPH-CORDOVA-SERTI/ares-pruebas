package mx.com.ares.base;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import mx.com.ares.deprecado.pagoleal.NuevoRegistroPl;
import mx.com.ares.repository.Login;
import mx.com.ares.repository.NuevoRegistro;
import mx.com.ares.repository.OlvideMiContrasena;
import mx.com.ares.repository.VentaDispositivo;
import mx.com.ares.repository.VentaManual;
import mx.com.ares.repository.MiInformacion;
import mx.com.ares.repository.Productos;
import mx.com.ares.repository.Cronos;


public class Base {
	
	protected static WebDriver navegador;

	protected Login Login;
	protected NuevoRegistro NuevoRegistro;
	protected NuevoRegistroPl NuevoRegistroPl;
	protected OlvideMiContrasena Contrasena;
	protected MiInformacion MiInformacion;
	protected VentaManual VentaManual;
	protected VentaDispositivo VentaDispositivo;
	protected Productos Productos;
	protected Cronos Cronos;
	
	protected String usuarioF = "userBereF";
	protected String usuarioP = "userBereP";
	protected String usuarioT = "userBereT";
	protected String usuarioI = "inbursaqa6";
	protected String usuarioIn = "inbursaqa03";
	protected String usuarioInFact = "InbusaQa";
	protected String usuarioCronos = "cronosQA_0001";
	protected String usuarioInCronos = "testMaximo4";
	protected String contrasenaQa = "Qa654321*";
	protected String contrasena = "Demo#2023";
	protected String contrasenaIn = "Demo*2024";
	protected String correoF = "userBereF@yopmail.com";
	protected String correoI = "userBereI@yopmail.com";
	protected String correoP = "userBereP@yopmail.com";
	protected String correoConfirmacionP = "userBereP@yopmail.com";
	protected String correoT = "userBereT@yopmail.com";
	protected String correoBA = "qa_baz030@yopmail.com";
	protected String contrasenaBA = "QAba*2024";
	protected String usuarioInactivoI= "Qa_Inbursa";
	protected String usuarioInactivoF= "user_pruebas42";
	protected String usuarioInactivoP= "qapagoleal1";
	protected String usuarioInactivoT= "user_tokap21";
	protected String usuarioRegistroIn="QA_feen003";
	protected String contrasenaRegistroIn = "QAfe*2024";
	protected String usuarioRegistroF="FeeQaB";
	protected String contrasenaRegistro = "Demo#2023";
	protected String apellidoM ="Juarez";
	protected String telefono ="5522336611";
	protected String telefonoNumMen ="552233";
	protected String nombre ="Marco";
	protected String apellidoP ="Ortiz";
	protected String nombreComercio ="VentaRosa";
	protected String tarjetaVisa = "4152313486960805";
	protected String tarjetaMC = "5288439131136485";
	protected String tarjetaValeras = "6394840514485960";
	protected String tarjetaAMEX = "376718270701009";
	protected String RFCFisica = "GALJ800515XXX";
	protected String RFCMoral = "EJE123456ABC";
	protected String nombreTarjeta = "Juan San Martín";
	

	protected String defaultDownloadDirectory="src/test/resources/archivos para Pruebas/Downloads";
	

	Map<String, Object> prefs = new HashMap<String, Object>();
   

	@BeforeClass
	@Parameters("browserType")
	public void abrirNavegador(String browserType) throws InterruptedException {
		
		switch(browserType)
		{
		case "Edge":
			System.setProperty("webdriver.edge.driver", "src/test/resources/Edge/119.0.2151.58_edgedriver_win64/msedgedriver.exe");//windows
//			System.setProperty("webdriver.edge.driver", "src/test/resources/Edge/119.0.2151.58_edgedriver_mac64/msedgedriver");//mac
//			System.setProperty("webdriver.edge.driver", "src/test/resources/Edge/119.0.2151.58_edgedriver_linux64/msedgedriver");//linux
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--remote-allow-origins=*");
//		    edgeOptions.setHeadless(true);//linux
			navegador = new EdgeDriver(edgeOptions);
			Login = new Login(navegador);
			NuevoRegistro = new NuevoRegistro(navegador);
			NuevoRegistroPl = new NuevoRegistroPl(navegador);
			Contrasena = new OlvideMiContrasena(navegador);
			MiInformacion = new MiInformacion(navegador);
			VentaManual = new VentaManual(navegador);
			VentaDispositivo = new VentaDispositivo(navegador);
			Productos = new Productos(navegador);
			Cronos = new Cronos(navegador);
			break;
		
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Firefox/geckodriver-v0.33.0-win64/geckodriver.exe");//windows
//			System.setProperty("webdriver.gecko.driver", "src/test/resources/Firefox/geckodriver-linux/geckodriver");//linux
//			System.setProperty("webdriver.gecko.driver", "src/test/resources/Firefox/geckodriver-mac/geckodriver");//mac
			FirefoxOptions optionsFirefox =new FirefoxOptions();
//		    optionsFirefox.setHeadless(true);//linux
			navegador = new FirefoxDriver(optionsFirefox);
			Login = new Login(navegador);
			NuevoRegistro = new NuevoRegistro(navegador);
			NuevoRegistroPl = new NuevoRegistroPl(navegador);
			Contrasena = new OlvideMiContrasena(navegador);
			MiInformacion = new MiInformacion(navegador);
			VentaManual = new VentaManual(navegador);
			VentaDispositivo = new VentaDispositivo(navegador);
			Productos = new Productos(navegador);
			Cronos = new Cronos(navegador);
			break;
		case "chrome":
			File file = new File(defaultDownloadDirectory);
			 String absolutePath = file.getAbsolutePath();
			 System.out.println("Ruta absoluta: " + absolutePath);
			 System.setProperty("webdriver.chrome.driver", "src/test/resources/Chrome/chromedriver-win64/125.0.6422.113/chromedriver.exe");
			
			 prefs.put("download.default_directory",absolutePath);
			 prefs.put("download.prompt_for_download", false);
			 prefs.put("download.directory_upgrade", true);
			 prefs.put("safebrowsing.enabled", true);
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		    options.setExperimentalOption("prefs", prefs);
//			options.setHeadless(true);
			navegador = new ChromeDriver(options);
			Login = new Login(navegador);
			NuevoRegistro = new NuevoRegistro(navegador);
			NuevoRegistroPl = new NuevoRegistroPl(navegador);
			Contrasena = new OlvideMiContrasena(navegador);
			MiInformacion = new MiInformacion(navegador);
			VentaManual = new VentaManual(navegador);
			VentaDispositivo = new VentaDispositivo(navegador);
			Productos = new Productos(navegador);
			Cronos = new Cronos(navegador);
			break;
		}
		
		
	}
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
}
