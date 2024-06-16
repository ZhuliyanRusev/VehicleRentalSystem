package abstractClass;

public abstract class Vehicle {
    protected String vehicleBrand;
    protected String model;
    protected double vehiclePriceValue;

    public Vehicle(String brand, String model, double vehiclePrice) {
        this.vehicleBrand = brand;
        this.model = model;
        this.vehiclePriceValue = vehiclePrice;
    }


    public abstract double getDailyRentalCost(int rentalPeriod);

    public abstract double getDailyInsuranceCost();

    public abstract double getDailyInitialInsuranceCost();
    public abstract double getVehicleDiscount();
    public abstract double getVehicleCharge();
    public abstract boolean isVehicleChargedOrHasDiscount();
    public String getVehicleBrand() {
        return vehicleBrand;
    }
    public String getModel() {
        return model;
    }
}

