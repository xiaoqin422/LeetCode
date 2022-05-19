/**
 * 包名: PACKAGE_NAME
 * 类名: Car
 * 创建用户: 25789
 * 创建日期: 2022年05月17日 17:12
 * 项目名: LeetCode
 *
 * @author: 秦笑笑
 **/
public class Car {
    //    线程可见
    private static volatile  Car car = null;
    private Car(){

    }
    public static Car getInstance(){
        if (car == null){
            synchronized (Car.class){
                // 双重检测
                if (car == null){
                    car = new Car();
                }
            }
        }
        return car;
    }
}