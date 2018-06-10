package modeloDAO;



import java.util.List;

import modelo.DevolucionDTO;
import modelo.PerdidasDTO;
import modelo.ProductoDTO;
import modelo.VentaDTO;

public class InformeDTO {
private List<ProductoDTO> listProductoDTO;
private List<VentaDTO> listVentaDTO;
private List<DevolucionDTO> listDevolucionDTO;
private PerdidasDTO listPerdidaDTO;
public InformeDTO(List<ProductoDTO> listProductoDTO, List<VentaDTO> listVentaDTO, List<DevolucionDTO> listDevolucionDTO,
		PerdidasDTO listPerdidaDTO) {
	super();
	this.listProductoDTO = listProductoDTO;
	this.listVentaDTO = listVentaDTO;
	this.listDevolucionDTO = listDevolucionDTO;
	this.listPerdidaDTO = listPerdidaDTO;
}
public List<ProductoDTO> getListProductoDTO() {
	return listProductoDTO.get(0);
}
public List<VentaDTO> getListVentaDTO() {
	return listVentaDTO;
}
public List<DevolucionDTO> getListDevolucionDTO() {
	return listDevolucionDTO;
}
public PerdidasDTO getListPerdidaDTO() {
	return listPerdidaDTO;
}
@Override
public String toString() {
	return "listaProductoDTO=" + listProductoDTO + ", listVentaDTO=" + listVentaDTO + ", listDevolucionDTO="
			+ listDevolucionDTO + ", listPerdidaDTO=" + listPerdidaDTO + "n";
}




}

