package com.lhsystems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMaximumFlightChain {
  private MaximumFlightChain maximumFlightChain = new MaximumFlightChain();

  @Test
  public void testWhenFlightsAreOrdered(){
    List<FlightChain> validFlightChains = new ArrayList<>();

    FlightChain expectedFlightChain1 = new FlightChain(new Flight(1, 3));
    expectedFlightChain1.append(new Flight(6, 8));

    FlightChain expectedFlightChain2 = new FlightChain(new Flight(3, 5));
    expectedFlightChain2.append(new Flight(6, 8));

    validFlightChains.add(expectedFlightChain1);
    validFlightChains.add(expectedFlightChain2);

    List<Flight> flights = new ArrayList<>();

    Flight flight1 = new Flight(1, 3);
    Flight flight2 = new Flight(3, 5);
    Flight flight3 = new Flight(6, 8);

    flights.add(flight1);
    flights.add(flight2);
    flights.add(flight3);

    FlightChain output = maximumFlightChain.findLongestFlightChain(flights);
    assertTrue(validFlightChains.contains(output));
  }

  @Test
  public void testWhenFlightsAreInRandomOrder(){
    FlightChain expectedFlightChain = new FlightChain(new Flight(1, 3));
    expectedFlightChain.append(new Flight(4, 5));
    expectedFlightChain.append(new Flight(6, 7));

    List<Flight> flights = new ArrayList<>();

    Flight flight1 = new Flight(3, 5);
    Flight flight2 = new Flight(1, 3);
    Flight flight3 = new Flight(2, 5);
    Flight flight4 = new Flight(6, 7);
    Flight flight5 = new Flight(4, 5);

    flights.add(flight1);
    flights.add(flight2);
    flights.add(flight3);
    flights.add(flight4);
    flights.add(flight5);

    FlightChain output = maximumFlightChain.findLongestFlightChain(flights);
    assertEquals(expectedFlightChain, output);
  }

  @Test
  public void testToStringOnSingleFlightChain(){
    String expectedOutput = "{1,3}";

    FlightChain flightChain = new FlightChain(new Flight(1, 3));

    String output = flightChain.toString();
    assertEquals(expectedOutput, output);
  }

  @Test
  public void testToStringOnComplexFlightChain(){
    String expectedOutput = "{1,3}{4,5}{6,7}{8,9}{10,12}{13,17}{19,24}";

    FlightChain flightChain = new FlightChain(new Flight(1, 3));
    flightChain.append(new Flight(4, 5));
    flightChain.append(new Flight(6, 7));
    flightChain.append(new Flight(8, 9));
    flightChain.append(new Flight(10, 12));
    flightChain.append(new Flight(13, 17));
    flightChain.append(new Flight(19, 24));

    String output = flightChain.toString();
    assertEquals(expectedOutput, output);
  }

  @Test
  public void testMaxFlightChainCreatinWithToString(){
    List<String> validOutputs = Stream.of("{1,3}{4,5}{8,9}{10,11}", "{1,3}{4,7}{8,9}{10,11}", "{1,3}{5,6}{8,9}{10,11}").collect(Collectors.toList());

    List<Flight> flights = new ArrayList<>();

    Flight flight1 = new Flight(6, 12);
    Flight flight2 = new Flight(10, 11);
    Flight flight3 = new Flight(8, 9);
    Flight flight4 = new Flight(4, 7);
    Flight flight5 = new Flight(5, 6);
    Flight flight6 = new Flight(4, 5);
    Flight flight7 = new Flight(1, 3);

    flights.add(flight1);
    flights.add(flight2);
    flights.add(flight3);
    flights.add(flight4);
    flights.add(flight5);
    flights.add(flight6);
    flights.add(flight7);

    FlightChain output = maximumFlightChain.findLongestFlightChain(flights);

    assertTrue(validOutputs.contains(output.toString()));
  }
}