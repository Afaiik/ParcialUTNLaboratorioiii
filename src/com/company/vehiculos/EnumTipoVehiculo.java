package com.company.vehiculos;

public enum EnumTipoVehiculo {

    //Se aprovecha el tipo de vehiculos para demostrar el uso de un ENUM

    VEHICULO_GRANDE("GRANDE"),
    VEHICULO_CHICO("CHICO");

    private final String text;

    EnumTipoVehiculo(final String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}