package RulesForLsp.SignatureRule;

public class ReturnType {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child   = new Child();

        // Using Child object with Client
        Client client1 = new Client(child);
        client1.takeAnimal();

        // Using Parent object with Client
        Client client2 = new Client(parent);
        client2.takeAnimal();
    }
}

// Return Type Rule:
// Subtype overridden method return type can be a subclass of the parent method's return type.
// This is called "covariant return type". Java supports this.

class Animal {
    // Common Animal methods
}

class Dog extends Animal {
    // Dog-specific methods
}

class Parent {
    public Animal getAnimal() {
        System.out.println("Parent : Returning Animal instance");
        return new Animal();
    }
}

class Child extends Parent {
    @Override
    public Dog getAnimal() { // Covariant return type (Dog is a subclass of Animal)
        System.out.println("Child : Returning Dog instance");
        return new Dog();
    }
}

class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void takeAnimal() {
        Animal a = p.getAnimal(); // Works even if p.getAnimal() returns Dog
    }
}