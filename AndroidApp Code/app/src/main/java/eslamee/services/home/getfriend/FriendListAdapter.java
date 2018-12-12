package eslamee.services.home.getfriend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import eslamee.R;
import eslamee.models.FriendListModel;

/**
 * Created by Manjeet Singh on 7/27/2018.
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.AlphalistBindViewHolder>{
    List<FriendListModel> list;
    Context context;
    public FriendListAdapter(List<FriendListModel> res,Context c1) { // 1
        list = res;
        context = c1;
    }

    @Override
    public AlphalistBindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { // 3
        View view = LayoutInflater.from(context)
                .inflate(R.layout.alpharet,parent,false);
        return new AlphalistBindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlphalistBindViewHolder holder, int position) {  // 5
        Picasso picasso = Picasso.with(context);
        if(list.get(position)!=null) {
          picasso.load(list.get(position).getPic())
                .centerInside()
              .fit()
            .into(holder.image);
         }
        if(list.get(position).getName()!=null) {
            holder.name.setText("" + list.get(position).getName());

        }
        if(list.get(position).getContact()!=null) { // correct here.
            holder.contact.setText(""+ list.get(position).getContact());
        }
        if(list.get(position).getHobbies()!=null) {
            holder.hobby.setText("" + list.get(position).getHobbies());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    } // 2

    public class AlphalistBindViewHolder extends RecyclerView.ViewHolder{ // 4
        ImageView image;
        TextView name;
        TextView hobby;
        TextView contact;
        Button more;
        public AlphalistBindViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.pro_img);
            image.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    Bundle bundle = new Bundle(); // to send ID aage.
                    bundle.putString("ID",list.get(getAdapterPosition()).get_id());

                    Intent intent = new Intent(context,FullFriendInfo.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    intent.putExtras(bundle);
                    context.startActivity(intent);


                    //  String url = list.get(getAdapterPosition()).get_url();
                    // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    // startActivity(browserIntent);




                }
            });
            name = (TextView) itemView.findViewById(R.id.name);
            name.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle(); // to send ID aage.
                    bundle.putString("ID",list.get(getAdapterPosition()).get_id());

                    Intent intent = new Intent(context,FullFriendInfo.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                    //  String url = list.get(getAdapterPosition()).get_url();
                    // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    // startActivity(browserIntent);



                }
            });
            hobby = (TextView) itemView.findViewById(R.id.hobbies);
            hobby.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle(); // to send ID aage.
                    bundle.putString("ID",list.get(getAdapterPosition()).get_id());
                    Intent intent = new Intent(context,FullFriendInfo.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                    //  String url = list.get(getAdapterPosition()).get_url();
                    // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    // startActivity(browserIntent);



                }
            });
            contact = (TextView) itemView.findViewById(R.id.phone);
            contact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    Bundle bundle = new Bundle(); // to send ID aage.
                    bundle.putString("ID",list.get(getAdapterPosition()).get_id());

                    Intent intent = new Intent(context,FullFriendInfo.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                    //  String url = list.get(getAdapterPosition()).get_url();
                    // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    // startActivity(browserIntent);



                }
            });

        }
    }
}
