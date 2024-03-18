class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }

    public void move() {
        System.out.println("Animal moves");
    }
}

class Dog extends Animal {
 
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

  
    public void move(String direction) {
        System.out.println("Dog moves " + direction);
    }
}


public class Polymorphism {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.sound();
        animal1.move(); 

        Dog dog = new Dog();
        dog.sound(); 
        dog.move("forward"); 

        
    }
}
