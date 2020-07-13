package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import modelo.Departamento;
import modelo.Empleado;
import modelo.DAO.EmpleadoDAO;

/**
 * Servlet implementation class inicioController
 */
@WebServlet("/inicio")
public class inicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(inicioController.class);
	private static final EmpleadoDAO dao = EmpleadoDAO.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String resultado = request.getParameter("resultado");

			request.setAttribute("empleados", dao.mostrar(resultado));
			request.setAttribute("resultado", resultado);
		} catch (Exception e) {
			LOG.equals(e);
			e.printStackTrace();

		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String ape1 = request.getParameter("ape1");
		String ape2 = request.getParameter("ape2");
		String nif = request.getParameter("nif");
		String depto = request.getParameter("departamento");
		int codDepto = Integer.parseInt(depto);

		String mensaje = "";

		boolean isRediret = true;

		try {
			LOG.trace("accedemos al controlador");
			
			Empleado e =new Empleado();
			Departamento d= new Departamento();
			
			
			e.setNombre(nombre);
			e.setApe1(ape1);
			e.setApe2(ape2);
			e.setNif(nif);
			d.setCodigo(codDepto);
			e.setDepartamento(d); 
			dao.insertar(e);
			mensaje="Nuevo empleado registrado con exito";
			
		} catch (Exception e) {
			LOG.error(e);
		
		mensaje=" Se ha producido un error.";
		
		}finally {
			
			request.setAttribute("nombre",nombre);
			request.setAttribute("ape1",ape1);
			request.setAttribute("ape2",ape2);
			request.setAttribute("nif",nif);
			request.setAttribute("codDepto",codDepto);
			
			
			request.setAttribute("mensaje ",mensaje);
			
			request.setAttribute("empleados", dao.getInstance());
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
	}
}
