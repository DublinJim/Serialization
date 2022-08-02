import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import protoClasses.Student;
import protoClasses.Student.ClassYear;
import protoClasses.Student.PhoneType;


public class Demo {

    public static void main(String[] args) throws IOException {
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

        ServerSocket serverSocket;
    
        ObjectOutputStream objOut = null;
        ObjectInputStream objIn;

        Student student1 = Student.newBuilder()
            .setId(34)
            .setName("Joe")
            .setPhonetype(PhoneType.MOBILE)
            .setClassyear(ClassYear.SENIOR)
            .build();
            
        
        Socket socket=new Socket("127.0.0.1", Server.PORT);
        try {
            objOut = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        objIn = new ObjectInputStream(socket.getInputStream());

        objOut.writeObject(student1);
        Server server = new Server();
        server.showStudent();

    }
}
