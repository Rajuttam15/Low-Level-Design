// Method Argument Rule : 
// Subtype method arguments can be identical or wider than the supertype
// Java enforces this by requiring the same method signature for overrides


package RulesForLsp.SignatureRule;

// Superclass (package-private)
class Parent1 {
    public void print(String msg) {
        System.out.println("Parent: " + msg);
    }
}

// Subclass
class Child extends Parent1 {
    @Override
    public void print(String msg) {
        System.out.println("Child: " + msg);
    }
}

// Client
class Client {
    private Parent1 p;

    public Client(Parent1 p) {
        this.p = p;
    }

    public void printMsg() {
        p.print("Hello");
    }
}

// Main class (public — matches file name)
public class MethodArgument {
    public static void main(String[] args) {
        Parent1 parent = new Parent1();
        Parent1 child = new Child();

        // Using Parent instance
        Client client1 = new Client(parent);
        client1.printMsg();

        // Using Child instance (substituted in place of Parent)
        Client client2 = new Client(child);
        client2.printMsg();
    }
}