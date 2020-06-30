package com.company.automoviles;

import com.company.common.AppParameters;
import com.company.vehiculos.EnumTipoVehiculo;
import com.company.vehiculos.VehiculoUtilitario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AutomovilUrbano extends Automovil{
    private int cantMaxOcupantes;

    public AutomovilUrbano() {
    }

    public AutomovilUrbano(int cantMaxOcupantes) {
        this.cantMaxOcupantes = cantMaxOcupantes;
    }

    public AutomovilUrbano(int cantMaxAirbags, int cantMaxOcupantes) {
        super(cantMaxAirbags);
        this.cantMaxOcupantes = cantMaxOcupantes;
    }

    public AutomovilUrbano(String nombreModelo, float precio, EnumTipoVehiculo tipoVehiculo, int cantMaxAirbags, int cantMaxOcupantes) {
        super(nombreModelo, precio, tipoVehiculo, cantMaxAirbags);
        this.cantMaxOcupantes = cantMaxOcupantes;
    }

    public int getCantMaxOcupantes() {
        return cantMaxOcupantes;
    }

    public void setCantMaxOcupantes(int cantMaxOcupantes) {
        this.cantMaxOcupantes = cantMaxOcupantes;
    }

    public ArrayList<AutomovilUrbano> leerArchivo(){
        File file = new File(AppParameters.BASE_PATH_ARCHIVOS + AppParameters.AUTOMOVIL_URBANO_NOMBRE_ARCHIVO);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<AutomovilUrbano> vehiculosLeidos = null;

        if(file.exists()){
            try {
                InputStream inputStream = new FileInputStream(file);
                TypeReference<ArrayList<AutomovilUrbano>> vehiculoType = new TypeReference<ArrayList<AutomovilUrbano>>() { };

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
