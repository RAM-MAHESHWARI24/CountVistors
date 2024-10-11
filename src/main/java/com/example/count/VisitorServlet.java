package com.example.count;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VisitorServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int visitorCount;

    @Override
    public void init() throws ServletException {
        visitorCount = 0; // Initialize visitor count
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        visitorCount++; // Increment visitor count

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Visitor Count</title>");
        out.println("<style>");
        out.println("h1 { color: red; animation: blink 1s step-end infinite; }");
        out.println("@keyframes blink { 50% { opacity: 0; } }");
        out.println("</style></head><body>");
        out.println("<h1>You are visitor number " + visitorCount + "</h1>");
        out.println("<a href='index.html'>Go back to form</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Process form data
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String languages = request.getParameter("languages");
        String citizenship = request.getParameter("citizenship");

        // Redirect to doGet to display the visitor count
        response.sendRedirect("VisitorServlet");
    }
}
