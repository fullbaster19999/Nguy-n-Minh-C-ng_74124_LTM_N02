import jdk.net.Sockets;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public void connect(){
        DataOutputStream dos = null;

        DataInputStream dis=null;

        try {
            Socket socket = new Socket("localhost", 1106);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("Hello, IP: 1106 của client");
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (socket.getInputStream()));
            String response = br.readLine();
            if(response != null) {
                System.out.println("Sever phản hồi: " + response);
            }
            dos = new DataOutputStream(socket.getOutputStream());

            dis = new DataInputStream(socket.getInputStream());

            Scanner input = new Scanner(System.in);

            String s = null;

            while(true)

            {

                System.out.print("\nNhap du lieu: ");

                s =input.nextLine();

                dos.writeUTF(s);



                String str = dis.readUTF();

                System.out.print("Kết quả từ Server : " + str);


            }
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
        c.connect();

    }

}
