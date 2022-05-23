package study.daily;

import study.dada.DailyCourse1;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class ObjextTest {

    /**
     * 获取对象的属性和其对应的值
     *
     * @throws Exception
     */
    public static Map<String, Object> getFiledAndValue(Object object) throws Exception {

        String str = "Integer Long Short Byte Float Double Character Boolean Date String";
        Map<String, Object> map = new HashMap<>();
        List<Field> fields = getFields(object);
        for (Field field : fields) {
            if (!field.getName().equals("serialVersionUID") && str.contains(field.getType().getSimpleName())) {
                if (invokeGetMethod(field.getName(), object) != null) {
                    if (!invokeGetMethod(field.getName(), object).equals("")) {
                        map.put(field.getName(), invokeGetMethod(field.getName(), object));
                    }
                }
            }
        }
        return map;
    }

    public static List<Field> getFields(Object object) throws Exception {
        List<Field> list = new ArrayList<>();
        Class<?> thisClass = object.getClass();
        int n = 0;
        for (; thisClass != Object.class; thisClass = thisClass.getSuperclass()) {
            Field[] fields = thisClass.getDeclaredFields();
            if (n == 0) {
                for (Field f : fields) {
                    if (!f.getName().equals("serialVersionUID")) {
                        list.add(f);
                    }
                }
            } else {
                for (Field f : fields) {
                    int i = f.getModifiers();
                    boolean isPrivate = Modifier.isPrivate(i);
                    if (!f.getName().equals("serialVersionUID") && isPrivate == false) {
                        list.add(f);
                    }
                }
            }
            n++;
        }
        return list;
    }

    /**
     * 执行对象的GET方法
     *
     * @param fieldName
     * @return
     */
    public static Object invokeGetMethod(String fieldName, Object object) {
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, object.getClass());
            Method method = pd.getReadMethod();
            return method.invoke(object);
        } catch (Exception e) {
            return null;
        }

    }

    public static void main(String[] args) throws Exception {
        Object p1 = new DailyCourse1.Parent("f1", "c1", "f");

        Map<String, Object> map = getFiledAndValue(p1);

        System.out.println("map = " + map);
    }
}
