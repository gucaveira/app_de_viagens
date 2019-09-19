package com.appdeviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    @NonNull
    public static String periodEmTexto(int dias){
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_E_MES);
        String dataFormatoIda = formatoBrasileiro.format(dataIda.getTime());
        String dataFormatoVolta= formatoBrasileiro.format(dataVolta.getTime());
        return dataFormatoIda + " - "
                + dataFormatoVolta + " de "
                + dataVolta.get(Calendar.YEAR);
    }
}
