import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerStr servente = new ServerStr();
        servente.attendi();
        servente.comunica();;

        /* attivare due istanze separate di bluej
        ClientStr cliente = new ClientStr();
        cliente.conneti();
        cliente.comunica();
        */
    }
}