import abstractClass.Vehicle;
import classes.Car;
import classes.CargoVan;
import classes.Motorcycle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Invoice {
    private final RentalInfo rentalInfo;

    public Invoice(RentalInfo rentalInfo) {
        this.rentalInfo = rentalInfo;
    }

    public void display() {
        Vehicle vehicle = rentalInfo.getVehicle();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        double totalRentalCost = rentalInfo.calculateTotalRentalCost();
        double totalInsuranceCost = rentalInfo.calculateTotalInsuranceCost();
        double earlyReturnDiscountRent = rentalInfo.calculateEarlyReturnDiscountForRent();
        double earlyReturnDiscountInsurance = rentalInfo.calculateEarlyReturnDiscountForInsurance();

        StringBuilder invoiceBuilder = new StringBuilder();
        invoiceBuilder.append("XXXXXXXXXX\n")
                .append("Date: ").append(LocalDate.now().format(formatter)).append("\n")
                .append("Customer Name: ").append(rentalInfo.getCustomerName()).append("\n")
                .append("Rented Vehicle: ").append(vehicle.getVehicleBrand()).append(" ").append(vehicle.getModel()).append("\n\n")
                .append("Reservation start date: ").append(rentalInfo.getReservationStartDate().format(formatter)).append("\n")
                .append("Reservation end date: ").append(rentalInfo.getReservationEndDate().format(formatter)).append("\n")
                .append("Reserved rental days: ").append(ChronoUnit.DAYS.between(rentalInfo.getReservationStartDate(), rentalInfo.getReservationEndDate())).append(" days\n\n")
                .append("Actual return date: ").append(rentalInfo.getActualReturnDate().format(formatter)).append("\n")
                .append("Actual rental days: ").append(ChronoUnit.DAYS.between(rentalInfo.getReservationStartDate(), rentalInfo.getActualReturnDate())).append(" days\n\n")
                .append(String.format("Rental cost per day: $%.2f%n", vehicle.getDailyRentalCost((int) (ChronoUnit.DAYS.between(rentalInfo.getReservationStartDate(), rentalInfo.getReservationEndDate())))));

        if(vehicle.isVehicleChargedOrHasDiscount()) {
            if (vehicle instanceof CargoVan || vehicle instanceof Car) {
                invoiceBuilder.append(String.format("Initial insurance per day: $%.2f%n", vehicle.getDailyInitialInsuranceCost()));
                invoiceBuilder.append(String.format("Insurance discount per day: $%.2f%n", vehicle.getVehicleDiscount()));
            }

            if (vehicle instanceof Motorcycle && vehicle.getVehicleCharge() != 0) {
                invoiceBuilder.append(String.format("Initial insurance per day: $%.2f%n", vehicle.getDailyInitialInsuranceCost()));
                invoiceBuilder.append(String.format("Insurance addition per day: $%.2f%n", vehicle.getVehicleCharge()));
            }
        }

            invoiceBuilder.append(String.format("Insurance per day: $%.2f%n%n", vehicle.getDailyInsuranceCost()));
            if (earlyReturnDiscountRent > 0) {
                invoiceBuilder.append(String.format("Early return discount for rent: $%.2f%n", earlyReturnDiscountRent))
                        .append(String.format("Early return discount for insurance: $%.2f%n", earlyReturnDiscountInsurance));
            }


        invoiceBuilder.append(String.format("Total rent: $%.2f%n", totalRentalCost - earlyReturnDiscountRent))
                .append(String.format("Total insurance: $%.2f%n%n", totalInsuranceCost - earlyReturnDiscountInsurance))
                .append(String.format("Total: $%.2f%n", totalRentalCost + totalInsuranceCost - earlyReturnDiscountRent - earlyReturnDiscountInsurance))
                .append("XXXXXXXXXX\n");


        System.out.println(invoiceBuilder.toString());
    }
}
