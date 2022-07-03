import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {

		boolean moreData = false;
		Scanner in = new Scanner(System.in);
		do {
			int tickets;
			String userData;
			Movie m = new Movie();
			System.out.println("Enter the name of a movie:");
			userData = in.nextLine();
			m.setTitle(userData);
			System.out.println("Enter the rating of the movie:");
			userData = in.nextLine();
			m.setRating(userData);
			System.out.println("Enter the number of tickets sold: ");
			tickets = in.nextInt();
			m.setSoldTickets(tickets);
			System.out.println(m.toString());
			System.out.println();
			System.out.println("Do you want to enter another? (y or n)");
			in.nextLine(); 
			userData = in.nextLine();
			if (userData.equals("y")) {
				moreData = true;
			} else {
				moreData=false;
			}

			
		} while (moreData);
		System.out.println("Goodbye. Thank you answering!");
		in.close();
	}

}
