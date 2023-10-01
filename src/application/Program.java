package application;

import java.util.Scanner;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of employees: ");
		int numberOfEmployees = sc.nextInt();

		List<Employee> employees = new ArrayList<>();

		for (int i = 1; i <= numberOfEmployees; i++) {
			Employee e;

			System.out.println("Employee #" + i + " data:");

			System.out.print("Outsourced? (y/n): ");
			char outsourced = sc.next().charAt(0);

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Hours: ");
			Integer hours = sc.nextInt();

			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();

			if (outsourced == 'y') {
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();

				e = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
			} else {
				e = new Employee(name, hours, valuePerHour);
			}

			employees.add(e);
		}

		System.out.println();
		System.out.println("PAYMENTS:");

		for (Employee e : employees) {
			System.out.println(e.getName() + " - $" + String.format("%.2f", e.payment()));
		}

		sc.close();
	}
}
