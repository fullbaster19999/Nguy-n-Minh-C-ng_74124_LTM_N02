import jdk.net.Sockets;

import java.io.*;
import java.net.ServerSocket;
import  java.net.Socket;

public class Sever {
    public void serve(){
        DataOutputStream dos = null;

        DataInputStream dis=null;
        int count =0;
        try {
            System.out.println("Client " + ++count);
            ServerSocket server = new ServerSocket(1106);
            System.out.println("Server được mở: ");
            while(true) {
                Socket socket = server.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader
                        (socket.getInputStream()));
                String request = br.readLine();
                if (request != null) {
                    System.out.println("Nhận từ sever: " + request);
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.println(request.toUpperCase());
                }
                dos = new DataOutputStream(socket.getOutputStream());

                dis = new DataInputStream(socket.getInputStream());

                String inline = "";

                while (true) {

                    inline = dis.readUTF();

                    String ch = inline.toString();

                    if (ch != null) {

                        String i = inline;

                        switch (i) {

                            case "0":
                                inline = "Không";
                                break;

                            case "1":
                                inline = "Một";
                                break;

                            case "2":
                                inline = "Hai";
                                break;

                            case "3":
                                inline = "Ba";
                                break;

                            case "4":
                                inline = "Bốn";
                                break;

                            case "5":
                                inline = "Năm";
                                break;

                            case "6":
                                inline = "Sáu";
                                break;

                            case "7":
                                inline = "Bảy";
                                break;

                            case "8":
                                inline = "Tám";
                                break;

                            case "9":
                                inline = "Chín";
                                break;

                            case "END":
                                inline = "Good Bye!";
                                server.close();
                                break;
                        }

                        dos.writeUTF(inline);

                    }

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Sever server = new Sever();
        server.serve();

    }
}
