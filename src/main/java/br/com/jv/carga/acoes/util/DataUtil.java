package br.com.jv.carga.acoes.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataUtil {
	
	public static Date convertStringToDate(String data) {
		return convertStringToDate(data,"yyyy-MM-dd");
	}
	
    public static Date convertStringToDate(String data, String formato) {
        if (data == null)
            return null;
        if (formato == null)
            formato = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(formato, new Locale("pt", "BR"));

        try {
            Date today = df.parse(data);
            return today;
        } catch (ParseException e) {
            return null;
        }
    }	

	public static String convertDateToString(Date data) {
		return convertDateToString(data, null);
	}

	public static String convertDateToString(Date data, String formato) {
		if (data == null)
			return null;
		if (formato == null)
			formato = "dd/MM/yyyy";
		DateFormat df = new SimpleDateFormat(formato, new Locale("pt", "BR"));
		String today = df.format(data);
		return today;

	}

}
