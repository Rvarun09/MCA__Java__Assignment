public class Animal {
  String name;
  int age;
  Animal(String name,int age){
    this.name=name;
    this.age=age;
  }
  public void makesound(){
    System.out.println("make sound");
  }; 
}
class Dog extends Animal{
    Dog(String name,int age){
        super(name,age);
    }
   @Override
   public void makesound(){
    System.out.println("Bark");
   }

}
class Cat extends Animal{
    Cat(String name,int age){
        super(name,age);
    }
@Override
   public void makesound(){
    System.out.println("Meowwww");
   }
}
class Bird extends Animal{
    Bird(String name,int age){
        super(name,age);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
@Override
   public void makesound(){
    System.out.println("Chirp");
   }
}
class Main{
    public static void main(String[] args) {
        Animal a1 = new Animal("HAHA", 5);
        a1.makesound();
        Dog d1 = new Dog("Shitzu", 7);
        d1.makesound();
        Cat c1 = new Cat("Chuava", 4);
        c1.makesound();
        Bird b1 = new Bird("Sparrow", 2);
        b1.makesound();     
    }
}
