package com.example.hidden;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hidden.MainActivity;
import com.example.hidden.R;
import com.example.hidden.UserListShow;
import com.example.hidden.Database;
import com.example.hidden.User;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context mContext;
    ArrayList<User> userArrayList;

    public Adapter(Context context, ArrayList<User> userArrayList) {
        this.mContext = context;
        this.userArrayList = userArrayList;
    }
    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = mInflater.inflate(R.layout.user_list, parent, false);

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView score = (TextView) view.findViewById(R.id.score);


        name.setText(userArrayList.get(position).getName());
        score.setText(String.valueOf(userArrayList.get(position).getScore()));

        LinearLayout userLinearLayout = view.findViewById(R.id.user);
        userLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, GameActivity.class);
                intent.putExtra("id", userArrayList.get(position).getId());
                mContext.startActivity(intent);
            }
        });

        return view;
    }

}
