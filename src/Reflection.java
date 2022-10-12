import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws Exception{
        Cat cat = new Cat("Carlos", 5);

        System.out.println("----------FIELDS--------------");
        //get object field names
        Field[] catFields = cat.getClass().getDeclaredFields();
        for(Field field: catFields){
            System.out.println(field.getName());
        }

        //change private and final field of the object
        for(Field field: catFields){
            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(cat, "Fluffy");
            }
        }
        System.out.println("Cat new name is: " + cat.getName());

        System.out.println("----------METHODS------------");

        //get object's methods names
        Method[] catMethods = cat.getClass().getDeclaredMethods();
        for(Method method: catMethods){
            System.out.println(method.getName());
        }

        System.out.println("-------INVOKING METHODS--------");

        //invoking public method (new object needed)
        cat.meow();
        //invoking public static method (no object needed, done from Class)
        Cat.publicStaticMethod();

        //invoking private method
        for(Method method : catMethods){
            if(method.getName().equals("privateMethod")){
                method.setAccessible(true);
                method.invoke(cat);
            }
        }

        //invoking private static method
        for(Method method : catMethods){
            if(method.getName().equals("privateStaticMethod")){
                method.setAccessible(true);
                method.invoke(null);
            }
        }
    }
}