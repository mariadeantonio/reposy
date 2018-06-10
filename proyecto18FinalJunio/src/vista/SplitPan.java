package vista;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ModelTableVentasParticipantes;
import modeloDAO.PerdidasDAO;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SplitPan extends JPanel {
	private JTable tableSBproductoDevolucion;
	private JTable tableSBparticipanteDevolucion;
	private JTextField textFclienteSBeleccionado;
	private JTable table_SAperdidas;
	private JTextField textFtotalPerdidas;

	
	/**
	 * Create the panel.
	 */
	public SplitPan() {
		setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		splitPane.setBounds(10, 11, 1018, 504);
		add(splitPane);
		
		JPanel panelSA = new JPanel();
		splitPane.setLeftComponent(panelSA);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 126, 485, 278);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
					.addContainerGap())
		);
		

		table_SAperdidas = new JTable(new ModelTableVentasParticipantes());
		table_SAperdidas.setAutoCreateRowSorter(true);
		table_SAperdidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_2.setViewportView(table_SAperdidas);
		panel_4.setLayout(gl_panel_4);
		panelSA.setLayout(null);
		panelSA.add(panel_4);
		
		textFtotalPerdidas = new JTextField();
		textFtotalPerdidas.setBounds(235, 415, 86, 20);
		panelSA.add(textFtotalPerdidas);
		textFtotalPerdidas.setColumns(10);
		textFtotalPerdidas.setText(new PerdidasDAO().sumaPerdidas()+"");
		JLabel lblNewLabel_1 = new JLabel("Total p\u00E9rdidas");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(117, 416, 108, 14);
		panelSA.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Euros");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(331, 416, 46, 14);
		panelSA.add(lblNewLabel_2);
		
		JLabel lblPerdidas = new JLabel("DEVOLUCIONES A PERDIDAS");
		lblPerdidas.setBounds(56, 75, 401, 29);
		panelSA.add(lblPerdidas);
		lblPerdidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerdidas.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPerdidas.setForeground(new Color(0, 102, 153));
		//PanelPerdidas p= new PanelPerdidas();
       // panelSA.add(p, BorderLayout.CENTER);
        
        
        
		
		JPanel panelSB = new JPanel();
		splitPane.setRightComponent(panelSB);
		
		JPanel panel_1 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableSBproductoDevolucion = new JTable();
		tableSBproductoDevolucion.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"CODIGO PRODUCTO", "TOTAL VENTAS", "TOTAL DEVOLUCIONES", "TOTAL DEVOLUCIONES A  PERDIDAS"
			}
		));
		scrollPane.setViewportView(tableSBproductoDevolucion);
		
		JLabel lblProductos = new JLabel("Productos devueltos a p\u00E9rdidas");
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductos.setForeground(new Color(0, 102, 153));
		
		JPanel panel_2 = new JPanel();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		tableSBparticipanteDevolucion = new JTable();
		tableSBparticipanteDevolucion.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"DNI PARTICIPANTE", "TOTAL COMPRAS", "TOTAL DEVOLUCIOMNES", "TOTAL DEVOLUCIONES A PERDIDAS"
			}
		));
		scrollPane_1.setViewportView(tableSBparticipanteDevolucion);
		
		JLabel lblClientes = new JLabel("Participantes con devoluciones a p\u00E9rdidas");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(new Color(0, 102, 153));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(" Datos participante seleccionado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		textFclienteSBeleccionado = new JTextField();
		textFclienteSBeleccionado.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panelSB = new GroupLayout(panelSB);
		gl_panelSB.setHorizontalGroup(
			gl_panelSB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSB.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelSB.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProductos, GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
						.addComponent(lblClientes, GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
						.addComponent(textFclienteSBeleccionado, GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelSB.setVerticalGroup(
			gl_panelSB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSB.createSequentialGroup()
					.addGap(46)
					.addComponent(lblProductos, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblClientes, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(textFclienteSBeleccionado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panelSB.setLayout(gl_panelSB);
		
	}
	
	/**
	 * @param tableSBproductoDevolucion the tableSBproductoDevolucion to set
	 */
	public void setTableSBproductoDevolucion(JTable tableSBproductoDevolucion) {
		this.tableSBproductoDevolucion = tableSBproductoDevolucion;
	}

	/**
	 * @param tableSBparticipanteDevolucion the tableSBparticipanteDevolucion to set
	 */
	public void setTableSBparticipanteDevolucion(JTable tableSBparticipanteDevolucion) {
		this.tableSBparticipanteDevolucion = tableSBparticipanteDevolucion;
	}

	/**
	 * @param textFclienteSBeleccionado the textFclienteSBeleccionado to set
	 */
	public void setTextFclienteSBeleccionado(JTextField textFclienteSBeleccionado) {
		this.textFclienteSBeleccionado = textFclienteSBeleccionado;
	}

	/**
	 * @param table_SAperdidas the table_SAperdidas to set
	 */
	public void setTable_SAperdidas(JTable table_SAperdidas) {
		this.table_SAperdidas = table_SAperdidas;
	}

	/**
	 * @param textFtotalPerdidas the textFtotalPerdidas to set
	 */
	public void setTextFtotalPerdidas(JTextField textFtotalPerdidas) {
		this.textFtotalPerdidas = textFtotalPerdidas;
	}

	/**
	 * @return the tableSBproductoDevolucion
	 */
	public JTable getTableSBproductoDevolucion() {
		return tableSBproductoDevolucion;
	}

	/**
	 * @return the tableSBparticipanteDevolucion
	 */
	public JTable getTableSBparticipanteDevolucion() {
		return tableSBparticipanteDevolucion;
	}

	/**
	 * @return the textFclienteSBeleccionado
	 */
	public JTextField getTextFclienteSBeleccionado() {
		return textFclienteSBeleccionado;
	}

	/**
	 * @return the table_SAperdidas
	 */
	public JTable getTable_SAperdidas() {
		return table_SAperdidas;
	}

	/**
	 * @return the textFtotalPerdidas
	 */
	public JTextField getTextFtotalPerdidas() {
		return textFtotalPerdidas;
	}

	
}
