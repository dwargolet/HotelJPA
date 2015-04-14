package hotel.ejb;

import hotel.entity.Hotel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;

/**
 *
 * @author Daniel
 */
@Stateless
public class HotelFacade extends AbstractFacade<Hotel> {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG
            = LoggerFactory.getLogger(HotelFacade.class);

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HotelFacade() {
        super(Hotel.class);
    }

    public void deleteById(Integer id) {
        Hotel hotel = this.find(id);
        this.remove(hotel);
    }

    /**
     * Demonstrates using logging
     * @return 
     */
    public List<Hotel> findAllHotels() {
        LOG.debug("finding all hotels");
        List<Hotel> hotels = findAll();
        LOG.debug("Found {} hotels", hotels.size());
        return hotels;
    }
    
    // demo Spring method-level security...
    
    @Secured({"ROLE_ADMIN"})
    public Hotel editHotel(Hotel hotel) {
        edit(hotel);
        return this.find(hotel.getHotelId());
    }
    
    @Secured({"ROLE_ADMIN"})
    public void deleteHotelById(Integer id) {
        this.deleteById(id);
    }

    /**
     * Finds hotels by a search key, which is checked against one of these
     * fields: name, city, zip
     *
     * @param searchKey - a value or portion of a value of a field for name,
     * city or zip
     * @return matching hotel records
     */
    public List<Hotel> searchForHotelByAny(String searchKey) {
        String jpql = "select h from Hotel h where h.name LIKE :searchKey OR h.city LIKE :searchKey OR h.zip LIKE :searchKey";
        TypedQuery<Hotel> query = getEntityManager().createQuery(jpql, Hotel.class);
        query.setParameter("searchKey", "%" + searchKey + "%");
        return query.getResultList();
    }

}
