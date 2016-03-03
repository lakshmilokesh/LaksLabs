package com.sample;

/**
 *
 * Java program which demonstrate that we can not override static method in Java.
 * Had Static method can be overridden, with Super class type and sub class object
 * static method from sub class would be called in our example, which is not the case.
 *
 * Similarly private methods cannot be overriden as the methods are private and are not accessible in the child class.
 * @author
 */
public class CanWeOverrideStaticMethod {

    public static void main(String args[]) {

        Screen scrn = new ColorScreen();

        //if we can  override static , this should call method from Child class
        //Java won't resolve method call at runtime and depending upon type of Object which is used to call static
        //method, corresponding method will be called

        scrn.show(); //IDE will show warning, static method should be called from classname

    }

}

class Screen{

    /*
     * public static method which can not be overridden in Java
     */
    public static void show(){
        System.out.printf("Static method from parent class");
    }
}

class ColorScreen extends Screen{
    /*
     * static method of same name and method signature as existed in super
     * class, this is not method overriding instead this is called
     * method hiding in Java
     */
    public static void show(){
        System.err.println("Overridden static method in Child Class in Java");
    }
}

