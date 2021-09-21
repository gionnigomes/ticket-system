package br.com.ticket.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DateManager {

	private final int beforeDays = 1;
	private final int rangeDays = 10;
	LocalDate dataOntem = LocalDate.now().minusDays(beforeDays);
	LocalDate dataAtual = LocalDate.now();
	LocalDate dataFinal = LocalDate.now().plusDays(rangeDays);

	private String yesterdayDay = LocalDate.now().minusDays(beforeDays).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	private String actualDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	private String finalDate = LocalDate.now().plusDays(rangeDays).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	public ArrayList<String> getDates() {
		ArrayList<String> datas = new ArrayList<String>();
		datas.add(formatDates(dataOntem));
		for (LocalDate date = dataAtual; date.isBefore(dataFinal.plusDays(1)); date = date.plusDays(1)) {
			datas.add(formatDates(date));
		}
		return datas;
	}

	public String formatDates(LocalDate dateUnformat) {
		String date = dateUnformat.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return date;
	}
	
	public LocalDate convertToLocalDate(String dateString) {
		String data = dateString;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(data,formatter);
		return date;
	}

	public String getYesterdayDay() {
		return yesterdayDay;
	}

	public void setYesterdayDay(String yesterdayDay) {
		this.yesterdayDay = yesterdayDay;
	}

	public String getActualDate() {
		return actualDate;
	}

	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String finaldate) {
		this.finalDate = finaldate;
	}

}
