package com.company.common;

import com.company.automoviles.AutomovilCarrera;
import com.company.automoviles.AutomovilUrbano;
import com.company.vehiculos.VehiculoMotocicleta;
import com.company.vehiculos.VehiculoUtilitario;

import java.util.ArrayList;

public class AppParameters {
    private AppParameters() {}

    public static final String BASE_PATH_ARCHIVOS = "resources\\";

    public static final String VEHICULO_MOTOCICLETA_NOMBRE_ARCHIVO = "VehiculoMotocicleta.json";
    public static final String VEHICULO_UTILITARIO_NOMBRE_ARCHIVO = "VehiculoUtilitario.json";
    public static final String AUTOMOVIL_CARRERA_NOMBRE_ARCHIVO = "AutomovilCarrera.json";
    public static final String AUTOMOVIL_URBANO_NOMBRE_ARCHIVO = "AutomovilUrbano.json";


    public static final int PRECIO_FILTRO = 100000;
}
