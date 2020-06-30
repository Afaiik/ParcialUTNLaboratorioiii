package com.company.Interfaces;

import java.util.ArrayList;

public interface IJsonFunctions<T> {
    ArrayList<T> leerArchivo();
    boolean escribirToArchivo(T item);
    boolean escribirArrayToArchivo(ArrayList<T> items);
}
