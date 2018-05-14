package xulihua.demo;

import java.io.*;

/**
 * Created by Administrator on 2018/5/14.
 * 如何在对象序列化时，对内容进行加密？？？
 * 为何要序列化，序列化提供了序列化版本号，以下输入输出流，可出现在客户端和服务端
 *
 *java持久层为什么要实现序列化？？
 * 简单来说序列化就是一种用来处理对象流的机制。所谓对象流也就是将对象的
   内容进行流化，流的概念这里不用多说(就是I/O)。我们可以对流化后的对象进行读写
   操作，也可将流化后的对象传输于网络之间(注：要想将对象传输于网络必须进行流化)！
   在对对象流进行读写操作时会引发一些问题，而序列化机制正是用来解决这些问题的！

 * 此类序列化到了内存
 */

class Customer implements Serializable{
    private static final long serialVersionUID = -4751775312832006196L;
    private Integer id;
    private int age;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }

    //对象序列化时，底层会自动调用此方法
    private void writeObject(ObjectOutputStream os) throws IOException {
        //加密（加密算法：可以参考Base64）
        id+=1;
        os.defaultWriteObject();
    }
    //反序列化，底层会自动调用此方法
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        //反序列化
        in.defaultReadObject();
        //解密
        id-=1;
    }
}

public class TestIO02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Customer c1 = new Customer();
        c1.setId(10);
        c1.setAge(20);
        //1.对象序列化
        //1.1构建流对象
        //此类底层基于byte[] buf数组实现,将内容通过这个类写入这里，或则说是序列化到内存，也可以说是缓存到这个数组里
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(c1);
        System.out.println("序列化ok");
        //2.对象反序列化
        ByteArrayInputStream in = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(in);
        Customer c2 = (Customer) ois.readObject();
        System.out.println(c2);
    }
}
