package Problem_02_CarShop;

public interface Rentable extends Car {
    int MIN_RENT_DAYS = 0;

    double PRICE_PER_DAY = 0;

    int getMinRentDay();

    double getPricePerDay();
}
