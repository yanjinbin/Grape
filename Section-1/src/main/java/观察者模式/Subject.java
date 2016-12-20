package 观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Silver Bullet
 * @since 十二月-20
 */
public abstract class Subject {
    public List<Observer> observers = new ArrayList<Observer>();//不能写成 public List<Observer> observers ;不然会报空指针异常

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }


    public void notifyObserver(){
        for (Observer observer:observers){
            observer.update();
        }
    }

    public abstract void  doSomething();
}
