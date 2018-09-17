public class Person {
  String name;

    public Person(String personName) {
            name = personName;
    }

    public String greet(String yourName) {
            return String.format("Hi %s, my name is %s", name, yourName);
    }
    
    public static void main(String[] args){
    	Person person = new Person("Tom");
    	System.out.println(person.greet("Dick"));
    	;
    }
}