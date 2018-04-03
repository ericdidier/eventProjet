package be.formation.backend.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Classe qui permet de définir le lieu du déroulement Event.
 */
@Entity
public class Venue extends BaseEntity {

    private String name ;

    private String city;

    @OneToMany(mappedBy = "venue")
    private List<Event> events ;

    public Venue(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
