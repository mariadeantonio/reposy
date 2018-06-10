package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CargarClientesGson {
   public static void main(String[] args) {
	   
	List<FanDTO> listClientes=new ArrayList<>();
	BufferedReader reader = null; 
	
    try {
		reader = new BufferedReader ( new FileReader ( "Datos/clientes.json" ));
		 Gson gson = new Gson();
	        FanDTO[] clientesDTO = gson.fromJson(reader, FanDTO[].class);

	        for (FanDTO clienteDTO : clientesDTO) {
	            listClientes.add(clienteDTO);
	        }
	        System.out.println(listClientes); 
	        System.out.println(clientesDTO.length);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
   } 
}
