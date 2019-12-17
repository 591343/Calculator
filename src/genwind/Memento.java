package genwind;

import java.util.Vector;

/**
 * @author  chenxiao
 * @date 2019/12/17
 * 备忘录模式实现历史记录回滚
 */
public class Memento {
    private Vector<String> info;

    public Memento(Vector<String> info){
        this.info=info;
    }

    public Vector<String> getInfo() {
        return info;
    }

    public void setInfo(Vector<String> info) {
        this.info = info;
    }


}
