package ua.training.entity;

import java.util.Set;

public class Order {
    private long id;
    private String firstName;
    private String secondName;
    private User user;
    private Cruise cruise;
    private Ticket ticket;
    private long orderPrice;

    private Set<Excursion> excursionList;

    public Order(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.user = builder.user;
        this.cruise = builder.cruise;
        this.ticket = builder.ticket;
        this.orderPrice = builder.orderPrice;
        this.excursionList = builder.excursionList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Set<Excursion> getExcursionList() {
        return excursionList;
    }


    @Override
    public String toString() {
        return "Order{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", user=" + user +
                ", cruise=" + cruise +
                ", ticket=" + ticket +
                '}';
    }

    public static class Builder {
        private long id;
        private String firstName;
        private String secondName;
        private User user;
        private Cruise cruise;
        private Ticket ticket;
        private long orderPrice;
        private Set<Excursion> excursionList;


        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder cruise(Cruise cruise) {
            this.cruise = cruise;
            return this;
        }

        public Builder ticket(Ticket ticket) {
            this.ticket = ticket;
            return this;
        }


        public Builder orderPrice(long price) {
            this.orderPrice = price;
            return this;
        }

        public Builder excursions(Set<Excursion> excursions) {
            this.excursionList = excursions;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
