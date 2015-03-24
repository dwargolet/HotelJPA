
package hotel.model;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "hotel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
    @NamedQuery(name = "Hotel.findByHotelId", query = "SELECT h FROM Hotel h WHERE h.hotelId = :hotelId"),
    @NamedQuery(name = "Hotel.findByHotelName", query = "SELECT h FROM Hotel h WHERE h.hotelName = :hotelName"),
    @NamedQuery(name = "Hotel.findByStreetAddress", query = "SELECT h FROM Hotel h WHERE h.streetAddress = :streetAddress"),
    @NamedQuery(name = "Hotel.findByCity", query = "SELECT h FROM Hotel h WHERE h.city = :city"),
    @NamedQuery(name = "Hotel.findByState", query = "SELECT h FROM Hotel h WHERE h.custState = :custState"),
    @NamedQuery(name = "Hotel.findByPostalCode", query = "SELECT h FROM Hotel h WHERE h.zip = :zip"),
    @NamedQuery(name = "Hotel.findByNotes", query = "SELECT h FROM Hotel h WHERE h.notes = :notes")})
    
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "hotel_id")
    private int hotelId;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String custState;
    @Column(name = "postal_code")
    private String zip;
    @Column(name = "notes")
    private String notes;

    
    
    
    public Hotel(int hotelId) {
        this.hotelId = hotelId;
    }
    
    
    public Hotel() {
    }

    public Hotel(int hotelId, String hotelName, String streetAddress, String city, String custState, String zip, String notes) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.custState = custState;
        this.zip = zip;
        this.notes = notes;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.hotelId;
        return hash;
    }

    @Override
    public String toString() {
        return "Hotel2{" + "hotelId=" + hotelId + ", hotelName=" + hotelName + ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + custState + ", zip=" + zip + ", notes=" + notes + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (this.hotelId != other.hotelId) {
            return false;
        }
        return true;
    }
    
    
    
    
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCustState() {
        return custState;
    }

    public void setCustState(String custState) {
        this.custState = custState;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
