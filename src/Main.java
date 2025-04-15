import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) {
        List<String> parameterTypesAccepted = new ArrayList<>();
        parameterTypesAccepted.add("int");
        parameterTypesAccepted.add("double");
        parameterTypesAccepted.add("java.lang.String");

        String planetsRoot = "src/Planets/";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the planet you want to scan: ");
        String planetName = scanner.nextLine();
        System.out.println("Searching for planet " + planetName + "...");
        File planet = new File(planetsRoot + planetName);
        URLClassLoader classLoader;
        if(!planet.isDirectory()){
            System.out.println("There is no planet with that name");
            return;
        }else System.out.println("Planet found! Scanning for alien life...");
        try {
            URL[] urls = new URL[]{planet.toURI().toURL()};
            classLoader = new URLClassLoader(urls);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return;
        }
        List<String> discoveredAliens = new ArrayList<>();
        for(;;){
            File[] aliens = planet.listFiles();
            if (aliens == null) break;

            for (File alien : aliens) {
                boolean foundAlien = false;
                if (alien.isFile() && alien.getName().endsWith(".class") && !discoveredAliens.contains(alien.getName())) {
                    foundAlien = true;
                    String alienName = alien.getName().replace(".class", "");

                    try {
                        Class<?> alienClass = classLoader.loadClass("Planets." + planetName + "." + alienName);
                        System.out.println("Alien found: " + alienName + " ,in package: " + alienClass.getName());

                        Field[] alienFields = alienClass.getFields();
                        Field[] alienDeclaredFields = alienClass.getDeclaredFields();
                        List<Field> reunitedFields = new ArrayList<>(List.of(alienFields));

                        for (Field field : alienDeclaredFields) {
                            if (!reunitedFields.contains(field)) {
                                reunitedFields.add(field);
                            }
                        }

                        System.out.println("Fields:");
                        for (Field field : reunitedFields) {
                            System.out.println(field.getName() + " : " + field.getType().getName());
                        }

                        Method[] alienMethods = alienClass.getMethods();
                        Method[] alienDeclaredMethods = alienClass.getDeclaredMethods();
                        List<Method> reunitedMethods = new ArrayList<>(List.of(alienMethods));

                        for (Method method : alienDeclaredMethods) {
                            if (!reunitedMethods.contains(method)) {
                                reunitedMethods.add(method);
                            }
                        }

                        Constructor<?>[] alienConstructors = alienClass.getConstructors();

                        System.out.println("constructors:");
                        for (Constructor<?> constructor : alienConstructors) {
                            constructor.setAccessible(true);
                            System.out.println("Constructor: " + constructor.getName());
                            List<Parameter> parameters = List.of(constructor.getParameters());
                            if(parameters.isEmpty()){
                                Object alienInstance = constructor.newInstance();
                                setRandomValuesForFields(reunitedFields, alienInstance, List.of());
                                printFieldsValue(reunitedFields, alienInstance);
                                useMethods(reunitedMethods, alienInstance);
                            }else{
                                List<Object> valuesForConstr = new ArrayList<>();
                                Random random = new Random();
                                List<String> fieldsInConstr = new ArrayList<>();
                                for (Parameter parameter : parameters) {
                                    System.out.println(parameter.getType().getName());
                                    if(!parameterTypesAccepted.contains(parameter.getType().getName())){
                                        System.out.println("This alien is not accepted on Earth");
                                        return;
                                    } else if(parameter.getType().equals(int.class)){
                                        valuesForConstr.add(random.nextInt(100));
                                    } else if(parameter.getType().equals(double.class)){
                                        valuesForConstr.add(random.nextDouble(100));
                                    }else{
                                        valuesForConstr.add(generateRandomString());
                                    }
                                    fieldsInConstr.add(parameter.getName());
                                }
                                Object alienInstance = constructor.newInstance(valuesForConstr.toArray());
                                setRandomValuesForFields(reunitedFields, alienInstance, fieldsInConstr);
                                printFieldsValue(reunitedFields, alienInstance);
                                useMethods(reunitedMethods, alienInstance);
                            }
                        }


                    }catch (Exception e) {
                        System.out.println("Error loading class: " + e.getMessage());
                    }

                    discoveredAliens.add(alien.getName());
                }
                if(foundAlien){
                    System.out.println("\n");
                }
            }
        }
        scanner.close();
        try{
            classLoader.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static String generateRandomString(){
        Random random = new Random();

        int length = random.nextInt(10) + 1;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String result = "";
        for(int i = 0; i < length; i++){
            char ch = alphabet.charAt(random.nextInt(alphabet.length()));
            result += String.valueOf(ch);
        }
        return result;
    }
    public static void setRandomValuesForFields(List<Field> fields, Object object, List<String> fieldsAlreadySetInConstr) {
        Random random = new Random();

        for (Field field : fields) {
            if (fieldsAlreadySetInConstr.contains(field.getName())) {
                continue;
            }
            try {
                field.setAccessible(true);
                if (field.getType().equals(int.class)) {
                    field.set(object, random.nextInt(100));
                } else if (field.getType().equals(double.class)) {
                    field.set(object, random.nextDouble() * 100);
                } else if (field.getType().equals(String.class)) {
                    field.set(object, generateRandomString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public static void printFieldsValue(List<Field> fields, Object obj){
        for(Field field : fields){
            try {
                field.setAccessible(true);
                if (field.getType().equals(int.class)) {
                    System.out.println(field.getName() + " : " + field.get(obj));
                } else if (field.getType().equals(double.class)) {
                    System.out.println(field.getName() + " : " + field.get(obj));
                } else if (field.getType().equals(String.class)) {
                    System.out.println(field.getName() + " : " + field.get(obj));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public static void useMethods(List<Method> methods, Object obj){
        Random random = new Random();

        for(Method method : methods){
            method.setAccessible(true);
            try {
                Class<?>[] paramTypes = method.getParameterTypes();
                Object[] paramValues = new Object[paramTypes.length];

                for(int i = 0; i < paramTypes.length; i++){

                        if (paramTypes[i] == int.class) {
                            paramValues[i] = random.nextInt(20000);
                        } else if (paramTypes[i] == double.class) {
                            paramValues[i] = random.nextDouble() * 300;
                        } else if (paramTypes[i] == String.class) {
                            paramValues[i] = generateRandomString();
                        } else {
                            System.out.println("We cannot invoke the method " + method.getName() + " ,a parameter unknown: " + paramTypes[i].getName());
                            return;
                        }
                    }
                if(method.getReturnType().equals(void.class)){
                    method.invoke(obj, paramValues);
                    System.out.println("The method " + method.getName() + " with void return type has been invoked");
                }else{
                    Object returnValue = method.invoke(obj, paramValues);
                    System.out.println("The method " + method.getName() + " with " + method.getReturnType() + " return type has been invoke and the return is: " + returnValue);
                }
            }catch(Exception e){
                System.out.println("Err: " + e.getMessage());
            }
        }
        System.out.println("\n");
    }
}