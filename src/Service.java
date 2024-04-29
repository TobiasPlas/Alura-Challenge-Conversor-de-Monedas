import com.google.gson.JsonObject;

public class Service {


    public String conversorDeMoneda(JsonObject jsonObject,String monedaInicial ,String tipoDeCambio,double cantidad){

        double conversion = jsonObject.getAsJsonObject("conversion_rates").get(tipoDeCambio).getAsDouble();

        return "El cambio a la cantidad de: "+ cantidad +" "+ monedaInicial +" a "+ tipoDeCambio +" es de: "+ (cantidad*conversion);
    }




}
