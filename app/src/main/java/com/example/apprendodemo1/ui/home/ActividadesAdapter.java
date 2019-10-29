package com.example.apprendodemo1.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.apprendodemo1.R;

import java.util.ArrayList;

public class ActividadesAdapter extends RecyclerView.Adapter<ActividadesAdapter.MyViewHolder>{
    private ArrayList<Dinamica> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout textView;
        public TextView tituloDinamica;
        public TextView descripcionDinamica;

        public MyViewHolder(LinearLayout v) {
            super(v);
            textView = v;
            tituloDinamica = (TextView) v.findViewById(R.id.tituloDinamica);
            descripcionDinamica = (TextView) v.findViewById(R.id.descripcionDinamica);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ActividadesAdapter(ArrayList<Dinamica> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ActividadesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardlistadoactividades, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Dinamica obj = mDataset.get(position);

        holder.tituloDinamica.setText(obj.titulo);
        holder.descripcionDinamica.setText(obj.descripcion);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
