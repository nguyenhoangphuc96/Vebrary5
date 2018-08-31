package com.lacviet.vebrary5.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lacviet.vebrary5.Model.MainScreenWithImageModel;
import com.lacviet.vebrary5.R;
import com.lacviet.vebrary5.Util;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MainscreenRecyclerViewAdapter extends RecyclerView.Adapter<MainscreenRecyclerViewAdapter.ViewHolder> {

    private List<MainScreenWithImageModel> ExhibitList;
    private Context mContext;
    private PostItemListener mItemListener;
    private int id;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvName, tvAuthor;
        public ImageView imvBook;
        private ProgressBar progressBar;
        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvItemName);
            tvAuthor = itemView.findViewById(R.id.tvItemAuthor);
            imvBook = itemView.findViewById(R.id.imvItemImage);
            progressBar = itemView.findViewById(R.id.pbItemMainScreen);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            MainScreenWithImageModel item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.geteXHID());

            /*notifyDataSetChanged();*/
        }
    }

    public MainscreenRecyclerViewAdapter(Context context, List<MainScreenWithImageModel> posts, PostItemListener itemListener) {
        ExhibitList = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public MainscreenRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_recyclerview_mainscreen, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainscreenRecyclerViewAdapter.ViewHolder holder, int position) {

        MainScreenWithImageModel item = ExhibitList.get(position);
        holder.tvName.setText(item.geteXHIBITNAME());
        holder.tvAuthor.setText(item.getdESCRIPTION());


       /* //get ID and load image by id
        id = item.getEXHID();
        loadImage(id,holder);*/

        if (item.geteIMAGE() != null) {
            holder.progressBar.setVisibility(View.GONE);
            showImage(item.geteIMAGE(), holder);
        } else {
            holder.progressBar.setVisibility(View.VISIBLE);
            holder.imvBook.setImageDrawable(null);
        }
        if(item.geteIMAGE()==""){
            holder.progressBar.setVisibility(View.GONE);
            holder.imvBook.setImageDrawable(mContext.getResources().getDrawable(R.drawable.img_no_image));
        }
    }


    @Override
    public int getItemCount() {
        return ExhibitList.size();
    }

    public void updateAnswers(List<MainScreenWithImageModel> items) {
        ExhibitList = items;
        notifyDataSetChanged();
    }


    public void updateMoreAnswers(List<MainScreenWithImageModel> items) {
        ExhibitList.addAll(items);
        notifyDataSetChanged();
    }

    private MainScreenWithImageModel getItem(int adapterPosition) {
        return ExhibitList.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }

    public List<MainScreenWithImageModel> getTestList() {
        return ExhibitList;
    }

    private void showImage(String imageString, ViewHolder holder) {
        try {
            Picasso.with(mContext).load(imageString).into(holder.imvBook);
            /*Bitmap bmp = Util.StringToBitMap(imageString);
            holder.imvBook.setImageBitmap(bmp);*/
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void showErrorMessage() {
        Toast.makeText(mContext, "Error loading posts", Toast.LENGTH_SHORT).show();
    }

}