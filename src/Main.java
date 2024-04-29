import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Conversor de Monedas

        Boolean correrAplicacion=true;
        int eleccion=0;
        double monto=0;
        String monedaBase="";
        int monedaAConverir=0;

        Scanner leer=new Scanner(System.in);

        Service service = new Service();

        System.out.println("Bienvenido al Conversor de Monedas");




       //Creamos un menu para que el usuario pueda interactuar y elegir el tipo de moneda a convertir

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

    //obtenemos el archivo Json con los valores de dicha divisa

if (correrAplicacion==true){
    HttpClient client=HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/469afefeb409e147489de19d/latest/"+monedaBase))
            .build();


    HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

    String json= response.body();

    Gson gson=new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

    //transformamos el Json a objeto en java

   JsonObject jsonObject =gson.fromJson(json,JsonObject.class);


//Elegimos la cantidad de dinero para hacer el cambio

    System.out.println("********************************************");
    System.out.println("Ingrese el monto que quiere convertir: ");
    monto =leer.nextInt();


    //Repetimos el menu para elegir a que moneda hacer el cambio

    System.out.println("********************************************");
    System.out.println("Elija el tipo de moneda a convertir: ");

    System.out.println("1- USD(Dólar Estadounidense");
    System.out.println("2- ARS(peso argentino)");
    System.out.println("3- AUD(Dólar australiano)");
    System.out.println("4- BRL(Real brasileño)");
    System.out.println("5- CAD(Dolar canadiense)");
    System.out.println("9- Salir");
    monedaAConverir=leer.nextInt();

    //En cada caso llamamos a la funcion desarrollada en la clase service pasandole los valores correspondientes


    switch (monedaAConverir){
        case 1:
            System.out.println(service.conversorDeMoneda(jsonObject,monedaBase,"USD",monto));
            break;
        case 2:
            System.out.println(service.conversorDeMoneda(jsonObject,monedaBase,"ARS",monto));
            break;
        case 3:
            System.out.println(service.conversorDeMoneda(jsonObject,monedaBase,"AUD",monto));
            break;
        case 4:
            System.out.println(service.conversorDeMoneda(jsonObject,monedaBase,"BRL",monto));
            break;
        case 5:
            System.out.println(service.conversorDeMoneda(jsonObject,monedaBase,"CAD",monto));
            break;
        case 9:
            correrAplicacion=false;
            break;
        default:
            System.out.println("Opcion no valida");
            break;
            
    }
    }
    }
    }
}
