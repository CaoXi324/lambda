
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaDemo {

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.test1();
        lambdaDemo.test2();
        lambdaDemo.test3();
        lambdaDemo.test4();
    }


    //    实例对象名::实例方法名
    public void test1() {
//          为了更好理解，将ps声明出来
        PrintStream ps = System.out;
//          传入的参数用来打印到控制台
        Consumer<String> con = (str) -> ps.println(str);
//          调用方法
        con.accept("Hello World！");
//          上面是一个简单的例子，下面我们换个写法
        System.out.println("--------------------------------");
//          ps为PrintStream对象，println为实例方法
        Consumer<String> con2 = ps::println;
//          调用方法
        con2.accept("Hello Java8！");
//          所以也可换成这种写法
        Consumer<String> con3 = System.out::println;
    }

//        类名::类方法名

    public void test2() {
//1  使用Math类的静态方法max(double,double)做最大值选择
        BiFunction<Double, Double, Double> fun = (x, y) -> Math.max(x, y);
//2  调用方法，返回double
        Double apply1 = fun.apply(1.5, 22.2);
        System.out.println(apply1);

        System.out.println("--------------------------------------------------");

//3  Max.max(x,y)写成 Math::max
        BiFunction<Double, Double, Double> fun2 = Math::max;
        Double apply = fun2.apply(1.2, 1.5);
        System.out.println(apply);
    }


    //    类名::实例方法名
    public void test3() {
//1  x调用equals方法，y作为参数
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("abcde", "abcde"));

        System.out.println("-----------------------------------------");

//2  可以改写为 String::equals
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("abc", "abc"));
    }

//    构造器的引用
    public void test4() {
//1  新建一个对象
        Supplier<Student> sup = () -> new Student();

        System.out.println(sup.get());

        System.out.println("------------------------------------");

        Supplier<Student> sup2 = Student::new;
        System.out.println(sup2.get());

    }
}

