package highconcurrentdesign.chapter05;

/**
 *
 * 此方法的缺点是不能控制构造函数的执行时机
 * @author raowei
 * @date 2019-03-27
 */
public class ClazzSingleton {
   private static ClazzSingleton single = new ClazzSingleton();

   private ClazzSingleton() {}

   public static ClazzSingleton getInstance() {
       return single;
   }

}
