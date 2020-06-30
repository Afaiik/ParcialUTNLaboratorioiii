package com.company.vehiculos;

import com.company.common.AppParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class VehiculoMotocicleta extends Vehiculo{
    private int cilindrada;

    public VehiculoMotocicleta() {
    }

    public VehiculoMotocicleta(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public VehiculoMotocicleta(String nombreModelo, float precio, EnumTipoVehiculo tipoVehiculo, int cilindrada) {
        super(nombreModelo, precio, tipoVehiculo);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public ArrayList<VehiculoMotocicleta> leerArchivo(){
        File file = new File(AppParameters.BASE_PATH_ARCHIVOS + AppParameters.VEHICULO_MOTOCICLETA_NOMBRE_ARCHIVO);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<VehiculoMotocicleta> vehiculosLeidos = null;

        if(file.exists()){
            try {
                InputStream inputStream = new FileInputStream(file);
                TypeReference<ArrayList<VehiculoMotocicleta>> vehiculoType = new TypeReference<ArrayList<VehiculoMotocicleta>>() { };

                vehiculosLeidos = objectMapper.readValue(inputStream, vehiculoType);

                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return vehiculosLeidos;
        }else
            return null;
    }
}
