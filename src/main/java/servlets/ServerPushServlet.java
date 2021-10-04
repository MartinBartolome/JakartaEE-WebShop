package servlets;

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

        PushBuilder pushBuilder = request.newPushBuilder();
        if (pushBuilder != null) {
            pushBuilder.path("resources/img/tau.jpg")
                    .addHeader("content-type", "image/jpg")
                    .push();
        }
        try (PrintWriter respWriter = response
                .getWriter();) {
            respWriter.write(
                    "<html><img src='resources/img/tau.jpg'></html>");

        }
    }
}
