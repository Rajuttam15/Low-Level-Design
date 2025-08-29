package FactoryDesignPattern;

public class FactoryMethod {
    public static void main(String[] args) {
        
        // Client doesn’t know which class is being used
        CarFactory sedanFactory = new SedanFactory();
        Car sedan = sedanFactory.createCar();
        sedan.buy();

        CarFactory suvFactory = new SuvFactory();
        Car suv = suvFactory.createCar();
        suv.buy();

        CarFactory hatchbackFactory = new HatchbackFactory();
        Car hatchback = hatchbackFactory.createCar();
        hatchback.buy();
    }
}


interface Car {
    void buy();
}

// ---------------- Concrete Products ----------------
class Sedan implements Car {
    public void buy() {
        System.out.println("Buying a Sedan car");
    }
}

class Suv implements Car {
    public void buy() {
        System.out.println("Buying an SUV car");
    }
}

class Hatchback implements Car {
    public void buy() {
        System.out.println("Buying a Hatchback car");
    }
}

// ---------------- Factory Interface ----------------
interface CarFactory {
    Car createCar(); // factory method
}

// ---------------- Concrete Factories ----------------
class SedanFactory implements CarFactory {
    public Car createCar() {
        return new Sedan();
    }
}

class SuvFactory implements CarFactory {
    public Car createCar() {
        return new Suv();
    }
}

class HatchbackFactory implements CarFactory {
    public Car createCar() {
        return new Hatchback();
    }
}

/* 
interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

class BasicWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, and ketchup!");
    }
}

class StandardWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

// Factory Interface and Concrete Factories
interface BurgerFactory {
    Burger createBurger(String type);
}

class SinghBurger implements BurgerFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}

class KingBurger implements BurgerFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}

// Main Class
public class FactoryMethod {
    public static void main(String[] args) {
        String type = "basic";

        BurgerFactory myFactory = new SinghBurger();
        Burger burger = myFactory.createBurger(type);

        if (burger != null) {
            burger.prepare();
        }
    }
}
*/