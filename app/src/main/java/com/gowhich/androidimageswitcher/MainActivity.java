package com.gowhich.androidimageswitcher;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewSwitcher.ViewFactory {

    private Button button1;
    private Button button2;
    private ImageSwitcher imageSwitcher;
    private int index = 0;//用户浏览图片的顺序
    private List<Drawable> list = new ArrayList<>();//存放用户图片信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) this.findViewById(R.id.button);
        button2 = (Button) this.findViewById(R.id.button2);
        imageSwitcher = (ImageSwitcher) this.findViewById(R.id.imageSwitcher);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        imageSwitcher.setFactory(this);

        //往list中装入图片信息
        list.add(getResources().getDrawable(R.drawable.fengjing1));
        list.add(getResources().getDrawable(R.drawable.fengjing2));
        list.add(getResources().getDrawable(R.drawable.fengjing3));
        list.add(getResources().getDrawable(R.drawable.fengjing4));

        if(list.size() > 0){
            imageSwitcher.setImageDrawable(list.get(0));
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                index--;
                if(index<0){
                    index = list.size() - 1;
                }
                imageSwitcher.setImageDrawable(list.get(index));
                break;
            case R.id.button2:
                index++;
                if(index >= list.size()){
                    index = 0;
                }
                imageSwitcher.setImageDrawable(list.get(index));
                break;
        }
    }

    @Override
    public View makeView() {
        return new ImageView(MainActivity.this);
    }
}
