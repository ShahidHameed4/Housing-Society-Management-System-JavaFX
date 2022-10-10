package HSMS.Property;

import HSMS.Property.Property;

public class RentedProperty extends Property {

    private int rentAmount;
    private float rentIncrement;

    public int getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }

    public float getRentIncrement() {
        return rentIncrement;
    }

    public void setRentIncrement(float rentIncrement) {
        this.rentIncrement = rentIncrement;
    }
}
