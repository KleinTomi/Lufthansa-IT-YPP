package com.lhsystems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumFlightChain {
    // TODO implement me
    public FlightChain findLongestFlightChain(List<Flight> flights){
        int min = 999; //sets the minimum to big amount
        List<Integer> startList = new ArrayList<Integer>();
        Flight firstFlight = null;
        List<Flight> orderedflights;

        for (Flight f : flights)
        {
            startList.add(f.getStartHour());
            if (min > f.getStartHour()){
                min = f.getStartHour();
                firstFlight = f;

            } // it finds the first flight by its start hour
          //sets the minimum to the end hour of the first flight

        }
        min = firstFlight.getEndHour();
        FlightChain resFlights = new FlightChain(firstFlight);
        Collections.sort(startList);
        for (int i = 0; i < startList.size(); i++) { //the size() counts the number of flights in the list
            Flight nextf = null;
            for (Flight f : flights)
            {
                if (min < f.getStartHour()){
                    nextf = f;
                }else {
                    if (nextf != null){}else {
                        nextf = null;
                    }
                }


            }
            if (nextf != null) {
                min = nextf.getEndHour();
                resFlights.append(nextf);//this iterates through the list for a maximum of "startList.size" times to find the next flight that starthour is higher than the previous flight endhour
            }
        }
        return resFlights;





    }
}
