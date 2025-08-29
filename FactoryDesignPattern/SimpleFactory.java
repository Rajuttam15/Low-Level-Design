package FactoryDesignPattern;

public class SimpleFactory {
    public static void main(String[] args) {
        BrurgerFactory factory = new BrurgerFactory();

        Burger burger1 = factory.createBurger("basic");
        if (burger1 != null) {
            burger1.prepare();
        }

        Burger burger2 = factory.createBurger("standard");
        if (burger2 != null) {
            burger2.prepare();
        }

        Burger burger3 = factory.createBurger("premium");
        if (burger3 != null) {
            burger3.prepare();
        }

        Burger burger4 = factory.createBurger("unknown");
        if (burger4 != null) {
            burger4.prepare();
        }
    }
}

interface Burger {
    void prepare();
}

//concrete Burgers implementing Burger interface

class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger");
    }
}

// Making the Burger Factory

class BrurgerFactory {
    public Burger createBurger(String type) {
        if(type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        }
        else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}
