package com.petrichor.strategy.good3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Administrator on 2018/9/2.
 *
 练习
 Sunny软件公司欲开发一款飞机模拟系统，该系统主要模拟不同种类飞机的飞行特征与起飞特征，需要模拟的飞机种类及其特征如表24-1所示：
 表24-1 飞机种类及特征一览表

 飞机种类
 起飞特征
 飞行特征

 直升机(Helicopter)
 垂直起飞(VerticalTakeOff)
 亚音速飞行(SubSonicFly)

 客机(AirPlane)
 长距离起飞(LongDistanceTakeOff)
 亚音速飞行(SubSonicFly)

 歼击机(Fighter)
 长距离起飞(LongDistanceTakeOff)
 超音速飞行(SuperSonicFly)


 为将来能够模拟更多种类的飞机，试采用策略模式设计该飞机模拟系统。
 */

//模拟类：环境类
class Simulation {

    private Aircraft aircraft; //维持一个对抽象折扣类的引用


    //注入一个飞机类对象
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public void launchAndFlight() {
        this.aircraft.launchAndFlight();
    }
}

//飞机类：抽象策略类
interface Aircraft {
    public void launchAndFlight();
}

//直升机类：具体策略类
class Helicopter implements Aircraft {

    @Override
    public void launchAndFlight() {
        System.out.println("我是直升机，我垂直起飞！");
        System.out.println("我是直升机，我亚音速飞行！");
    }


}

//客机类：具体策略类
class AirPlane implements Aircraft {

    @Override
    public void launchAndFlight() {
        System.out.println("我是客机，我长距离起飞！");
        System.out.println("我是客机，我亚音速飞行！");
    }
}

//歼击机类：具体策略类
class Fighter implements Aircraft {

    @Override
    public void launchAndFlight() {
        System.out.println("我是歼击机，我长距离起飞！");
        System.out.println("我是歼击机，我超音速飞行！");
    }
}

class Client {
    public static void main(String args[]) {
        Simulation mt = new Simulation();

        Aircraft aircraft;
        aircraft = (Aircraft) XMLUtil.getBean(); //读取配置文件并反射生成具体飞机对象
        mt.setAircraft(aircraft); //注入飞机对象

        mt.launchAndFlight();

    }
}

class XMLUtil {
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getBean() {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("config.xml"));

            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("simulation-className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = classNode.getNodeValue();

            //通过类名生成实例对象并将其返回
            Class c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


