package se.iths.security;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

@ServletSecurity(@HttpConstraint(rolesAllowed = {"ADMIN", "USER"}))
@WebServlet("/app")
public class ApplicationServlet extends HttpServlet {
    public ApplicationServlet() {
        super();
    }

    @Inject
    SecurityContext securityContext;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.getWriter()
                .append("Welcome to the application, ")
                .append(securityContext.getUserPrincipal().getName());


    }

}
