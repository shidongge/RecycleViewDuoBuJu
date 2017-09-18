package us.mifeng.recycleviewduobuju;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shido on 2017/9/18.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> list;
    private Context context;
    public static final int TYPE_1=1;
    public static final int TYPE_2=2;
    public MyAdapter(Context context,List<String> list){
        this.list=list;
        this.context=context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_1:
                return  new MyViewHorlder1(LayoutInflater.from(context).inflate(R.layout.item1,null));
            case TYPE_2:
                return new MyVeiwHorlder2(LayoutInflater.from(context).inflate(R.layout.item2,null));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHorlder1){
                TYPE1((MyViewHorlder1) holder,position);
        }else if ( holder instanceof MyVeiwHorlder2){
                TYPE2((MyVeiwHorlder2) holder,position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHorlder1 extends RecyclerView.ViewHolder{

        private final ImageView item1_img;
        private final TextView item1_title;
        private final TextView item1_time;
        private final TextView item1_neirong;

        public MyViewHorlder1(View itemView) {
            super(itemView);
            item1_img = (ImageView) itemView.findViewById(R.id.item1_img1);
            item1_title = (TextView) itemView.findViewById(R.id.item1_title);
            item1_time = (TextView) itemView.findViewById(R.id.item1_time);
            item1_neirong = (TextView) itemView.findViewById(R.id.item1_neirong);

        }
    }
    class MyVeiwHorlder2 extends RecyclerView.ViewHolder{

        private final ImageView item2_img;
        private final TextView item2_neirong;
        private final TextView item2_title;
        private final TextView item2_time;

        public MyVeiwHorlder2(View itemView) {
            super(itemView);
            item2_img = (ImageView) itemView.findViewById(R.id.item2_img1);
            item2_neirong = (TextView) itemView.findViewById(R.id.item2_neirong);
            item2_title = (TextView) itemView.findViewById(R.id.item2_title);
            item2_time = (TextView) itemView.findViewById(R.id.item2_time);
        }
    }
    private void TYPE1(MyViewHorlder1 viewHorlder1,int position){
        viewHorlder1.item1_img.setImageResource(R.mipmap.ic_launcher);
        viewHorlder1.item1_neirong.setText(list.get(position));
        viewHorlder1.item1_time.setText(list.get(position));
        viewHorlder1.item1_title.setText(list.get(position));

    }
    private void TYPE2(MyVeiwHorlder2 viewHorlder2,int position){
        viewHorlder2.item2_img.setImageResource(R.mipmap.ic_launcher);
        viewHorlder2.item2_neirong.setText(list.get(position));
        viewHorlder2.item2_time.setText(list.get(position));
        viewHorlder2.item2_title.setText(list.get(position));

    }


    @Override
    public int getItemViewType(int position) {
        if (position%2==0) {
            return TYPE_1;
        }else {
            return TYPE_2;
        }
    }
}
