package vista;


import javax.swing.JPanel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ModelTableProductos;
import modelo.FanDTO;
import modelo.ProductoDTO;
import modeloDAO.FansDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import modeloDAO.FansDAO;
import modelo.FanDTO;
public class PanelProductos extends JPanel {
private JTable tablep;
private JTextField textCantidad;
private List<ProductoDTO> listaProductos;
private JTextField textCodigo;
private JTextField textPrecio;
private JButton btnBorrar ;
private JButton btnInsertar ;
private JButton btnModificar ;
private JButton btnBuscar ;
private JButton btnInsertarCliente ;
private JButton btnCargar ;
private JButton btnInsertarProducto;

	/**
	 * Create the panel.
	 */
	public PanelProductos()  {
	
		JScrollPane scrollPane = new JScrollPane();
		
		btnBorrar = new JButton("BORRAR");	
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
			
                            String codigo=getTextCodigo().getText().toString();
                            ProductoDTO co= new ProductoDTO(codigo, 0, 0,"");
                            ProductoDAO po= new ProductoDAO();
              

                            boolean updateProducto=po.deleteProducto(codigo);

                            if(updateProducto) {
                                    JOptionPane.showMessageDialog(null, "Borrado correctamente ");
                            } else {
                                    JOptionPane.showMessageDialog(null, "No se ha podido borrar ");
                            }
                   */         
                            
               }     
		  });
		
		
		
	
		
		
		
		btnInsertar = new JButton("INSERTAR LISTA");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				  String codigo=getTextCodigo().getText().toString();
                  String preci=getTextPrecio().getText().toString();
                  int precio=Integer.parseInt(preci);
                  ProductoDTO co= new ProductoDTO(codigo, precio, 0,"");
                  ProductoDAO po= new ProductoDAO();
    

                  boolean updateProducto=po.updatePrecioProducto(codigo, precio);

                  if(updateProducto) {
                          JOptionPane.showMessageDialog(null, "Modificado correctamente ");
                  } else {
                          JOptionPane.showMessageDialog(null, "No se ha podido modificar ");
                  }
                  
                  
              }

			*/
			}
		});
		
		
		JLabel lblCodigo_producto = new JLabel("Codigo");
		lblCodigo_producto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo_producto.setForeground(Color.WHITE);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textCodigo = new JTextField();
		textCodigo.setColumns(5);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(5);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(5);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setFont(new Font("Verdana", Font.BOLD, 16));
		
		btnInsertarProducto = new JButton("INSERTAR PRODUCTO");	
		btnInsertarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
                            String codigo=getTextCodigo().getText().toString();
                            String preci=getTextPrecio().getText().toString();
                            String cantida=getTextCantidad().getText().toString();
                            int precio=Integer.parseInt(preci);
                            int cantidad=Integer.parseInt(cantida);
                          
                            
                            ProductoDTO co= new ProductoDTO(codigo, precio, cantidad);
                            ProductoDAO po= new ProductoDAO();
              

                            boolean registroProducto=po.addProducto(co);

                            if(registroProducto) {
                                    JOptionPane.showMessageDialog(null, "Registrado correctamente "+registroProducto);
                            } else {
                                    JOptionPane.showMessageDialog(null, "No se ha podido registrar "+registroProducto);
                            }
                            
                            System.out.println(codigo +""+precio);
                            */
                        }

		
		});
		
		
		btnCargar= new JButton("CARGAR");
		
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblProductos.setForeground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecio)
								.addComponent(lblCodigo_producto))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnInsertarProducto)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textPrecio, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
										.addComponent(textCantidad, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textCodigo, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(87))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(108)
							.addComponent(lblProducto)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(461)
					.addComponent(btnCargar)
					.addGap(33)
					.addComponent(btnModificar)
					.addGap(18)
					.addComponent(btnInsertar)
					.addGap(27)
					.addComponent(btnBorrar)
					.addContainerGap(91, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(558, Short.MAX_VALUE)
					.addComponent(lblProductos)
					.addGap(285))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(216)
							.addComponent(lblProducto)
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo_producto))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecio))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCantidad))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnInsertarProducto))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblProductos)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnBorrar))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnInsertar)
								.addComponent(btnModificar)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCargar)))
					.addGap(114))
		);
		
		DefaultTableModel modelop= new DefaultTableModel();
		tablep=new JTable(new ModelTableProductos());
		tablep.setAutoCreateRowSorter(true);
		tablep.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tablep);
		setLayout(groupLayout);
		
	
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		

		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		  }
	   });
			
	
	}
	public JTextField getTextCodigo() {
		// TODO Auto-generated method stub
		return textCodigo;
	}
	/**
	 * @return the btnInsertarProducto
	 */
	public JButton getBtnInsertarProducto() {
		return btnInsertarProducto;
	}
	
	
	public JTable getTablep() {
		return tablep;
	}
	/**
	 * @return the btnBorrar
	 */
	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	/**
	 * @return the btnInsertar
	 */
	public JButton getBtnInsertar() {
		return btnInsertar;
	}
	/**
	 * @return the btnModificar
	 */
	public JButton getBtnModificar() {
		return btnModificar;
	}
	/**
	 * @return the btnBuscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	/**
	 * @return the btnCargar
	 */
	public JButton getBtnCargar() {
		return btnCargar;
	}
	/**
	 * @return the textCantidad
	 */
	public JTextField getTextCantidad() {
		return textCantidad;
	}
	/**
	 * @return the listaProductos
	 */
	public List<ProductoDTO> getListaProductos() {
		return listaProductos;
	}
	/**
	 * @return the textPrecio
	 */
	public JTextField getTextPrecio() {
		return textPrecio;
	}
	/**
	 * @return the btnInsertarCliente
	 */
	public JButton getBtnInsertarCliente() {
		return btnInsertarCliente;
	}
	

	
	
}	
				


