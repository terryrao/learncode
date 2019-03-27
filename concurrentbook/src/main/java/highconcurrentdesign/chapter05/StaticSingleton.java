package highconcurrentdesign.chapter05;

/**
 * 静态类生成单例的方法
 * @author raowei
 * @date 2019-03-27
 */
public class StaticSingleton {
    private StaticSingleton() {
    }


    private static class singletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public StaticSingleton getInstance() {
        return singletonHolder.instance;
    }
}
