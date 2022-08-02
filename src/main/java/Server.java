import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import protoClasses.Student;

public class Server {

    public static final int PORT = 3191;
    static ServerSocket serverSocket;
    static Socket socket;
    static ObjectOutputStream objOut;
    static ObjectInputStream objIn;
    static Student student;




    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serverSocket = new ServerSocket(PORT);
        socket = serverSocket.accept();
        objOut = new ObjectOutputStream(socket.getOutputStream());
        objIn = new ObjectInputStream(socket.getInputStream());

        student = (Student) objIn.readObject();
        objIn.close();
        objOut.close();
        serverSocket.close();
        socket.close();
        System.out.println(student);
    }



}
