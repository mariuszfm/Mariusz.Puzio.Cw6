package controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ArtDAO;
import view.HtmlPrinter;

/**
 * Class which manages adding contents to the database
 *
 * @author 
 * @version 1.0
 */
public final class Add extends HttpServlet {
    
    /**
     * For printing HTML elements
     */
    private HtmlPrinter printer;

    /**
     * Manages the adding the art to the database
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.printer = new HtmlPrinter(response.getWriter());
        this.printer.printHeader();
        Map<String, String[]> parameterMap = request.getParameterMap();
        // chosen content to add
        if (parameterMap.containsKey("chooseArt")) {
            this.printer.printArtForm();
        }
        // filled add forms
        if (parameterMap.containsKey("addArt")) {
            String title = request.getParameter("title");
            String extension = request.getParameter("extension");
            String creator = request.getParameter("creator");
            String category = request.getParameter("category");
            if (title.isEmpty() || extension.isEmpty() || creator.isEmpty() || category.isEmpty()) {
                this.printer.printWrongInput();
            } else {
                if (ArtDAO.addArt(title, extension, creator, category)) {
                    this.printer.printConfirmation();
                } else {
                    this.printer.printNewArtError();
                }
            }
        }
        this.printer.printReturnOption();
        this.printer.printFooter();
    }
    
    /**
     * {@inheritDoc}
     * Handles the GET method. Works in the same way as doPost.
     * 
     * @param req is the servlet request
     * @param resp is the servlet response
     * @throws ServletException if there are servlet-oriented errors
     * @throws IOException  if there are input/output-oriented errors
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.processRequest(req, resp);
    }
    
    /**
     * {@inheritDoc}
     * Handles the POST method. Works in the same way as doGet
     * 
     * @param req is the servlet request
     * @param resp is the servlet response
     * @throws ServletException if there are servlet-oriented errors
     * @throws IOException  if there are input/output-oriented errors
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.processRequest(req, resp);
    }

}
