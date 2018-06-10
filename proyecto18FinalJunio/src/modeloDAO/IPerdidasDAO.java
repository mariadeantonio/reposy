package modeloDAO;

import java.util.List;

import modelo.PerdidasDTO;

public interface IPerdidasDAO {
List<PerdidasDTO> getListaPerdidas();
int sumaPerdidas();
}


