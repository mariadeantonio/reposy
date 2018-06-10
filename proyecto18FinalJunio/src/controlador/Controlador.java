package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import modelo.DevolucionDTO;
import modelo.FanDTO;
import modelo.ParticipanteDTO;
import modelo.PerdidasDTO;
import modelo.ProductoDTO;
import modelo.VentaDTO;
import modeloDAO.FansDAO;
import modeloDAO.ParticipanteDAO;
import modeloDAO.DevolucionDAO;
import modeloDAO.PerdidasDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;
import vista.PanelLogin;
import vista.SplitPan;
import vista.Vista;


public class Controlador implements ActionListener{

private static Vista vista;
private FansDAO clienteDAO;
private ProductoDAO productoDAO;
private DevolucionDAO devolucionesDAO;
private PerdidasDAO perdidas;
private SplitPan splipan;
private List<FanDTO> listaClientes;
private List<ProductoDTO> listaProductos;
private List<VentaDTO> listaVentas;
private List<DevolucionDTO>listaDevoluciones;
private List<PerdidasDTO> listaPerdidas;
boolean comprobarCliente;
boolean comprobarProducto;
boolean comprobarVenta;
private VentaDAO ventasDAO;
private PanelLogin panelLogin;
private String path;
  
	public Controlador(Vista vista, FansDAO fansDAO, ProductoDAO productoDAO, VentaDAO ventasDAO,
		DevolucionDAO devolucionesDAO, PerdidasDAO perdidasDAO) {
	
	this.vista = vista;
	this.clienteDAO = clienteDAO;
	this.productoDAO = productoDAO;
	this.ventasDAO = ventasDAO;
	this.devolucionesDAO = devolucionesDAO;
	this.perdidas = perdidasDAO;
	actionListener(this);
	
}

	
	
