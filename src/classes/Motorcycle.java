package classes;

import abstractClass.Vehicle;

public class Motorcycle extends Vehicle {
    private final int riderAge;
    private static final int RENTAL_DAYS_THRESHOLD = 7;
    private static final int DAILY_RENTAL_COST_MOTORCYCLE = 15;
    private static final int DAILY_RENTAL_COST_MOTORCYCLE_MORE_THAN_WEEK = 10;
    private static final double INSURANCE_RATE = 0.0002; // 0.02%
    private static final int AGE_THRESHOLD = 25;
    private static final double YOUNG_RIDER_CHARGE = 1.20;
    private boolean doesMotorcycleHaveCharge;

    public Motorcycle(String brand, String model, double value, int riderAge) {
        super(brand, model, value);
        this.riderAge = riderAge;
    }

    @Override
    public double getDailyRentalCost(int rentalPeriod) {
        return rentalPeriod <= RENTAL_DAYS_THRESHOLD ? DAILY_RENTAL_COST_MOTORCYCLE : DAILY_RENTAL_COST_MOTORCYCLE_MORE_THAN_WEEK;
    }

    @Override
    public double getDailyInsuranceCost() {
        double insuranceCost = INSURANCE_RATE * vehiclePriceValue;
        if (riderAge < AGE_THRESHOLD) {
            doesMotorcycleHaveCharge = true;
            insuranceCost *= YOUNG_RIDER_CHARGE;
        }
        return insuranceCost;
    }
    @Override
    public double getVehicleCharge() {
        return (INSURANCE_RATE * vehiclePriceValue) * 0.2;
    }


    @Override
    public double getDailyInitialInsuranceCost() {
        return INSURANCE_RATE * vehiclePriceValue;
    }

    @Override
    public double getVehicleDiscount() {
        return 0;
    }
    @Override
    public boolean isVehicleChargedOrHasDiscount() {
        return doesMotorcycleHaveCharge;
    }
}


