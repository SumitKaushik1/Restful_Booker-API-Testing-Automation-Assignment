package org.restfullbooker.pojo;

public class BookingDetails {
    private String firstname;
    private String lastname;
    private int totalprice;

    private boolean depositepaid;

    private BookingDates bookingdates;

    private String addtionalneeds;

    public BookingDetails() {

    }


    public BookingDetails(String firstName, String lastName, int totalPrice, boolean depositePaid, BookingDates bookingDates, String addtionalneeds) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.totalprice = totalPrice;
        this.depositepaid = depositePaid;
        this.bookingdates = bookingDates;
        this.addtionalneeds = addtionalneeds;
    }

    public void getFirstName(String firstName){
        this.firstname=firstname;
    }

    public void getLastName(String lastName){
        this.lastname=lastname;
    }

    public void getTotalPrice(int totalPrice){
        this.totalprice=totalprice;
    }

    public void getDepositePaid(boolean depositePaid){
        this.depositepaid=depositepaid;
    }

    public boolean isDepositePaid() {
        return depositepaid;
    }

    public BookingDates getBookingDates() {
        return bookingdates;
    }

    public String getAddtionalneeds() {
        return addtionalneeds;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastname;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalprice = totalprice;
    }

    public void setDepositePaid(boolean depositePaid) {
        this.depositepaid = depositepaid;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingdates = bookingdates;
    }

    public void setAddtionalneeds(String addtionalneeds) {
        this.addtionalneeds = addtionalneeds;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", totalPrice=" + totalprice +
                ", depositePaid=" + depositepaid +
                ", bookingDates=" + bookingdates +
                ", addtionalneeds='" + addtionalneeds + '\'' +
                '}';
    }






    }










