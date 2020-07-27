package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		
		System.out.print("Romm number: ");
		int roomNumber = input.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(input.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(input.next());
		
		
		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Error in reservation: Reservetion dates for update must be future dates");
		}
		else if (!checkOut.after(checkIn)) {
			System.out.println("Error in resevartion: Chack-out date must be after chack-in date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation); 

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(input.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(input.next());
			
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservetion dates for update must be future dates");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation); 
			}

		} 
		
		input.close();

	}

}
