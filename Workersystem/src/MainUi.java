

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import java.util.ArrayList;

/*
p
extends JFrame ；继承duJava的JFrame类，JFrame 是Java的窗体类zhi，继承它可以重写它的一些方法dao达到更方便编程的作用
 implements ActionListener ； 是实现 ActionListener 接口，为动作监听接口，是Java swing 监听窗体动作的一个接口
 
*/

public class MainUi  extends JFrame implements ActionListener {   //调用action listener的接口
     String text;  //boolean workerUse=false;
    static String mark=null;Worker te;
    static List<Worker> workerList =new ArrayList<Worker>();//列表Arrylist；
    static int ok=0;
    static  int idtext;
         //定义按钮
    JButton jb1,jb2,jb3=null;  //设置登录文本
   JRadioButton jrb1,jrb2=null; //设置人员
     JPanel jp1,jp2,jp3,jp4=null;
     JTextField jtf=null;     //登录账号
    JLabel jlb1,jlb2,jlb3=null;
    JPasswordField jpf=null;  //登录密码
    ButtonGroup bg=null;
    JPanel jp5=null;

    JMenuBar jmb=null;
    JMenu jm=null;
    JMenuItem jmi1,jmi2=null;


public static void main(String[] args)
{
     // Worker workerUse=new Worker(70,34,55,66,56,15,10,70,1,1);
    Worker te;
    Worker a=new Worker(45,34,55,66,56,0,0,0,2,1,2,"12345","12345","zxk",12000);
    Worker c=new Worker(12,34,55,737,1256,0,0,0,2,2,3,"123456","123456","wen",2400);
    Worker d=new Worker(12,134,55,737,278,0,0,0,1,2,1,"1","1","ze",3600); //样例//样例
      workerList.add(a);  //添加实例化的对象到集合类
      workerList.add(c);
      workerList.add(d);


      MainUi ms=new MainUi(); //实例化GUI类

//    //实例化HSSFWorkbook对象，相当于新建一个Excel文件
//    HSSFWorkbook workbook=new HSSFWorkbook();
//    //根据HSSFWorkbook获取Sheet
//    HSSFSheet sheet=workbook.createSheet();
//    //添加一行作为表格头
//    HSSFRow header=sheet.createRow(0);
//
//    //创建表格样式
//    HSSFCellStyle cellStyle=workbook.createCellStyle();
//
//    //创建头部表格
//    HSSFCell cell=header.createCell(0);
//    cell.setCellStyle(cellStyle);
//    cell.setCellValue("Y1");
//
//    cell=header.createCell(1);
//    cell.setCellStyle(cellStyle);
//    cell.setCellValue("Y2");
//
//    cell=header.createCell(2);
//    cell.setCellStyle(cellStyle);
//    cell.setCellValue("Y3");
//
//    cell=header.createCell(3);
//    cell.setCellStyle(cellStyle);
//    cell.setCellValue("Y4");
//
//    cell=header.createCell(4);
//    cell.setCellStyle(cellStyle);
//    cell.setCellValue("all");
//     for(int i=0;i<workerList.size();i++)
//     {   Worker d=workerList.get(i);
//         HSSFRow content=sheet.createRow(i+1);
//         content.createCell(0).setCellValue(d.id);
//         content.createCell(1).setCellValue(d.contract);
//         content.createCell(2).setCellValue(d.day);
//         content.createCell(3).setCellValue(d.password);
//         content.createCell(4).setCellValue(d.guangdong);
//
//     }try {
//    //写入文件
//    FileOutputStream fileOutputStream=new FileOutputStream("C:/员工信息.xls");
//    workbook.write(fileOutputStream);
//    fileOutputStream.close();
//    System.out.println("导出成功！");
//} catch (IOException e) {
//    e.printStackTrace();
//    System.out.println("导出失败！");
//}
//
//    //导入到excel表格
}

public MainUi()
{     if(ok==0)
      init();//设置按钮
         ok++;

}




