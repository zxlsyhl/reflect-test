package zxl.com.reflecttest;

import org.junit.Test;
import zxl.com.reflecttest.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    /**
     * 获得Class对象
     */
    @Test
    public void getClassObj(){
        try {
            //调用Class的静态方法：forname(String classPath)
            Class clazz1 = Class.forName("zxl.com.reflecttest.entity.Student");

            //调用运行时类的属性：.class
            Class clazz2 = Student.class;

            //通过运行时类的对象，调用getClass()
            Class clazz3 = new Student().getClass();

            //使用类的加载器：ClassLoader
            ClassLoader classLoader = Student.class.getClassLoader();
            Class clazz4 = classLoader.loadClass("zxl.com.reflecttest.entity.Student");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 无参构造器创建对象
     */
    @Test
    public void createInstance(){
        try {
            //获取Class对象
            Class clazz = Student.class;
            //获取无参构造器
            Constructor constructor = clazz.getConstructor();
            //创建实例
            Object object =  constructor.newInstance();
            System.out.println(object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 有参构造器创建对象
     */
    @Test
    public void createInstance2(){
        try {
            //获取Class对象
            Class clazz = Student.class;
            //获取无参构造器
            Constructor constructor = clazz.getConstructor(Integer.class);
            //创建实例
            Student stu = (Student) constructor.newInstance(1);

            System.out.println(stu.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取成员变量
     * getFields：获得公有（public）的成员变量
     * getDeclareFields：获得某个类所有已声明（public、private、protected）的成员变量，不包括父类的成员变量
     */
    @Test
    public void getFields(){
        try {
            //调用Class的静态方法：forname(String classPath)
//            Class clazz = Class.forName("zxl.com.reflecttest.entity.Student");
//            System.out.println(clazz);


            //调用运行时类的属性：.class
//            Class clazz = Student.class;

            Class clazz = Student.class;
            System.out.println("获得某个类的所有的公共（public）的字段，包括父类中的字段。 ");
            System.out.println("- - - getFields获取的成员变量 - - -");
            Field[] fs = clazz.getFields();
            for(Field f : fs){
                System.out.println(f);
            }

            System.out.println("获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。");
            System.out.println("- - - getDeclaredFields获取的成员变量 - - -");
            Field[] dfs = clazz.getDeclaredFields();
            for(Field f : dfs){
                System.out.println(f);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * getMethods：获得所有公用（public）的方法，包括父类的公共方法
     *
     * getDeclaredMethods：获得某个类已声明（public、private、protected）的所有方法，不包括父类
     */
    @Test
    public void getMethods(){
        try {
            Class clazz = Class.forName("zxl.com.reflecttest.entity.Student");
            System.out.println("- - - getMethods获取的方法 - - -");
            Method[] ms = clazz.getMethods();
            for(Method m : ms){
                System.out.println(m);
            }

            System.out.println("- - - getDeclaredMethods获取的方法 - - -");
            Method[] dms = clazz.getDeclaredMethods();
            for(Method m : dms){
                System.out.println(m);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 调用成员变量
     */
    @Test
    public void handleFileTest(){
        try {
            Class clazz = Class.forName("zxl.com.reflecttest.entity.Student");

            System.out.println("- - - 设置和获取成员值 - - -");
            Constructor constructor = clazz.getConstructor();
            Object stu = constructor.newInstance();

            Field nameF = clazz.getDeclaredField("name");
            nameF.setAccessible(true); //类中的成员变量为private,故必须进行此操作
            //成员变量赋值
            nameF.set(stu,"张三");
            //得到成员变量的值
            System.out.println(nameF.get(stu));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 调用方法
     */
    @Test
    public void invokeMethodTest(){
        try {
            Class clazz = Class.forName("zxl.com.reflecttest.entity.Student");

            System.out.println("- - - 调用方法 - - -");
            Constructor constructor = clazz.getConstructor();
            Object stu = constructor.newInstance();
            //设置值
            Method nameS = clazz.getDeclaredMethod("setName",String.class);
            nameS.invoke(stu,"李四");

            //获取值
            Method nameG = clazz.getDeclaredMethod("getName");
            Object name = nameG.invoke(stu);
            System.out.println(name);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void testTest(){
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
