import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//import org.apache.commons.collections4.map.HashedMap;
//import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;


public class scoreUi  extends JFrame implements ActionListener {
                    //系数
    final  double K0=1.1;
    final  double K0p=1.0;
    final double  point3=0.5;
    final  double B1=1.0;
    final  double B2=1.15;
    final double   K1=1;
   final static double ifall=1200;
   static  double add;
   int all;       //总的工作量
   static Worker workerUse;
    static List<Worker> workerList =new ArrayList<Worker>();


    JButton jb1=new JButton();
    JButton jb2=new JButton();
    JPanel   jp1=null;

   MainUi userUI =new MainUi();


       int num= userUI.getCustomer();
       int sellMode = userUI.getSellMode();
       int hexing= userUI.getKernel();
       int where= userUI.getLocations();
       int day= userUI.getday();
       int newWorker = userUI.getNewWorker();
       int contract= userUI.getContract();

    public static void main(String[] args)
    {


            workerList.add(workerUse);
            scoreUi  UI=new scoreUi(workerUse); //实例化类；


    }




      public scoreUi(Worker a)
      {

          workerUse =a;
          incompetent();
             //extra();
      }

      public void incompetent() {

            setBg();
          String[] columnNames = {"技术支持", "出差补助", "指导新员工",  "合同签订","合计"};
          Object[][] obj = new Object[5][5];                           //object 类
          for (int i = 0; i < 4; i++) {
              for (int j = 0; j < 5; j++) {
                  switch (j) {
                      case 0:
                          obj[0][0] = " 技术支持评价:  "+  new coutY1().coutY11(userUI.getY1()) ;
                          obj[0][1] = " 出差补助评价: "+new coutY2().coutY22(userUI.gety2(), workerUse.day);
                          obj[0][2] = " 指导新员工评价: "+new coutY3().coutY33(userUI.gety3(), workerUse.newworker);
                          obj[0][3] = " 合同签订评价: "+new coutY4().coutY44(userUI.getY4(), workerUse.contract);
                          obj[0][4] ="Y1： "+new coutY1().coutY11(userUI.getY1());

                          break;
                      case 1:
                          obj[1][0] = " 售后种类:  "+getSellMode();
                          obj[1][1] = " 地区： "+getlocas();
                          obj[1][2] = "新员工人数:"+ workerUse.newworker;
                          obj[1][3] ="合同数量: +"+ workerUse.contract;
                          obj[1][4] ="Y2："+new coutY2().coutY22(userUI.gety2(), workerUse.day);
                          break;
                      case 2:
                          obj[2][0] = " 客户人数 "+getCustomer();
                          obj[2][1] = "出差天数： "+ workerUse.day;
                          obj[2][2] = "系数E: "+getE();
                          obj[2][3] = "---";
                          obj[2][4] ="Y3："+new coutY3().coutY33(userUI.gety3(), workerUse.newworker);
                          break;
                      case 3:
                          obj[3][0] = "调节系数"+getK1();
                          obj[3][1] = "--";
                          obj[3][2] = "--";
                          obj[3][3] = "--";
                          obj[3][4] ="Y4: "+new coutY4().coutY44(userUI.getY4(), workerUse.contract);

                          break;
                      case 4:
                          obj[4][0] = "Y1";
                          obj[4][1] = "Y2";
                          obj[4][2] = "Y3";
                          obj[4][3] = "Y4";
                          obj[4][4] ="达标工作量："+workerUse.passWork;
                          break;
                  }
              }
          }

          JTable table=new JTable(obj, columnNames);  //JTable的其中一种构造方法
          TableColumn column=null;  					//设置JTable的列默认的宽度和高度
           table.setOpaque(false);
          int colunms = table.getColumnCount();
          for(int i=0;i<colunms;i++)
          {
              column = table.getColumnModel().getColumn(i);
              column.setPreferredWidth(200);  		//将每一列的默认宽度设置为100
          }
          table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);   //设置JTable自动调整列表的状态，此处设置为关闭
          JScrollPane scroll = new JScrollPane(table);       //用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看
          scroll.setSize(600, 550);
            scroll.setOpaque(false);
            scroll.getViewport().setOpaque(false);





          jb1 = new JButton("计算");
          jb2=new JButton("导出");
          jb1.setForeground(Color.BLUE);
          jb1.setBounds(new Rectangle(new Point(10, 10), jb1.getPreferredSize()));
          jb1.setContentAreaFilled(false);
          jb1.setForeground(Color.red);
          jb1.setBounds(new Rectangle(new Point(10, 10), jb1.getPreferredSize()));
          jb2.setContentAreaFilled(false);
          jp1=new JPanel();
          jp1.add(scroll);
          jp1.setOpaque(false);
          jp1.add(jb2);
          jp1.add(jb1);


          jp1.setSize(300,400);
          add(jp1);

