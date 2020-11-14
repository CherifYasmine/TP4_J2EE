import com.appa.metier.GestionUser;
import com.appa.metier.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        if (login!=null && pass!=null){
            GestionUser gu = new GestionUser();
            Utilisateur u = gu.Chercher(login,pass);
            if (u!=null){
                HttpSession maSession = request.getSession(true);
                maSession.setAttribute("user",u);
                request.getRequestDispatcher("bienvenue.jsp").forward(request,response);
            }
            else {
                request.setAttribute("erreur","Erreur de Connexion");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }
    }
}
