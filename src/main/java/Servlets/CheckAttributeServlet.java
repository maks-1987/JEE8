package Servlets;

import Maths.TestObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CheckAttributeServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckAttributeServlet</title>");
            out.println("</head>");
            out.println("<body>");

            HttpSession session = request.getSession(true);

            Object attr = session.getAttribute("formula");

            if (attr instanceof ArrayList) {
                ArrayList list = (ArrayList) attr;
                out.println("<h1>Список операций:</h1>");
                for (Object str : list) {
                    out.println("<h3>" + str + "</h3>");
                }
            } else {
                out.println("<h1>Операции не найдены</h1>");
            }
            out.println("<h1>" + ((TestObject) request.getServletContext().getAttribute("obj")).getName() + "</h1>");

        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** Returns a short description of the servlet. */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
