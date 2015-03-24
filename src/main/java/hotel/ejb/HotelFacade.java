package hotel.ejb;

import hotel.model.Hotel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;
/**
 *
 * @author Daniel
 */
@Stateless
public class HotelFacade extends AbstractFacade{
    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HotelFacade() {
        super(Hotel.class);
    }
    
    public List<Hotel> findByState(String custState)
    {
        Query q = this.getEntityManager().createNamedQuery("Hotel.findByState");
        q.setParameter(1, custState);
        return q.getResultList();
    }
    
}
