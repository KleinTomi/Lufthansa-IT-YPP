package com.lhsystems;

public class Flight {
    private int startHour;

    private int endHour;

    public Flight(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (startHour != flight.startHour) return false;
        return endHour == flight.endHour;
    }

    @Override
    public int hashCode() {
        int result = startHour;
        result = 31 * result + endHour;
        return result;
    }
}
