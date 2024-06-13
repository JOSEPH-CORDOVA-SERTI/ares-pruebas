package mx.com.ares.testcases.producto;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import mx.com.ares.base.Base;

public class PantallaProductosFuncionalFe extends Base {
	String mensajeVacio = "Aún no hay productos registrados en tu comercio. ¡Agrégalos y ofrece más opciones a tus clientes!";
	String nombre = "Sudadera";
	String precio = "90";
	String descripcion = "Sudadera color azul, 100% algodón";
	String nuevoNombre = "Pantalon";
	String nuevoPrecio = "280";
	String precioVacio = "Ingrese el precio del Producto";
	String nombreVacio = "Ingrese Nombre de producto";
	String precioCero = "Recuerda que el precio tiene que ser mayor a cero(0).";
	String notiVacia= "Ingrese la Descripción del Producto";
	String notiImagen = "Tu imagen ha sido agregada correctamente.";
	String imagenInvalida = "Los archivos con esta extensión no son permitidos";
	String notiBorrar = "No se encontró ningún producto";
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
		navegador.get("https://www.feenicia.net/Fnza_SSO/Account/signin");
		Login.UsuarioElement().sendKeys("user_feen3");
		Login.ContrasenaElement().sendKeys("Demo*2023");
		Login.IngresarElement().click();
		navegador.manage().window().maximize();
	}
	
	
	@AfterClass
	public void cerrarNavegador() {
		navegador.close();
	}
	
	@Test(description="Notificación de la sección productos cuando no se ha agregado ninguno ",enabled = true, priority = 1)
	public void sinProductos() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Productos.SeccionProductos()));
		Productos.SeccionProductos().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.MensajeSinProductos()));
		String mensaje = Productos.MensajeSinProductos().getText();
		Assert.assertEquals(mensaje, mensajeVacio);
	}
	
	@Test(description="Agregar producto, nombre vacío",enabled = true, priority = 2)
	public void agregarProductosNombreVacio() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		Productos.BotonAgregarProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.TituloProducto()));
		Productos.PrecioProducto().sendKeys(precio);
		Productos.DescripcionProducto().sendKeys(descripcion);
		Productos.BotonGuardaProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.MensajeSinProductos()));
		String mensaje = Productos.MensajeSinProductos().getText();
		Assert.assertEquals(mensaje, nombreVacio);
	}
	@Test(description="Agregar producto, precio vacío",enabled = true, priority = 3)
	public void agregarProductosPrecioVacio() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		Productos.NombreProducto().clear();
		Productos.PrecioProducto().clear();
		Productos.DescripcionProducto().clear();
		Productos.NombreProducto().sendKeys(nombre);
		Productos.DescripcionProducto().sendKeys(descripcion);
		Productos.BotonGuardaProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.MensajeSinProductos()));
		String mensaje = Productos.MensajeSinProductos().getText();
		Assert.assertEquals(mensaje, precioVacio);
	}
	
	@Test(description="Agregar producto, descripción vacío",enabled = true, priority = 4)
	public void agregarProductosDescripcionVacio() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		Productos.NombreProducto().clear();
		Productos.PrecioProducto().clear();
		Productos.DescripcionProducto().clear();
		Productos.NombreProducto().sendKeys(nombre);
		Productos.PrecioProducto().sendKeys(precio);
		Productos.BotonGuardaProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.NotificacionEditarProducto()));
		String mensaje = Productos.NotificacionEditarProducto().getText();
		Assert.assertEquals(mensaje, notiVacia);
	}
	
	@Test(description="Agregar imagen de producto con formato invalido",enabled = true, priority = 5)
	public void agregarProductosImagenInvalida() throws InterruptedException, AWTException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		WebElement spanElement = navegador.findElement(By.cssSelector("span.btn.btn-primary.btn-file"));
	    spanElement.click();
	    Thread.sleep(2000);
	    String rutaImagen = "C:\\Proyectos\\Ares\\src\\test\\resources\\archivos para Pruebas\\prueba1.txt";

	    // Copiar la ruta de la imagen al portapapeles
	    StringSelection seleccion = new StringSelection(rutaImagen);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);

	    // Crear una instancia de Robot para manejar la interacción del teclado
	    Robot robot = new Robot();

	    // Pegar la ruta de la imagen desde el portapapeles en el cuadro de diálogo del explorador de archivos
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);

	    // Presionar la tecla Enter para confirmar la selección de archivo
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);

	    // Esperar un breve período para que la imagen se cargue completamente
	    Thread.sleep(2000);
	    ewait.until(ExpectedConditions.visibilityOf(Productos.NotificacionGuardarImagen()));
	    String mensaje = Productos.NotificacionGuardarImagen().getText();
	    mensaje = mensaje.replace("×", "");


	    Assert.assertEquals(mensaje.trim(), imagenInvalida);
	}
	
	@Test(description="Agregar imagen de producto",enabled = true, priority = 6)
	public void agregarProductosImagen() throws InterruptedException, AWTException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		WebElement spanElement = navegador.findElement(By.cssSelector("span.btn.btn-primary.btn-file"));
	    spanElement.click();

	    // Esperar un breve período para que el explorador de archivos se abra completamente
	    Thread.sleep(2000);

	    // Ruta de la imagen que deseas subir
	    String rutaImagen = "C:\\Proyectos\\Ares\\src\\test\\resources\\archivos para Pruebas\\Sudadera.jpg";

	    // Copiar la ruta de la imagen al portapapeles
	    StringSelection seleccion = new StringSelection(rutaImagen);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);

	    // Crear una instancia de Robot para manejar la interacción del teclado
	    Robot robot = new Robot();

	    // Pegar la ruta de la imagen desde el portapapeles en el cuadro de diálogo del explorador de archivos
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);

	    // Presionar la tecla Enter para confirmar la selección de archivo
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);

	    // Esperar un breve período para que la imagen se cargue completamente
	    Thread.sleep(2000);
	    Productos.BotonGuardarImagen().click();
	    Productos.BotonGuardarImagen().click();
	    ewait.until(ExpectedConditions.visibilityOf(Productos.NotificacionGuardarImagen()));
	    String mensaje = Productos.NotificacionGuardarImagen().getText();
	    mensaje = mensaje.replace("×", "");
	    Assert.assertEquals(mensaje.trim(), notiImagen);
	}
	
	@Test(description="Agregar producto",enabled = true, priority = 8)
	public void agregarProductos() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		Productos.NombreProducto().clear();
		Productos.PrecioProducto().clear();
		Productos.DescripcionProducto().clear();
		Productos.NombreProducto().sendKeys(nombre);
		Productos.PrecioProducto().sendKeys(precio);
		Productos.DescripcionProducto().sendKeys(descripcion);
		Productos.BotonGuardaProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.TituloProductoAgregado()));
		String mensaje = Productos.TituloProductoAgregado().getText();
		String mensaje2 = Productos.PrecioProductoAgregado().getText();
		Assert.assertEquals(mensaje, nombre);
		Assert.assertEquals(mensaje2, "$ " + precio + ".00");
	}
	//@Test(description="Agregar producto, nombre repetido",enabled = true, priority = 9)

	
	@Test(description="Editar producto dejando el precio vacio",enabled = true, priority = 10)
	public void editarProductosPrecioVacio() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Productos.BotonEditarProducto()));
		Productos.BotonEditarProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.TituloProducto()));
		Thread.sleep(2000);
		Productos.NombreProducto().clear();
		Productos.PrecioProducto().clear();
		Productos.DescripcionProducto().clear();
		Productos.NombreProducto().sendKeys(nuevoNombre);
		Productos.DescripcionProducto().sendKeys(descripcion);
		Productos.BotonGuardaProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.NotificacionEditarProducto()));
		String mensaje = Productos.NotificacionEditarProducto().getText();
		Assert.assertEquals(mensaje, precioVacio);

	}
	@Test(description="Editar producto dejando el nombre vacio",enabled = true, priority = 11)
	public void editarProductosNombreVacio() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Productos.TituloProducto()));
		Thread.sleep(2000);
		Productos.NombreProducto().clear();
		Productos.PrecioProducto().clear();
		Productos.DescripcionProducto().clear();
		Productos.PrecioProducto().sendKeys(nuevoPrecio);
		Productos.DescripcionProducto().sendKeys(descripcion);
		Productos.BotonGuardaProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.NotificacionEditarProducto()));
		String mensaje = Productos.NotificacionEditarProducto().getText();
		Assert.assertEquals(mensaje, nombreVacio);
	}
	@Test(description="Editar producto dejando precio en 0",enabled = true, priority = 12)
	public void editarProductosPrecioCero() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		Thread.sleep(2000);
		Productos.NombreProducto().clear();
		Productos.PrecioProducto().clear();
		Productos.DescripcionProducto().clear();
		Productos.NombreProducto().sendKeys(nuevoNombre);
		Productos.PrecioProducto().sendKeys("0");
		Productos.DescripcionProducto().sendKeys(descripcion);
		Productos.BotonGuardaProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.NotificacionEditarProducto()));
		String mensaje = Productos.NotificacionEditarProducto().getText();
		Assert.assertEquals(mensaje, precioCero);
	}
	@Test(description="Editar producto",enabled = true, priority = 13)
	public void editarProductosExitosamente() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		navegador.navigate().refresh();
		ewait.until(ExpectedConditions.visibilityOf(Productos.TituloProducto()));
		Thread.sleep(2000);
		String textoCampoNombreProducto = Productos.NombreProducto().getAttribute("value");
		String textoCampoPrecioProducto = Productos.NombreProducto().getAttribute("value");
		String textoCampoDescripcionProducto = Productos.NombreProducto().getAttribute("value");
		Assert.assertEquals(textoCampoNombreProducto, nombre);
		Assert.assertEquals(textoCampoPrecioProducto, nombre);
		Assert.assertEquals(textoCampoDescripcionProducto, nombre);
		Productos.NombreProducto().clear();
		Productos.PrecioProducto().clear();
		Productos.DescripcionProducto().clear();
		Productos.NombreProducto().sendKeys(nuevoNombre);
		Productos.PrecioProducto().sendKeys(nuevoPrecio);
		Productos.DescripcionProducto().sendKeys(descripcion);
		Productos.BotonGuardaProducto().click();
		ewait.until(ExpectedConditions.visibilityOf(Productos.TituloProductoAgregado()));
		String mensaje = Productos.TituloProductoAgregado().getText();
		String mensaje2 = Productos.PrecioProductoAgregado().getText();
		Assert.assertEquals(mensaje, nuevoNombre);
		Assert.assertEquals(mensaje2, "$ " + nuevoPrecio + ".00");
	}
	
	
	@Test(description="Cancelar borrado de producto",enabled = true, priority = 14)
	public void cancelarBorrarProductos() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Productos.BotonBorrarProducto()));
		Productos.BotonBorrarProducto().click();
		navegador.switchTo().alert().dismiss();
		ewait.until(ExpectedConditions.visibilityOf(Productos.TituloProductoAgregado()));
		String mensaje = Productos.TituloProductoAgregado().getText();
		String mensaje2 = Productos.PrecioProductoAgregado().getText();
		Assert.assertEquals(mensaje, nuevoNombre);
		Assert.assertEquals(mensaje2, "$ " + nuevoPrecio + ".00");
	}
	@Test(description="Confirmación para borrar producto",enabled = true, priority = 15)
	public void BorrarProductos() throws InterruptedException {
		WebDriverWait ewait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(Productos.BotonBorrarProducto()));
		Productos.BotonBorrarProducto().click();
		navegador.switchTo().alert().accept();
		Thread.sleep(3000);
		
		String mensaje = Productos.NotificacionGuardarImagen().getText();
		mensaje = mensaje.replace("×", "");
		Assert.assertEquals(mensaje.trim(), notiBorrar);
	}	
}
