import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import protoClasses.Student;
import protoClasses.Student.ClassYear;
import protoClasses.Student.PhoneType;


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



        Student student1 = Student.newBuilder()
            .setId(34)
            .setName("Joe")
            .setPhonetype(PhoneType.MOBILE)
            .setClassyear(ClassYear.SENIOR)
            .build();




        try {
            FileOutputStream fileOut = new FileOutputStream("file.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(student1);
            objOut.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
