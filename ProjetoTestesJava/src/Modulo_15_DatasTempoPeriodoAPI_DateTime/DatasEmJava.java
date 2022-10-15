package Modulo_15_DatasTempoPeriodoAPI_DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DatasEmJava {

	public static void main(String[] args) throws ParseException, InterruptedException {
		
		
		// Faixa de tempo com Objeto Period
		LocalDate dataAntiga = LocalDate.of(2020, 7, 10);
		LocalDate dataNova = LocalDate.of(2022, 10, 11);
		System.out.println("Data antiga � maior que data atual >>> " + dataAntiga.isAfter(dataNova));
		System.out.println("Data antiga � anterior a atual >>> " + dataAntiga.isBefore(dataNova));
		System.out.println("Data antiga e atual s�o iguais >>> " + dataAntiga.isEqual(dataNova));
		
		// Trabalhando com Periodos em java - diferen�a entre datas
		Period periodo = Period.between(dataAntiga, dataNova);
		System.out.println(" quantos dias >>> " + periodo.getDays());
		System.out.println(" quantos meses >>> " + periodo.getMonths());
		System.out.println(" quantos anos >>> " + periodo.getYears());
		
		
		// Tempo de processo com Instant - pacote
		Instant inicio = Instant.now();
		Thread.sleep(2000);
		
		Instant ifinal = Instant.now();
		Duration duracao = Duration.between(inicio, ifinal);		
		System.out.println("Duracao com toNano() >>> "+duracao.toNanos());		
		System.out.println("Duracao com toMinutes() >>> "+duracao.toMinutes());
		System.out.println("Duracao com toDays() >>> "+duracao.toDays());
		System.out.println("Duracao com .toHours() >>> "+duracao.toHours());
		
		
		// Pegando dia mes anos com nova API java para data horas
		LocalDate localdate = LocalDate.now();
		System.out.println("Data Atual :"+ localdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("Dia do mes :"+ localdate.getDayOfMonth());
		System.out.println("Dia do ano :"+ localdate.getDayOfYear());
		System.out.println("Dia da semana :"+ localdate.getDayOfWeek());			
		
		// Nova API de Data e Hora do Java
		LocalDate dataAtual = LocalDate.now();
		System.out.println(dataAtual);
		
		LocalTime horaAtual = LocalTime.now();
		System.out.println(horaAtual);
		
		LocalDateTime dataHoraAtualJuntos = LocalDateTime.now();
		System.out.println(dataHoraAtualJuntos);
		
		// Formatando data com simpledateformat no LocalDateTime/LocalTime/LocalDate
		//System.out.println("Data/Hora formatada >>> "+dataHoraAtualJuntos.format(DateTimeFormatter.BASIC_ISO_DATE));
		//System.out.println("Data/Hora formatada >>> "+dataHoraAtualJuntos.format(DateTimeFormatter.ISO_DATE));
		//System.out.println("Data/Hora formatada >>> "+dataHoraAtualJuntos.format(DateTimeFormatter.ISO_DATE_TIME));
		//System.out.println("Data/Hora formatada >>> "+dataHoraAtualJuntos.format(DateTimeFormatter.ISO_INSTANT));
		//System.out.println("Data/Hora formatada >>> "+dataHoraAtualJuntos.format(DateTimeFormatter.ISO_LOCAL_DATE));
		
		
		
		

		/*
		 * // Gerando parcelas mensais e suas datas
		Date dataInicial = new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2022");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInicial);

		for ( int parcela = 1; parcela <= 12; parcela ++ ) {
			calendar.add(Calendar.MONTH, 1);
			
			System.out.println("Parcela de numero "+ parcela + " vencimento � em " 
								+ new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
		}
		 * */
		
		
		/*
		 * // CALCULANDO A QUANTIDADE DE DIAS ENTRE UM PERIODO DE DATAS  com ChronoUnit
		//Date dataPassada = new SimpleDateFormat("dd-MM-yyyy").parse();
		
		long dias = ChronoUnit.DAYS.between(LocalDate.parse("2022-10-01"), LocalDate.now());
		long cemAnos = ChronoUnit.CENTURIES.between(LocalDate.parse("2022-10-01"), LocalDate.now());//equivale a 100 anos
		
		long mes = ChronoUnit.MONTHS.between(LocalDate.parse("2022-10-01"), LocalDate.now());
		
		long ano = ChronoUnit.YEARS.between(LocalDate.parse("2022-10-01"), LocalDate.now());
		
		System.out.println(dias);
		System.out.println(cemAnos);
		System.out.println(mes);
		System.out.println(ano);
		 * */
		
		
		/*
		 * // CALCULANDO DIA M�S E ANO COM CALENDAR
		Calendar calendar = Calendar.getInstance(); // pega data atual
		
		// simular que data vem de outro lugar
		calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("10-10-2022")); // definindo data qualquer
		
		calendar.add(Calendar.DAY_OF_MONTH, 10);// Acrescenta 10 dias a data atual
		System.out.println( new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		
		calendar.add(Calendar.MONTH, 10);// Acrescenta 10 meses ao mes atual
		System.out.println( new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		
		calendar.add(Calendar.YEAR, 10);// Acrescenta 10 anos ao ano atual
		System.out.println( new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		 * */
		
		
		/*
		 * // Formatando a Data
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		
		// Pegando a data de hoje
		Date dataVencimento = simpleDate.parse("15/10/2022");
		Date dataAtual = simpleDate.parse("17/10/2022");
		
		// Comparando as datas de hoje
		// perguntando se o boleto esta vencido comparando com a data de hoje - o after() / before() faz isso
		if( dataVencimento.after(dataAtual) ) {
			System.out.println( "Boleto n�o vencido !" );
		} else {
			System.out.println(" Boleto vencido - PAGAR URGENTE ");
		}
		 * 
		 * */
		
		
		
		/*
		 * Date data =  new Date();		
		System.out.println(data.getDate() + " > Dia do mes");
		System.out.println(data.getTime() + " > milisegundos da data");
		System.out.println(data.getHours() + " > Hora do dia");
		System.out.println(data.getMinutes() + " > Minutos do dia");
		 * */

	}

}