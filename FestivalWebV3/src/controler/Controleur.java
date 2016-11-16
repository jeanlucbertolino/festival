package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controleur
 */
@WebServlet(
		name = "Controleur", 
		description = "Controleur General", 
		urlPatterns = {"/FestivalWebV2/*"}
		)
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher 	disp;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// recuperation de l'url (à partir du chemin relatif à la servlet application cad après /bb)
		String path = request.getPathInfo();
		System.out.println("================  dans Controleur path=" + path );
		System.out.println("================  dans Controleur path contexte =" + request.getContextPath() );
		
		if (path == null || path.equals("/")) {
			doAccueil(request, response);
		}
		else if (path.equals("/SceneServ")) {
			// affichage formulaire gestion des bonbons
			doFormScene(request, response);
		}
		else {
			request.setAttribute("msgErreur", "Accl&eacute;e interdit : URL erron&eacute;e !!!");
			doAccueil(request, response);
		}
		
		System.out.println("** Fin Controleur");
	}


	private void doFormScene(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		disp = request.getRequestDispatcher("/SceneServ");
		disp.forward(request,response);		
	}

	private void doAccueil(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		disp = request.getRequestDispatcher("/WEB-INF/index.jsp");
		disp.forward(request,response);	
		
//		//on demande au navigateur de réémettre cette requete
//		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/index.jsp"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
