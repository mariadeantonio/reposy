package vista;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ModelPanelB;
import controlador.ModelTableDevoluciones;
import modelo.DevolucionDTO;
import modeloDAO.DevolucionDAO;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class PanelDevoluciones extends JPanel {
	
	private JTable table;
	private List<DevolucionDTO> listaDevoluciones;

	
	private JButton btnCargar;
	private JButton btnAPerdidas;
	private JButton btnAVentas;

	/**
	 * Create the panel.
	 */
	public PanelDevoluciones() {
		
		JPanel panel = new JPanel();
		
		btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnAPerdidas = new JButton("A PERDIDAS");
		
		btnAVentas = new JButton("A VENTAS");
		
		JLabel lblNewLabel = new JLabel("Devoluciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(270, Short.MAX_VALUE)
					.addComponent(btnCargar)
					.addGap(53)
					.addComponent(btnAPerdidas)
					.addGap(52)
					.addComponent(btnAVentas)
					.addGap(172))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 758, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(349)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
					.addGap(181))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel)
					.addGap(29)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCargar)
						.addComponent(btnAPerdidas)
						.addComponent(btnAVentas))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
	
		
		table = new JTable(new ModelTableDevoluciones());
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);	
		
		
		
		
		
		
		
                btnAPerdidas.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	/*
                            if(!(table.getSelectionModel().isSelectionEmpty( ))) {

                                int filad = table.getSelectedRow();
                                String dni=table.getValueAt(filad, 0).toString();
                                String codigo_producto=table.getValueAt(filad, 1).toString();
                                DevolucionDAO d=new DevolucionDAO();

                                boolean borrar=d.deleteDevolucion(dni, codigo_producto);
                                if(borrar) {
                                        JOptionPane.showMessageDialog(null, "Se ha enviado a pérdidas");
                                } else {
                                        JOptionPane.showMessageDialog(null, "No ha sido posible enviar a pérdidas");
                                }
                                
                           }
                           
                           */
                    }
		 });
                
                btnAVentas.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	/*
                            if(!(table.getSelectionModel().isSelectionEmpty( ))) {
                  
                                int filad = table.getSelectedRow();
                                String dnis=table.getValueAt(filad, 0).toString();
                                String codigo_productos=table.getValueAt(filad, 1).toString();
                                String importes=table.getValueAt(filad, 2).toString().toString();
                                String estados=table.getValueAt(filad, 3).toString().toString();
                                String fecha_devolucions=table.getValueAt(filad, 4).toString();
                                
                                int importe =Integer.parseInt(importes);
                                DevolucionDAO d=new DevolucionDAO();
                                DevolucionDTO dto=new DevolucionDTO(dnis, codigo_productos, importe, estados, fecha_devolucions);

                                boolean aVentas=d.updateEstadoDevolucion(dnis, codigo_productos);
                                
                            if(aVentas) {
                                    JOptionPane.showMessageDialog(null, "Se ha enviado a ventas");
                            } else {
                                    JOptionPane.showMessageDialog(null, "No se ha enviado a ventas.Revise estado");
                            }
                            
                        }
                        */      
                    }
		 });


             btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		 
			}
		  
		  
		 });
			
}
	


/**
 * @return the table
 */
public JTable getTable() {
	return table;
}

/**
 * @return the listaDevoluciones
 */
public List<DevolucionDTO> getListaDevoluciones() {
	return listaDevoluciones;
}

/**
 * @return the btnCargar
 */
public JButton getBtnCargar() {
	return btnCargar;
}

/**
 * @return the btnAPerdidas
 */
public JButton getBtnAPerdidas() {
	return btnAPerdidas;
}

/**
 * @return the btnAVentas
 */
public JButton getBtnAVentas() {
	return btnAVentas;
}

}
