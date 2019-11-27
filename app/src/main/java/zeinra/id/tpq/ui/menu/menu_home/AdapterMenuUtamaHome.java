package zeinra.id.tpq.ui.menu.menu_home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import zeinra.id.tpq.R;

public class AdapterMenuUtamaHome extends RecyclerView.Adapter<AdapterMenuUtamaHome.MyViewHolder> {

    private ArrayList<PojoMenuHome> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        CircleImageView civImage;
        LinearLayout container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvTitle = itemView.findViewById(R.id.tv_menu_home);
            this.civImage = itemView.findViewById(R.id.civ_menu_home);
            this.container = itemView.findViewById(R.id.container);
        }
    }

    public AdapterMenuUtamaHome(ArrayList<PojoMenuHome> data) {
        this.dataSet = data;
    }

    @Override
    public AdapterMenuUtamaHome.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_menu_utama, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterMenuUtamaHome.MyViewHolder holder,final int listposition) {

        TextView textViewName = holder.tvTitle;
        ImageView imageView = holder.civImage;
        LinearLayout container = holder.container;

        textViewName.setText(dataSet.get(listposition).getTitle());
        imageView.setImageResource(dataSet.get(listposition).getImage());
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int currentPosition = getClickedPosition(view);

                if (currentPosition == 0){
                    message(view.getContext());
                } else if (currentPosition == 1){
                    message(view.getContext());
                } else if (currentPosition == 2){
                    message(view.getContext());
                } else if (currentPosition == 3){
                    message(view.getContext());
                }

            }
        });

    }

    private void message(Context context) {
        Toast.makeText(context, "In Syaa Allah kami akan segera hadir", Toast.LENGTH_SHORT).show();
    }

    private void sendTo(Context context, Class kelas){
        Intent i = new Intent(context, kelas);
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    private int getClickedPosition(View clickedView) {
        RecyclerView recyclerView = (RecyclerView) clickedView.getParent();
        MyViewHolder currentViewHolder = (MyViewHolder) recyclerView.getChildViewHolder(clickedView);
        return currentViewHolder.getAdapterPosition();
    }
}
