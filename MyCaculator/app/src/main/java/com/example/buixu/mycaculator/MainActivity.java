package com.example.buixu.mycaculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.system.ErrnoException;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import nguyenvanquan7826.com.Balan;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button //Hang cac bieu thuc so hoc
            SHIFT, ALPHA, LEFT,RIGHT,MODE,ON,// hang0
            CALC,TICHPHAN,COPY,REPLAY,NGHICHDAO_GIAITHUA,CONST,//hang1
            PHANSO_PHANSOHONHOP,CANBAC2_CANBAC3,BINHPHUONG,MuN_CanBacN,LOGARIT,LOGARITE,//hang2
            BUTTON_A,BUTTON_B,BUTTON_C,BUTTON_D_SINX,BUTTON_E_COSX,BUTTON_F_TANX,//hang3
            BUTTON_RLC,BUTTON_ENG_THUC_AO,BUTTON_NGOACTRAI_AGR,BUTTON_NGOACPHAI_ABS_X,BUTTON_PHAY_CHAMPHAY_Y,BUTTON_NHO_XOA_M,//hang4
            /// Hang phim so
            BUTTON_SO7_BOIM,BUTTON_SO8_BOIGIGA,BUTTON_SO9_BOI_TETRA,BUTTON_DELETE_INS,BUTTON_AC_OFF,//hang5
            BUTTON_SO4_MAT_BOIu,BUTTON_SO5_BOIMINI,BUTTON_SO6_BOIKILO,BUTTON_PHEPNHAN_nPr,BUTTON_PHEPCHIA_nCr,//hang6
            BUTTON_SO1_SUM_BOIf,BUTTON_SO2_S_VAR_BOIPICO,BUTTON_SO3_DISTR_BOINANO,BUTTON_PHEPCONG,BUTTON_PHEPTRU,//hang7
            BUTTON_SO0_RND,BUTTON_DAUPHAY_RAN,BUTTON_EXP_SOPI,BUTTON_HIENTHIKETQUATRUOCDO_DRG,BUTTON_PHEPBANG;//hang8
    TextView Input, Output,Textview_Shift,Textview_Alpha,Textview_set_angle,Textview_setmode,Textview_setmode2;//hang9
    String Chuoi_dau_vao="",chuoi_hien_thi_dau_ra="";
    int startut=0;
    int startut_ALpha=0;
    Balan mBalan;
    Button mButtons[];
    String Text1[]={
            "SHIFT","ALPHA","LEFT","RIGHT","MODE",   "ON",
            "CALC", "∫dx",  "COPY","RELAY","X^(−1)","CONST",
            "A/B/C","√",   "X^2","^","LOG","LN",
            "(-)",  "°'''", "HYP","SIN","COS","TAN",
            "RCL",  "ENG",  "(",")","''","M+",
            "7","8","9","DEL","AC",
            "4","5","6","X","÷",
            "1","2","3","+","-",
            "0",".","EXP","ANS","="
    };
    String Text2[]=
            {
                    "SHIFT","ALPHA","LEFT","RIGHT","CLR",   "ON",
                    "SOLVE", "D/DX",  "COPY","RELAY","X!","CONV",
                    "D/C","3√",   "X^3","x√","10^x","e^x",
                    "∠",  "←", "HYP","sin-1","COS-1","TAN-1",
                    "STO",  "←",  "arg","abs",";","M-",
                    "M","G","T","INS","OFF",
                    "µ","m","k","nPr","nCr",
                    "f","p","n","Pol(","Rec(",
                    "Rnd","Ran#","pi","DRG>","Re<->Im"

            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBalan=new Balan();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setGui();
        Chon_che_do_bam_cac_nut_su_kien();

        xu_ly_su_kien_nhan_nut_so();
        Xu_ly_cac_su_kien_toan_tu();
        Xu_lychuoi_dau_vao_va_hien_thi();
    }
    public void setGui()
    {// hang phim0
        SHIFT=(Button)findViewById(R.id.button_shift);
        ALPHA=(Button)findViewById(R.id.button_ALPHA);
        LEFT=(Button)findViewById(R.id.button_Left);
        RIGHT=(Button)findViewById(R.id.button_Right);
        MODE=(Button)findViewById(R.id.Button_Mode_CLR);
        ON=(Button)findViewById(R.id.button_ON);
        //Hang phim 1
        CALC=(Button)findViewById(R.id.button_CALC);
        TICHPHAN=(Button)findViewById(R.id.button_tichphanbacmot);
        COPY=(Button)findViewById(R.id.button_COPY);
        REPLAY=(Button)findViewById(R.id.button_REPLAY);
        NGHICHDAO_GIAITHUA=(Button)findViewById(R.id.button_nghichdao_giaithua);
        CONST=(Button)findViewById(R.id.button_CONST);
        //Hangphim2
        PHANSO_PHANSOHONHOP=(Button)findViewById(R.id.button_phanso_phansohonhop);
        CANBAC2_CANBAC3=(Button)findViewById(R.id.button_canbac2_canbac3);
        BINHPHUONG=(Button)findViewById(R.id.button_binhphuong);
        MuN_CanBacN=(Button)findViewById(R.id.button_muN_canbacN);
        LOGARIT=(Button)findViewById(R.id.button_Logarit);
        LOGARITE=(Button)findViewById(R.id.button_LogaritE);
        //Hangphim3
        BUTTON_A=(Button)findViewById(R.id.button_A);
        BUTTON_B=(Button)findViewById(R.id.button_B);
        BUTTON_C=(Button)findViewById(R.id.button_C);
        BUTTON_D_SINX=(Button)findViewById(R.id.button_D_SinX);
        BUTTON_E_COSX=(Button)findViewById(R.id.button_E_CosX);
        BUTTON_F_TANX=(Button)findViewById(R.id.button_F_TanX);
        //Hangphim4
        BUTTON_RLC=(Button)findViewById(R.id.button_RCL);
        BUTTON_ENG_THUC_AO=(Button)findViewById(R.id.button_ENG_thuc_ao);
        BUTTON_NGOACTRAI_AGR=(Button)findViewById(R.id.button_Ngoactrai_agr);
        BUTTON_NGOACPHAI_ABS_X=(Button)findViewById(R.id.button_Ngoacphai_Abs_X);
        BUTTON_PHAY_CHAMPHAY_Y=(Button)findViewById(R.id.button_phay_champhay_Y);
        BUTTON_NHO_XOA_M=(Button)findViewById(R.id.button_Luu_xoa_M);
        //Cac hang phim so
        BUTTON_SO7_BOIM=(Button)findViewById(R.id.button_so7_boiM);
        BUTTON_SO8_BOIGIGA=(Button)findViewById(R.id.button_so8_boiGiga);
        BUTTON_SO9_BOI_TETRA=(Button)findViewById(R.id.button_so9_boiTetra);
        BUTTON_DELETE_INS=(Button)findViewById(R.id.button_DEL_INS);
        BUTTON_AC_OFF=(Button)findViewById(R.id.button_AC_OFF);

        BUTTON_SO4_MAT_BOIu=(Button)findViewById(R.id.button_so4_MAT_boiU);
        BUTTON_SO5_BOIMINI=(Button)findViewById(R.id.button_so5_VCT_boiMini);
        BUTTON_SO6_BOIKILO=(Button)findViewById(R.id.button_so6_boiKilo);
        BUTTON_PHEPNHAN_nPr=(Button)findViewById(R.id.button_phepNhan_nPr);
        BUTTON_PHEPCHIA_nCr=(Button)findViewById(R.id.button_phepChia_nCr);

        BUTTON_SO1_SUM_BOIf=(Button)findViewById(R.id.button_so1_Sum_BoiF);
        BUTTON_SO2_S_VAR_BOIPICO=(Button)findViewById(R.id.button_so2_S_VAR_boiPico);
        BUTTON_SO3_DISTR_BOINANO=(Button)findViewById(R.id.button_so3_DISTR_boiNano);
        BUTTON_PHEPCONG=(Button)findViewById(R.id.button_phepCong);
        BUTTON_PHEPTRU=(Button)findViewById(R.id.button_phepTru);

        BUTTON_SO0_RND=(Button)findViewById(R.id.button_so0_Rnd);
        BUTTON_DAUPHAY_RAN=(Button)findViewById(R.id.button_dauphay_Ran);
        BUTTON_EXP_SOPI=(Button)findViewById(R.id.button_EXP_soPi);
        BUTTON_HIENTHIKETQUATRUOCDO_DRG=(Button)findViewById(R.id.button_Ketquatruoc_DRG);
        BUTTON_PHEPBANG=(Button)findViewById(R.id.button_phep_Bang);


        //Phan text view hien thi tren man hinh lcd
        Input=(TextView)findViewById(R.id.textView_input);
        Output=(TextView)findViewById(R.id.textView_output);
        Textview_Shift=(TextView)findViewById(R.id.textView_Shift);
        Textview_Alpha=(TextView)findViewById(R.id.textView_Alpha);
        Textview_set_angle=(TextView)findViewById(R.id.textView_Mode_angle);
        Textview_setmode=(TextView)findViewById(R.id.textView_Mode_View);
        Textview_setmode2=(TextView)findViewById(R.id.textView_setmode_2);
         mButtons= new Button[]{
                 //Hang cac bieu thuc so hoc
                 SHIFT, ALPHA, LEFT, RIGHT, MODE, ON,// hang0
                 CALC, TICHPHAN, COPY, REPLAY, NGHICHDAO_GIAITHUA, CONST,//hang1
                 PHANSO_PHANSOHONHOP, CANBAC2_CANBAC3, BINHPHUONG, MuN_CanBacN, LOGARIT, LOGARITE,//hang2
                 BUTTON_A, BUTTON_B, BUTTON_C, BUTTON_D_SINX, BUTTON_E_COSX, BUTTON_F_TANX,//hang3
                 BUTTON_RLC, BUTTON_ENG_THUC_AO, BUTTON_NGOACTRAI_AGR, BUTTON_NGOACPHAI_ABS_X, BUTTON_PHAY_CHAMPHAY_Y, BUTTON_NHO_XOA_M,//hang4
                 /// Hang phim so
                 BUTTON_SO7_BOIM, BUTTON_SO8_BOIGIGA, BUTTON_SO9_BOI_TETRA, BUTTON_DELETE_INS, BUTTON_AC_OFF,//hang5
                 BUTTON_SO4_MAT_BOIu, BUTTON_SO5_BOIMINI, BUTTON_SO6_BOIKILO, BUTTON_PHEPNHAN_nPr, BUTTON_PHEPCHIA_nCr,//hang6
                 BUTTON_SO1_SUM_BOIf, BUTTON_SO2_S_VAR_BOIPICO, BUTTON_SO3_DISTR_BOINANO, BUTTON_PHEPCONG, BUTTON_PHEPTRU,//hang7
                 BUTTON_SO0_RND, BUTTON_DAUPHAY_RAN, BUTTON_EXP_SOPI, BUTTON_HIENTHIKETQUATRUOCDO_DRG, BUTTON_PHEPBANG//hang8//
         };

    }
    public void setuptextforbutton()
    {
      switch (startut)
      {
          case 0:
          {
              for(int i=0;i<mButtons.length;i++)
              {
                  mButtons[i].setText(Text1[i]);
              }
              break;

          }
        //  break;
          case 1:
          {
              for(int i=0;i<mButtons.length;i++)
              {
                  mButtons[i].setText(Text2[i]);
              }
              break;

          }
        //  break;

      }

    }
    public void hienthimanhinhinput()
    {
        Input.setText(""+Chuoi_dau_vao);
    }
    public void Hienthiketquaramanhinh()
    {
        Output.setText(chuoi_hien_thi_dau_ra+"");
    }
    public void Chon_che_do_bam_cac_nut_su_kien()
    {
        // Dung phim shift de thay doi che do cac nut
        // startut=flase-che do binh thuong luc khong nhan phim Shift
        // startut=true-che do thuc hien cac chuc nang co shift, phim Shift duoc nhan
        SHIFT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startut==0) {
                    startut = 1;
                    startut_ALpha=0;
                    setuptextforbutton();
                    Textview_Shift.setText("S");
                    Textview_Alpha.setText("");

                }
                else
                {
                    if (startut==1)
                    {
                        startut = 0;
                        startut_ALpha=0;
                        setuptextforbutton();
                        Textview_Shift.setText("");
                        Textview_Alpha.setText("");
                    }
                }
            }
        });
        ALPHA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startut_ALpha==0) {
                    startut_ALpha = 1;
                    startut=0;
                    setuptextforbutton();
                    Textview_Alpha.setText("A");
                    Textview_Shift.setText("");
                }
                else
                {
                    if (startut_ALpha==1)
                    {
                        startut_ALpha = 0;
                        startut=0;
                        setuptextforbutton();
                        Textview_Alpha.setText("");
                        Textview_Shift.setText("");
                    }
                }
            }
        });
    }
    public void xu_ly_su_kien_nhan_nut_so()
    {
        // thiet lap su kien nhan nut cho cac nut so
        // phim so 0
        BUTTON_SO0_RND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switch (startut)
               {
                   case 0:
                       Chuoi_dau_vao=Chuoi_dau_vao+"0";
                       Input.setText(""+Chuoi_dau_vao);
                       break;
                   case 1:
                       startut=0;
                       break;
               }



            }
        });
        //phim so 1
        BUTTON_SO1_SUM_BOIf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"1";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        ////code here
                        startut=0;
                        break;

                }
            }
        });
        //phim so 2
        BUTTON_SO2_S_VAR_BOIPICO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"2";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        // code here
                        startut=0;
                        break;
                }
            }
        });
        //phim so 3
        BUTTON_SO3_DISTR_BOINANO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"3";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
        //phim so 4
        BUTTON_SO4_MAT_BOIu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"4";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
        //phim so 5
        BUTTON_SO5_BOIMINI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"5";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
        //so 6
        BUTTON_SO6_BOIKILO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"6";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
        BUTTON_SO7_BOIM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"7";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
        BUTTON_SO8_BOIGIGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"8";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
        BUTTON_SO9_BOI_TETRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"9";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });

        BUTTON_DAUPHAY_RAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+".";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;

                }
            }
        });





    }
    public void Xu_ly_cac_su_kien_toan_tu()
    {
        // cac phep toan co ban cong tru nhan chia
        BUTTON_PHEPCONG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"+";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;

                }
            }
        });
        BUTTON_PHEPTRU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"-";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
        BUTTON_PHEPNHAN_nPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"*";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
        BUTTON_PHEPCHIA_nCr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        Chuoi_dau_vao=Chuoi_dau_vao+"/";
                        Input.setText(""+Chuoi_dau_vao);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
    }
    public void Xu_lychuoi_dau_vao_va_hien_thi()
    {
        //Phep bang
        BUTTON_PHEPBANG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Input.setText("");
                try{
                    chuoi_hien_thi_dau_ra= mBalan.valueMath(Chuoi_dau_vao);
                }
                catch (Exception e)
                {
                    chuoi_hien_thi_dau_ra="Error: Syntax Error";
                }
                Output.setText(chuoi_hien_thi_dau_ra+"");
                Chuoi_dau_vao="";


            }
        });


        BUTTON_HIENTHIKETQUATRUOCDO_DRG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (startut)
                {
                    case 0:
                        //   Chuoi_dau_vao=Chuoi_dau_vao+"";
                        Output.setText(""+chuoi_hien_thi_dau_ra);
                        break;
                    case 1:
                        //code here
                        startut=0;
                        break;
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
