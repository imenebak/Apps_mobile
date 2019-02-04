package com.example.imene.devoir_tp_apps;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by imene on 04/05/2018.
 */

public class CustomerList extends ArrayAdapter<String> {
    private String[] TitreHistoire, Auteur;
    private int[] Images;
    private String[] nb;
    private Activity context;
    public CustomerList(Activity context, String[] TitreHistoire,String[] Auteur,int[] Images, String[] nb) {
        super( context, R.layout.lisr_layout, TitreHistoire);
        this.context=context;
        this.TitreHistoire=TitreHistoire;
        this.Auteur=Auteur;
        this.Images= Images;
        this.nb = nb;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r= convertView;
        ViewHolder viewHolder= null;
        if (r==null){
            LayoutInflater layoutInflater= context.getLayoutInflater();
            r=layoutInflater.inflate( R.layout.lisr_layout,null,true );
            viewHolder = new ViewHolder( r );
            r.setTag( viewHolder );
        }
        else {
            viewHolder=(ViewHolder)r.getTag();
        }
        viewHolder.im1.setImageResource( Images[position] );
        viewHolder.t1.setText( TitreHistoire[position] );
        viewHolder.t2.setText( Auteur[position] );
        viewHolder.t3.setText( nb[position] );
        return r;
    }

    public class ViewHolder{
        TextView t1, t2, t3;
        ImageView im1;
        ViewHolder(View v){
            t1=v.findViewById( R.id.His1Title );
            t2=v.findViewById( R.id.His1Aut );
            t3=v.findViewById( R.id.His1nbpage );
            im1=v.findViewById( R.id.His1Image );

        }
    }
}
