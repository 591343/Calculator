package genwind;

import java.util.Vector;

/**
 * 计算信息类
 */
public class ComputationInfo {
    //计算信息
    private Vector<String> info;

    public Vector<String> getInfo() {
        return info;
    }

    public void setInfo(Vector<String> info) {
        this.info = info;
    }

    public Memento saveMemento(){
        return  new Memento(info);
    }

    public void restoreMemento(Memento memento){
        this.info=memento.getInfo();
    }


}
