package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }


    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() <= passengers.size()) {
            throw new IllegalArgumentException("No more seat in the boat!");
        }
        passengers.add(passenger);
    }


    public double getPriceForPassenger(Passenger passenger) {

        return basicPrice * passenger.getCruiseClass().getValue();
    }


    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        throw new IllegalArgumentException("No passenger found: " + name);
    }


    public List<String> getPassengerNamesOrdered() {
        List<String> nameList = new ArrayList<>();
        for (Passenger passenger : passengers) {
            nameList.add(passenger.getName());

        }
        Collections.sort(nameList);
        return nameList;

    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger passenger : passengers) {
            sum += getPriceForPassenger(passenger);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> count = new HashMap<>();
        for (Passenger passenger : passengers) {
            if (!count.containsKey(passenger.getCruiseClass())) {
                count.put(passenger.getCruiseClass(), 1);
            } else {
                count.put(passenger.getCruiseClass(), count.get(passenger.getCruiseClass()) + 1);
            }

        }
        return count;
    }

}