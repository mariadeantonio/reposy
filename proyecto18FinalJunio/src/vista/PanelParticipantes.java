package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controlador.Controlador;
import controlador.ModelTableParticipantes;
import modelo.FanDTO;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class PanelParticipantes extends JPanel {
	private JTable tablaPa;
	private JTextField textFdniParty;
	private JTextField textFnombreParty;
	private JTextField textFemailParty;
	private JButton btnInsertarFan;
	private JButton btnCargarParty;
	private List<FanDTO> listaFans;
	private JButton btnInsertarParty;
	private JRadioButton rdbtnChico;
	private JRadioButton rdbtnChica;
  
	/**
	 * Create the panel.
	 */
	public PanelParticipantes() {
		JScrollPane scrollPane = new JScrollPane();
		
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDni.setForeground(Color.WHITE);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setForeground(Color.WHITE);
		
		textFdniParty = new JTextField();
		textFdniParty.setColumns(5);
		
		textFnombreParty = new JTextField();
		textFnombreParty.setColumns(5);
		
		textFemailParty = new JTextField();
		textFemailParty.setColumns(5);
		
		JLabel lblPartySeleccionado = new JLabel("Participante ");
		lblPartySeleccionado.setForeground(Color.WHITE);
		lblPartySeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));	
	    btnCargarParty = new JButton("CARGAR");
	    
		btnCargarParty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblPartyArriva = new JLabel("Participantes");
		lblPartyArriva.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblPartyArriva.setForeground(new Color(255, 255, 255));
		
		btnInsertarParty = new JButton("INSERTAR");
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setForeground(Color.WHITE);
	/*	
		rdbtnChico = new JRadioButton("Chico");
		
		rdbtnChica = new JRadioButton("Chica");
		*/
		 ButtonGroup groupButton_sexo = new ButtonGroup(); 
		   rdbtnChico = new JRadioButton("Chico");
		   rdbtnChico.setActionCommand("Chico");
		   rdbtnChico.setSelected(true);
		   
		   rdbtnChica = new JRadioButton("Chica");
		   rdbtnChica.setActionCommand("Chica");
		   
		   groupButton_sexo.add(rdbtnChico);   
		   groupButton_sexo.add(rdbtnChica);
		   
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombre)
										.addComponent(lblDni)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(textFnombreParty, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(textFdniParty, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addComponent(textFemailParty, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
											.addGap(68))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(6)
											.addComponent(rdbtnChico, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(rdbtnChica, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
											.addGap(68))
										.addComponent(lblPartySeleccionado)))
								.addComponent(lblSexo)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(125)
							.addComponent(btnInsertarParty, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(93)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(0)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(315)
							.addComponent(btnCargarParty, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(277))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(529, Short.MAX_VALUE)
					.addComponent(lblPartyArriva)
					.addGap(253))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblPartyArriva)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCargarParty))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(219)
							.addComponent(lblPartySeleccionado)
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFdniParty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDni))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFnombreParty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre))
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSexo)
								.addComponent(rdbtnChico)
								.addComponent(rdbtnChica, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFemailParty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail))
							.addGap(48)
							.addComponent(btnInsertarParty)))
					.addGap(90))
		);
	
		
	
    	tablaPa = new JTable(new ModelTableParticipantes());
		scrollPane.setViewportView(tablaPa);
		tablaPa.setAutoCreateRowSorter(true);//ro
		tablaPa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(groupLayout);
		
		
		 tablaPa.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
             public void valueChanged(ListSelectionEvent e) {
            	 
                
             }
            
         });
		
		
			

		
		btnCargarParty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		    }
		 });
			
			
		

	}

	/**
	 * @return the tablaPa
	 */
	public JTable getTablaPa() {
		return tablaPa;
	}

	/**
	 * @return the textFdniParty
	 */
	public JTextField getTextFdniParty() {
		return textFdniParty;
	}

	/**
	 * @return the textFnombreParty
	 */
	public JTextField getTextFnombreParty() {
		return textFnombreParty;
	}

	/**
	 * @return the textFemailParty
	 */
	public JTextField getTextFemailParty() {
		return textFemailParty;
	}


	/**
	 * @return the btnInsertarFan
	 */
	public JButton getBtnInsertarFan() {
		return btnInsertarFan;
	}

	

	/**
	 * @return the btnCargarParty
	 */
	public JButton getBtnCargarParty() {
		return btnCargarParty;
	}

	/**
	 * @return the listaFans
	 */
	public List<FanDTO> getListaFans() {
		return listaFans;
	}

	
	/**
	 * @return the btnInsertarParty
	 */
	public JButton getBtnInsertarParty() {
		return btnInsertarParty;
	}
}
	