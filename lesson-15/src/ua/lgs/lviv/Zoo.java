package ua.lgs.lviv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Zoo {
	Map<Person, List<Animal>> map= new HashMap<>();

	public void addPerson() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a name and an age of the person your would like to add: ");
		String name = scan.next();
		if(Character.isLowerCase(name.charAt(0))) {
			name=name.substring(0,1).toUpperCase()+name.substring(1);
		}
		int age = 0;
		if (scan.hasNextInt()) {
			age = scan.nextInt();
		} else {
			throw new Exception("Wrong input...");
		}
		map.put(new Person(name, age), new ArrayList<Animal>());
	}

	public void addAnimal() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a name of the person who owns an animal: ");
		String name = scan.next();
		Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Animal>> next = iterator.next();
			if (next.getKey().getName().equalsIgnoreCase(name)) {
				List<Animal> animals = next.getValue();
				System.out.println("Enter a type and a name of an animal you wanna add:");
				String typeAnimal = scan.next();
				String nameAnimal = scan.next();
				if(Character.isLowerCase(nameAnimal.charAt(0))) {
					nameAnimal=nameAnimal.substring(0,1).toUpperCase()+nameAnimal.substring(1);
				}
				animals.add(new Animal(typeAnimal, nameAnimal));
				next.setValue(animals);
			}

		}
	}
	
	public void removeAnimal() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a name of the person who owns an animal: ");
		String name = scan.next();
		Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Animal>> next = iterator.next();
			if (next.getKey().getName().equals(name)) {
				List<Animal> animals = next.getValue();
				System.out.println("Enter a name of an animal you wanna remove:");
				String nameAnimal = scan.next();
				Iterator<Animal> iterator3 = animals.iterator();
				while(iterator3.hasNext()) {
					Animal next2 = iterator3.next();
					if(next2.getName().equalsIgnoreCase(nameAnimal)) {
						iterator3.remove();
					}
				}
			}
		}
	}
	
	public void removePerson(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a name of the person you wanna remove from the ZooClub: ");
		String name = scan.next();
		Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Animal>> next = iterator.next();
			if (next.getKey().getName().equalsIgnoreCase(name)) {
				iterator.remove();
			} 
		}
	}
	
	public void removeTheConcreteAnimal() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a name of the animal you wanna remove from the ZooClub: ");
		String name = scan.next();
		Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Animal>> next = iterator.next();
			List<Animal> animals = next.getValue();
			Iterator<Animal> iterator3 = animals.iterator();
			while(iterator3.hasNext()) {
				Animal next2 = iterator3.next();
				if(next2.getName().equalsIgnoreCase(name)) {
					iterator3.remove();
				} 
			}
		}
	}
	
	public void printZooClub() {
		System.out.println(map);
	}
}
