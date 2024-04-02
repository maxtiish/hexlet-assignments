package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        String[] array = new String[Address.class.getDeclaredMethods().length];
        var i = 0;
        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                array[i] = "Method " + method.getName() + " returns a value of type " + method.getReturnType().getSimpleName();
                i++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
