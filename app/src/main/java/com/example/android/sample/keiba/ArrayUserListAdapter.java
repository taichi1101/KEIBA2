package com.example.android.sample.keiba;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArrayUserListAdapter extends BaseAdapter{


    //これは、userlistのためのAdapter
    private Context ctx;

    LayoutInflater layoutInflater ;
    public ArrayList<UserAccount> adapterlist;

    public ArrayUserListAdapter(Context cotext, ArrayList<UserAccount> adapterlist) {
        this.ctx = cotext;
        this.adapterlist = adapterlist;
        this.layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayUserListAdapter(Context ctx) {
        this.ctx = ctx;
        this.layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setAdapterList(ArrayList<UserAccount> adapterlist) {
        this.adapterlist = adapterlist;
    }

    @Override
    public int getCount() {
        return adapterlist.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return adapterlist.get(position).getId();
    }



    //1/4 多分この下のgetViewのpositionはタッチされた場所のviewの文字を取得するためのもの
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserAccount user = adapterlist.get(position);
        user.username=adapterlist.get(position).getUsername();
        user.score=adapterlist.get(position).getScore();
        user.imageView=adapterlist.get(position).getImageView();

        //多分だけどidnumberも取得して一意のデータを取得する必要があるんだと思う
        //usernameなど、UserクラスのArrayListAdapterに使用してるidを使う

        //user.idnumber=adapterlist.get(position).getIdnumber();
        convertView = layoutInflater.inflate(R.layout.accountrowdata,parent,false);
        ((TextView)convertView.findViewById(R.id.username)).setText(adapterlist.get(position).getUsername());
        ((TextView)convertView.findViewById(R.id.score)).setText(adapterlist.get(position).getScore());
//        ((ImageView)convertView.findViewById(R.id.imageview)).setImageResource(adapterlist.get(position).getImageView());

        //この上でgetItemIdが行われてるからそれを使う
        ((ImageView)convertView.findViewById(R.id.imageview)).setImageResource((int)adapterlist.get(position).getId());



//        ImageView appInfoImage = (ImageView)view.findViewById(R.id.item_image);
//        appInfoImage.setImageResource(item.getImageId());

        //この下を、idnumberを表示しなくした時に消した
        // ((TextView)convertView.findViewById(R.id.idnumber)).setText(adapterlist.get(position).getIdnumber());
        return convertView;
        //return new UserListView(ctx, user.data, user.username, user.comment,user.idnumber);
    }
}
