import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import protoClasses.Student;

public class Server {

    public static final int PORT = 3191;
    ServerSocket serverSocket;
    Socket socket;
    ObjectOutputStream objOut;
    ObjectInputStream objIn;


    {
        try {
            serverSocket = new ServerSocket(PORT);
            socket = serverSocket.accept();
            objOut = new ObjectOutputStream(socket.getOutputStream());
            objIn = new ObjectInputStream(socket.getInputStream());

            Student student =(Student) objIn.readObject();
            objIn.close();
            objOut.close();
            serverSocket.close();
            socket.close();
            System.out.println(student);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
