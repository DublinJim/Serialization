import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Serializer {

    public static void main(String[] args) {

        //					Steps to Deserialize
        //					---------------------------------------------------------------
        //					1. Your class should implement Serializable interface
        //					2. add import java.io.Serializable;
        //					3. FileInputStream fileIn = new FileInputStream(file path);
        //					4. ObjectInputStream in = new ObjectInputStream(fileIn);
        //					5. objectNam = (Class) in.readObject();
        //					6. in.close(); fileIn.close();
        //					---------------------------------------------------------------

        User user = null;

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                "file.ser"));
            user = (User) in.readObject();
            in.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert user != null;
        user.sayHello();
        System.out.println(user);
    }
}
