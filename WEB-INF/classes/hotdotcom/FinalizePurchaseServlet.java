package hotdotcom;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** Servlet that reads credit card information,
 *  performs a stock purchase, and displays confirmation page.
 *  <P>
 *  Taken from More Servlets and JavaServer Pages
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.moreservlets.com/.
 *  &copy; 2002 Marty Hall; may be freely used or adapted.
 */

public class FinalizePurchaseServlet extends HttpServlet {
  
  /** Use doPost for non-SSL access to prevent
   *  credit card number from showing up in URL.
   */
  
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    String fullName = request.getParameter("fullName");
    String cardNum = request.getParameter("cardNum");
    confirmPurchase(fullName, cardNum);
    String destination = "/investing/sucker.jsp";
    RequestDispatcher dispatcher =
      getServletContext().getRequestDispatcher(destination);
    dispatcher.forward(request, response);
  }

  /** doGet calls doPost. Servlets that are
   *  redirected to through SSL must have doGet.
   */
  
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  private void confirmPurchase(String fullName,
                               String cardNum) {
    // Details removed to protect the guilty.
  }
}
