import java.util.Scanner;

public class WiFiDiagnosis {
	/*
	 * Class: CMSC203 Instructor: Prof. G. Grinberg Description: This is supposed to
	 * be WiFi diagnosis tool. Due: 06/20/22 Platform/compiler: Eclipse I pledge
	 * that I have completed the programming assignment independently. I have not
	 * copied the code from a student or any source. I have not given my code to any
	 * student. Print your Name here: Ojas Malghan
	 */

	public static void main(String[] args) {

		// what is the program about

		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.");
		System.out.println();
		System.out.println();
		// to store user data
		String response;
		Scanner in = new Scanner(System.in);
		// first way to fix the issue
		System.out.println("First Step: Reboot the computer and try to connect");
		System.out.print("Did that fix the problem? (Yes or No) ");
		// store if it worked or not
		response = in.nextLine();
		System.out.println();
		// if did not work, give another fix
		if (response.equals("No")) {
			System.out.println("Second Step: Reboot the router and try to connect");
			System.out.print("Did that fix the problem? (Yes or No) ");
			response = in.nextLine();
			System.out.println();

			// any answer besides No will lead to termination of the program.
		} else {

			System.out.print("This fixed the issue!");
			in.close();
			return;
		}
		// if still not fixed, purpose another solution.
		if (response.equals("No")) {

			System.out.println("Third Step: Make sure the cables connecting the router are firmly plugged in and power "
					+ "is getting" + " to the router");
			System.out.print("Did that fix the problem? (Yes or No) ");
			response = in.nextLine();
			System.out.println();

		} else {
			// if resolved, end the program
			System.out.print("This fixed the issue!");
			in.close();
			return;
		}
		if (response.equals("No")) {

			// another way to fix it
			System.out.println("Fourth Step: Move the computer closer to the router and try to connect ");
			System.out.print("Did that fix the problem? (Yes or No) ");
			response = in.nextLine();
			System.out.println();

		} else {
			// resolved
			System.out.print("This fixed the issue!");
			in.close();
			return;
		}
		// last fix, if nothing else worked
		if (response.equals("No")) {
			in.close();
			System.out.println("Fifth Step: Contact your ISP");
			return;

		} else {
			// leave program since the issue has been fixed
			System.out.print("This fixed the issue!");
			in.close();

			return;
		}

	}

}
