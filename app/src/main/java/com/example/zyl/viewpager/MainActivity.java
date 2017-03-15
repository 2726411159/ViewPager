package com.example.zyl.viewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private int[]img={R.drawable.pi,R.drawable.pic,R.drawable.picc};
    private Button btn_login,btn_register;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_register= (Button) findViewById(R.id.btn_register);
        viewPager= (ViewPager) findViewById(R.id.viewPager);

        MyViewPager myViewPager=new MyViewPager();//相当于适配器
        viewPager.setAdapter(myViewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==2){
                    btn_login.setVisibility(View.VISIBLE);
                    btn_register.setVisibility(View.VISIBLE);
                    btn_login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "...", Toast.LENGTH_SHORT).show();
                        }
                    });
                    btn_register.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "1001", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private class MyViewPager extends PagerAdapter{
        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imge=new ImageView(MainActivity.this);
            imge.setScaleType(ImageView.ScaleType.FIT_XY);
            imge.setImageResource(img[position]);
            container.addView(imge);
            return imge;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
