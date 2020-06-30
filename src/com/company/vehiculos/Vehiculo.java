package com.company.vehiculos;

import com.company.Interfaces.IJsonFunctions;
import com.company.automoviles.AutomovilCarrera;
import com.company.automoviles.AutomovilUrbano;
import com.company.common.AppParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
    private String nombreModelo;
    private float precio;
    private EnumTipoVehiculo tipoVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(String nombreModelo, float precio, EnumTipoVehiculo tipoVehiculo) {
        this.nombreModelo = nombreModelo;
        this.precio = precio;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public EnumTipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(EnumTipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public ArrayList<Vehiculo> leerArchivo(String nombreArchivo){
        File file = new File(nombreArchivo);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Vehiculo> vehiculosLeidos = null;

        if(file.exists()){
            try {
                InputStream inputStream = new FileInputStream(file);
                TypeReference<ArrayList<Vehiculo>> vehiculoType = new TypeReference<ArrayList<Vehiculo>>() { };

                vehiculosLeidos = objectMapper.readValue(inputStream, vehiculoType);

                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return vehiculosLeidos;
        }else
            return null;
    }

    /*public boolean escribirToArchivo(Vehiculo item){
        File file = new File(AppParameters.BASE_PATH_ARCHIVOS + AppParameters.VEHICULOS_NOMBRE_ARCHIVO);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (file.createNewFile()){ //TRUE == se creo el archivo
                ArrayList<Vehiculo> arrayList = new ArrayList<>();
                arrayList.add(item);
                objectMapper.writeValue(file, arrayList);
            } else {
                ArrayList<Vehiculo> vehiculosLeidos = leerArchivo();
                //Leo los valores antes de escribir el nuevo asi no se sobreescriben
                vehiculosLeidos.add(item);
                objectMapper.writeValue(file, vehiculosLeidos);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    public void escribirArrayToArchivo(List<Vehiculo> items){
        File fileVehiculoMotocicleta = new File(AppParameters.BASE_PATH_ARCHIVOS + AppParameters.VEHICULO_MOTOCICLETA_NOMBRE_ARCHIVO);
        File fileVehiculoUtilitario = new File(AppParameters.BASE_PATH_ARCHIVOS + AppParameters.VEHICULO_UTILITARIO_NOMBRE_ARCHIVO);
        File fileAutomovilCarrera = new File(AppParameters.BASE_PATH_ARCHIVOS + AppParameters.AUTOMOVIL_CARRERA_NOMBRE_ARCHIVO);
        File fileAutomovilUrbano = new File(AppParameters.BASE_PATH_ARCHIVOS + AppParameters.AUTOMOVIL_URBANO_NOMBRE_ARCHIVO);

        ArrayList<VehiculoMotocicleta> arrayVehiculoMotocicleta = new ArrayList<>();
        ArrayList<VehiculoUtilitario> arrayVehiculoUtilitario = new ArrayList<>();
        ArrayList<AutomovilCarrera> arrayAutomovilCarrera = new ArrayList<>();
        ArrayList<AutomovilUrbano> arrayAutomovilUrbano = new ArrayList<>();


        for(Vehiculo item : items){
            if(item instanceof VehiculoMotocicleta)
                arrayVehiculoMotocicleta.add((VehiculoMotocicleta)item);
            else if(item instanceof VehiculoUtilitario)
                arrayVehiculoUtilitario.add((VehiculoUtilitario)item);
            else if (item instanceof AutomovilCarrera)
                arrayAutomovilCarrera.add((AutomovilCarrera)item);
            else if(item instanceof AutomovilUrbano)
                arrayAutomovilUrbano.add((AutomovilUrbano)item);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        escribirArchivo(fileVehiculoMotocicleta, objectMapper, new ArrayList<Vehiculo>(arrayVehiculoMotocicleta));
        escribirArchivo(fileVehiculoUtilitario, objectMapper, new ArrayList<Vehiculo>(arrayVehiculoUtilitario));
        escribirArchivo(fileAutomovilCarrera, objectMapper, new ArrayList<Vehiculo>(arrayAutomovilCarrera));
        escribirArchivo(fileAutomovilUrbano, objectMapper, new ArrayList<Vehiculo>(arrayAutomovilUrbano));
    }

    private void escribirArchivo(File file, ObjectMapper objectMapper, ArrayList<Vehiculo> items){
        try {
            if (file.createNewFile()) { //TRUE == se creo el archivo
                ArrayList<Vehiculo> arrayList = new ArrayList<>();
                arrayList.addAll(items);
                objectMapper.writeValue(file, arrayList);
            } else {
                ArrayList<Vehiculo> readValues = leerArchivo(file.getName());
                readValues.addAll(items);
                objectMapper.writeValue(file, readValues);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "nombreModelo='" + nombreModelo + '\'' +
                ", precio=" + precio +
                ", tipoVehiculo=" + tipoVehiculo +
                '}';
    }
}
