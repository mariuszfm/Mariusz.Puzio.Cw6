package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ArtDAO;
import DAO.CategoryDAO;
import DAO.CreatorDAO;
import model.Art;
import model.Category;
import model.Creator;
import view.HtmlPrinter;

/**
 * Class which manages printing the database contents in the browser
 *
 * @author 
 * @version 1.0
 */
public final class Show extends HttpServlet {
    
    /**
     * For printing html text
     */
    private HtmlPrinter printer;
    
    /**
     * Shows chosen table in the browser
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
        // show all the arts
        if (parameterMap.containsKey("showArts")) {
            this.printer.printArtsColumnHeaders();
            List<Art> list = ArtDAO.getArts();
            if (list != null) {
                for (Art a : list) {
                    this.printer.printRowStart();
                    this.printer.printCell(Integer.toString(a.getId()));
                    this.printer.printCell(a.getTitle());
                    this.printer.printCell(a.getExtension());
                    this.printer.printCell(CreatorDAO.getCreatorByID(a.getCreatorId()).getName());
                    this.printer.printCell(CategoryDAO.getCategoryByID(a.getCategoryId()).getName());
                    this.printer.printRowEnd();
                }
            }
        }
        // show all the creators
        if (parameterMap.containsKey("showCreators")) {
            this.printer.printCreatorsColumnHeaders();
            List<Creator> list = CreatorDAO.getCreators();
            if (list != null) {
                for (Creator c : list) {
                    this.printer.printRowStart();
                    this.printer.printCell(Integer.toString(c.getId()));
                    this.printer.printCell(c.getName());
                    this.printer.printRowEnd();
                }
            }
        }
        // show all the categories
        if (parameterMap.containsKey("showCategories")) {
            this.printer.printCategoriesColumnHeaders();
            List<Category> list = CategoryDAO.getCategories();
            if (list != null) {
                for (Category c : list) {
                    this.printer.printRowStart();
                    this.printer.printCell(Integer.toString(c.getId()));
                    this.printer.printCell(c.getName());
                    this.printer.printRowEnd();
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
     * Handles the POST method. Works in the same way as doGet.
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
