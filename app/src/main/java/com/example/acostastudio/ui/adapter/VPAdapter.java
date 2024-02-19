package com.example.acostastudio.ui.adapter;

import android.animation.LayoutTransition;
import android.text.Layout;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acostastudio.R;
import com.example.acostastudio.ui.item.ViewPagerItem;

import java.util.ArrayList;

public class VPAdapter extends RecyclerView.Adapter<VPAdapter.ViewHolder> {

    ArrayList<ViewPagerItem> viewPagerItemArrayList;

    public VPAdapter(ArrayList<ViewPagerItem> viewPagerItemArrayList) {
        this.viewPagerItemArrayList = viewPagerItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pager_history,parent,false);

        LinearLayout visible1,invisible1;

        visible1 = view.findViewById(R.id.linearVisible1);

        visible1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        CardView cardLayout = view.findViewById(R.id.cardView);
        cardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = v.findViewById(R.id.contenido);
                if (textView.getMaxLines() == 3) {
                    textView.setMaxLines(Integer.MAX_VALUE);
                    textView.setEllipsize(null);
                    TransitionManager.beginDelayedTransition(parent, new AutoTransition());
                } else {
                    textView.setMaxLines(3);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    TransitionManager.beginDelayedTransition(parent, new AutoTransition());
                }
            }
        });


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ViewPagerItem viewPagerItem = viewPagerItemArrayList.get(position);

        holder.titulo.setText(viewPagerItem.titulo);
        holder.contenido.setText(viewPagerItem.contenido);


    }

    @Override
    public int getItemCount() {
        return viewPagerItemArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView titulo,contenido;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.titulo);
            contenido = itemView.findViewById(R.id.contenido);

        }
    }

}
