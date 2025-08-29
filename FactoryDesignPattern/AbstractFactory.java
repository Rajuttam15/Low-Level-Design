package FactoryDesignPattern;

public class AbstractFactory {
        public static void main(String[] args) {
        String roomType = "deluxe";
        String restaurantType = "veg";

        // Choose a Hotel Factory
        HotelFactory hotelFactory = new BasicHotel(); 

        // Create products
        Room room = hotelFactory.createRoom(roomType);
        Restaurant restaurant = hotelFactory.createRestaurant(restaurantType);

        if (room != null) room.book();
        if (restaurant != null) restaurant.reserve();
        System.out.println("--------------------");
        hotelFactory = new VipHotel();
        room = hotelFactory.createRoom(roomType);
        restaurant = hotelFactory.createRestaurant("nonveg");
        if (room != null) room.book();
        if (restaurant != null) restaurant.reserve();
        
    }
}

// --- Product 1: Room ---
interface Room {
    void book();
}

class StandardRoom implements Room {
    public void book() {
        System.out.println("Booking a Standard Room (AC, TV, single bed).");
    }
}

class DeluxeRoom implements Room {
    public void book() {
        System.out.println("Booking a Deluxe Room (AC, TV, double bed, WiFi).");
    }
}

class SuiteRoom implements Room {
    public void book() {
        System.out.println("Booking a Suite Room (Luxury bed, minibar, ocean view).");
    }
}

// --- Product 2: Restaurant ---
interface Restaurant {
    void reserve();
}

class VegRestaurant implements Restaurant {
    public void reserve() {
        System.out.println("Reserving a table at Veg Restaurant (Pure Veg Menu).");
    }
}

class NonVegRestaurant implements Restaurant {
    public void reserve() {
        System.out.println("Reserving a table at Non-Veg Restaurant (Includes chicken, fish, etc).");
    }
}

// --- Abstract Factory ---
interface HotelFactory {
    Room createRoom(String type);
    Restaurant createRestaurant(String type);
}

// --- Concrete Factory 1: Basic Hotel ---
class BasicHotel implements HotelFactory {
    public Room createRoom(String type) {
        if (type.equalsIgnoreCase("standard")) {
            return new StandardRoom();
        } else if (type.equalsIgnoreCase("deluxe")) {
            return new DeluxeRoom();
        } else {
            System.out.println("Invalid room type for Basic Hotel!");
            return null;
        }
    }

    public Restaurant createRestaurant(String type) {
        if (type.equalsIgnoreCase("veg")) {
            return new VegRestaurant();
        } else {
            System.out.println("Basic Hotel only provides Veg Restaurant!");
            return null;
        }
    }
}

// --- Concrete Factory 2: VIP Hotel ---
class VipHotel implements HotelFactory {
    public Room createRoom(String type) {
        if (type.equalsIgnoreCase("standard")) {
            return new DeluxeRoom(); // VIP hotel doesn't give very basic rooms
        } else if (type.equalsIgnoreCase("deluxe")) {
            return new DeluxeRoom();
        } else if (type.equalsIgnoreCase("suite")) {
            return new SuiteRoom();
        } else {
            System.out.println("Invalid room type for VIP Hotel!");
            return null;
        }
    }

    public Restaurant createRestaurant(String type) {
        if (type.equalsIgnoreCase("veg")) {
            return new VegRestaurant();
        } else if (type.equalsIgnoreCase("nonveg")) {
            return new NonVegRestaurant();
        } else {
            System.out.println("Invalid restaurant type for VIP Hotel!");
            return null;
        }
    }
}