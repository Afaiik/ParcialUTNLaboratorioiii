package com.company.automoviles;

import com.company.common.AppParameters;
import com.company.vehiculos.EnumTipoVehiculo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AutomovilCarrera extends Automovil{
    private int velocidadMaximaKm;

    public AutomovilCarrera() {
    }

    public AutomovilCarrera(int velocidadMaximaKm) {
        this.velocidadMaximaKm = velocidadMaximaKm;
    }

    public AutomovilCarrera(int cantMaxAirbags, int velocidadMaximaKm) {
        super(cantMaxAirbags);
        this.velocidadMaximaKm = velocidadMaximaKm;
    }

    public AutomovilCarrera(String nombreModelo, float precio, EnumTipoVehiculo tipoVehiculo, int cantMaxAirbags, int velocidadMaximaKm) {
        super(nombreModelo, precio, tipoVehiculo, cantMaxAirbags);
        this.velocidadMaximaKm = velocidadMaximaKm;
    }

    public int getVelocidadMaximaKm() {
        return velocidadMaximaKm;
    }

    public void setVelocidadMaximaKm(int velocidadMaximaKm) {
        this.velocidadMaximaKm = velocidadMaximaKm;
    }


    public ArrayList<AutomovilCarrera> leerArchivo(){
        File file = new File(AppParameters.BASE_PATH_ARCHIVOS + AppParameters.AUTOMOVIL_CARRERA_NOMBRE_ARCHIVO);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<AutomovilCarrera> vehiculosLeidos = null;

        if(file.exists()){
            try {
                InputStream inputStream = new FileInputStream(file);
                TypeReference<ArrayList<AutomovilCarrera>> vehiculoType = new TypeReference<ArrayList<AutomovilCarrera>>() { };

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
