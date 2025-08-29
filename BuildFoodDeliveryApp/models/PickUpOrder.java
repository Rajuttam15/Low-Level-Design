package BuildFoodDeliveryApp.models;

public class PickUpOrder extends Order {
    private String restaurantAddress;

    public PickUpOrder() {
        restaurantAddress = "";
    }

    @Override
    public String getType() {
        return "Pickup";
    }

    public void setRestaurantAddress(String addr) {
        restaurantAddress = addr;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    // Implement remaining Order methods with actual fields
}
