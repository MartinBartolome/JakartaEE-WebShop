package servlets;

import database.beans.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = { "/serverpush" })
public class ServerPushServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {

        User employee = new User();
        employee.setId(5);
        employee.setEmail("Abo Sheasha");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
