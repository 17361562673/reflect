/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:Reflect1
 * Time:2019/10/2915:03
 * Description:
 */
package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect1 {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("reflect.Person");
            Constructor<?> constructor = aClass.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            Field name = aClass.getDeclaredField("name");
            //暴力反射
            name.setAccessible(true);
            name.set(instance, "zzq");
            System.out.println(instance);
            Method print = aClass.getDeclaredMethod("print", null);
            print.setAccessible(true);
            Object invoke = print.invoke(null, null);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
