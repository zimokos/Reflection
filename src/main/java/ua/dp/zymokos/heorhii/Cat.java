package ua.dp.zymokos.heorhii;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Cat {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Animal animal = new Animal();
        getFields(animal);
        changeFieldByName(animal, "first", "hundred");
        changeFieldByName(animal, "second", 200);
        changeFieldByName(animal, "third", 300.0);
        System.out.println();
        classInfo(animal);
    }

    public static void getFields(Animal animal) {
        Class aClass = animal.getClass();
        Integer number = 1;
        for (Field field : aClass.getDeclaredFields()) {
            System.out.print("Field #" + number);
            System.out.print(": " + field.getName());
            System.out.print(" (" + field.getType().getName() + ")");
            System.out.println();
            number++;
        }
    }

    public static void changeFieldByName(Animal animal, String fieldName, String newValue) throws NoSuchFieldException, IllegalAccessException {
        Class aClass = animal.getClass();
        Field field = aClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        System.out.print("Старое значение: ");
        System.out.print(field.get(animal));
        field.set(animal, newValue);
        System.out.print(", новое значение: ");
        System.out.println(field.get(animal));
    }

    public static void changeFieldByName(Animal animal, String fieldName, Integer newValue) throws NoSuchFieldException, IllegalAccessException {
        Class aClass = animal.getClass();
        Field field = aClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        System.out.print("Старое значение: ");
        System.out.print(field.get(animal));
        field.set(animal, newValue);
        System.out.print(", новое значение: ");
        System.out.println(field.get(animal));
    }

    public static void changeFieldByName(Animal animal, String fieldName, Double newValue) throws NoSuchFieldException, IllegalAccessException {
        Class aClass = animal.getClass();
        Field field = aClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        System.out.print("Старое значение: ");
        System.out.print(field.get(animal));
        field.set(animal, newValue);
        System.out.print(", новое значение: ");
        System.out.println(field.get(animal));
    }

    public static void classInfo(Object object) {
        Class obj = object.getClass();
        System.out.print("Class: " + obj.getName());
        int modifiers = obj.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.println(" ( modifier: public )");
        }
        if (Modifier.isPrivate(modifiers)) {
            System.out.println(" ( modifier: private )");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(" ( modifier: abstract )");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(" ( modifier: final )");
        }
        Class objSuperclass = obj.getSuperclass();
        System.out.println("SuperClass: " + objSuperclass.getName());
        Integer fieldNumber = 0;
        for (Field field : obj.getDeclaredFields()) {
            fieldNumber++;
            System.out.print("Field #" + fieldNumber);
            System.out.print(": " + field.getName() + " ( type: ");
            System.out.print(field.getType().getName() + " )");
            System.out.println();
        }
        Integer constructorNumber = 0;
        for (Constructor constructor : obj.getDeclaredConstructors()) {
            constructorNumber++;
            System.out.print("Constructor #" + constructorNumber + ": ");
            System.out.print(constructor.getName() + " ( parameter types: ");
            for (Class parameterType : constructor.getParameterTypes()) {
                System.out.print(parameterType.getName() + " ");
                ;
            }
            System.out.print(")");
            System.out.println();
        }
        Integer methodNumber = 0;
        for (Method method : obj.getDeclaredMethods()) {
            methodNumber++;
            System.out.print("Method #" + methodNumber + ": ");
            System.out.print(method.getName() + " ( return type: ");
            System.out.print(method.getReturnType().getName() + " ) ( parameter types: ");
            for (Class parameterType : method.getParameterTypes()) {
                System.out.print(parameterType.getName() + " ");
            }
            System.out.print(")");
            System.out.println();
        }
    }
}