          this.setLocation(450, 200);
          this.setVisible(true);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.pack();
          jb1.addActionListener(this);
          jb2.addActionListener(this);
      }






    @Override
    public void actionPerformed (ActionEvent e){
             if(e.getActionCommand()=="计算") {

                  if(jud())
                 JOptionPane.showMessageDialog(null, " 未达标！！  ，还差"+add()+"工作量", "提示消息", JOptionPane.ERROR_MESSAGE);
                   else
                 JOptionPane.showMessageDialog(null, " 恭喜！ 通过了", "提示消息", JOptionPane.WARNING_MESSAGE);
             }else if(e.getActionCommand()=="导出")
             {
                 exportXml();
                 JOptionPane.showMessageDialog(null, "数据已经导出", "提示消息", JOptionPane.WARNING_MESSAGE);
             }

    }


    public List<Worker> getWorkerList()
    {
        return workerList;

    }



    public String getSellMode()
    {
        if(sellMode ==1)
            return "售前 系数为1";
         else
            return "售后 系数为1.15";


    }

    public int getCustomer()
    {
         return num;


    }

   public double getK1()
   {    if(num>50&&num<100)
           {
               return (K1+(num-50)*0.004);
           }
           else if(num>100)
               return (K1+(num-100)*0.002);
           else
               return K1;

   }

   public String getlocas()  //获取地区
   {
          if(where==1)
               return "花都区";
          else if (where==2)
                return "广州市内";
          else if(where==3)
                  return "广东省内";
          else
                  return "广东省外";

   }

   public int getTravel()
   {
       return day;
   }

   public double getE()
   {   double E=0;
         if(newWorker <20&& newWorker >1)
         {
          E=1.0;
         }else if(newWorker >20&& newWorker <=40)
             E=0.6;
         else if(newWorker >=40&& newWorker <=100)
             E=0.3;
         else
             E=0.15;
       return   E;
   }


   public int getnew()
   {

       return newWorker;
   }

   public boolean jud()
   {
         double sum2=new coutY1().coutY11(userUI.getY1())+new coutY2().coutY22(userUI.gety2(), workerUse.day)+new coutY3().coutY33(userUI.gety3(), workerUse.newworker)+new coutY4().coutY44(userUI.getY4(), workerUse.contract);
        if(workerUse.passWork>sum2)
        {return true;
            }
        else
            return false;
   }

  public double add()
  {      double sum6;
          sum6=workerUse.passWork-(new coutY1().coutY11(userUI.getY1())+new coutY2().coutY22(userUI.gety2(), workerUse.day)+new coutY3().coutY33(userUI.gety3(), workerUse.newworker)+new coutY4().coutY44(userUI.getY4(), workerUse.contract));

         return sum6;
  }


public void exportXml(){
     List<Worker> E=new ArrayList<Worker>();
        E.add(workerUse);             //添加从WorkerUI中获取的worker类
    //List<Worker> E=new MainUi().getWorkerList();
//实例化一个list类  调用Mainui方法获取到对象
    //实例化HSSFWorkbook对象，相当于新建一个Excel文件
    HSSFWorkbook workbook=new HSSFWorkbook();
    //根据HSSFWorkbook获取Sheet
    HSSFSheet sheet=workbook.createSheet();
    //添加一行作为表格头
    HSSFRow header=sheet.createRow(0);

    //创建表格样式
    HSSFCellStyle cellStyle=workbook.createCellStyle();

    //创建头部表格
    HSSFCell cell=header.createCell(0);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Y1");

    cell=header.createCell(1);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Y2");

    cell=header.createCell(2);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Y3");

    cell=header.createCell(3);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Y4");

    cell=header.createCell(4);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("技术支持评价");

    cell=header.createCell(5);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("出差补助评价");

    cell=header.createCell(6);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("指导新员工评价");


    cell=header.createCell(7);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("合同签订评价");

    cell=header.createCell(8);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("总工作量");

    cell=header.createCell(9);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("姓名");

    for(int i=0;i<E.size();i++)
    {   Worker d=E.get(i);
        HSSFRow content=sheet.createRow(i+1);
        content.createCell(0).setCellValue(d.y1);
        content.createCell(1).setCellValue(d.y2);
        content.createCell(2).setCellValue(d.y3);
        content.createCell(3).setCellValue(d.y4);
        content.createCell(4).setCellValue(new coutY1().coutY11(d.y1));
        content.createCell(5).setCellValue(new coutY2().coutY22(d.y2,d.day));
        content.createCell(6).setCellValue(new coutY3().coutY33(d.y3,d.newworker));
        content.createCell(7).setCellValue(new coutY4().coutY44(d.y4,d.contract));
        content.createCell(8).setCellValue(coutall(d));
        content.createCell(9).setCellValue(d.name);





    }try {
    //写入文件
    FileOutputStream fileOutputStream=new FileOutputStream("excel/员工信息.xls");
    workbook.write(fileOutputStream);
    fileOutputStream.close();
    System.out.println("导出成功！");

} catch (IOException e) {
    e.printStackTrace();
    System.out.println("导出失败！");
}


}
public  double coutall(Worker d)
{


      double workamount=0;
      workamount=new coutY1().coutY11(d.y1)+new coutY1().coutY11(d.y2)+new coutY3().coutY33(d.y3, workerUse.newworker)+new coutY4().coutY44(d.y4, workerUse.contract);


      return workamount;
}


    public void setBg(){  //设置背景图片
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon
                ("img/少女.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }

}
