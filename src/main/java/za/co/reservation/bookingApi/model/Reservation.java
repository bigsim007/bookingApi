package za.co.reservation.bookingApi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@Column(updatable = false, nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="test_sequence")
    //@SequenceGenerator(name = "test_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    private Long id;

    private String room;
    private int price;

    private int rooms;

    private int persons;

    private int children;

    private String openBuffet;
    private Date arrivalDate;

    private Date departureDate;

    private int stayDays;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    public Reservation() {
    }

    public Reservation(String room, int price, int rooms, int persons, int children,
                       String openBuffet, Date arrivalDate, int stayDays, Client client) {
        this.room = room;
        this.price = price;
        this.rooms = rooms;
        this.persons = persons;
        this.children = children;
        this.openBuffet = openBuffet;
        this.arrivalDate = arrivalDate;
        this.stayDays = stayDays;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getOpenBuffet() {
        return openBuffet;
    }

    public void setOpenBuffet(String openBuffet) {
        this.openBuffet = openBuffet;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getStayDays() {
        return stayDays;
    }

    public void setStayDays(int stayDays) {
        this.stayDays = stayDays;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room='" + room + '\'' +
                ", price=" + price +
                ", rooms=" + rooms +
                ", persons=" + persons +
                ", children=" + children +
                ", openBuffet='" + openBuffet + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", stayDays=" + stayDays +
                ", client=" + client +
                '}';
    }
}
