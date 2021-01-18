public class coutY1 {

    public double  coutY11(int Y1)   //计算技术支持
    {
     MainUi b=new MainUi();
       final  double K0=1.1;    //核心
        final  double K0p=1.0;   //非核心
           //各种可以选择的系数，通过if来筛选；
        final  double B1=1.0;      //售前
        final  double B2=1.15;      //售后
        final double   K1=1;     //人员系数






        double sum=0.0;
        int num=b.getCustomer();
        int sellmdoe=b.getSellMode();
        int hexing=b.getKernel();


        if(num<50)
        {
            if(sellmdoe==1)
            {
                if(hexing==1)
                {
                    sum=  ((Y1*B1+7)*K0*K1);
                }else
                    sum= ((Y1*B1+7)*K0p*K1);
            }else if(sellmdoe==2)
            {
                if(hexing==1)
                {
                    sum=  ((Y1*B2+7)*K0*K1);
                }else
                    sum= ((Y1*B2+7)*K0p*K1);

            }
        }else if(num>50&&num<100){
            if(sellmdoe==1)
            {
                if(hexing==1)
                {
                    sum=  ((Y1*B1+7)*K0*(K1+(num-50)*0.004));
                }else
                    sum= ((Y1*B1+7)*K0p*(K1+(num-50)*0.002));
            }else if(sellmdoe==2)
            {
                if(hexing==1)
                {
                    sum= ((Y1*B2+7)*K0*(K1+(num-50)*0.004));
                }else
                    sum= ((Y1*B2+7)*K0p*(K1+(num-50)*0.004));

            }




        }else if(num>100)
        {
            if(sellmdoe==1)
            {
                if(hexing==1)
                {
                    sum=  ((Y1*B1+7)*K0*(K1+(num-100)*0.002));
                }else
                    sum= ((Y1*B1+7)*K0p*(K1+(num-100)*0.002));
            }else if(sellmdoe==2)
            {
                if(hexing==1)
                {
                    sum= ((Y1*B2+7)*K0*(K1+(num-100)*0.002));
                }else
                    sum= ((Y1*B2+7)*K0p*(K1+(num-100)*0.002));

            }
        }




        return sum;
    }


}
