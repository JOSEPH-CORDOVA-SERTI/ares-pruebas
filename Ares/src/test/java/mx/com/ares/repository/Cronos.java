package mx.com.ares.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cronos {
	
	public Cronos(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	//###########################################Login###########################################
	
	@FindBy(xpath ="//*[@id=\"login\"]/div/div/h1")
	WebElement title;
	
	@FindBy(xpath ="//*[@id=\"login\"]/div/div/form/div[1]/label")
	WebElement labelUserName;
	
	@FindBy(xpath ="//*[@id=\"username\"]")
	WebElement userName;
	
	

	@FindBy(xpath ="//*[@id=\"login\"]/div/div/form/div[2]/label")
	WebElement labelPassword;
	
	@FindBy(xpath ="//*[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath ="//*[@id=\"login.button\"]")
	WebElement btnLogin;
	
	@FindBy(xpath ="//*[@id=\"login\"]/div/div/form/div[3]/div")
	WebElement notificacionLogin;
	
	@FindBy(xpath ="//*[@id=\"login\"]/div/div/form/small")
	WebElement textoLogin;
	
	////*[@id="loginCurrentYear"]
	
	@FindBy(xpath ="//*[@id=\"loginCurrentYear\"]")
	WebElement yearLogin;
	
	//###########################################DASHBOARD############################################

	@FindBy(xpath ="/html/body/div[1]/div/nav/a")
	WebElement navBarDashBoard;
	
	
	

	@FindBy(xpath ="/html/body/div[1]/div/nav/a")
	WebElement dropdownNavBarDashBoard;
	

	
	@FindBy(xpath ="//*[@id=\"sidebar\"]/div/div[1]/div[2]/div/div/div/a")
	WebElement titleMainSideBar;

	@FindBy(xpath ="//*[@id=\"sidebar\"]/div/div[1]/div[2]/div/div/div/ul/li[1]")
	WebElement titleSideBar;
	

	@FindBy(xpath ="//*[@id=\"sidebar\"]/div/div[1]/div[2]/div/div/div/ul/li[2]")
	WebElement sidebarDashboard;
	

	@FindBy(xpath ="//*[@id=\"sidebar\"]/div/div[1]/div[2]/div/div/div/ul/li[3]")
	WebElement title2Sidebar;
	

	@FindBy(xpath ="//*[@id=\"sidebar\"]/div/div[1]/div[2]/div/div/div/ul/li[5]")
	WebElement grupalsideBar;
	
	@FindBy(xpath =" //*[@id=\"dashboard\"]/div/div[1]/div[1]/h1")
	WebElement titleDashBoard;
	
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[1]/div/div/div/div[2]/div")
	WebElement titleTransacciones;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[1]/div/div/div/div[2]/h3")
	WebElement numberTransacciones;
	
	
	
	
	
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[2]/div/div/div/div[2]/div")
	WebElement titleAprobadas;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[2]/div/div/div/div[2]/h3")
	WebElement numberAprobadas;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[3]/div/div/div/div[2]/div")
	WebElement titleRechazadas;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[3]/div/div/div/div[2]/h3")
	WebElement numberRechazadas;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[4]/div/div/div/div[2]/div")
	WebElement titlePromedio;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[4]/div/div/div/div[2]/h3")
	WebElement numberPromedio;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[5]/div/div/div/div[2]/div")
	WebElement titleAprobado;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[5]/div/div/div/div[2]/h3")
	WebElement numberAprobado;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[6]/div/div/div/div[2]/div")
	WebElement titleReintentos;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[3]/div/div[6]/div/div/div/div[2]/h3")
	WebElement numberReintentos;
	
	
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[2]/div[1]/div/label")
	WebElement labelInicio;
	@FindBy(xpath ="//*[@id=\"startDate\"]")
	WebElement dateInicio;
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[2]/div[2]/div/label")
	WebElement labelFin;
	@FindBy(xpath ="//*[@id=\"endDate\"]")
	WebElement datefin;
	
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[2]/div[3]/button")
	WebElement btnBuscar;
	
	
//  #highcharts-f76dagx-56 > svg > text.highcharts-credits
	
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[4]/div[1]/div")
	WebElement grafica1;
	
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[4]/div[2]/div")
	WebElement grafica2;
	
	//*[@id="highcharts-ixlih17-0"]/svg/text[4]

	
	
	
	 // /html/body/div[1]/div/main/div/div[4]/div[1]/div/div/div/svg/text[4]
	@FindBy(xpath = "/html/body/div[1]/div/main/div/div[4]/div[1]/div/div/div/svg/text[4]")
	WebElement grafica1link;
	
	@FindBy(css ="svg>text.highcharts-title")
	WebElement grafica2link;


	// /html/body/div[1]/div/footer/div/div/div[2]/p/a
	
	@FindBy(xpath ="/html/body/div[1]/div/footer/div/div/div[2]/p/a")
	WebElement linkFeenicia;
	
	//###########################################Individual###########################################
	
	@FindBy(xpath ="/html/body/div[1]/div/nav/a")
	WebElement menuHamburguesa;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/div/div[1]/h1")
	WebElement titleAgrgarIndividual;
	
	@FindBy(xpath ="//*[@id=\"sidebar\"]/div/div[1]/div[2]/div/div/div/ul/li[4]/a")
	WebElement desplegableIndividual;
	
	@FindBy(xpath ="//*[@id=\"individual\"]/li[1]/a")
	WebElement agregarIndividual;
	
	@FindBy(xpath ="//*[@id=\"individual\"]/li[2]/a")
	WebElement consultarIndividual;
	
	@FindBy(xpath ="//*[@id=\"idPlan\"]")
	WebElement desplegableTipoDePlan;
	
	@FindBy(xpath ="//*[@id=\"planUnit\"]")
	WebElement recurrencia;
//	
	
	
	
	@FindBy(xpath ="/html/body/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[1]")
	WebElement calendario;
	
	
	
	@FindBy(xpath ="//*[@id=\"startDate\"]")
	WebElement fechaDeInicio;
	
	@FindBy(xpath ="//*[@id=\"amount\"]")
	WebElement monto;
	
	@FindBy(xpath ="//*[@id=\"reference\"]")
	WebElement referencia;
	
	@FindBy(xpath ="//*[@id=\"cardHolderName\"]")
	WebElement nombreTarjeta;
	
	@FindBy(xpath ="//*[@id=\"pan\"]")
	WebElement numeroTarjeta;
	
	@FindBy(xpath ="//*[@id=\"month\"]")
	WebElement mesExp;
	
	@FindBy(xpath ="//*[@id=\"year\"]")
	WebElement anioExp;
	
	@FindBy(xpath ="//*[@id=\"cvv\"]")
	WebElement cvvOpcional;
	
	@FindBy(xpath ="//*[@id=\"email\"]")
	WebElement emailOpcional;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[2]/div/button")
	WebElement btnIniciar;
	
	@FindBy(xpath ="//*[@id=\"dashboard\"]/div/div[1]/div[1]/h1")
	WebElement titleDashboard;

	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/div/div[2]/div/div[2]")
	WebElement notificacionAgregar;

	@FindBy(xpath ="//*[@id=\"get\"]/div/div[2]/div/div[2]/div[1]/h3")
	WebElement titleDatosSuscripcion;
	
	
	
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[2]/h3")
	WebElement titleDatosBancarios;
	
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[2]/div[1]/label")
	WebElement labelNombreTarjeta;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[2]/div[2]/label")
	WebElement labelNumeroTarjeta;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[2]/div[3]/label")
	WebElement labelexpiracion;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[2]/div[4]/label")
	WebElement labelCVV;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[2]/div[5]/label")
	WebElement labelEmail;
	
	
	
	
	
	
	
	
	
	
	
	
	

	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/div/div[2]/div/div[1]")
	WebElement alert;
	
	 
//######################################################grupal###################################################//
	

	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/div/div[1]/h1")
	WebElement titleGrupal;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[1]/h3")
	WebElement titleDatos;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[1]/div[1]/label")
	WebElement labelTipoPlan;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[1]/div[2]/label")
	WebElement labelRecurrencia;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[1]/div[3]/label")
	WebElement labelInicioGrupal;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[1]/div[4]/label")
	WebElement labelMonto;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[1]/div[5]/label")
	WebElement labelReintentos;

	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[1]/div[6]/label")
	WebElement labelReferencia;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[2]/a")
	WebElement linkDescargarFormato;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[2]/div/label[1]")
	WebElement labelArchivo;
	
	@FindBy(xpath ="//*[@id=\"subscribe\"]/div/form/div[1]/div[2]/div/label[2]")
	WebElement labelCsv;
	
	@FindBy(xpath ="//*[@id=\"fileInput\"]")
	WebElement inputDragandDrop;
	
	@FindBy(xpath ="//*[@id=\"paymentRetries\"]")
	WebElement inputReintentos;
	
	
	
	
	@FindBy(xpath ="//*[@id=\"grupal\"]/li[1]/a")
	WebElement agregarGrupal;
	
	@FindBy(xpath ="//*[@id=\"grupal\"]/li[2]")
	WebElement consultarGrupal;
	
//########################consultar grupal#######################################
	
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[1]/div[1]/h1")
	WebElement titleConsultarGrupal;
	
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[1]/div[1]/button")
	WebElement btnFiltrar;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[1]/div[2]/div/label")
	WebElement labelMostrar;
	

	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[1]/div[2]/div/div/select")
	WebElement desplegableMostrar;
	
	
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[1]/div[3]/button")
	WebElement btnDescargar;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[1]")
	WebElement columnaID;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[2]")
	WebElement columnaReferencia;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[3]")
	WebElement columnaPlan;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[4]")
	WebElement columnaMonto;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[5]")
	WebElement columnaInicio;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[6]")
	WebElement columnaFin;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[7]")
	WebElement columnaRegistro;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[8]")
	WebElement columnasuscripcioneso;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[9]")
	WebElement columnaProcesado;
	
	
	
	
	
	
	
	//##############################################filtro suscripcion grupal##################################################
	
	
	

	
	
	

	
	
	
	
	
	
	@FindBy(xpath ="//*[@id=\"filtros\"]/div[1]/input")
	WebElement filtroReferencia;
	
	
	@FindBy(xpath ="//*[@id=\"filtros\"]/div[2]/select")
	WebElement filtroPlan;
	
	
	@FindBy(xpath ="//*[@id=\"filtros\"]/div[3]/input")
	WebElement filtroMonto;
	
	@FindBy(xpath ="//*[@id=\"filtersStartDate\"]")
	WebElement filtroFechaInicio;
	
	@FindBy(xpath ="//*[@id=\"filtersEndDate\"]")
	WebElement filtroFechaFin;
	
	@FindBy(xpath ="//*[@id=\"filtersRegisterDate\"]")
	WebElement filtroFechaRegistro;
	
	@FindBy(xpath ="//*[@id=\"filtros\"]/div[4]/input")
	WebElement filtroGrupal;
	
	
	           
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")
	WebElement referencia1;
	
	// //*[@id="getList"]/div[1]/div/main/div/div[2]/div[2]/table/tbody/tr[25]/td[2]
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/tbody/tr[25]/td[2]")
	WebElement referencia25;
	
	
	@FindBy(xpath ="//*[@id=\"filtros\"]/button[1]")
	WebElement btnAplicarFiltro;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[1]/div[2]/div/div[2]")
	WebElement notiConsultarGrupal;
	
	
	//*[@id="filtros"]/button[2]
	
	@FindBy(xpath ="//*[@id=\"filtros\"]/button[2]")
	WebElement btnBorrarFiltro;
	
	
	
	//*[@id="getList"]/div[1]/div/main/div/div[2]/div[2]/table/tbody/tr[1]/td[9]/i
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/tbody/tr[1]/td[9]/i")
	WebElement visualizarSuscripcionIndividual;
	
	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/tbody/tr[1]/td[8]/div")
	WebElement etiquetaIndividual;
	
	
////*[@id="highcharts-f76dagx-62"]/svg/g[8]/g/g/g[1]/path[2]
	
	//*[@id="filtros"]/div[2]/div[2]/select
	
	@FindBy(xpath ="//*[@id=\"filtros\"]/div[2]/div[2]/select")
	WebElement estadoIndividual;
	
	
	
	
	@FindBy(xpath ="//*[@id=\"get\"]/div/div[2]/div/div[2]/div[1]/div[2]/button[2]")
	WebElement btnCancelarSubVisualizada;
	
	
	@FindBy(xpath ="//*[@id=\"get\"]/div/div[2]/div/div[2]/div[1]/div[2]/button[1]")
	WebElement btnRenovar;
	
	@FindBy(xpath ="//*[@id=\"subscriptionCancelModal\"]/div/div/div/div/button[2]")
	WebElement btnCancelarCancelar;
	@FindBy(xpath ="//*[@id=\"subscriptionCancelModal\"]/div/div/div/div/button[1]")
	WebElement btnConfirmarCancelar;
	
	@FindBy(xpath ="//*[@id=\"subscriptionRenovateModal\"]/div/div/div/div/div[2]/button[1]")
	WebElement btnConfirmarRenovar;
	@FindBy(xpath ="//*[@id=\"subscriptionRenovateModal\"]/div/div/div/div/div[2]/button[2]")
	WebElement btnCancelarRenovar;
	
	
	
	//*[@id="get"]/div/div[2]/div/div[1]
	
	@FindBy(xpath ="//*[@id=\"get\"]/div/div[2]/div/div[1]")
	WebElement etiquetaCancelada;
	
	
	@FindBy(xpath ="//*[@id=\"get\"]/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/dl/dd[4]")
	WebElement fechaRenovacion;
	
	
	
	
	
	public WebElement getBtnCancelarSubVisualizada() {
		return btnCancelarSubVisualizada;
	}



	public WebElement getBtnRenovar() {
		return btnRenovar;
	}



	public WebElement getBtnCancelarCancelar() {
		return btnCancelarCancelar;
	}



	public WebElement getEtiquetaCancelada() {
		return etiquetaCancelada;
	}



	public WebElement getFechaRenovacion() {
		return fechaRenovacion;
	}



	public WebElement getBtnConfirmarCancelar() {
		return btnConfirmarCancelar;
	}



	public WebElement getBtnConfirmarRenovar() {
		return btnConfirmarRenovar;
	}



	public WebElement getBtnCancelarRenovar() {
		return btnCancelarRenovar;
	}



	public WebElement getVisualizarSuscripcionIndividual() {
		return visualizarSuscripcionIndividual;
	}



	public WebElement getEstadoIndividual() {
		return estadoIndividual;
	}



	public WebElement getLinkFeenicia() {
		return linkFeenicia;
	}



	public WebElement getEtiquetaIndividual() {
		return etiquetaIndividual;
	}



	public WebElement getFiltroGrupal() {
		return filtroGrupal;
	}



	public WebElement getReferencia25() {
		return referencia25;
	}

	public WebElement getBtnBorrarFiltro() {
		return btnBorrarFiltro;
	}

	public WebElement getGrafica1link() {
		return grafica1link;
	}

	public WebElement getGrafica2link() {
		return grafica2link;
	}

	public WebElement getNotiConsultarGrupal() {
		return notiConsultarGrupal;
	}

	public WebElement getBtnAplicarFiltro() {
		return btnAplicarFiltro;
	}

	public WebElement getReferencia1() {
		return referencia1;
	}

	public WebElement getFiltroReferencia() {
		return filtroReferencia;
	}

	public WebElement getFiltroPlan() {
		return filtroPlan;
	}

	public WebElement getFiltroMonto() {
		return filtroMonto;
	}

	public WebElement getFiltroFechaInicio() {
		return filtroFechaInicio;
	}

	public WebElement getFiltroFechaFin() {
		return filtroFechaFin;
	}

	public WebElement getFiltroFechaRegistro() {
		return filtroFechaRegistro;
	}

	public WebElement getAlert() {
		return alert;
	}
	
	public WebElement getCalendario() {
		return calendario;
	}

	
	public WebElement getTitleDatosBancarios() {
		return titleDatosBancarios;
	}


	public WebElement getLabelNombreTarjeta() {
		return labelNombreTarjeta;
	}


	public WebElement getLabelNumeroTarjeta() {
		return labelNumeroTarjeta;
	}


	public WebElement getLabelexpiracion() {
		return labelexpiracion;
	}


	public WebElement getLabelCVV() {
		return labelCVV;
	}


	public WebElement getLabelEmail() {
		return labelEmail;
	}


	public WebElement getBtnFiltrar() {
		return btnFiltrar;
	}


	public WebElement getLabelMostrar() {
		return labelMostrar;
	}


	public WebElement getDesplegableMostrar() {
		return desplegableMostrar;
	}


	public WebElement getBtnDescargar() {
		return btnDescargar;
	}


	public WebElement getColumnaID() {
		return columnaID;
	}


	public WebElement getColumnaReferencia() {
		return columnaReferencia;
	}


	public WebElement getColumnaPlan() {
		return columnaPlan;
	}


	public WebElement getColumnaMonto() {
		return columnaMonto;
	}


	public WebElement getColumnaInicio() {
		return columnaInicio;
	}


	public WebElement getColumnaFin() {
		return columnaFin;
	}


	public WebElement getColumnaRegistro() {
		return columnaRegistro;
	}


	public WebElement getColumnasuscripcioneso() {
		return columnasuscripcioneso;
	}


	public WebElement getColumnaProcesado() {
		return columnaProcesado;
	}


	public WebElement getListaPaginas() {
		return listaPaginas;
	}

	@FindBy(xpath ="//*[@id=\"getList\"]/div[1]/div/main/div/div[2]/div[2]/table/thead/tr/th[9]")
	WebElement listaPaginas;
	
	
	
	
	
	
	
	public WebElement getTitleConsultarGrupal() {
		return titleConsultarGrupal;
	}


	public WebElement getAgregarGrupal() {
		return agregarGrupal;
	}


	public WebElement getConsultarGrupal() {
		return consultarGrupal;
	}


	public WebElement getLabelUserName() {
		return labelUserName;
	}


	public WebElement getTitleGrupal() {
		return titleGrupal;
	}


	public WebElement getTitleDatos() {
		return titleDatos;
	}


	public WebElement getLabelTipoPlan() {
		return labelTipoPlan;
	}


	public WebElement getLabelRecurrencia() {
		return labelRecurrencia;
	}


	public WebElement getLabelInicioGrupal() {
		return labelInicioGrupal;
	}


	public WebElement getLabelMonto() {
		return labelMonto;
	}


	public WebElement getLabelReintentos() {
		return labelReintentos;
	}


	public WebElement getLabelReferencia() {
		return labelReferencia;
	}


	public WebElement getLinkDescargarFormato() {
		return linkDescargarFormato;
	}


	public WebElement getLabelArchivo() {
		return labelArchivo;
	}


	public WebElement getLabelCsv() {
		return labelCsv;
	}


	public WebElement getInputDragandDrop() {
		return inputDragandDrop;
	}


	public WebElement getInputReintentos() {
		return inputReintentos;
	}


	public WebElement getNavBarDashBoard() {
		return navBarDashBoard;
	}


	public WebElement getTitleMainSideBar() {
		return titleMainSideBar;
	}


	public WebElement getDropdownNavBarDashBoard() {
		return dropdownNavBarDashBoard;
	}





	
	
	public WebElement getTitleReintentos() {
		return titleReintentos;
	}


	public WebElement getNumberReintentos() {
		return numberReintentos;
	}


	public WebElement getTitleSideBar() {
		return titleSideBar;
	}


	public WebElement getSidebarDashboard() {
		return sidebarDashboard;
	}


	public WebElement getTitle2Sidebar() {
		return title2Sidebar;
	}


	public WebElement getGrupalsideBar() {
		return grupalsideBar;
	}


	public WebElement getTitleDashBoard() {
		return titleDashBoard;
	}


	public WebElement getTitleTransacciones() {
		return titleTransacciones;
	}


	public WebElement getNumberTransacciones() {
		return numberTransacciones;
	}


	public WebElement getTitleAprobadas() {
		return titleAprobadas;
	}


	public WebElement getNumberAprobadas() {
		return numberAprobadas;
	}


	public WebElement getTitleRechazadas() {
		return titleRechazadas;
	}


	public WebElement getNumberRechazadas() {
		return numberRechazadas;
	}


	public WebElement getTitlePromedio() {
		return titlePromedio;
	}


	public WebElement getNumberPromedio() {
		return numberPromedio;
	}


	public WebElement getTitleAprobado() {
		return titleAprobado;
	}


	public WebElement getNumberAprobado() {
		return numberAprobado;
	}


	public WebElement getLabelInicio() {
		return labelInicio;
	}


	public WebElement getDateInicio() {
		return dateInicio;
	}


	public WebElement getLabelFin() {
		return labelFin;
	}


	public WebElement getDatefin() {
		return datefin;
	}


	public WebElement getBtnBuscar() {
		return btnBuscar;
	}


	public WebElement getGrafica1() {
		return grafica1;
	}


	public WebElement getGrafica2() {
		return grafica2;
	}


	public WebElement getLabelUser() {
		return labelUserName;
	}
	
	public WebElement getYearLogin() {
		return yearLogin;
	}
	public WebElement getLabelPassword() {
		return labelPassword;
	}
	
	
	public WebElement getTitleLogin() {
		return title;
	}

	public WebElement getTextLogin() {
		return textoLogin;
	}

	
	public WebElement getTitleDatosSuscripcion() {
		return titleDatosSuscripcion;
	}

	public WebElement getNotificacionAgregar() {
		return notificacionAgregar;
	}

	public WebElement getTitleAgrgarIndividual() {
		return titleAgrgarIndividual;
	}

	public WebElement getTitleDashboard() {
		return titleDashboard;
	}
	
	public WebElement getNotificacionLogin() {
		return notificacionLogin;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getMenuHamburguesa() {
		return menuHamburguesa;
	}

	public WebElement getDesplegableIndividual() {
		return desplegableIndividual;
	}

	public WebElement getAgregarIndividual() {
		return agregarIndividual;
	}

	public WebElement getConsultarIndividual() {
		return consultarIndividual;
	}

	public WebElement getDesplegableTipoDePlan() {
		return desplegableTipoDePlan;
	}

	public WebElement getRecurrencia() {
		return recurrencia;
	}

	public WebElement getFechaDeInicio() {
		return fechaDeInicio;
	}

	public WebElement getMonto() {
		return monto;
	}

	public WebElement getReferencia() {
		return referencia;
	}

	public WebElement getNombreTarjeta() {
		return nombreTarjeta;
	}

	public WebElement getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public WebElement getMesExp() {
		return mesExp;
	}

	public WebElement getAnioExp() {
		return anioExp;
	}

	public WebElement getCvvOpcional() {
		return cvvOpcional;
	}

	public WebElement getEmailOpcional() {
		return emailOpcional;
	}

	public WebElement getBtnIniciar() {
		return btnIniciar;
	}
	
	
}
