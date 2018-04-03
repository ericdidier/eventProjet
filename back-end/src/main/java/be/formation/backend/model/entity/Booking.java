package be.formation.backend.model.entity;

import be.formation.backend.converter.LocalDateTimeAttributeConverter;
import be.formation.backend.converter.SendingModelConverter;
import be.formation.backend.enums.SendingModeEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Booking extends  BaseEntity {

    private int ticketsCount ;

    @Column(nullable = true)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDate bookingDateTime;

    @Column(nullable = true, length = 1)
    @Convert(converter = SendingModelConverter.class)
    private SendingModeEnum sendingModeEnum;

    @ManyToOne
    private  User user;

    @OneToMany(mappedBy = "booking")
    private List<Ticket> tickets;

    @ManyToOne
    private Event event;

    public Booking() {
    }

    public int getTicketsCount() {
        return ticketsCount;
    }

    public void setTicketsCount(int ticketsCount) {
        this.ticketsCount = ticketsCount;
    }

    public LocalDate getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDate bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public SendingModeEnum getSendingModeEnum() {
        return sendingModeEnum;
    }

    public void setSendingModeEnum(SendingModeEnum sendingModeEnum) {
        this.sendingModeEnum = sendingModeEnum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
