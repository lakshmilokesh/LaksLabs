
package com.stacks;

import java.util.ArrayList;
import java.util.List;

public class AnimalQueue {

	List<Dog> dogs = new ArrayList<Dog>();
	List<Cat> cats = new ArrayList<Cat>();
	private int order = 0;
	
	public void AnimalEnqueue (Animal a) {
		order++;
		a.setOrder(order);
		
		if (a instanceof Dog) {
			dogs.add((Dog)a);
		}
		else if(a instanceof Cat) {
			cats.add((Cat)a);
		}
	}
	public Animal dequeueAny(){
		if (dogs == null || dogs.size() == 0) {
			return dequeueCat();
		}
		if (cats == null || cats.size() == 0) {
			return dequeueDog();
		}
		Dog d = dogs.get(0);
		Cat c = cats.get(0);
		
		if(d.isOlderThan(c)) {
			return dequeueDog();
		}
		else {
			return dequeueCat();
		}
	}
	
	private Dog dequeueDog() {
		// TODO Auto-generated method stub
		Dog c = (Dog)getAnimal(dogs);
		dogs.remove(c);
		return c;
	}
	private Cat dequeueCat() {
		// TODO Auto-generated method stub
		Cat c = (Cat)getAnimal(cats);
		cats.remove(c);
		return c;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private Animal getAnimal(List lt) {
		int lastindex = lt.size()-1;
		return (Animal)lt.get(lastindex);
	}
}
