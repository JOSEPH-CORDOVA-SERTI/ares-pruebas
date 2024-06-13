package mx.com.ares.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VentaManual {
	
	public VentaManual(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	@FindBy(id="aSales")
	WebElement venta;
	
	@FindBy(id="sltAfiliation")
	WebElement afiliacion;
	
	@FindBy(xpath="//*[@id=\"sltAfiliation\"]/option[2]")
	WebElement affSelececion;
	
	@FindBy(id="opciones_1")
	WebElement montoFijo;
	
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
	
	@FindBy(id="btnCancel2")
	WebElement btnCancelar;
	
	@FindBy(xpath="/html/body/ul/li[1]/div")
	WebElement ventaExitosa;
	
	@FindBy(id="checkMSI")
	WebElement checkMSI;
	
	@FindBy(id="opc1")
	WebElement opc1;
	
	@FindBy(id="opc2")
	WebElement opc2;
	
	@FindBy(id="opc3")
	WebElement opc3;
	
	@FindBy(id="opc4")
	WebElement opc4;
	
	@FindBy(id="cbxConcept_chosen")
	WebElement listado;
	
	@FindBy(id="cbxConcept")
	WebElement listado1;
	
	@FindBy(id="txtQuantity")
	WebElement txtQuantity;
	
	@FindBy(id="btnAdd")
	WebElement btnAgregar;
	
	public WebElement ventaManual() {
		return venta;
	}
	
	public WebElement afiliacion() {
		return afiliacion;
	}
	
	public WebElement affSelececion() {
		return affSelececion;
	}
	
	public WebElement montoFijo() {
		return montoFijo;
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
	
	public WebElement btnCancelar() {
		return btnCancelar;
	}
	
	public WebElement ventaExitosa() {
		return ventaExitosa;
	}
	
	public WebElement checkMSI() {
		return checkMSI;
	}
	
	public WebElement opc1() {
		return opc1;
	}
	
	public WebElement opc2() {
		return opc2;
	}
	
	public WebElement opc3() {
		return opc3;
	}
	
	public WebElement opc4() {
		return opc4;
	}
	
	public WebElement listado() {
		return listado;
	}
	
	public WebElement listado1() {
		return listado1;
	}
	
	public WebElement txtQuantity() {
		return txtQuantity;
	}

	public WebElement btnAgregar() {
		return btnAgregar;
	}
	
}
