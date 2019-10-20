package zxl.com.reflecttest.interfaces;

import org.junit.Test;
import zxl.com.reflecttest.interfaces.impl.Apple;

/**
 * test1 获取一个实现类的父类 和 实现的接口类。
 */
public class InterfaceReflectTest {
    @Test
    public void test1(){
        try {
            Class clazz = Class.forName(Apple.class.getName());
            System.out.println(clazz.getSuperclass());
            Class<?>[] interFaces = clazz.getInterfaces();
            for(Class<?> infa :interFaces){
                System.out.println("实现的接口："+infa);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        try {
            Class clazz = Class.forName(Fruit.class.getName());
            System.out.println(clazz);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
