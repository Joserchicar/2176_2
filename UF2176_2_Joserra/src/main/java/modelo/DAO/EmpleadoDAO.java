package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import modelo.ConnectionManager;
import modelo.Departamento;
import modelo.Empleado;

public class EmpleadoDAO {

	private final static Logger LOG = Logger.getLogger(EmpleadoDAO.class);
	private static EmpleadoDAO INSTANCE;

	private EmpleadoDAO() {
		super();

	}

	public static synchronized EmpleadoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EmpleadoDAO();
		}
		return INSTANCE;
	}

	public ArrayList<Empleado> mostrar(String criterioBusqueda) throws Exception {// (int codigo, String nif,String
																					// nombre,String ape1, String
																					// ape2)throws Exception {

		ArrayList<Empleado> resultado = new ArrayList<Empleado>();

		if (criterioBusqueda == null) {
			criterioBusqueda = "";
		}

		String sql = " SELECT "
				+ " e.codigo 'codigo',e.nif, e.nombre ,e.ape1 , e.ape2 ,d.nombre 'departamento',d.presupuesto'presupuesto' ,d.gasto 'gasto'"
				+ "FROM empleado e LEFT JOIN departamento d ON e.cod_departamento =d.codigo "
				+ "WHERE CONCAT(e.nombre,ape1,ape2,nif)LIKE '%" + criterioBusqueda + "%' " + "ORDER BY e.codigo ASC;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			LOG.debug(pst);

			Empleado e = null;
			Departamento d = null;
			while (rs.next()) {

				e = new Empleado();
				d = new Departamento();

				e.setCodigo(rs.getInt("codigo"));
				e.setNombre(rs.getString("nombre"));
				e.setApe1(rs.getString("ape1"));
				e.setApe2(rs.getString("ape2"));
				e.setNif(rs.getString("nif"));

				d.setCodigo(rs.getInt("codigo"));
				d.setNombre(rs.getString("departamento"));
				d.setGasto(rs.getFloat("gasto"));
				d.setPresupuesto(rs.getFloat("presupuesto"));

				e.setDepartamento(d);

				resultado.add(e);
			}

		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}

		return resultado;
	}

	public Empleado insertar(Empleado e) throws Exception {

		String SQL_INSERT = " INSERT INTO empleado (nombre,ape1,ape2,nif,cod_departamento) VALUES (?,?,?,?,?);";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

		) {

			pst.setString(1, e.getNombre());
			pst.setString(2, e.getApe1());
			pst.setString(3, e.getApe2());
			pst.setString(4, e.getNif());
			pst.setInt(4, e.getDepartamento().getCodigo());

			LOG.debug(pst);
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {

				// conseguir el ID

				try (ResultSet rsKeys = pst.getGeneratedKeys()) {

					if (rsKeys.next()) {
						
						int id = rsKeys.getInt(1);
						e.setCodigo(id);
					}
				}

			} else {
				throw new Exception("No se ha podido guardar el registro " + e);
			}

		}

		return e;

	}

}
