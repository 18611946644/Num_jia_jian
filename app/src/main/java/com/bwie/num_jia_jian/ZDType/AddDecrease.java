package com.bwie.num_jia_jian.ZDType;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.num_jia_jian.R;

/**
 * Created by DELL on 2018/10/3.
 */

public class AddDecrease extends RelativeLayout {

    //控件
    private ImageView imgAdd;
    private ImageView imgDecrease;
    private TextView txtShow;

    //4 接口回调
      //1 定义一个接口
      public interface InterfaceOnClickListener{
          //定义两个方法  加号  和 减号
         void add(int num);

         void decrease(int num);
    }
      //2 提供一个接口对象
      private InterfaceOnClickListener listener;
      //3 提供一个接口对象传递方法
      public void setInterfaceOnClickListener(InterfaceOnClickListener listener){
          this.listener = listener;
      }

    //1 重写三个方法
    public AddDecrease(Context context) {
        this(context,null);
    }

    public AddDecrease(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AddDecrease(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //2 调用一个方法
        init(context,attrs);
    }

    //2 被调用的方法
    private void init(Context context, AttributeSet attrs) {
        //1 调用画的自定义view及其属性  ----返回了一个属性数组
        //参数R.styleable.AddDecrease_view_Style为引入的自定义属性名 使用一共两个参数的
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Add_Decrease_Type);
        //2 设置改变默认颜色  参数一位子姓名   参数二为设置默认值
        int color = typedArray.getColor(R.styleable.Add_Decrease_Type_middle_text_color, Color.RED);

        //得到默认颜色后  需要给控件附上值  但是必须是在找到这个控件之后再进行赋值 否则报错 所以赋值这一步在找到控件之后才写的

        //3 设置改变图片默认属性
        int resourceId = typedArray.getResourceId(R.styleable.Add_Decrease_Type_left_image_style, R.drawable.ic_launcher_foreground);
        //赋值同上 必须在找到这个控件之后再进行赋值

        //4 找控件前要引入布局
        View.inflate(context,R.layout.item_add_decrease,this);
        // 5 找控件
        imgAdd = findViewById(R.id.img_add);
        imgDecrease = findViewById(R.id.img_decrease);
        txtShow = findViewById(R.id.txt_num);

        //6 进行赋值  //注  除了自定义默认的  可以到主引入自定义布局中进行修改
        txtShow.setTextColor(color);
        imgDecrease.setImageResource(resourceId);

        //7 为加减号进行点击事件
        imgDecrease.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击减号 进行减1
                //1 首先要得到当前text内容
                String s = txtShow.getText().toString();
                //2 将数据类型强zhuan为int 类型
                int num = Integer.valueOf(s);
                //3 判断当前是否小于1  如果小于则不减 如果大于就减1
                if(num>1){
                    num--;
                }
                //4 将值重新赋值给text
                txtShow.setText(num+"");
                //5 加完之后进行方法回调
                listener.decrease(num);
            }
        });

        imgAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击加号进行 加1
                //1 首先得到当前内容值
                String s = txtShow.getText().toString();
                //2 将值强zhuan为int类型
                int num = Integer.valueOf(s);
                //3 得到之后  进行加1
                num++;
                //4 重新赋值
                txtShow.setText(num+"");
                //5 调用加号方法
                listener.add(num);
            }
        });
    }

    //3 颜色改变方法
    public void ChangeColor(int color){
        txtShow.setTextColor(color);
    }

}
