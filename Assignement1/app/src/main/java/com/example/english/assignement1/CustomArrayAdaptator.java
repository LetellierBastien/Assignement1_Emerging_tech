package com.example.english.assignement1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by english on 09/03/2016.
 */
public class CustomArrayAdaptator extends ArrayAdapter<ElementListeView>{

    ArrayList <ElementListeView> elements = null;
    Context context;

    public CustomArrayAdaptator(Context context, ArrayList <ElementListeView> resource) {
        super(context,R.layout.row,resource);

        this.context = context;
        this.elements = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.row, parent, false);


            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.textView1);
            holder.box = (CheckBox) convertView.findViewById(R.id.checkBox1);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        ElementListeView e = getItem(position);

        holder.box.setChecked(e.checked==1);
        holder.text.setText(e.text);

        return convertView;
    }

}
