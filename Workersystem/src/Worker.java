import java.time.Year;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Worker {
    int y1,y2,y3,y4;
    int  customer; //顾客人数
    int  hexing; //是否为核心产品
    int  guangdong;  //是否为广东市区 1为花都区内  ， 2为广州市内， 3为广东省外 4位广东省内
    int   contract;
    int day;  //出差天数
    int  newworker;  //新员工人数
    int  sellmode; //1为售前  2位售后
    double passWork; //通过的标准工作量
     String id;
     String password ;
     String name;

   public Worker(int a,int b,int c,int d,int customer,int contract,int day,int newworker,int sellmode,int hexing,int guangdong,String id,String password,String name,double passWork)
   {   y1=a;

       y2=b;

       y3=c;

       y4=d;

       this.customer=customer;

       this.contract=contract;

       this.day=day;

       this.newworker=newworker;

       this.sellmode=sellmode;

       this.hexing=hexing;

       this.guangdong=guangdong;

       this.id=id;


       this.password=password;


       this.name=name;

       this.passWork=passWork;
   }

   public String getId()
   {
       return  id;
   }

public String getName()
{
    return name;
}

  public int getY1()
  {
    return y1;
  }

  public int getY2()
    {
        return y2;
    }

    public int getY3()
    {
        return y3;
    }


    public int getY4()
    {
        return y4;
    }

    public int getCustomer()
    {


        return customer;
    }

    public int getHexing()
    {

        return hexing;


    }

    public int getContract()
    {

        return customer;
    }


    public int getGuangdong()
    {


        return guangdong;
    }

    public int getDay()
    {


        return day;
    }


    public int getNewworker()
    {

        return newworker;
    }


    public int getSellmode()
    {


        return sellmode;
    }















}
