package be.formation.backend.model.entity;

import be.formation.backend.converter.LocalDateTimeAttributeConverter;
import be.formation.backend.converter.SendingModelConverter;
import be.formation.backend.converter.TypeEventConverter;
import be.formation.backend.enums.TypeEventEnum;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Event  extends  BaseEntity {

    private String  tilte ;

    private String description ;

    private  boolean ticketsAvailable;

    public Event() {
    }

    @Column(nullable = true)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDate dateTimeEvent;

    @Column(nullable = true, length = 15)
    @Convert(converter = TypeEventConverter.class)
    private TypeEventEnum typeEvent;

     @OneToMany(mappedBy = "event")
     private List<Booking> bookings;





}
