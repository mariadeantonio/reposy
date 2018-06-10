package modeloDAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.Conexion;
import modelo.ConexionProfe;
import modelo.FanDQO;
import modelo.FanDTO;


public class FansDAO implements IFansDAO {
	private static Connection conexion= Conexion.getInstance();
	PreparedStatement preparedStatement;
	FanDTO cdto;
	Statement statement;
	ResultSet resultSet;
	String sql;
	private String path;
	
	@Override
	public boolean crearTablaFans() {
		boolean creada=false;
		Statement statement = null;
		try{
			statement = conexion.createStatement();
		    statement.executeUpdate("drop table IF EXISTS fans");
		    System.out.println("borrada BD");
		    statement.executeUpdate("CREATE TABLE fans(DNI TEXT PRIMARY KEY, NOMBRE TEXT NOT NULL,  SEXO TEXT, EMAIL  TEXT NOT NULL, FECHA_NACIMIENTO TEXT, PARTICIPA TEXT);");
		    
		 creada=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		return creada;
	}
	
	
	@Override
	public List<FanDTO> getListaFans() {
		List<FanDTO> listFans = new ArrayList<>();
		
	String	sql = "SELECT * FROM fans;";
		try(Statement statement=conexion.createStatement();
				ResultSet resultset = statement.executeQuery(sql);) {
			
		
			while (resultset.next()){
				String dni = resultset.getString("DNI");
				String nombre = resultset.getString("NOMBRE");
				String sexo = resultset.getString("SEXO");
				String email = resultset.getString("EMAIL");
				String fecha=resultset.getString("FECHA_NACIMIENTO");
				String participa=resultset.getString("PARTICIPA");
				FanDTO fan = new FanDTO(dni, nombre, sexo, email, fecha, participa);
				listFans.add(fan);
			}
				
		} catch (SQLException e2) {
			System.out.println("No se pudo leer getListaFans");
		}
		return listFans;
	}
	
	
	@Override
	public List<FanDQO> getListaFansQparticipan() {
		List<FanDQO> listFansQ = new ArrayList<>();
		
	String	sql = "SELECT DNI, NOMBRE, SEXO, EMAIL FROM fans WHERE PARTICIPA='SI';";
		try(Statement statement=conexion.createStatement();
				ResultSet resultset = statement.executeQuery(sql);) {
			
		
			while (resultset.next()){
				String dni = resultset.getString("DNI");
				String nombre = resultset.getString("NOMBRE");
				String sexo = resultset.getString("SEXO");
				String email = resultset.getString("EMAIL");
				FanDQO fanDQO = new FanDQO(dni, nombre, sexo, email);
				listFansQ.add(fanDQO);
			}
				
		} catch (SQLException e2) {
			System.out.println("No se pudo leer getListaFansQparticipan");
		}
		return listFansQ;
	}
	
	@Override
	public boolean existeFan(String dni) {
		boolean existe=false;
		int fila=0;
		sql = "Select dni FROM fans WHERE DNI=?;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();){
			preparedStatement.setString(1, dni);
			while (resultSet.next()){
				fila++;
			}
			if (fila != 0)		
				existe= true;
			System.out.println("El dni si existe");
		} catch (SQLException e) {
			System.out.println("El dni no existe");
		}	
		
		return existe;
	}
			

	

	@Override
	public  boolean addFans(String dni, String nombre, String sexo, String email, String fecha, String participa) {
        boolean add = false;
		
		String sql = "INSERT INTO fans(DNI, NOMBRE, SEXO, EMAIL, FECHA_NACIMIENTO, PARTICIPA) VALUES (?, ? , ?, ?, ?, ?);";
		try(PreparedStatement  preparedStatement = conexion.prepareStatement(sql);) {
			preparedStatement.setString(1, dni);
			preparedStatement.setString(2, nombre);
			preparedStatement.setString(3, sexo);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, fecha);
            preparedStatement.setString(6, participa);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				add = true;
		} catch (SQLException e) {
			System.out.println("No se pudo a�adir el cliente");

		}
		
		return add;	
	}
	
	
	@Override
	public  boolean addFan(FanDTO fan) {
        boolean add = false;
		
		String sql = "INSERT INTO fans VALUES (?, ? , ?, ?, ?, ?);";
		try (PreparedStatement  preparedStatement = conexion.prepareStatement(sql);){
			preparedStatement.setString(1, fan.getDni());
			preparedStatement.setString(2, fan.getNombre());
			preparedStatement.setString(3, fan.getSexo());
			preparedStatement.setString(4, fan.getEmail());
			preparedStatement.setString(5, fan.getFecha());
			preparedStatement.setString(6, fan.getParticipa());
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				add = true;
		} catch (SQLException e) {
			System.out.println("No se pudo a�adir el fan");

		}
		
		return add;	
	}


	@Override
	public boolean deleteFan(String dni) {
		boolean delete= false;
		sql = "DELETE FROM fans WHERE DNI = ?";
		try(PreparedStatement preparedStatement = conexion.prepareStatement(sql);) {
			preparedStatement.setString(1, dni);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				delete = true;
		} catch (SQLException e) {
			System.out.println("No se pudo borrar el cliente");

		}
		
		return delete;
	}
	

	@Override
	public boolean updateEmailFan( String email, String dni) {
		boolean update = false;
	
		String sql = "UPDATE fans SET EMAIL=?   WHERE DNI = ?";
		try(PreparedStatement preparedStatement = conexion.prepareStatement(sql);) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, dni);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				update = true;
		} catch (SQLException e) {
			System.out.println("No se pudo modificar el email");

		}
		
		return update;
	}



	@Override
	public boolean addListaFans(List<FanDTO> listaFans) {
		boolean addC=false;
		for(FanDTO cto: listaFans){
			FansDAO cd=new FansDAO();
			addFan(cto); 
			addC=true;
        }
	
		return addC;
	}
	
	public static Object [][] listaData (List<FanDTO> lista){
		Object [][] matriz = new Object [lista.size()][6];
			
			for (int i=0 ; i < lista.size() ;i++){
			matriz[i][0] = lista.get(i).getDni();
			matriz[i][1] = lista.get(i).getNombre();
			matriz[i][2] = lista.get(i).getSexo();
			matriz[i][3] = lista.get(i).getEmail();
			matriz[i][4] = lista.get(i).getFecha();
			matriz[i][5] = lista.get(i).getParticipa();
			}
		
		return matriz;	
		}
	
	
	
	public static void main(String[] args) {
		FansDAO c=new FansDAO();
		FanDTO d=new FanDTO("11111111RR", "Ana", "Sanles", "ana@gmail.com","--","--");
		c.addFans("33333333Z", "Genaro", "CHICO", "gene@gmail.com", "2018-23-09", "SI");
		//System.out.println("SQLITE");
		//System.out.println(c.getListaFans());
		//c.addListaFans(c.readListClientesDesdeJson("Datos/clientes.json"));
		//System.out.println(c.readListClientesDesdeJson("Datos/clientes.json"));
		//System.out.println(c.deleteFan("33333333OOEWEWEW"));
		//System.out.println(c.updateEmailFan( "PuebloJienense33@gmail.com", "33333333OO"));
		System.out.println(c.getListaFans());
        // System.out.println(c.crearTablaFans());
		//System.out.println(c.getListaFansQparticipan());
	     System.out.println(c.existeFan("33333333A"));
	}

}






