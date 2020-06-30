package com.company.vehiculos;

import com.company.common.AppParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class VehiculoUtilitario extends Vehiculo{

    public float cantKgMax;
    public float altura;

    public VehiculoUtilitario() {
    }

    public VehiculoUtilitario(float cantKgMax, float altura) {
        this.cantKgMax = cantKgMax;
        this.altura = altura;
    }

    public VehiculoUtilitario(String nombreModelo, float precio, EnumTipoVehiculo tipoVehiculo, float cantKgMax, float altura) {
        super(nombreModelo, precio, tipoVehiculo);
        this.cantKgMax = cantKgMax;
        this.altura = altura;
    }

    public float getCantKgMax() {
        return cantKgMax;
    }

    public void setCantKgMax(float cantKgMax) {
        this.cantKgMax = cantKgMax;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public ArrayList<VehiculoUtilitario> leerArchivo(){
        File file = new File(AppParameters.BASE_PATH_ARCHIVOS + AppParameters.VEHICULO_UTILITARIO_NOMBRE_ARCHIVO);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<VehiculoUtilitario> vehiculosLeidos = null;

        if(file.exists()){
            try {
                InputStream inputStream = new FileInputStream(file);
                TypeReference<ArrayList<VehiculoUtilitario>> vehiculoType = new TypeReference<ArrayList<VehiculoUtilitario>>() { };

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
