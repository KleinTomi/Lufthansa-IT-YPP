package com.lhsystems;

public class FlightChain {
    private FlightChain next;
    private Flight currentFlight;

    public FlightChain(Flight currentFlight) {
        this.currentFlight = currentFlight;
    }

    public void append(Flight flight){
        FlightChain lastInTheChain = this;
        while(lastInTheChain.next != null){
            lastInTheChain = lastInTheChain.next;
        }

        lastInTheChain.next = new FlightChain(flight);
    }

    public FlightChain getNext() {
        return next;
    }

    public Flight getCurrentFlight() {
        return currentFlight;
    }

    // TODO implement me
    @Override
    public String toString(){

        String output = "";
        FlightChain lastInTheChain = this;
        while(lastInTheChain != null){
            Flight currentFlight = lastInTheChain.getCurrentFlight();
            output += "{"+currentFlight.getStartHour()+","+currentFlight.getEndHour()+"}";
            lastInTheChain = lastInTheChain.next;
        }


        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightChain that = (FlightChain) o;

        if (next != null ? !next.equals(that.next) : that.next != null) return false;
        return currentFlight != null ? currentFlight.equals(that.currentFlight) : that.currentFlight == null;
    }

    @Override
    public int hashCode() {
        int result = next != null ? next.hashCode() : 0;
        result = 31 * result + (currentFlight != null ? currentFlight.hashCode() : 0);
        return result;
    }
}
