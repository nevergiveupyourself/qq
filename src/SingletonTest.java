//方法一：单例饿汉模式,在类装载时创建
public class Singleton{
  private static final Singleton INSTANCE=new Singleton();
  // Private constructor suppresses
  // default public constructor
  private Singleton(){};
  
  public static Singleton getInstance(){
    return INSTANCE;
  }
}

//方法二：单例懒汉模式,第一次使用单例时创建,此种方法只能用在JDK5及以后版本(注意 INSTANCE 被声明为 volatile)
public class Singleton {
  
    private static volatile Singleton INSTANCE=null;

    //Private constructor suppresses
    //default public constructor
    private Singleton(){};

    //Thread safe and performance  promote
    public static Singleton getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton.class){
                // When more than two threads run into the first null check same time,
                // to avoid instanced more than one time, it needs to be checked again.
              //疑问,2次判空的理由待进一步确认,synchronized按道理已经阻塞了？
                if(INSTANCE == null){
                    INSTANCE=new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
