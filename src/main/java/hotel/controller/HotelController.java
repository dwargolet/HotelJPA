package hotel.controller;
import hotel.entity.Hotel;
import hotel.ejb.HotelFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The main controller in this app
 *
 * @author Daniel
 */
public class HotelController extends HttpServlet {

    private static final String ACTION_PARAM = "action";
    private static final String ID_PARAM = "hotelId";
//    private static final String LIST_ACTION = "list";
//    private static final String FIND_ONE_ACTION = "findone";
    private static final String EDIT_ACTION = "edit";
    private static final String CREATE_ACTION = "create";
    private static final String DELETE_ACTION = "delete";
//    private static final String SEARCH_ACTION = "search";
    private static final String RESULT_PAGE = "/Views/database.jsp";
//    private static final int ALL_HOTELS = 0;
//    private static final int SEARCH_BY_STATE = 1;
//    private static final int SEARCH_BY_CITY = 2;

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

        // set default destination
        //String destination = HOME_PAGE;
        RequestDispatcher view;
        // Attempt to get QueryString parameters, may not always be available
        String action = request.getParameter(ACTION_PARAM);
        String hotelId = request.getParameter(ID_PARAM);
        String name;
        String address;
        String city;
        String state;
        String zip;
        String notes;
        String stringPk = "";            
        int pk;
        
        Hotel hotel = new Hotel();
//        try {
        if(action != null){
            switch (action) {
                case CREATE_ACTION:
                    
                    name = request.getParameter("hotelName");
                    address = request.getParameter("hotelAddress");
                    city = request.getParameter("hotelCity");
                    zip = request.getParameter("hotelZip");
                    state = request.getParameter("hotelState");
                    notes = request.getParameter("hotelNote");

                    hotel.setCity(city);
                    hotel.setHotelName(name);
                    hotel.setNotes(notes);
                    hotel.setZip(zip);
                    hotel.setCustState(state);
                    hotel.setStreetAddress(address);   
                    hotelService.create(hotel);
                    
                    
                break;
                case DELETE_ACTION: {
                    hotelService.deleteHotelById(Integer.valueOf(hotelId));
                    break;
                }

                case EDIT_ACTION: {

                    stringPk = request.getParameter("hotelId");
                    pk = Integer.parseInt(stringPk);
                    hotel = (Hotel) hotelService.find(pk);
                    name = request.getParameter("hotelName");
                    address = request.getParameter("hotelAddress");
                    city = request.getParameter("hotelCity");
                    zip = request.getParameter("hotelZip");
                    state = request.getParameter("hotelState");
                    notes = request.getParameter("hotelNote");
                    hotel.setCity(city);
                    hotel.setHotelName(name);
                    hotel.setNotes(notes);
                    hotel.setZip(zip);
                    hotel.setCustState(state);
                    hotel.setStreetAddress(address);
                    
                    hotelService.edit(hotel);
                }
                default:
                    break;
            }
        }

//        } catch (IOException | NumberFormatException e) {
//            // Error messages will appear on the destination page if present
//            request.setAttribute("errMessage", e.getMessage());
//
//            // Just in case it's some other exception not predicted
//        } catch (Exception e2) {
//            // Error messages will appear on the destination page if present
//            request.setAttribute("errMessage", e2.getMessage());
//        }

        List<Hotel> hotels = hotelService.findAll();
        request.setAttribute("hotelList", hotels);
        view = request.getRequestDispatcher(RESULT_PAGE);        
        view.forward(request, response);
    }

    /*
     This is very ineffeficient having to get the entire hotel list on every
     request. In the future we'll learn how to use Ajax techniques to only
     update portions of the page that need updating. Then this refresh 
     operation won't be necessary.
     */
//    private void refreshHotelList(HttpServletRequest request, HttpServletResponse response, HotelFacade hotelService)
//            throws ServletException, IOException {
//
//        List<Hotel> hotels = hotelService.findAllHotels();
//        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
//
//        hotels.forEach((hotel) -> {
//            jsonArrayBuilder.add(
//                    Json.createObjectBuilder()
//                    .add("hotelId", hotel.getHotelId())
//                    .add("name", hotel.getHotelName())
//                    .add("address", hotel.getStreetAddress())
//                    .add("city", hotel.getCity())
//                    .add("zip", hotel.getZip())
//            );
//        });
//
//        JsonArray hotelsJson = jsonArrayBuilder.build();
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        out.write(hotelsJson.toString());
//        out.flush();
//    }

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
