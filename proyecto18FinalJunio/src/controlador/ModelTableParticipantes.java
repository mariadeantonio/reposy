package controlador;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import modelo.ParticipanteDTO;
import modeloDAO.ParticipanteDAO;



@SuppressWarnings("serial")
public class ModelTableParticipantes extends AbstractTableModel implements TableModelListener {
List<ParticipanteDTO> listaParticipantes;
JTable tablePa;
	private static String[] columnNames = {"DNI", "NOMBRE", "SEXO", "EMAIL", "FECHA"};
	
	private static Object[][] datos = ParticipanteDAO.listaData(new ParticipanteDAO().getListaParticipantes());
	
	
	
	/**
	 * @return the tablep
	 */
	public JTable getTablePa() {
		return tablePa;
	}


	public ModelTableParticipantes () {
		addTableModelListener(this);
	}

	
	  public void cargarTablaParticipantes(JTable tablePa) {
	    	DefaultTableModel model= new DefaultTableModel();
	    	tablePa.setModel(model);
	    	 model.addColumn("DNI");
	    	 model.addColumn("NOMBRE");
	    	 model.addColumn("APELLIDOS");
	    	 model.addColumn("EMAIL");
	    	 model.addColumn("FECHA");
	    	 listaParticipantes=new ParticipanteDAO().getListaParticipantes();
	    		     ParticipanteDTO p;
	    		     for (int i = 0; i < listaParticipantes.size(); i++) {
	    		    	 Object[]  fila= new Object[5];
	    		    	 p=listaParticipantes.get(i);
	    		         fila[0]=p.getDni();
	    		         fila[1]=p.getNombre();
	    		         fila[2]=p.getSexo();
	    		         fila[3]=p.getEmail();
	    		         fila[4]=p.getFecha();	
	    		         model.addRow(fila);
	    		     }      
	    	}
	    	
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex < 5) {
            return false;
        } else {
            return true;
        }
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
        datos[row][col] = value;
        fireTableCellUpdated(row, col);
    }
	
	@Override
	public void tableChanged(TableModelEvent e) {
		
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return datos[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	/**
	 * @return the columnNames
	 */
	public static String[] getColumnNames() {
		return columnNames;
	}

	/**
	 * @param columnNames the columnNames to set
	 */
	public static void setColumnNames(String[] columnNames) {
		ModelTableParticipantes.columnNames = columnNames;
	}

	/**
	 * @return the datos
	 */
	public static Object[][] getData() {
		return datos;
	}

	/**
	 * @param data the datos to set
	 */
	public static void setData(Object[][] data) {
		ModelTableParticipantes.datos = data;
	}
}
