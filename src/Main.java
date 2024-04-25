import com.AluraChallenge.dto.MonedaDTO;
import com.AluraChallenge.model.Moneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Conversor de Monedas
        Boolean correrAplicacion=true;
        int eleccion=0;
        double monto=0;
        String monedaBase="";
        String monedaAConverir;
            Scanner leer=new Scanner(System.in);

        System.out.println("Bienvenido al Conversor de Monedas");
while (eleccion!=9) {
    System.out.println("********************************************");
    System.out.println("Elija un tipo de moneda:");

    System.out.println("1- USD(Dólar Estadounidense");
    System.out.println("2- ARS(peso argentino)");
    System.out.println("3- AUD(Dólar australiano)");
    System.out.println("4- BRL(Real brasileño)");
    System.out.println("5- CAD(Dolar canadiense)");
    System.out.println("9- Salir");
    eleccion = leer.nextInt();

    switch (eleccion){
        case 1:
            monedaBase="USD";
            break;
        case 2:
            monedaBase="ARS";
            break;
        case 3:
            monedaBase="AUD";
            break;
        case 4:
            monedaBase="BRL";
            break;
        case 5:
            monedaBase="CAD";
            break;
        case 9:
            correrAplicacion=false;
            break;
        default:
            System.out.println("Opcion no valida");
            break;
    }
if (correrAplicacion==true){
    HttpClient client=HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/469afefeb409e147489de19d/latest/"+monedaBase))
            .build();


    HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

    String json= response.body();

    Gson gson=new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
    MonedaDTO monedaLista= gson.fromJson(json, MonedaDTO.class);
    System.out.println(json);
    System.out.println(monedaLista);

//    System.out.println("********************************************");
//    System.out.println("Ingrese el monto que quiere convertir: ");
//    monto =leer.nextInt();



//    System.out.println(moneda.g);
//    System.out.println("********************************************");
//    System.out.println("");











            }
        }

    }
}
