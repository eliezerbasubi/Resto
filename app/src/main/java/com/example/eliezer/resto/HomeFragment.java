package com.example.eliezer.resto;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v7.widget.RecyclerView ;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button order;
    private RecyclerView recycler;
    private View mView;
    private DatabaseReference mdatabase;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        mdatabase = FirebaseDatabase.getInstance().getReference().child("Food");
        mdatabase.keepSynced(true);

        recycler = mView.findViewById(R.id.home_recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return mView;
    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model,FoodViewHolder> adapter = new FirebaseRecyclerAdapter <Model, FoodViewHolder>(
                Model.class,
                R.layout.layout_modal,
                FoodViewHolder.class,
                mdatabase

        ) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, Model model, int position) {
                    viewHolder.setName(model.name,model.price);
                    viewHolder.setImage(getContext(),model.image);
            }
        };
        recycler.setAdapter(adapter);
    }

    private static class FoodViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView foodImage;
        public FoodViewHolder(View itemView) {
            super(itemView);

            view = itemView;
        }

        public void setName(String name,String price){
            TextView txt = view.findViewById(R.id.item_name);
            txt.setText(name);

            TextView txtDesc = view.findViewById(R.id.item_price);
            txtDesc.setText(price);
        }

        public void setImage(Context context, String url){
            foodImage = view.findViewById(R.id.item_img);
            Glide
                    .with(context)
                    .load(url).apply(new RequestOptions()
                    .placeholder(R.drawable.resto_logo)
                    .dontAnimate()
                    .dontTransform())
                    .into(foodImage);
        }
    }
}
