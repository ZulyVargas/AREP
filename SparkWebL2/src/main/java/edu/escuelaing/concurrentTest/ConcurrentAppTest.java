package edu.escuelaing.concurrentTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

//No funcionan aún el POST
public class ConcurrentAppTest extends Thread{

    private static final String USER_AGENT = "Mozilla/5.0";
    //private static final String GET_URL = "http://localhost:4567/convert/toFahrenheit/40";
    private static AtomicInteger countPetition = null;
    private static final int NUM_OF_REQUEST = 11;
    private static final String forCelsius = "http://localhost:4567/convert/toFahrenheit/20";
    private static final String forFahrenheit = "http://localhost:4567/convert/toCelsius/";
    //private static final String forCelsius = "https://calm-earth-36734.herokuapp.com/convert/toFahrenheit/";
    //private static final String forFahrenheit = "https://calm-earth-36734.herokuapp.com/convert/toFahrenheit/";
    private static String urlPlus= "/";
    private static double degree = 32;
    private static Random rand ;

    public static void main(String[] args) throws IOException {
        countPetition = new AtomicInteger(0);
        rand = new Random();
        for (int i=0; i < NUM_OF_REQUEST -5 ;i++){
            Thread t = new ConcurrentAppTest();

            urlPlus = forCelsius;
            degree = rand.nextInt(300)  / 100.0;
            t.start();
        }
        countPetition = new AtomicInteger(0);
        for (int i=0; i < NUM_OF_REQUEST -5 ;i++){
            Thread t = new ConcurrentAppTest();
            urlPlus = forFahrenheit + degree;
            degree = rand.nextInt(300)  / 100.0;
            t.start();
        }
    }

    /**
     * Call the method to access to the Api.
     */
    public void run() {
        try {
            makePetition(this.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void makePetition(long id) throws IOException {
        URL obj = new URL(urlPlus);
        System.out.println("URL " + obj );
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode );

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            countPetition.getAndIncrement();
            if (countPetition.get() == NUM_OF_REQUEST)  System.out.println("the number of successful petitions is  " + countPetition);
        } else {
            System.out.println("GET request not worked");
        }
    }

}
