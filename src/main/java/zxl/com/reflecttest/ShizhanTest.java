package zxl.com.reflecttest;

import org.junit.Test;
import zxl.com.reflecttest.entity.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ShizhanTest {

    @Test
    public void test1(){
        getObj(Student.class);
    }


    public void getObj(Class<?> s){
        try {
            Class clazz = Class.forName(s.getName());
            Object obj = clazz.newInstance();
            System.out.println("obj.tostring"+obj);
            System.out.println("获取类中public类型的参数包含父类：");
            Field[] fields = clazz.getFields();
            for (Field field:fields){
                System.out.println(field.getName());
                System.out.println(field);
            }
            System.out.println("获取类所有的参数：");
            Field[] fields2 = clazz.getDeclaredFields();
            for (Field field:fields2){
                System.out.println(field);
                System.out.println(field.getName());
                System.out.println(field.getType());
            }

            System.out.println("获取类中public类型的方法包含父类：");
            Method[] ms = clazz.getMethods();
            for (Method method:ms){
                System.out.println(method);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSet(){
        Set<String> strs = new HashSet<String>();
        strs.add("1");
        strs.add("3");
        strs.add("4");
        strs.add("5");
        strs.add("6");
        strs.add("7");
        System.out.println("迭代遍历：");
        Iterator<String> ss = strs.iterator();
        while (ss.hasNext()){
            System.out.println(ss.next());
        }
        System.out.println("for循环遍历");
        for (String str :strs){
            System.out.println(str);
        }



    }
}
