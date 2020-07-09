package modelo;

public class Departamento {

	private int codigo;
	private String nombre;
	private double presupuesto;
	private double gasto;
	
	
	
	public Departamento() {
		super();
		this.codigo=0;
		this.nombre="";
		this.presupuesto=0;
		this.gasto=0;
			
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPresupuesto() {
		return presupuesto;
	}



	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}



	public double getGasto() {
		return gasto;
	}



	public void setGasto(double gasto) {
		this.gasto = gasto;
	}



	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", gasto="
				+ gasto + "]";
	}

	
	
	
	
}
