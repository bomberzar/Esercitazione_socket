import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStr {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringModifica = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public void attendi() {
        try {
            System.out.println("1 SERVER partito in esecuzione...");

            //creo un server sulla porta 6789
            server = new ServerSocket(6789);
            //rimane in attesa di un client
            client = server.accept();
            //chiudo il server per inibire altri client
            server.close();

            //associo due oggetti al socket del client per effettuare la scrittura e la lettura
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());

        } catch (IOException e) {
           System.out.println(e.getMessage());
           System.out.println("Errore durante l'istanza del sever !");
           System.exit(1);
        }
    }

    public void comunica() throws IOException {
        //rimango in attesa della riga trasmessa dal client
        System.out.println("3 benvenuto client, scrivi una frase e la trasformo in maiuscolo. Attendo...");
        stringaRicevuta = inDalClient.readLine();
        System.out.println("6 ricevuta la stringa dal cliente: " + stringaRicevuta);

        //la modifico e a la rispedisco al client
        stringModifica = stringaRicevuta.toUpperCase();
        System.out.println("7 invio la stringa modificata al client...");
        outVersoClient.writeBytes(stringModifica+'\n');

        //termina elaborazione sul server : chiudo la connessione del client
        System.out.println("9 SERVER: fine elaborazione .... buoma notte!");
        client.close();
    }
}
