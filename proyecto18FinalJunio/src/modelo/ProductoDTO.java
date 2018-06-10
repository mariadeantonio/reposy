package modelo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProductoDTO implements List<ProductoDTO> {
private String codigo_producto;
private int precio;
private int cantidad;
private String fecha;
public ProductoDTO(String codigo_producto, int precio, int cantidad, String fecha) {
	super();
	this.codigo_producto = codigo_producto;
	this.precio = precio;
	this.cantidad=cantidad;
	this.fecha = fecha;
}

public ProductoDTO(String codigo_producto, int precio, int cantidad) {
	super();
	this.codigo_producto = codigo_producto;
	this.precio = precio;
	this.cantidad=cantidad;
}


public ProductoDTO(String dni, String codigo, int precio) {
	// TODO Auto-generated constructor stub
}

public ProductoDTO(String dni, String codigoProducto, String fecha2) {
	// TODO Auto-generated constructor stub
}



public ProductoDTO(String dniCliente, String codigoProducto) {
	// TODO Auto-generated constructor stub
}

/**
 * @return the codigo_producto
 */
public String getCodigo_producto() {
	return codigo_producto;
}
/**
 * @param codigo_producto the codigo_producto to set
 */
public void setCodigo_producto(String codigo_producto) {
	this.codigo_producto = codigo_producto;
}
/**
 * @return the precio
 */
public int getPrecio() {
	return precio;
}
/**
 * @param precio the precio to set
 */
public void setPrecio(int precio) {
	this.precio = precio;
}


/**
 * @return the cantidad
 */
public int getCantidad() {
	return cantidad;
}

/**
 * @param cantidad the cantidad to set
 */
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

/**
 * @return the fecha
 */
public String getFecha() {
	return fecha;
}
/**
 * @param fecha the fecha to set
 */
public void setFecha(String fecha) {
	this.fecha = fecha;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "codigo_producto=" + codigo_producto + ", precio=" + precio + ", cantidad=" + cantidad
			+ ", fecha=" + fecha + "\n";
}

@Override
public boolean add(ProductoDTO arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void add(int arg0, ProductoDTO arg1) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean addAll(Collection<? extends ProductoDTO> arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean addAll(int arg0, Collection<? extends ProductoDTO> arg1) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	
}

@Override
public boolean contains(Object arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean containsAll(Collection<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ProductoDTO get(int arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int indexOf(Object arg0) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Iterator<ProductoDTO> iterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int lastIndexOf(Object arg0) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public ListIterator<ProductoDTO> listIterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ListIterator<ProductoDTO> listIterator(int arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean remove(Object arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ProductoDTO remove(int arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean removeAll(Collection<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean retainAll(Collection<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ProductoDTO set(int arg0, ProductoDTO arg1) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<ProductoDTO> subList(int arg0, int arg1) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <T> T[] toArray(T[] arg0) {
	// TODO Auto-generated method stub
	return null;
}


public static void main(String[] args) {
	
}


}
