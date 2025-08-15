package DIPViolationAndFollowed;

public class DIPViolated {
     public static void main(String[] args) {
        UserService1 service = new UserService1();
        service.storeUserToSQL("Aditya");
        service.storeUserToMongo("Rohit");
    }
}
class MySQLDatabase1 {  // Low-level module
    public void saveToSQL(String data) {
        System.out.println("Executing SQL Query: INSERT INTO users VALUES('" + data + "');");
    }
}

class MongoDBDatabase1 {  // Low-level module
    public void saveToMongo(String data) {
        System.out.println("Executing MongoDB Function: db.users.insert({name: '" + data + "'})");
    }
}

class UserService1 {  // High-level module (Tightly coupled)
    private final MySQLDatabase1 sqlDb = new MySQLDatabase1();      
    private final MongoDBDatabase1 mongoDb = new MongoDBDatabase1();

    public void storeUserToSQL(String user1) {
        // MySQL-specific code
        sqlDb.saveToSQL(user1);
    }

    public void storeUserToMongo(String user) {
        // MongoDB-specific code
        mongoDb.saveToMongo(user);
    }
}
