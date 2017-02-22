package view;

import java.io.PrintWriter;

/**
 * Prints html text in the browser
 *
 * @author 
 * @version 1.0
 */
public final class HtmlPrinter {

    /**
     * Object for printing text
     */
    private final PrintWriter printWriter;
    
    /**
     * Default constructor
     * 
     * @param printWriter is assigned to printWriter
     */
    public HtmlPrinter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }
    
    /**
     * Prints the beginning of the page
     */
    public void printHeader() {
        this.printWriter.print("<!DOCTYPE html>\n"
                + "<html>\n"
                + "\t<head>\n"
                + "\t\t<title>Galeria Sztuki</title>\n"
                + "\t</head>\n"
                + "\t<body>\n");
    }
    
    /**
     * Prints the ending of the page
     */
    public void printFooter() {
        this.printWriter.print("\t</body>\n"
                + "</html>\n");
        this.printWriter.close();
    }
    
    /**
     * Prints information about error
     */
    public void printWrongInput() {
        this.printWriter.print("Brak jednego z parametrów.");
    }
    
    /**
     * Prints information about successful addition of data
     */
    public void printConfirmation() {
        this.printWriter.print("<h3>Dodano pomyślnie.</h3>");
    }
    
    /**
     * Prints the form for information about new art
     */
    public void printArtForm() {
        this.printWriter.print( "<form action=\"Add\" method=\"POST\">"
                + "Tytuł: <input type=\"text\" name=\"title\"> <br>"
                + "Opis: <input type=\"text\" name=\"extension\"> <br> "
                + "Autor:  <input type=\"text\" name=\"creator\"> <br> "
                + "Kategoria:  <input type=\"text\" name=\"category\"> <br> "
                + "<input type=\"submit\" value=\"Wyślij\" name=\"addArt\"> "
                + "</form> "
        );
    }
    
    /**
     * Prints the return button
     */
    public void printReturnOption() {
        this.printWriter.print("<button onclick=\"location.href='/GaleriaSztuki'\">Wróć</button>");
    }
    
    /**
     * Prints the beginning of a table with simple default values
     */
    public void printTableBeginning() {
        this.printWriter.print("<table border=\"1\" style=\"width:40%\">");
    }
    
    /**
     * Prints the beginning of arts table
     */
    public void printArtsColumnHeaders() {
        this.printTableBeginning();
        this.printWriter.print("<tr><th>id</th><th>tytuł</th><th>opis</th><th>autor</th><th>kategoria</th></tr>");
    }
    
    /**
     * Prints the beginning of creators table
     */
    public void printCreatorsColumnHeaders() {
        this.printTableBeginning();
        this.printWriter.print("<tr><th>id</th><th>nazwa</th></tr>");
    }
    
    /**
     * Prints the beginning of categories table
     */
    public void printCategoriesColumnHeaders() {
        this.printTableBeginning();
        this.printWriter.print("<tr><th>id</th><th>nazwa</th></tr>");
    }
    
    /**
     * Prints the beginning of a row of table
     */
    public void printRowStart() {
        this.printWriter.print("<tr>");
    }
    
    /**
     * Prints a single cell of a table with its contents
     * 
     * @param string is the content of a cell
     */
    public void printCell(String string) {
        this.printWriter.print("<td>" + string + "</td>");
    }
    
    /**
     * Prints the ending of a row of table
     */
    public void printRowEnd() {
        this.printWriter.print("</tr>");
    }
    
    /**
     * Prints information about failing to add new art
     */
    public void printNewArtError() {
        this.printWriter.print("<h2>Nie można dodać dzieła.</h2>");
    }
    
}
