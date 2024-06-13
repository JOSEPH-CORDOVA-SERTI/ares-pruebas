package mx.com.ares.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VentaDispositivo {
	
	public VentaDispositivo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(id="btnPayInLine")
	WebElement PagarenLinea;
	
	@FindBy(id="iNumBlue")
	WebElement iNumBlue;
	
	@FindBy(id="btnAddBlue")
	WebElement Agregar;
	
	@FindBy(id="opciones_2")
	WebElement listaProductos;
	
	@FindBy(id="txtMTotal")
	WebElement monto;
	
	@FindBy(xpath="//*[@id=\"a_collapseOne\"]/button")
	WebElement btnAceptar;
	
	@FindBy(xpath="//*[@id=\"btnCancelMonto\"]")
	WebElement btnLimpiar;
	
	@FindBy(id="txtName")
	WebElement tarjetahabiente;
	
	@FindBy(id="txtCardNumber")
	WebElement tarjeta;
	
	@FindBy(id="txtSecurityCode")
	WebElement cvv;
	
	@FindBy(id="sltMonth")
	WebElement expMonth;
	
	@FindBy(id="sltYear")
	WebElement expYear;
	
	@FindBy(id="btnPay")
	WebElement btnPagar;

	
	
	public WebElement PagarenLinea() {
		return PagarenLinea;
	}
	
	public WebElement iNumBlue() {
		return iNumBlue;
	}
	
	public WebElement Agregar() {
		return Agregar;
	}
	
	public WebElement listaProductos() {
		return listaProductos;
	}
	
	public WebElement monto() {
		return monto;
	}
	
	public WebElement btnAceptar() {
		return btnAceptar;
	}
	
	public WebElement btnLimpiar() {
		return btnLimpiar;
	}
	
	public WebElement tarjetahabiente() {
		return tarjetahabiente;
	}
	
	public WebElement tarjeta() {
		return tarjeta;
	}
	
	public WebElement cvv() {
		return cvv;
	}
	
	public WebElement expMonth() {
		return expMonth;
	}
	
	public WebElement expYear() {
		return expYear;
	}
	
	public WebElement btnPagar() {
		return btnPagar;
	}

	
}
