public class coutY2 {
  MainUi C=new MainUi();
    double D1;  //出差调节系数；
    double D2;  //地点调节系数；是否为广东市区 1为花都区内  ， 2为广州市内， 3为广东省外 4位广东省内
    int location=C.getLocations();  //是否为广东市区    1为花都区内  ， 2为广州市内， 3为广东省外 4位广东省内

  int day;

        public double coutY22(int y2,int day)
        {
              this.day=day;//获取出差天数
              double sum=0.0;
             if(day<30)
             {   D1=1;
                if(location==1)  //在花都区内
                {    D2=0.8;
                    sum=y2*day*D1*D2;

                }else if(location==2)//在广州市内
                  {
                      D2=1;
                      sum=y2*day*D1*D2;
                  }
                 else if(location==3) //在广东省内
                    {
                        D2=1;
                        sum=y2*day*D1*D2;
                    }
                 else {              //在广东省外
                     D2=1.5;
                     sum=y2*day*D1*D2;
                   }

             }else if(day>30&&day<=50)
                {  D1=0.6;
                    if(location==1)  //在花都区内
                    {    D2=0.8;
                        sum=y2*day*D1*D2;

                    }else if(location==2)//在广州市内
                    {
                        D2=1;
                        sum=y2*day*D1*D2;
                    }
                    else if(location==3) //在广东省内
                    {
                        D2=1.2;
                        sum=y2*day*D1*D2;
                    }
                    else {              //在广东省外
                        D2=1.5;
                        sum=y2*day*D1*D2;
                    }
                }else{
                        D1=0.3;
                 if(location==1)  //在花都区内
                 {    D2=0.8;
                     sum=y2*day*D1*D2;

                 }else if(location==2)//在广州市内
                 {
                     D2=1;
                     sum=y2*day*D1*D2;
                 }
                 else if(location==3) //在广东省内
                 {
                     D2=1;
                     sum=y2*day*D1*D2;
                 }
                 else {              //在广东省外
                     D2=1.5;
                     sum=y2*day*D1*D2;
                 }                                                                       }



           return sum;
        }




}
