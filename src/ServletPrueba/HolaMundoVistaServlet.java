package ServletPrueba;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoVista
 */
@WebServlet(name = "HolaMundoVista", urlPatterns = { "/HolaMundoVista" }) 
public class HolaMundoVistaServlet extends HttpServlet { 
	private static final long serialVersionUID = 2L; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoVistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String nombre = (String) request.getParameter("NombreUsuario");

		Vector listado = (Vector)request.getSession().getAttribute("listado");
		if (listado == null){ 
			listado = new Vector();
		}
		Integer contador= (Integer) getServletContext().getAttribute("contador"); 

		if ( contador == null ){  
			contador = new Integer(0);
		} 
		// Establecemos el contador como atributo del context bajo el nombre 
		// contador. En caso de que ya existiera, sobreescribiría la referencia
		// existente con la nueva.

		getServletContext().setAttribute("contador",new Integer(contador.intValue()+1)); 

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
		out.println("<BODY>");
		if(nombre != null){
			out.println("<BR>Hola "+nombre+"<BR>");
			listado.addElement(nombre);
		}

		request.getSession().setAttribute("listado",listado); 

		out.println("Bienvenido a mi página web!");
		out.println("<br>");  
		out.print("Contigo, hoy me han visitado:<br>");
		out.println("<br><br>" + contador +" visitas"); 
		for ( int i = 0 ; i < listado.size() ; i++ ){   
			out.println("<br>"+(String)listado.elementAt(i));   
		} 

		out.println("<a href=\"index.html\">volver</a>"); 
		out.println("</BODY></HTML>");
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
