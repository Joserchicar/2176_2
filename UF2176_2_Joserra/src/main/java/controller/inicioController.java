package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.DAO.EmpleadoDAO;

/**
 * Servlet implementation class inicioController
 */
@WebServlet("/inicio")
public class inicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(inicioController.class);
	private static final  EmpleadoDAO dao = EmpleadoDAO.getInstance();       
      
    
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			 
			String resultado =request.getParameter("resultado");
					
			request.setAttribute("empleados", dao.mostrar(null) );
			
		} catch (Exception e) {
		LOG.equals(e);
			e.printStackTrace();
			
		}		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
