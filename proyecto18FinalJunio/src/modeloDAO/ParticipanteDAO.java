package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Conexion;
import modelo.ConexionProfe;
import modelo.ParticipanteDTO;

public class ParticipanteDAO implements IParticipanteDAO {
		private static Connection conexion= Conexion.getInstance();
		PreparedStatement preparedStatement;
		ParticipanteDTO cdto;
		Statement statement;
		String sql;
		private String path;
		
	 
		 
		@Override
		public List<ParticipanteDTO> getListaParticipantes() {
			List<ParticipanteDTO> listParticipantes = new ArrayList<>();
			
		String	sql = "SELECT * FROM clientes;";
			try(Statement statement=conexion.createStatement();
				   ResultSet resultset = statement.executeQuery(sql);) {
				while (resultset.next()){
					String dni = resultset.getString("DNI");
					String nombre = resultset.getString("NOMBRE");
					String sexo = resultset.getString("SEXO");
					String email = resultset.getString("EMAIL");
					String fecha=resultset.getString("FECHA");
					ParticipanteDTO participante = new ParticipanteDTO(dni, nombre, sexo, email, fecha);
					listParticipantes.add(participante);
				}
					
			} catch (SQLException e2) {
				System.out.println("No se pudo leer getListaParticipantes");
			}
			return listParticipantes;
		}

		@Override
		public  boolean addParticipante(String dni, String nombre, String sexo, String email) {
	        boolean add = false;
			
			String sql = "INSERT INTO clientes(DNI, NOMBRE, SEXO, EMAIL) VALUES (?, ? , ?, ?);";
			try(PreparedStatement  preparedStatement = conexion.prepareStatement(sql);) {
				System.out.println("Entra en tr11y");
				preparedStatement.setString(1, dni);
				System.out.println("Entra en tr13y");
				preparedStatement.setString(2, nombre);
				preparedStatement.setString(3, sexo);
				preparedStatement.setString(4, email);
				
				int rows = preparedStatement.executeUpdate();
				System.out.println("Entra en tr14y");
				if (rows != 0)
					add = true;
			} catch (SQLException e) {
				System.out.println("No se pudo añadir el participante");

			}
			
			return add;	
		}
		
		
		@Override
		public  boolean addParticipante(ParticipanteDTO p) {
	        boolean add = false;
			
			String sql = "INSERT INTO clientes(DNI, NOMBRE, SEXO, EMAIL) VALUES (?, ? , ?, ?);";
			try(PreparedStatement  preparedStatement = conexion.prepareStatement(sql);) {
				System.out.println("Entra en tr11y");
			   
			    System.out.println("Entra en tr12y");
				preparedStatement.setString(1, p.getDni());
				System.out.println("Entra en tr13y");
				preparedStatement.setString(2, p.getNombre());
				preparedStatement.setString(3, p.getSexo());
				preparedStatement.setString(4, p.getEmail());
				
				int rows = preparedStatement.executeUpdate();
				System.out.println("Entra en tr14y");
				if (rows != 0)
					add = true;
			} catch (SQLException e) {
				System.out.println("No se pudo añadir el participante");

			}
			
			return add;	
		}

		@Override
		public boolean deleteParticipante(String dni) {
			boolean delete= false;
			sql = "DELETE FROM clientes WHERE DNI = ?";
			try (PreparedStatement  preparedStatement = conexion.prepareStatement(sql);){
				preparedStatement.setString(1, dni);
				int rows = preparedStatement.executeUpdate();
				if (rows != 0)
					delete = true;
			} catch (SQLException e) {
				System.out.println("No se pudo borrar el participante");

			}
			
			return delete;
		}
		
     
		@Override
		public boolean updateEmailParticipante( String email, String dni) {
			boolean update = false;
		
			String sql = "UPDATE clientes SET EMAIL=?   WHERE DNI = ?";
			try(PreparedStatement  preparedStatement = conexion.prepareStatement(sql);) {
				System.out.println("1");
				preparedStatement.setString(1, email);
				System.out.println("2");
				preparedStatement.setString(2, dni);
				System.out.println("3");
				int rows = preparedStatement.executeUpdate();
				if (rows != 0)
					update = true;
			} catch (SQLException e) {
				System.out.println("No se pudo modificar el email del participante");

			}
			
			return update;
		}



		@Override
		public boolean addListaParticipantes(List<ParticipanteDTO> listaparticipantes) {
			boolean addLC=false;
			try {
				conexion.setAutoCommit(true);
				for(ParticipanteDTO cto: listaparticipantes){
					ParticipanteDAO cd=new ParticipanteDAO();
					cd.addParticipante(cto); 
				 }
				addLC=true;
			} catch (SQLException e) {
			    try {
					conexion.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
	        
		
			return addLC;
		}
		
		public static Object [][] listaData (List<ParticipanteDTO> lista){
			Object [][] matriz = new Object [lista.size()][5];
				
				for (int i=0 ; i < lista.size() ;i++){
				matriz[i][0] = lista.get(i).getDni();
				matriz[i][1] = lista.get(i).getNombre();
				matriz[i][2] = lista.get(i).getSexo();
				matriz[i][3] = lista.get(i).getEmail();
				matriz[i][4] = lista.get(i).getFecha();
				}
			
			return matriz;	
			}
		
		
		
		public static void main(String[] args) {
			ParticipanteDAO c=new ParticipanteDAO();
			List<ParticipanteDTO>lista=new ArrayList<>();
			ParticipanteDTO d0=new ParticipanteDTO("99999999R", "Jose", "CHICO", "mvpprg@gmail.com");
			ParticipanteDTO d1=new ParticipanteDTO("99999999P", "Lolo", "CHICO", "mvpprg@gmail.com");
			ParticipanteDTO d2=new ParticipanteDTO("99999999Q", "Ramiro", "CHICO", "mvpprg@gmail.com");
			ParticipanteDTO d3=new ParticipanteDTO("99999999S", "Juanito", "CHICO", "mvpprg@gmail.com");
			lista.add(d0);
			lista.add(d1);
			lista.add(d2);
			lista.add(d3);
			c.addParticipante("99999999B", "Lorena", "CHICA", "mvpprg@gmail.com");
			//System.out.println("SQLITE");
			System.out.println(c.getListaParticipantes());
		    //System.out.println(c.deleteParticipante("99999999Q"));
			//System.out.println(c.updateEmailParticipante("joseO@gmail.com", "99999999R"));
			c.addListaParticipantes(lista);
		    System.out.println(c.getListaParticipantes());

			
		}

	
}
