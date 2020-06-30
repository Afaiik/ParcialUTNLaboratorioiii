package com.company;

import com.company.automoviles.AutomovilCarrera;
import com.company.automoviles.AutomovilUrbano;
import com.company.common.AppParameters;
import com.company.vehiculos.EnumTipoVehiculo;
import com.company.vehiculos.Vehiculo;
import com.company.vehiculos.VehiculoMotocicleta;
import com.company.vehiculos.VehiculoUtilitario;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World ! ");

        //Utiliza consigna 02 adentro
        ArrayList<Vehiculo> vehiculos = consigna2B();

        if(vehiculos != null){

            //Consigna 03
            consigna03(vehiculos);

            //Consigna 04
            consigna04(vehiculos);

            consigna05(vehiculos);
        }
    }

    private static ArrayList<Vehiculo> consigna02(){
        //Crear un ArrayList con al menos un vehículo de cada tipo.(​4 pts​)
        AutomovilCarrera automovilCarrera = new AutomovilCarrera("Auto re rapido", 750000, EnumTipoVehiculo.VEHICULO_CHICO, 5, 400);
        AutomovilUrbano automovilUrbano = new AutomovilUrbano("Auto urbano lento", 60000, EnumTipoVehiculo.VEHICULO_CHICO, 3, 5);
        VehiculoUtilitario vehiculoUtilitario = new VehiculoUtilitario("Camioneta de carga", 750000, EnumTipoVehiculo.VEHICULO_GRANDE, 3500, 2.7f);
        VehiculoMotocicleta vehiculoMotocicleta = new VehiculoMotocicleta("CBR Fireblade", 800000, EnumTipoVehiculo.VEHICULO_CHICO, 1100);
        AutomovilUrbano automovilUrbano2 = new AutomovilUrbano("Auto urbano rapido", 60000, EnumTipoVehiculo.VEHICULO_CHICO, 3, 5);
        VehiculoUtilitario vehiculoUtilitario2 = new VehiculoUtilitario("Camioneta de carga mas grande", 750000, EnumTipoVehiculo.VEHICULO_GRANDE, 3500, 2.7f);
        VehiculoMotocicleta vehiculoMotocicleta2 = new VehiculoMotocicleta("Otra moto", 800000, EnumTipoVehiculo.VEHICULO_CHICO, 1100);
        VehiculoMotocicleta vehiculoMotocicleta3 = new VehiculoMotocicleta("Otra CBR", 800000, EnumTipoVehiculo.VEHICULO_CHICO, 1100);

        ArrayList<Vehiculo> arrayVehiculos = new ArrayList<>();
        arrayVehiculos.add(automovilCarrera);
        arrayVehiculos.add(automovilUrbano);
        arrayVehiculos.add(automovilUrbano2);
        arrayVehiculos.add(vehiculoUtilitario);
        arrayVehiculos.add(vehiculoUtilitario2);
        arrayVehiculos.add(vehiculoMotocicleta);
        arrayVehiculos.add(vehiculoMotocicleta2);
        arrayVehiculos.add(vehiculoMotocicleta3);

        return arrayVehiculos;
    }

    private static ArrayList<Vehiculo> consigna2B(){

        ArrayList<Vehiculo> vehiculosVarios = consigna02();

        // 2.B : leer esta lista desde un Archivo (recordar el uso de excepciones).
        //Las funciones tienen su propio try catch, aun asi el catch enviaría la excepción hacia afuera, siendo catcheada aca
        try{
            //No valido con HasNext solo para este ejemplo, para no tener que instanciar un vehiculo aparte para usar esta funcion
            Vehiculo vehiculosFileHandler = vehiculosVarios.iterator().next();

            //Escribo al array todos los vehiculos
            vehiculosFileHandler.escribirArrayToArchivo(vehiculosVarios);

            //Leo desde el archivo creado todos los vehiculos
            ArrayList<Vehiculo> arrayVehiculos = new ArrayList<Vehiculo>();

            AutomovilCarrera automovilCarrera = new AutomovilCarrera("Auto re rapido", 750000, EnumTipoVehiculo.VEHICULO_CHICO, 5, 400);
            AutomovilUrbano automovilUrbano = new AutomovilUrbano("Auto urbano lento", 60000, EnumTipoVehiculo.VEHICULO_CHICO, 3, 5);
            VehiculoUtilitario vehiculoUtilitario = new VehiculoUtilitario("Camioneta de carga", 750000, EnumTipoVehiculo.VEHICULO_GRANDE, 3500, 2.7f);
            VehiculoMotocicleta vehiculoMotocicleta = new VehiculoMotocicleta("CBR Fireblade", 800000, EnumTipoVehiculo.VEHICULO_CHICO, 1100);
            arrayVehiculos.addAll(automovilCarrera.leerArchivo());
            arrayVehiculos.addAll(automovilUrbano.leerArchivo());
            arrayVehiculos.addAll(vehiculoUtilitario.leerArchivo());
            arrayVehiculos.addAll(vehiculoMotocicleta.leerArchivo());


            return arrayVehiculos;

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static void consigna03(ArrayList<Vehiculo> vehiculos){
        for(Vehiculo item : vehiculos){
            System.out.println(item.toString());
        }
    }

    private static void consigna04(ArrayList<Vehiculo> vehiculos){
        System.out.println("Imprimiendo los mayores a " + AppParameters.PRECIO_FILTRO);
        for(Vehiculo item : vehiculos){
            if(item.getPrecio() > AppParameters.PRECIO_FILTRO){
                System.out.println(item.toString());
            }
        }
        System.out.println("----------------");
    }

    private static void consigna05(ArrayList<Vehiculo> items){

        ArrayList<VehiculoMotocicleta> arrayVehiculoMotocicleta = new ArrayList<>();
        ArrayList<VehiculoUtilitario> arrayVehiculoUtilitario = new ArrayList<>();
        ArrayList<AutomovilCarrera> arrayAutomovilCarrera = new ArrayList<>();
        ArrayList<AutomovilUrbano> arrayAutomovilUrbano = new ArrayList<>();
        int contMotos = 0;
        int contUtilitario = 0;
        int contCarrera = 0;
        int contUrbano = 0;

        for(Vehiculo item : items){
            if(item instanceof VehiculoMotocicleta){
                arrayVehiculoMotocicleta.add((VehiculoMotocicleta)item);
                contMotos++;
            }
            else if(item instanceof VehiculoUtilitario){
                arrayVehiculoUtilitario.add((VehiculoUtilitario)item);
                contUtilitario++;
            }
            else if (item instanceof AutomovilCarrera){
                arrayAutomovilCarrera.add((AutomovilCarrera)item);
                contCarrera++;
            }
            else if(item instanceof AutomovilUrbano){
                arrayAutomovilUrbano.add((AutomovilUrbano)item);
                contUrbano++;
            }
        }

        System.out.println("Cantidad Vehiculo Motocicleta = " + contMotos);
        System.out.println("Cantidad Vehiculo Utilitario = " + contUtilitario);
        System.out.println("Cantidad Automovil Carrera = " + contCarrera);
        System.out.println("Cantidad Automovil Urbano = " + contUrbano);
    }
}
