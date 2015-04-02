/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controller;

import hotel.ejb.HotelFacade;
import hotel.entity.Hotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import listener.HotelSessionListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
 *
 * @author Daniel
 */
public class HotelController2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   private static String RESULT_PAGE = "/Views/database.jsp";  
   private static final String ACTION_DELETE = "delete";
   private static final String ACTION_EDIT = "edit";
   private static final String ACTION_CREATE = "create";
   private static final String ACTION_SEARCH = "search";
   //private static final String ACTION_LIST = "list";
   private static final int ALL_HOTELS = 0;
   private static final int SEARCH_BY_STATE = 1;
   private static final int SEARCH_BY_CITY = 2;
   
   @EJB
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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
//        HttpSession session = request.getSession();
//        HotelSessionListener sl = new HotelSessionListener();
        
        
        
        ServletContext sctx = getServletContext();
        WebApplicationContext ctx
                = WebApplicationContextUtils.getWebApplicationContext(sctx);
        HotelFacade hotelService = (HotelFacade) ctx.getBean("hotelService");
        
        
        
        
        
        PrintWriter out = response.getWriter();
        
        
        
        String name;
        String address;
        String city;
        String state;
        String zip;
        String notes;
        String stringPk = "";            
        int pk;

        RequestDispatcher view;
        
        Hotel hotel = new Hotel();

        String hotelId = request.getParameter("hotelId");

        if(request.getParameter("action") != null){
            switch(request.getParameter("action")){
                case ACTION_CREATE:                
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
                //hotelService.create(hotel);
                break;    
//                case ACTION_DELETE:
//                    out = response.getWriter();
//                    pk = Integer.parseInt(hotelId);            
//                    hotelService.delete(pk);
//                    response.setContentType("application/json; charset=UTF-8");
//                    response.setStatus(200);
//                    out.write("{\"success\":\"true\"}");
//                    out.flush();
//                break;    
                case ACTION_EDIT:
                    out = response.getWriter();
                    StringBuilder sb = new StringBuilder();
                    String payload = sb.toString();
                    JsonReader reader = Json.createReader(new StringReader(payload));
                    JsonObject hotelJson = reader.readObject();
                    hotelId = hotelJson.getString("hotelId");
                    Integer id = (hotelId == null || hotelId.isEmpty()) ? null : Integer.valueOf(hotelId);
                    hotel.setHotelId(id);
                    hotel.setStreetAddress(hotelJson.getString("hotelAddress"));
                    hotel.setCity(hotelJson.getString("hotelCity"));
                    hotel.setHotelName(hotelJson.getString("hotelName"));
                    hotel.setZip(hotelJson.getString("zip"));
                    
                    
                    
                    
//                    stringPk = request.getParameter("hotelId");
//                    pk = Integer.parseInt(stringPk);
//                    hotel = (Hotel) hotelService.find(pk);
//                    name = request.getParameter("hotelName");
//                    address = request.getParameter("hotelAddress");
//                    city = request.getParameter("hotelCity");
//                    zip = request.getParameter("hotelZip");
//                    state = request.getParameter("hotelState");
//                    notes = request.getParameter("hotelNote");
//                    hotel.setCity(city);
//                    hotel.setHotelName(name);
//                    hotel.setNotes(notes);
//                    hotel.setZip(zip);
//                    hotel.setCustState(state);
//                    hotel.setStreetAddress(address);
                    
                    hotelService.edit(hotel);
                    
                    response.setContentType("application/json; charset=UTF-8");
                    response.setStatus(200);
                    out.write("{\"success\":\"true\"}");
                    out.flush();
                break;
//                case ACTION_LIST:
//                    List<Hotel> hotels = hotelService.findAll();
//                    refreshHotelList(request,response);
//                break; 
                case ACTION_SEARCH:
                    switch(Integer.parseInt(request.getParameter("searchOptions")))
                    {
                        case ALL_HOTELS:
                        break;
                        case SEARCH_BY_STATE:
                        request.setAttribute("state", request.getParameter("state"));
                        break;
                        case SEARCH_BY_CITY:
                        request.setAttribute("city", request.getParameter("city"));
                        break;
                    }
                    break;
                default:
                    break;
            }
            
            //List<Hotel> hotels = hotelService.findAll();  
            //request.setAttribute("hotelList", hotels);
            refreshHotelList(request,response,hotelService);
            
            
        }
       
//        List<Hotel> hotels = hotelService.findAll();
//        request.setAttribute("hotelList", hotels);

                
       // String sessionCount = Integer.toString(sl.getTotalSessions());
       // request.setAttribute("activeSessionCount", sessionCount);
               
        view = request.getRequestDispatcher(RESULT_PAGE);        
        view.forward(request, response);
    }

    
    private void refreshHotelList(HttpServletRequest request, HttpServletResponse response, HotelFacade hotelService)
            throws ServletException, IOException {

        List<Hotel> hotels = hotelService.findAll();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        hotels.forEach((hotel) -> {
            jsonArrayBuilder.add(
                    Json.createObjectBuilder()
                    .add("hotelId", hotel.getHotelId())
                    .add("name", hotel.getHotelName())
                    .add("address", hotel.getStreetAddress())
                    .add("city", hotel.getCity())
                    .add("zip", hotel.getZip())
            );
        });

        JsonArray hotelsJson = jsonArrayBuilder.build();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write(hotelsJson.toString());
        out.flush();
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HotelController2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HotelController2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
