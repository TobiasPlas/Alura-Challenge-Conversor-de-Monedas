# Conversor de monedas con JAVA




####Creamos un menu para interactuar con el usuario

```java

	Scanner leer=new Scanner(System.in);

    System.out.println("********************************************");
    System.out.println("Elija un tipo de moneda:");

    System.out.println("1- USD(Dólar Estadounidense");
    System.out.println("2- ARS(peso argentino)");
    System.out.println("3- AUD(Dólar australiano)");
    System.out.println("4- BRL(Real brasileño)");
    System.out.println("5- CAD(Dolar canadiense)");
    System.out.println("9- Salir");
	eleccion = leer.nextInt();
```

<p>
Luego pedimos un monto para hacer la convercion
</p>

####Cantidad de dinero para hacer la convercion 

```Java
    System.out.println("********************************************");
    System.out.println("Ingrese el monto que quiere convertir: ");
    monto =leer.nextInt();
```
<p>
Para posteriormente volver a mostrar el mismo menu que al inicio,pero esta vez para ingresar el tipo de moneda al que desea convertir.
</p>


```Java
 	System.out.println("********************************************");
    System.out.println("Elija el tipo de moneda a convertir: ");

    System.out.println("1- USD(Dólar Estadounidense");
    System.out.println("2- ARS(peso argentino)");
    System.out.println("3- AUD(Dólar australiano)");
    System.out.println("4- BRL(Real brasileño)");
    System.out.println("5- CAD(Dolar canadiense)");
    System.out.println("9- Salir");
    monedaAConverir=leer.nextInt();
```
