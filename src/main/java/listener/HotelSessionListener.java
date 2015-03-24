package listener;

/**
 *
 * @author Daniel
 */

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class HotelSessionListener implements HttpSessionListener {

    public static int sessionCount = 0;


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ++sessionCount;
        se.getSession().getServletContext().setAttribute("sessionCount", HotelSessionListener.sessionCount);
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        --sessionCount;
        se.getSession().getServletContext().setAttribute("sessionCount", HotelSessionListener.sessionCount);
    }
    
    public int getTotalSessions(){
        return sessionCount;
    }

}
