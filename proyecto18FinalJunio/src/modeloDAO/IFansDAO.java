package modeloDAO;

import java.util.List;

import modelo.FanDQO;
import modelo.FanDTO;
import modelo.ParticipanteDTO;
import modelo.ProductoDTO;

public interface IFansDAO { 
	List<FanDTO> getListaFans();
	boolean deleteFan(String  dni);
	boolean updateEmailFan(String dni, String email);
	boolean addListaFans(List<FanDTO> listaFans);
    boolean crearTablaFans();
	boolean addFans(String dni, String nombre, String apellidos, String email, String fecha, String participa);
	boolean addFan(FanDTO fanDTO);
	List<FanDQO>  getListaFansQparticipan();
	boolean existeFan(String dni);
	
}