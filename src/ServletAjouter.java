import com.appa.metier.GestionUser;
import com.appa.metier.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "ServletAjouter", urlPatterns = "/ServletAjouter")
public class ServletAjouter extends HttpServlet {
    private static final GestionUser gestionUtilisateur = new GestionUser();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vector<Utilisateur> users = gestionUtilisateur.lister();
        req.setAttribute("users", users);

        HttpSession maSession = req.getSession(false);

        if (maSession == null) {
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
        }

        Utilisateur user = (Utilisateur) maSession.getAttribute("user");
        if (user == null) {
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
        }

        req.setAttribute("data", user);

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String ville = req.getParameter("ville");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin(login);
        utilisateur.setPass(password);
        utilisateur.setEmail(email);
        utilisateur.setVille(ville);
        gestionUtilisateur.ajouter(utilisateur);

        Vector usersUpdated = gestionUtilisateur.lister();
        req.setAttribute("users", usersUpdated);
        RequestDispatcher rd = req.getRequestDispatcher("Lister.jsp");
        rd.forward(req, resp);

    }
}
