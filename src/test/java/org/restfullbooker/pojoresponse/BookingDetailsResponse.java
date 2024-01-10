package org.restfullbooker.pojoresponse;

import org.restfullbooker.pojorequest.BookingDetails;

public class BookingDetailsResponse {

    int bookingid;
    BookingDetails bookingDetails;

    @Override
    public String toString() {
        return "BookingDetailsResponse{" +
                "bookingid=" + bookingid +
                ", bookingDetails=" + bookingDetails +
                '}';
    }
}
