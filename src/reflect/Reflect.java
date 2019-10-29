/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:Reflect
 * Time:2019/10/2914:57
 * Description:
 */
package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("reflect.Person");
            Constructor<?> constructor = aClass.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                String name = method.getName();
                if (name.startsWith("set")) {
                    String s = name.substring(3);
                    String s1 = s.substring(0, 1).toLowerCase() + s.substring(1);
                    Field field = aClass.getDeclaredField(s1);
                    Class<?> type = field.getType();
                    if (Integer.class==type) {
                        method.invoke(instance, 1);
                    }
                    if (String.class==type) {
                        method.invoke(instance,"周志强");
                    }
                    if (Integer.class==type) {
                        method.invoke(instance,22);
                    }
                }
            }
            System.out.println(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
