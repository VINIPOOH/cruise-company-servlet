package ua.training.model.dto;

import ua.training.model.entity.Cruise;

public class TicketCruiseDTO {
    private long id;
    private String ticketName;
    private long priceWithDiscount;
    private Cruise cruise;

    public TicketCruiseDTO(long id, String ticketName, long priceWithDiscount) {
        this.id = id;
        this.ticketName = ticketName;
        this.priceWithDiscount = priceWithDiscount;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public long getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(long priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    @Override
    public String toString() {
        return "TicketCruiseDTO{" +
                "id=" + id +
                ", ticketName='" + ticketName + '\'' +
                ", priceWithDiscount=" + priceWithDiscount +
                ", cruise=" + cruise +
                '}';
    }
}