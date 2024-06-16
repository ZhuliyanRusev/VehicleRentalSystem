package classes;

import abstractClass.Vehicle;

public class Car extends Vehicle {
    private final int safetyRating;
    private static final int RENTAL_DAYS_THRESHOLD = 7;
    private static final int DAILY_RENTAL_COST_CAR = 20;
    private static final int DAILY_RENTAL_COST_CAR_MORE_THAN_WEEK = 15;
    private static final double INSURANCE_RATE = 0.0001; // 0.01%
    private static final int SAFETY_RATING_THRESHOLD = 4;
    private static final double INSURANCE_DISCOUNT_FOR_SAFETY = 0.90;

    private boolean doesCarHaveADiscount;
    public Car(String brand, String model, double value, int safetyRating) {
        super(brand, model, value);
        this.safetyRating = safetyRating;
    }



    @Override
    public double getDailyRentalCost(int rentalPeriod) {
        return rentalPeriod <= RENTAL_DAYS_THRESHOLD ? DAILY_RENTAL_COST_CAR : DAILY_RENTAL_COST_CAR_MORE_THAN_WEEK;
    }

    @Override
    public double getDailyInsuranceCost() {
        double insuranceCost = INSURANCE_RATE * vehiclePriceValue;
        if (safetyRating >= SAFETY_RATING_THRESHOLD) {
            doesCarHaveADiscount = true;
            insuranceCost *= INSURANCE_DISCOUNT_FOR_SAFETY;
        }
        return insuranceCost;
    }

    @Override
    public double getDailyInitialInsuranceCost() {
        return  INSURANCE_RATE * vehiclePriceValue;
    }

    @Override
    public double getVehicleDiscount() {
        return  (INSURANCE_RATE * vehiclePriceValue) * 0.10;
    }

    @Override
    public double getVehicleCharge() {
        return 0;
    }
    @Override
    public boolean isVehicleChargedOrHasDiscount() {
        return doesCarHaveADiscount;
    }
}

