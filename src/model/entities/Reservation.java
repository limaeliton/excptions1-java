package model.entities;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		// programação defensiva tratar as Exceções no começo do metodo.
		 if (!checkOut.after(checkIn)) {
			 throw new DomainException( " check-out date must be after check-in date"); 
		 }
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}



	public Date getCheckOut() {
		return checkOut;
	}

	public long duration( ) {
		// diferença entre duas datas em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		// converter milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn , Date checkOut) {	
		 Date now = new Date();
		 
		 // é utilizada essa classe de Execoes IllegalArgumentException quando os argumentos que
		 //se passa para o metodo são inválidos. >> Date checkIn , Date checkOut e assim e mostrado
		 // o erro no  programa.
		 
		 if(checkIn.before(now) || checkOut.before(now)){
			 throw new DomainException( " Reservation dates for update must be future dates");
		 }
		 
		 	// verificar se o !checkOut.after não é depois do checkIn
		 if (!checkOut.after(checkIn)) {
			 throw new DomainException( " check-out date must be after check-in date"); 
		 }
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	
		
	}
	
	@Override
	public String toString() {
		return " Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ " check-out: "
				+ sdf.format(checkOut)
				+ " , "
				+ duration()
				+ "  nights ";
		
	}
}
