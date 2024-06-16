import abstractClass.Vehicle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalInfo {
    private final String customerName;
    private final Vehicle vehicle;
    private final LocalDate reservationStartDate;
    private final LocalDate reservationEndDate;
    private final LocalDate actualReturnDate;

    public RentalInfo(String customerName, Vehicle vehicle, LocalDate reservationStartDate, LocalDate reservationEndDate, LocalDate actualReturnDate) {
        this.customerName = customerName;
        this.vehicle = vehicle;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.actualReturnDate = actualReturnDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public int getReservedRentalDays() {
        return (int) ChronoUnit.DAYS.between(reservationStartDate, reservationEndDate);
    }

    public int getActualRentalDays() {
        return (int) ChronoUnit.DAYS.between(reservationStartDate, actualReturnDate);
    }

    public double calculateTotalRentalCost() {
        int allRentalDays = getReservedRentalDays();
        return allRentalDays * vehicle.getDailyRentalCost(getReservedRentalDays());
    }

    public double calculateTotalInsuranceCost() {
        int allRentalDays = getReservedRentalDays();
        return allRentalDays * vehicle.getDailyInsuranceCost();
    }

    public double calculateEarlyReturnDiscountForRent() {
        int reservedDays = getReservedRentalDays();
        int actualRentalDays = getActualRentalDays();
        if (actualRentalDays != reservedDays) {
            return (reservedDays - actualRentalDays) * vehicle.getDailyRentalCost(reservedDays) /2;
        }
        return 0;
    }
    public double calculateEarlyReturnDiscountForInsurance() {
        int reservedDays = getReservedRentalDays();
        int actualRentalDays = getActualRentalDays();
        if (actualRentalDays != reservedDays) {
            return (reservedDays - actualRentalDays) * vehicle.getDailyInsuranceCost();
        }
        return 0;


    }

}