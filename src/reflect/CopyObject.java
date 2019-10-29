/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:CopyObject
 * Time:2019/10/2915:20
 * Description:
 */
package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CopyObject {
    public static void main(String[] args) {
        Person p = new Person();
        p.setId(1);
        p.setName("周志强");
        p.setAge(22);
        System.out.println(copyObjet(p));
    }
    public static Object copyObjet(Object obj) {
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        Object instance=null;
        try {
            Constructor<?> constructor = aClass.getDeclaredConstructor();
             instance = constructor.newInstance();
            for (Field field : fields) {
                String name = field.getName();
                Class<?> type = field.getType();
                String sName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                String gName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                Method sMethod = aClass.getDeclaredMethod(sName, type);
                Method gMethod = aClass.getDeclaredMethod(gName, null);
                Object result = gMethod.invoke(obj, null);
                sMethod.invoke(instance,result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
