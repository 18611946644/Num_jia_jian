package com.bwie.num_jia_jian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bwie.num_jia_jian.ZDType.AddDecrease;

public class MainActivity extends AppCompatActivity {

    private AddDecrease adv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1 布局控件
        adv = findViewById(R.id.adv);

        //2 接口的实现
        AddDecrease.InterfaceOnClickListener listener = new AddDecrease.InterfaceOnClickListener() {
            @Override
            public void add(int num) {
                Toast.makeText(MainActivity.this, "当前的数量是" + num, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void decrease(int num) {
                Toast.makeText(MainActivity.this, "当前的数量是" + num, Toast.LENGTH_SHORT).show();
            }
        };

        // 回调第三步方法   把接口的对象调用第3步传进去
        adv.setInterfaceOnClickListener(listener);
        //颜色改变 可以调用方法进行颜色修改  也可以在自定义属性之后 直接带布局中修改
        //adv.ChangeColor(Color.RED);
    }
}
