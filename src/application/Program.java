package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
	 
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		
			System.out.print("Room number: ");
			int number = teclado.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): " );
			Date checkIn = sdf.parse(teclado.next());
			System.out.print("Check-out date (dd/MM/yyyy): " );
			Date checkOut = sdf.parse(teclado.next());
				
		
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println(" Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): " );
			 checkIn = sdf.parse(teclado.next());
			System.out.print("Check-out date (dd/MM/yyyy): " );
			 checkOut = sdf.parse(teclado.next());
			 
		
			 reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);			
		}
		
		catch(ParseException error) {
			System.out.println("invalid date format");
		}
		catch(DomainException error) {
			System.out.println("Error inreservation: " + error.getMessage());
		}
		// é um tipo de Exceção genérico pra que seja feito o UPCast para RuntimeException
		// e mostra uma mensagem genérica de erro inesperado. também tem a estrutura de herança e UPCast .
		catch(RuntimeException error) {
			System.out.println("Unexpected error");
		}
		
		teclado.close();
	}

}
