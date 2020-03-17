package ua.lgs.lviv;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		Zoo zoo=new Zoo();
		while(true) {
			System.out.println("Enter a number of your choice: ");
			menu();
			int choice=0;
			if(scan.hasNext()) {
				choice=scan.nextInt();
			} else {
				throw new Exception("Wrong input");
			}

			switch(choice) {
				case 1:{
					zoo.addPerson();
					System.out.println();
					zoo.printZooClub();
					break;
				}
				case 2:{
					zoo.addAnimal();
					System.out.println();
					zoo.printZooClub();
					break;
				}
				case 3:{
					zoo.removeAnimal();
					System.out.println();
					zoo.printZooClub();
					break;
				}
				case 4:{
					zoo.removePerson();
					System.out.println();
					zoo.printZooClub();
					break;
				}
				case 5:{
					zoo.removeTheConcreteAnimal();
					System.out.println();
					zoo.printZooClub();
					break;
				}
				case 6:{
					zoo.printZooClub();
					break;
				}
				case 7:{
					 System.out.println("Exiting...");
		             System.exit(0);
					break;
				}
				
			}
		}

	}
	public static void menu() {
		System.out.println("1. To add a person into a ZooClub");
		System.out.println("2. To add an animal into a ZooClub");
		System.out.println("3. To remove an animal from a ZooClub");
		System.out.println("4. To remove a person from a ZooClub");
		System.out.println("5. To remove a concrete animal from all the participants of a ZooClub");
		System.out.println("6. To display all the information about ZooClub");
		System.out.println("7. To exit...");
	}

}
