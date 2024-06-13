package mx.com.ares.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productos {
	
	public Productos(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	@FindBy(xpath ="/html/body/ul/li/div/div")
	WebElement sinProductos;
	
	@FindBy(xpath ="/html/body/ul/li[1]/div/div")
	WebElement notiEditar;
	
	@FindBy(xpath ="/html/body/ul/li[1]/div")
	WebElement notiImagen;
	
	@FindBy(xpath ="/html/body/ul/li[1]/div/div")
	WebElement notiEliminar;
	
	
	@FindBy(xpath = "//*[@id=\"containerProducts\"]/div/div/div/h3")
	WebElement tituloProductoAgregado;
	
	@FindBy(xpath = "//*[@id=\"containerProducts\"]/div/div/div/p")
	WebElement precioProductoAgregado;
	
	@FindBy(id = "btnMenuAddProduct")
	WebElement botonAgregarProducto;
	
	@FindBy(id = "myModalLabel")
	WebElement tituloProducto;
	
	@FindBy(id = "aProduct")
	WebElement seccionProductos;
	
	@FindBy(id = "txtProdName")
	WebElement nombreProducto;
	
	@FindBy(id = "txtProdPrice")
	WebElement precioProducto;
	
	@FindBy(id = "tags_tagsinput")
	WebElement tagProducto;
	
	@FindBy(id = "txtProdDescription")
	WebElement descripcionProducto;
	
	@FindBy(id = "btnAddProduct")
	WebElement btnGuardaProducto;
	
	@FindBy(id = "btnCrop")
	WebElement botonGuardarImagen;
	
	@FindBy(xpath ="//*[@id=\"file2\"]")
	WebElement botonAgregarImagen;
	
	@FindBy(xpath ="//*[@id=\"containerProducts\"]/div/div/div/div/a[1]")
	WebElement botonEditarProducto;
	
	@FindBy(xpath ="//*[@id=\"containerProducts\"]/div/div/div/div/a[2]")
	WebElement botonBorrarProducto;
	
	
	
	public WebElement BotonBorrarProducto() {
		return botonBorrarProducto;
	}
	
	public WebElement NotificacionBorrarProducto() {
		return notiEliminar;
	}
	
	public WebElement NotificacionGuardarImagen() {
		return notiImagen;
	}
	
	public WebElement NotificacionEditarProducto() {
		return notiEditar;
	}
	
	public WebElement BotonEditarProducto() {
		return botonEditarProducto;
	}
	
	public WebElement PrecioProductoAgregado() {
		return precioProductoAgregado;
	}
	
	public WebElement TituloProductoAgregado() {
		return tituloProductoAgregado;
	}
	
	public WebElement BotonAgregarImagen() {
		return botonAgregarImagen;
	}
	
	public WebElement BotonGuardarImagen() {
		return botonGuardarImagen;
	}
	
	public WebElement BotonGuardaProducto() {
		return btnGuardaProducto;
	}
	
	public WebElement DescripcionProducto() {
		return descripcionProducto;
	}
	
	public WebElement TagProducto() {
		return tagProducto;
	}
	
	public WebElement PrecioProducto() {
		return precioProducto;
	}
	
	public WebElement NombreProducto() {
		return nombreProducto;
	}
	
	public WebElement TituloProducto() {
		return tituloProducto;
	}
	
	public WebElement SeccionProductos() {
		return seccionProductos;
	}
	
	public WebElement BotonAgregarProducto() {
		return botonAgregarProducto;
	}
	
	public WebElement MensajeSinProductos() {
		return sinProductos;
	}
}
