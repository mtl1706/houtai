package xulihua.demo;

import java.io.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/15.
 * 对象序列化时如何实现对象序列化力度控制？？
 * 方案一：
 * 100个属性，只有一个属性不序列化？  （使用transient修饰该属性）
 * 方案二：
 * 100个属性，只有一个属性需要序列化？
 * （实现Serializable改为让对象实行Externalizable此类是其一个实现类，让后实现其中的方法）
 */
public class TestIO03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //构造Log对象
        Log log = new Log();
        log.setId(10);
        log.setUser("a");
        log.setOperator("b");
        log.setIp("172.88.50.120");
        log.setCreatedTime(new Date());
        //对对象进行序列化,对象序列化到文件
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("f.txt"));
        out.writeObject(log);
        out.close();
        //对对象反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
        Log log1 = (Log)in.readObject();
        System.out.println(log1);
        //Log{id=null, user='null', operator='null', createdTime=null, ip='172.88.50.120'}
    }
}
