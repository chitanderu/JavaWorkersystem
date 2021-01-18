import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerUI  extends JFrame implements ActionListener{
    JButton jb1=new JButton();
    JButton jb2=new JButton();
    JPanel jp1,jp2,jp3,jp9=null;
    JPanel  sey,sey2,sey3,sey4;
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6=null;
    JLabel  id=null;
    JLabel Y1,Y2,Y3,Y4=null;
    JLabel uY1,uY2,uY3,uY4=null;
    JLabel     cus,day1,con,wor;
    JTextField customer,day,contract;  //供用户补充的个人信息
    JPanel     customerUse,dayUse,contractUse;
      static Worker workerUse;//显示用户的4个初始系数
    public static  void  main(String[] args)
    {

        WorkerUI ui=new WorkerUI(workerUse);

    }

    public WorkerUI(Worker user)    //不能申明为void  否则弹不出新界面
    {   setBg();
        workerUse =user;     //将传入的WORKER 类赋给a；
        //this.setLayout(null);
        //jp1.setLayout(null);

        //创建组件
        jb1 = new JButton("绩效查询");
        jb1.setForeground(Color.RED);
        jb1.setBounds(new Rectangle(new Point(200, 300), jb1.getPreferredSize()));
        jb1.setContentAreaFilled(false);

        jb2=new JButton("添加信息");
        jb2.setForeground(Color.BLUE);
        jb2.setContentAreaFilled(false);
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp9=new JPanel();
        jp9.setOpaque(false);
        jlb1=new JLabel("姓名：");
        jlb1.setBounds(new Rectangle(new Point(200, 300), jb1.getPreferredSize()));
        jlb2=new JLabel("id：");
        jlb3=new JLabel("公告：");
        Y1=new JLabel("系数1:");
        Y2=new JLabel("系数2: ");
        Y3=new JLabel("系数3: ");
        Y4=new JLabel("系数4: ");




        uY1=new JLabel(String.valueOf(new MainUi().getY1()));
        uY2=new JLabel(String.valueOf(new MainUi().gety2()));
        uY3=new JLabel(String.valueOf(new MainUi().gety3()));
        uY4=new JLabel(String.valueOf(new MainUi().getY4()));

        sey=new JPanel();
        sey.add(Y1);
        sey.add(uY1);

        sey2=new JPanel();
        sey2.add(Y2);
        sey2.add(uY2);

        sey3=new JPanel();       //存放系数
        sey3.add(Y3);
        sey3.add(uY3);

        sey4=new JPanel();

        sey4.add(Y4);
        sey4.add(uY4);
        sey.setOpaque(false);

        sey2.setOpaque(false);

        sey3.setOpaque(false);

        sey4.setOpaque(false);


        jlb3.setForeground(Color.red);
        jlb4=new JLabel("考核进行中 请输入相关数据进入考核界面-----------------------");


        jlb5=new JLabel(workerUse.getName());

//

            jp1.add(jlb1);
            jp1.add(jlb5);

//        jp9.add(jlb2);
//        jp9.add(id);

        jp2.add(jb1);
        jp2.add(jb2);

        jp3.add(jlb3);
        jp3.add(jlb4);

        cus=new JLabel("新员工人数");
        customer=new JTextField(3);

        contractUse=new JPanel();
        contractUse.add(cus);
        contractUse.add(customer);
        contractUse.setOpaque(false);

        dayUse=new JPanel();
        day1=new JLabel("出差天数");
        day=new JTextField(3);
        dayUse.add(day1);
        dayUse.add(day);
        dayUse.setOpaque(false);

         customerUse=new JPanel();
        con=new JLabel("合同订单数");
        contract=new JTextField(3);
        contractUse.add(con);
        contractUse.add(contract);
        contractUse.setOpaque(false);


        //jp4.setOpaque(false);
        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(sey);
        this.add(sey2);
        this.add(sey3);
        this.add(sey4);
                          //this.add(jp9);
        this.add(contractUse);
        this.add(dayUse);
        this.add(customerUse);
        //设置布局管理器
        //this.setLayout(new GridLayout(5,4,50,50));
        this.setLayout(new FlowLayout());
       // this.setLayout(new CardLayout(15,15));
        this.setTitle("个人信息");
        this.setSize(400,650);
        this.setLocation(200, 200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
        jb1.addActionListener(this);
        jb2.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

      if(e.getActionCommand()=="绩效查询")
                 {
                     if(contract.getText().isEmpty()||day.getText().isEmpty()||customer.getText().isEmpty())
                     {
                         JOptionPane.showMessageDialog(null,"信息未添加完毕 请重新添加","提示消息",JOptionPane.WARNING_MESSAGE);
                           return;
                     }
                         dispose();

                    scoreUi UI= new scoreUi(workerUse);

                 }else if(e.getActionCommand()=="添加信息")
                       {
                             if(contract.getText().isEmpty()||day.getText().isEmpty()||customer.getText().isEmpty())
                                 {
                                     JOptionPane.showMessageDialog(null,"信息未添加完毕 请重新添加","提示消息",JOptionPane.WARNING_MESSAGE);
                                 }
                             else{
                                      workerUse.contract= Integer.parseInt(contract.getText());  //用integer类中的pareInt 方法将字符类转换为int
                                      workerUse.day=Integer.parseInt(day.getText());
                                      workerUse.newworker=Integer.parseInt(customer.getText());
                                 JOptionPane.showMessageDialog(null,"添加成功","提示消息",JOptionPane.WARNING_MESSAGE);
                             }

                       }






    }


    public void setBg(){  //设置背景图片
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon
                ("img/mixi.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
}


