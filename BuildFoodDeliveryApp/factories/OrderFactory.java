package BuildFoodDeliveryApp.factories;

import java.util.List;
import BuildFoodDeliveryApp.models.*;
import BuildFoodDeliveryApp.strategies.*;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}
