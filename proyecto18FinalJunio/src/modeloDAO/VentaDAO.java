package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.FanDTO;
import modelo.Conexion;
import modelo.ConexionProfe;
import modelo.ProductoDTO;
import modelo.VentaDTO;

public class VentaDAO implements IVentaDAO {
	private static Connection conexion= Conexion.getInstance();
	PreparedStatement preparedStatement;
    VentaDTO vdto;
	String sql=null;
	
	@Override
	public List<VentaDTO> getListaVentas() {
		  List<VentaDTO> listaVentas=new ArrayList<>();
			String sql=" SELECT * FROM VENTAS ";
			//Creamos el objeto statement
		    try {
				Statement statement=conexion.createStatement();
			   //Creamos el objeto resultSet
			    ResultSet resultSet=statement.executeQuery(sql);
			    while(resultSet.next()) {
			        	String dniCliente=resultSet.getString("DNI");
			        	String codigoProducto=resultSet.getString("CODIGO_PRODUCTO");
			        	int importe=resultSet.getInt("IMPORTE");
			            String fechaVenta=resultSet.getString("FECHA_VENTA");
			        	VentaDTO venta=new VentaDTO(dniCliente, codigoProducto, importe, fechaVenta);
			            listaVentas.add(venta);
			    }       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No lee getListaVentas");
			}
			
			return listaVentas;
	}
@Override
	public boolean addVenta (String dniCliente, String codigoProducto, int importe) {
   boolean add = false;
   boolean addProducto = false;
      
		String sql = "INSERT INTO ventas(DNI, CODIGO_PRODUCTO, IMPORTE) VALUES (?, ?, ?);";
		try {
			System.out.println("add1");
		    preparedStatement = conexion.prepareStatement(sql);
		    System.out.println("add2");
			preparedStatement.setString(1, dniCliente);
			System.out.println("add3");
			preparedStatement.setString(2, codigoProducto);
			preparedStatement.setInt(3, importe);
			System.out.println("add4");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0) {
				System.out.println("Venta Correcta");
			}
			  
			/*String  sql0 = "UPDATE productos SET CANTIDAD=CANTIDAD-1   WHERE CODIGO_PRODUCTO = ?;";
			  preparedStatement = conexion.prepareStatement(sql0);
			  preparedStatement.setString(1, codigoProducto);
			  int rows0 = preparedStatement.executeUpdate();
				if (rows0 != 0) {
					ProductoDTO p=new ProductoDTO(dniCliente, codigoProducto, importe);
					ProductoDAO pdao=new ProductoDAO();
					pdao.productoCantidadMenosUno(p.getCodigo_producto());
					addProducto = true;
					System.out.println("Producto -1 correcto");
				}
				*/
		} catch (SQLException e) {
			System.out.println("No se pudo añadir la venta");

		}
		
		return add;
		
	}

	@Override
	public boolean deleteVenta(String dni, String  codigoProducto, String fecha) {
		boolean delete= false;
		sql = "DELETE FROM ventas WHERE DNI = ? AND CODIGO_PRODUCTO = ? AND FECHA_VENTA=?;";
		try {
			preparedStatement = conexion.prepareStatement(sql);
		System.out.println(1);
			preparedStatement.setString(1, dni);
		System.out.println(2);
			preparedStatement.setString(2, codigoProducto);
			preparedStatement.setString(3, fecha);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				delete = true;
			System.out.println("Venta borrar perfectamente");
		} catch (SQLException e) {
			System.out.println("No se pudo borrar la venta");

		}
		
		return delete;
	}
	
	public static Object [][] listaData (List<VentaDTO> lista){
		Object [][] matriz = new Object [lista.size()][4];
			
			for (int i=0 ; i < lista.size() ;i++){
			matriz[i][0] = lista.get(i).getDniCliente();
			matriz[i][1] = lista.get(i).getCodigoProducto();
			matriz[i][2] = lista.get(i).getImporte();
			matriz[i][3] = lista.get(i).getFechaVenta();
			}
		
		return matriz;	
		}
	
	
	
	
	public static void main(String[] args) {
		VentaDAO vdao=new VentaDAO();
		FanDTO cd= new FanDTO("44444444D", "","","","","");
    	ProductoDTO pd=new ProductoDTO("A7", 787, 0, "");
	    System.out.println(vdao.addVenta("77777778F", "C0DF", 186));
		//System.out.println(vdao.addVentas());
		System.out.println(vdao.deleteVenta("77777778G", "C054", "2018-06-05"));
		System.out.println(vdao.getListaVentas());
	}

}
