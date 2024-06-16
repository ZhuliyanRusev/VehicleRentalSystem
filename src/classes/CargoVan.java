package classes;

import abstractClass.Vehicle;

public class CargoVan extends Vehicle {
    private final int driverExperience;
    private static final int RENTAL_DAYS_THRESHOLD = 7;
    private static final int DAILY_RENTAL_COST_CARGO_VAN = 50;
    private static final int DAILY_RENTAL_COST_CARGO_VAN_MORE_THAN_WEEK = 40;
    private static final double INSURANCE_RATE = 0.0003; // 0.03%
    private static final int EXPERIENCE_THRESHOLD = 5;
    private static final double EXPERIENCE_DISCOUNT = 0.85;
    private boolean doesCargoVanHaveADiscount;

    public CargoVan(String brand, String model, double value, int driverExperience) {
        super(brand, model, value);
        this.driverExperience = driverExperience;
    }

    @Override
    public double getDailyRentalCost(int rentalPeriod) {
        return rentalPeriod <= RENTAL_DAYS_THRESHOLD ? DAILY_RENTAL_COST_CARGO_VAN : DAILY_RENTAL_COST_CARGO_VAN_MORE_THAN_WEEK;
    }

    @Override
    public double getDailyInsuranceCost() {
        double insuranceCost = INSURANCE_RATE * vehiclePriceValue;
        if (driverExperience > EXPERIENCE_THRESHOLD) {
            doesCargoVanHaveADiscount = true;
            insuranceCost *= EXPERIENCE_DISCOUNT;
        }
        return insuranceCost;
    }

    @Override
    public double getDailyInitialInsuranceCost() {
        return INSURANCE_RATE * vehiclePriceValue;
    }

    @Override
    public double getVehicleDiscount() {
        return (INSURANCE_RATE * vehiclePriceValue) * 0.15;
    }

    @Override
    public double getVehicleCharge() {
        return 0;
    }

    @Override
    public boolean isVehicleChargedOrHasDiscount() {
        return doesCargoVanHaveADiscount;
    }
}


