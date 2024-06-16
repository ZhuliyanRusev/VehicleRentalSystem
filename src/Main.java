import abstractClass.Vehicle;
import classes.Car;
import classes.CargoVan;
import classes.Motorcycle;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Mitsubishi", "Mirage", 15000, 3);
        RentalInfo carRental = new RentalInfo("John Doe", car,
                LocalDate.of(2024, 6, 3),
                LocalDate.of(2024, 6, 13),
                LocalDate.of(2024, 6, 13));
        new Invoice(carRental).display();


        Vehicle motorcycle = new Motorcycle("Triumph", "Tiger Sport 660", 10000, 20);
        RentalInfo motorcycleRental = new RentalInfo("Mary Johnson", motorcycle,
                LocalDate.of(2024, 6, 3),
                LocalDate.of(2024, 6, 13),
                LocalDate.of(2024, 6, 13));
        new Invoice(motorcycleRental).display();


        Vehicle cargoVan = new CargoVan("Citroen", "Jumper", 20000, 8);
        RentalInfo cargoVanRental = new RentalInfo("John Markson", cargoVan,
                LocalDate.of(2024, 6, 3),
                LocalDate.of(2024, 6, 18),
                LocalDate.of(2024, 6, 13));
        new Invoice(cargoVanRental).display();
    }
}
