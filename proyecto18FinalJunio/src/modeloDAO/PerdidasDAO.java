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
import modelo.PerdidasDTO;

public class PerdidasDAO  implements IPerdidasDAO{
	private static Connection conexion= Conexion.getInstance();;
	Statement statement;
	String sql;

@Override
public List<PerdidasDTO> getListaPerdidas() {
	List<PerdidasDTO> listaPerdidas = new ArrayList<>();
	
String	sql = "SELECT * FROM perdidas ORDER BY DNI_CLIENTE;";
	try(Statement statement=conexion.createStatement();
			ResultSet resultset = statement.executeQuery(sql);) {
		
	
		while (resultset.next()){
			String codigo = resultset.getString("CODIGO_PRODUCTO");
			String dni = resultset.getString("DNI_CLIENTE");
			int importe = resultset.getInt("IMPORTE");
			String fecha=resultset.getString("FECHA");
			PerdidasDTO pd = new PerdidasDTO(codigo, dni, importe, fecha);
			listaPerdidas.add(pd);
		}
			
	} catch (SQLException e2) {
		System.out.println("No se pudo leer getListaClientes");
	}
	return listaPerdidas;
  }




public static Object [][] listaDatos (List<PerdidasDTO> lista){
	Object [][] matriz = new Object [lista.size()][5];
		
		for (int i=0 ; i < lista.size() ;i++){
		matriz[i][0] = lista.get(i).getCodigoProducto();
		matriz[i][1] = lista.get(i).getDniCliente();
		matriz[i][2] = lista.get(i).getImporte();
		matriz[i][3] = lista.get(i).getFecha();
		}
	
	return matriz;	
	}

@Override
public int sumaPerdidas() {
int total=0;
String	sql = "SELECT SUM(IMPORTE) FROM perdidas ;";
 try(Statement statement=conexion.createStatement();
	    ResultSet resultset = statement.executeQuery(sql);) {

    total=resultset.getInt(1);
		
  } catch (SQLException e2) {
	System.out.println("No se pudo entrar");
  }

	return total;
}


public static void main(String[] args) {
	PerdidasDAO p=new PerdidasDAO();
	System.out.println(p.getListaPerdidas());
	System.out.println(p.sumaPerdidas());
 }





}