    @Override  //对事件进行监听
    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand()=="退出")
      {
        System.exit(0);
      } else if(e.getActionCommand()=="登录")
      {    if(!jtf.getText().isEmpty()) {
                   if(jrb1.isSelected())
                   {

                       Worker workerUse =login();  //调用登录方法
                        if(workerUse ==null)
                        {
                            JOptionPane.showMessageDialog(null,"用户不存在 请检查  ","提示消息",JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                       if(workerUse !=null&& workerUse.id.equals(jtf.getText())&& workerUse.password.equals(jpf.getText()))
                       {
                           JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
                              //this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // dispose();

                           WorkerUI ui=new WorkerUI(workerUse);   //实例化 的同时 传入 worker这个对象
                            ;

                       }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
                       {
                           JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
                       }else if(jtf.getText().isEmpty())
                       {
                           JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
                       }else if(jpf.getText().isEmpty())
                       {
                           JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
                       }
                        else
                       {
                           JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
                               //清空输入框

                       }
                   }
                   }

      }else if(e.getActionCommand()=="重置")
        {
             clear();
        }

    }

    public	void clear()
    {
        jtf.setText("");
        jpf.setText("");
    }

public  Worker login()
{
    for(int i = 0; i< workerList.size(); i++)
    {  Worker exmaple= workerList.get(i);
        if(exmaple.id.equals(jtf.getText()))
           {      idtext=i;
               return  exmaple;}

    }


    return null;

}
 public Worker getAccount()
 {



  Worker text= workerList.get(idtext);


   return text;
 }

  public Worker getUser(Worker t)
  {

      return t;
  }


    public String getNamer()
   {
       Worker d=getAccount();


        return d.name;

   }


    public int getY1()
    {   Worker d=getAccount();


        return d.y1;
    }

    public int getKernel()
    { Worker d=getAccount();


        return d.hexing;
    }


    public  int getSellMode()
    {
        Worker d=getAccount();


        return d.sellmode;
    }


    public int getCustomer()
    {
        Worker d=getAccount();


        return d.customer;


    }

    public int getday()
    {
         Worker d=getAccount();

        return d.day;
    }

   public int getLocations()
   {
       Worker d=getAccount();

       return d.guangdong;
   }


    public int gety2() {
        Worker d=getAccount();

        return d.y2;
    }

    public int gety3()
    {   Worker d=getAccount();

        return d.y3;
    }

    public int getNewWorker()
    {   Worker d=getAccount();

       return d.newworker;
    }



 public int getContract()
 {

     Worker d=getAccount();

     return d.contract;
 }

 public int getY4()
 {
     Worker d=getAccount();

     return d.y4;

 }
public String getId()
{Worker d=getAccount();
    return d.id;
}

 public  String  getmark()
 {
      return mark;
 }

public void init()
{   setBg();
    //设置按钮
    jb1=new JButton("登录");
    jb2=new JButton("重置");
    jb3=new JButton("退出");
    //给按钮设置监听

    jb1.addActionListener(this);
    jb2.addActionListener(this);
    jb3.addActionListener(this);

    jmb=new JMenuBar();    //建立菜单选项；
    jm=new JMenu("选项");
    jmi1=new JMenuItem("开始");
    jmi2=new JMenuItem("退出系统");
    //添加到组件中

    jm.add(jmi2);
    jm.add(jmi1);
    jmb.add(jm);
    jrb1=new JRadioButton("工人");
    jrb1.setOpaque(false);
    bg=new ButtonGroup();


    bg.add(jrb1);

    jp1=new JPanel();
    jp2=new JPanel();
    jp3=new JPanel();
    jp4=new JPanel();



//final JLabel l=new JLabel();
//ImageIcon i=new ImageIcon()

    jlb1=new JLabel("用户名");
    jlb2=new JLabel("密码");


    jtf=new JTextField(10);
    jpf=new JPasswordField(10);
//加入到jPanel容器中
    jp1.add(jlb1);
    jp1.add(jtf);
    jp1.setOpaque(false);

    jp2.add(jlb2);
    jp2.add(jpf); //password judge
    jp2.setOpaque(false);

    jp4.add(jb1);
    jp4.add(jb2);
    jp4.add(jb3);
    jp4.add(jrb1);//添加到JPanel组件

    jp4.setOpaque(false);
    jp1.setOpaque(false);
    jp2.setOpaque(false);
    jp3.setOpaque(false);

    this.setJMenuBar(jmb);
    this.add(jp1);
    this.add(jp2);
    this.add(jp4);


    this.setLayout(new GridLayout(4,1));
    //给窗口设置标题
    this.setTitle("职员工作量管理系统");
    //设置窗体大小
    this.setSize(600,750);
    //设置窗体初始位置
    this.setLocation(200, 150);
    //设置当关闭窗口时，保证JVM也退出
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //显示窗体
    //this.setUndecorated(true);
    //this.setBackground(new Color(0,0,0,0));
    //this.setVisible(true);

    this.setVisible(true);
    this.setResizable(true);
}



 public List<Worker> getWorkerList()
 {
     return workerList;

 }


    public void setBg(){  //设置背景图片
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon
                ("img/original-1.gif");
        JLabel background = new JLabel(img);
          this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
           background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }


}
