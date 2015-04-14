
package hotel.controller;

import hotel.ejb.HotelFacade;
import hotel.entity.Hotel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class SearchController extends HttpServlet {
    private static final String RESULT_PAGE = "/Views/search.jsp";
    private static final int ALL_HOTELS = 0;
    private static final int SEARCH_BY_STATE = 1;
    private static final int SEARCH_BY_CITY = 2;
    private static final String ACTION_PARAM = "action";
    
    @Inject
    private HotelFacade hotelService;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher view;
        String action = request.getParameter(ACTION_PARAM);
        
//        String name;
//        String address;
//        String city;
//        String state;
//        String zip;
//        String notes;
//        String stringPk = "";            
//        int pk;
        
//        Hotel hotel = new Hotel();
        List<Hotel> hotels = null;
        
        if(action != null){
            switch(Integer.parseInt(request.getParameter("searchOptions")))
            {
                case ALL_HOTELS:
                    hotels = hotelService.findAll();
                    break;
                case SEARCH_BY_STATE:
                    request.setAttribute("state", request.getParameter("state"));
                    hotels = hotelService.searchForHotelByAny("state");
                break;
                case SEARCH_BY_CITY:
                    request.setAttribute("city", request.getParameter("city"));
                    hotels = hotelService.searchForHotelByAny("city");
                break;
                default:
                    break;
            }            
        }
        
        request.setAttribute("hotelList", hotels);
        view = request.getRequestDispatcher(RESULT_PAGE);        
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
