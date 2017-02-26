package com.ddb.listviewtest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.view.View.*;

/**
 * Created by deepin on 17-2-26.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int reourceId;

    public FruitAdapter(Context context,int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        this.reourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit = getItem(position);//获取当前项的Ｆｒｕｉｔ实例
        //不使用缓存进行优化的代码
        //View view = LayoutInflater.from(getContext()).inflate(reourceId,parent,false);

        //使用缓存进行优化，原理很简单就是用一个组件存起来，有点类似单例模式！
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(reourceId,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else {
            view =convertView;
            viewHolder = (ViewHolder) view.getTag();//取出保存的ｖｉｅｗｈｏｌｄｅｒ
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    //定义内部类用于存储获取到的组件，避免多次重复获取影响性能！
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }

}
