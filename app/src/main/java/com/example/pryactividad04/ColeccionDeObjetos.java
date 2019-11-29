package com.example.pryactividad04;

import java.util.ArrayList;

public class ColeccionDeObjetos {
    TelefonoCelular obj;

    public int buscarPorModelo(ArrayList coleccion, String dato)
    {
        int i;

        for(i=0; i<coleccion.size(); i=i+1)
        {
            obj = (TelefonoCelular) coleccion.get(i);

            if(obj.modelo.equals(dato))
                return i;
        }
        return -1;
    }

    public void ordenarPorModelo(ArrayList coleccion)
    {
        int i, j;
        TelefonoCelular tempo1, tempo2;

        for(i=0; i<coleccion.size()-1; i=i+1)
            for(j=i+1; j<coleccion.size(); j=j+1)
            {
                tempo1 = (TelefonoCelular) coleccion.get(i);
                tempo2 = (TelefonoCelular) coleccion.get(j);

                if(tempo1.modelo.compareTo(tempo2.modelo) > 0)
                {
                    obj = tempo1;
                    coleccion.set(i, tempo2);
                    coleccion.set(j, obj);
                }
            }
    }

    public void ordenarPorPrecio(ArrayList coleccion)
    {
        int i, j;
        TelefonoCelular tempo1, tempo2;

        for(i=0; i<coleccion.size()-1; i=i+1)
            for(j=i+1; j<coleccion.size(); j=j+1)
            {
                tempo1 = (TelefonoCelular) coleccion.get(i);
                tempo2 = (TelefonoCelular) coleccion.get(j);

                if(tempo1.precio > tempo2.precio)
                {
                    obj = tempo1;
                    coleccion.set(i, tempo2);
                    coleccion.set(j, obj);
                }
            }
    }
}
