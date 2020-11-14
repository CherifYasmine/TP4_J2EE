import com.appa.metier.GestionUser;
import com.appa.metier.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "ServletListe", urlPatterns = "/ServletListe")
public class ServletListe extends HttpServlet {
    private static final GestionUser gestionUtilisateur = new GestionUser();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        Vector users = gestionUtilisateur.lister();
        req.setAttribute("users", users);
        RequestDispatcher rd = req.getRequestDispatcher("Lister.jsp");
        rd.forward(req, response);
    }
}