	private void actionListener(ActionListener oyente) {
	//vista.getPanelLogin().getBtnEntrar().addActionListener(controlador);
	vista.getMntmSalir().addActionListener(oyente);
	vista.getMntmClientes().addActionListener(oyente);
	vista.getMntmParticipantes().addActionListener(oyente);
	vista.getMntmProductos().addActionListener(oyente);
	vista.getMntmSobreNosotros().addActionListener(oyente);
	
	vista.getPanelB().getBtnAnular_v().addActionListener(oyente);
	vista.getPanelB().getBtnCargar_v().addActionListener(oyente);
	vista.getPanelB().getBtnCargar().addActionListener(oyente);
	vista.getPanelB().getBtnCargarProductos().addActionListener(oyente);
	vista.getPanelB().getBtnInsertarVenta().addActionListener(oyente);


	
	vista.getPanelFans().getBtnInsertarFans().addActionListener(oyente);
	vista.getPanelFans().getBtnBorrarFan().addActionListener(oyente);
	vista.getPanelFans().getBtnCargarFan().addActionListener(oyente);
	vista.getPanelFans().getBtnMas().addActionListener(oyente);
	vista.getPanelFans().getBtnMasMas().addActionListener(oyente);
	vista.getPanelFans().getBtnMenos().addActionListener(oyente);
	vista.getPanelFans().getBtnMenosMenos().addActionListener(oyente);
	vista.getPanelFans().getBtnModificarFan().addActionListener(oyente);
	
	vista.getPanelDevoluciones().getBtnAPerdidas().addActionListener(oyente);
	vista.getPanelDevoluciones().getBtnAVentas().addActionListener(oyente);
	vista.getPanelDevoluciones().getBtnCargar().addActionListener(oyente);
	/*
	vista.getPanelProductos().getBtnBorrar().addActionListener(oyente);
	vista.getPanelProductos().getBtnBuscar().addActionListener(oyente);
	vista.getPanelProductos().getBtnCargar().addActionListener(oyente);
	vista.getPanelProductos().getBtnInsertar().addActionListener(oyente);
	vista.getPanelProductos().getBtnModificar().addActionListener(oyente);
	vista.getPanelProductos().getBtnInsertarProducto().addActionListener(oyente);
	*/	
	vista.getPanelB().getTableV().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
              if(!(vista.getPanelB().getTableV().getSelectionModel().isSelectionEmpty( ))) {
            	  vista.getPanelB().getBtnAnular_v().setEnabled(false);
                  vista.getPanelB().getBtnInsertarVenta().setEnabled(true);
                  int fila = vista.getPanelB().getTableV().getSelectedRow();
                    String codigo_producto= vista.getPanelB().getTableV().getValueAt(fila, 0).toString();
                    String importe=vista.getPanelB().getTableV().getValueAt(fila, 1).toString();
                    vista.getPanelB().getTextFproducto_v().setText(codigo_producto);
                    vista.getPanelB().getTextFImporte_v().setText(importe);
                    Calendar fecha = new GregorianCalendar();
                       int año = fecha.get(Calendar.YEAR);
                       int mes = fecha.get(Calendar.MONTH);
                       int dia = fecha.get(Calendar.DAY_OF_MONTH);
                       int hora = fecha.get(Calendar.HOUR_OF_DAY);
                       int minuto = fecha.get(Calendar.MINUTE);
                       int segundo = fecha.get(Calendar.SECOND);
                  
                    vista.getPanelB().getTextFieldFecha().setText(año + "-" + (mes+1) +"-" +dia); 
              }
	});
    vista.getPanelB().getTableP().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
		 if(!(vista.getPanelB().getTableP().getSelectionModel().isSelectionEmpty( ))) {
			
			 vista.getPanelB().getBtnAnular_v().setEnabled(true);
		     vista.getPanelB().getBtnInsertarVenta().setEnabled(false);
        /*     int fila = vista.getPanelB().getTableP().getSelectedRow();
             String dni = vista.getPanelB().getTableP().getValueAt(fila, 0).toString();
             String codigo= vista.getPanelB().getTableP().getValueAt(fila, 1).toString();
             String importe=vista.getPanelB().getTableP().getValueAt(fila, 2).toString();
             String fecha=vista.getPanelB().getTableP().getValueAt(fila, 3).toString();
             vista.getPanelB().getTextFdni_v().setText(dni);
             vista.getPanelB().getTextFproducto_v().setText(codigo);
             vista.getPanelB().getTextFImporte_v().setText(importe);
             vista.getPanelB().getTextFieldFecha().setText(fecha);*/
         }
         
   	});
    
    vista.getPanelB().getTableParty().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
 		 if(!(vista.getPanelB().getTableParty().getSelectionModel().isSelectionEmpty( ))) {
 			  int fila = vista.getPanelB().getTableParty().getSelectedRow();
              String dni = vista.getPanelB().getTableParty().getValueAt(fila, 0).toString(); 
              vista.getPanelB().getTextFdni_v().setText(dni);
 		 }
    });
    vista.getPanelProductos().getTablep().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
		 if(!(vista.getPanelProductos().getTablep().getSelectionModel().isSelectionEmpty( ))) {
	/*
            int fila = vista.getPanelProductos().getTablep().getSelectedRow();
            String codigo = vista.getPanelProductos().getTablep().getValueAt(fila, 0).toString();
            String precio= vista.getPanelProductos().getTablep().getValueAt(fila, 1).toString();
            String cantidad=vista.getPanelProductos().getTablep().getValueAt(fila, 2).toString();
            
            vista.getPanelProductos().getTextCodigo().setText(codigo);
            vista.getPanelProductos().getTextPrecio().setText(precio);
            vista.getPanelProductos().getTextCantidad().setText(cantidad);
         */  
        }
        
  	});
	
    vista.getPanelParticipantes().getTablaPa().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
		 if(!(vista.getPanelParticipantes().getTablaPa().getSelectionModel().isSelectionEmpty( ))) {
	/*
           int fila = vista.getPanelParticipantes().getTablaPa().getSelectedRow();
           String dni = vista.getPanelParticipantes().getTablaPa().getValueAt(fila, 0).toString();
           String nombre= vista.getPanelParticipantes().getTablaPa().getValueAt(fila, 1).toString();
           String apellidos=vista.getPanelParticipantes().getTablaPa().getValueAt(fila, 2).toString();
           String email=vista.getPanelParticipantes().getTablaPa().getValueAt(fila, 3).toString();
           vista.getPanelParticipantes().getTextFdniParty().setText(dni);
           vista.getPanelParticipantes().getTextFnombreParty().setText(nombre);
           vista.getPanelParticipantes().getTextFapellidosParty().setText(apellidos);
           vista.getPanelParticipantes().getTextFemailParty().setText(email);
          
          */
       }
       
 	});
    
    //Fans
    vista.getPanelFans().getTablaFan().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {		
		 if(!(vista.getPanelFans().getTablaFan().getSelectionModel().isSelectionEmpty( ))) {
	/*
          int fila = vista.getPanelFans().getTablaFan().getSelectedRow();
          String dni = vista.getPanelFans().getTablaFan().getValueAt(fila, 0).toString();
          String nombre= vista.getPanelFans().getTablaFan().getValueAt(fila, 1).toString();
          String sexo=vista.getPanelFans().getTablaFan().getValueAt(fila, 2).toString();
          String email=vista.getPanelFans().getTablaFan().getValueAt(fila, 3).toString();
          String f_nacimiento=vista.getPanelFans().getTablaFan().getValueAt(fila, 4).toString();
          String participa=vista.getPanelFans().getTablaFan().getValueAt(fila, 5).toString();
          vista.getPanelFans().getTextFdniFan().setText(dni);
          vista.getPanelFans().getTextFnombreFan().setText(nombre);
          vista.getPanelFans().getTextFemailFan().setText(email);
      
        */  
      }
      
	});
    
    
    
    
    
	}
	


	
    @Override
    //JmenuBar
    public void actionPerformed(ActionEvent e) {
	   if (e.getSource().getClass() == JMenuItem.class) {
			  JMenuItem menuItem = (JMenuItem) e.getSource();	
			     if(menuItem.getText().equals("Salir")) {	
			        cerrarAplicacion();
			     }
		         else if(menuItem.getText().equals("Sobre nosotros")) {
                   sobreNosotros();
		         }
		         else {
		    	    rutaAlFichero();
		         }
	  }
	   
	  //PanelVentas CRUD
	   
     
    
     
     
   
     //Panel CRUD 
     if(e.getSource()==vista.getPanelFans().getBtnCargarFan()) {
    	ModelTableFans.setData(FansDAO.listaData(new FansDAO().getListaFans()));	
     	vista.getPanelFans().getTablaFan().repaint();  
    
     }
	 if(e.getSource()==vista.getPanelFans().getBtnInsertarFans()) {
		 FansDAO dao = new FansDAO();;
		 
		 String dni=vista.getPanelFans().getTextFdniFan().getText();
		 String nombre=vista.getPanelFans().getTextFnombreFan().getText();
		 String sexo=null;
		 if(vista.getPanelFans().getRdbtnChica().isSelected()) {
			sexo="Chica"; 
		 }else {
			 sexo="Chico";
		 }
		 String email=vista.getPanelFans().getTextFemailFan().getText();
		 SimpleDateFormat formaFecha= new SimpleDateFormat("yyyy-MM-dd");
		 String fecha=formaFecha.format(vista.getPanelFans().getDateChooser().getDate());
		 String participa=null;
		 if(vista.getPanelFans().getRdbtnNo().isSelected()) {
			participa="No"; 
		 }else {
			 participa="Si";
		 }
		 
		 
		 boolean registro=dao.addFans(dni, nombre, sexo, email, fecha, participa);  
		  if(registro==true) {
		      JOptionPane.showMessageDialog(null, "-F. insertado correctamente-");
		      vista.getPanelFans().getTextFdniFan().setText("");
		      vista.getPanelFans().getTextFemailFan().setText("");
		      vista.getPanelFans().getTextFnombreFan().setText("");
		      vista.getPanelFans().getGroupButton_sexo().getSelection().getActionCommand();
		      vista.getPanelFans().getGroupButton_participa().getSelection().getActionCommand();
		      vista.getPanelFans().getDateChooser().setCalendar(null);
		      
	       }else {
	    	 JOptionPane.showMessageDialog(null, "-F. no pudo ser insertado-");
	       }
	       
		 /*
		  if(e.getSource()==vista.getPanelB().getBtnInsertarVenta()) {
			  int fila = vista.getPanelB().getTablev().getSelectedRow();
				if ((vista.getPanelB().getTablev().getSelectedRow() >= 0)) {
					Object codigo= vista.getPanelB().getTablev().getValueAt(fila, 0);
					Object precio= vista.getPanelB().getTablev().getValueAt(fila, 1);
					vista.getPanelB().getTextFproducto_v().setText(codigo.toString());
					vista.getPanelB().getTextFImporte_v().setText(precio.toString());
				}
			 
		  }
		  */
	 }
	 

	 
	 //Panel Productos CRUD
	 if(e.getSource()==vista.getPanelProductos().getBtnCargar()) {
	 ModelTableProductos.setData(ProductoDAO.listaData(new ProductoDAO().getListaProductos()));	
	 vista.getPanelFans().getTablaFan().repaint();  
	 }
	 
	 
	 
	 
	 
	 
	 if(e.getSource()==vista.getPanelDevoluciones().getBtnCargar()) {
	  ModelTableDevoluciones.setData(DevolucionDAO.listaData(new DevolucionDAO().getListaDevolucionPendienteRevision()));	
		 vista.getPanelDevoluciones().getTable().repaint();	 
	 }
	 
	 
	 
	 
	 if(e.getSource()==vista.getPanelParticipantes().getBtnCargarParty()) {
		  ModelTableParticipantes.setData(ParticipanteDAO.listaData(new ParticipanteDAO().getListaParticipantes()));	
			 vista.getPanelParticipantes().getTablaPa().repaint();	 
	 }
	 
	 
	 
	 
	 
	 if(e.getSource()==vista.getPanelB().getBtnCargar_v()) {
		  ModelPanelBP.setData(VentaDAO.listaData(new VentaDAO().getListaVentas()));	
		  vista.getPanelB().getTableP().repaint();	 
	 }
	 
	 
	 
	 
	 
	 if(e.getSource()==vista.getPanelB().getBtnCargarProductos()) {
		  ModelPanelB.setData(ProductoDAO.listaData(new ProductoDAO().getListaProductos()));	
		  vista.getPanelB().getTableP().repaint();	 
	 }
	 
	 
   
    } //Cierre de los eventos	

    
    
    
	@SuppressWarnings("static-access")
	public  String rutaAlFichero() {
	 JFileChooser jFileChooser = new JFileChooser(".");
	 int resultado = jFileChooser.showOpenDialog(vista.getFrame());
     if (resultado == jFileChooser.APPROVE_OPTION) {
	  path = jFileChooser.getSelectedFile().getPath();  
	 }
	 return path;
	}
	
	 private void cerrarAplicacion() {
		System.exit(0);

	 }

	
	
	 @SuppressWarnings("static-access")
	private void sobreNosotros() {
		JOptionPane jpJOptionPane = new JOptionPane();
		jpJOptionPane.showMessageDialog(vista.getFrame(), 
		"The Event's Singel", "PinBravo",
        JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void darTotalPerdidas() {

	}
	
	}
	
	
	/*
	public  void acertarLogin() {
		char[] login=vista.getPanelLogin().getPasswordField().getPassword();
    	String pass=new String(login);
    	
    	if(vista.getPanelLogin().getTextFLogin().getText().equals("login") && (pass.equals("pass"))) {
    	      //  dispose();
    	
    	        JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "Has ingresado correctamente", JOptionPane.INFORMATION_MESSAGE);   
    	        activarPestanas();
    	
         	}
    	
    	    else {
    	    	JOptionPane.showMessageDialog(null, "Login o pass incorrecto", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    	    	
    	    }
	}
	*/

