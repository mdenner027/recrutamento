package br.com.esiggroup.recrutamento.taskmanager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DateParser {

	public Calendar parse(String dataTextual) {
		Calendar dataCalendar = Calendar.getInstance();
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTextual);
			dataCalendar.setTime(data);
		} catch (ParseException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na conversão da data");
		}
		return dataCalendar;
	}
	
	public String formatDate(Calendar date) {
		return new SimpleDateFormat("dd/MM/yyyy").format(date.getTime());
	}
}
