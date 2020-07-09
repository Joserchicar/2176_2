package modelo;




public class Empleado {
	
	private int codigo;
	private String nif;
	private String nombre;
	private String ape1;
	private String ape2;
	private Departamento departamento;

	public Empleado() {
		super();
		this.codigo=0;
		this.nif="";
		this.nombre="";
		this.ape1="";
		this.ape2="";
		this.departamento= new Departamento();
	}

	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nif=" + nif + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2="
				+ ape2 + ", departamento=" + departamento + "]";
	}
	
	
	
	
	
}
