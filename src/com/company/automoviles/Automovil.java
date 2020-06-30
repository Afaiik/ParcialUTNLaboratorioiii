package com.company.automoviles;

import com.company.vehiculos.EnumTipoVehiculo;
import com.company.vehiculos.Vehiculo;

public abstract class Automovil extends Vehiculo {
    private int cantMaxAirbags;

    public Automovil() {
    }

    public Automovil(int cantMaxAirbags) {
        this.cantMaxAirbags = cantMaxAirbags;
    }

    public Automovil(String nombreModelo, float precio, EnumTipoVehiculo tipoVehiculo, int cantMaxAirbags) {
        super(nombreModelo, precio, tipoVehiculo);
        this.cantMaxAirbags = cantMaxAirbags;
    }

    public int getCantMaxAirbags() {
        return cantMaxAirbags;
    }

    public void setCantMaxAirbags(int cantMaxAirbags) {
        this.cantMaxAirbags = cantMaxAirbags;
    }
}
