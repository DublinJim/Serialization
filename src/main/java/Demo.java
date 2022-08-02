import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Begin");

        //					Steps to Serialize
        //					---------------------------------------------------------------
        //					1. Your class should implement Serializable interface
        //					2. add import java.io.Serializable;
        //					3. FileOutputStream fileOut = new FileOutputStream(file path)
        //					4. ObjectOutputStream out = new ObjectOutputStream(fileOut);
        //					5. out.writeObject(objectName)
        //					6. out.close(); fileOut.close();
        //					---------------------------------------------------------------

        User user = new User();

        user.name = "Joe";
        user.password = "password";

        user.sayHello();

        try {
            FileOutputStream fileOut = new FileOutputStream("file.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(user);
            objOut.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
