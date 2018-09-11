package com.lacviet.vebrary5.Adapter;

import android.content.Context;
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
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewBookRCVAdapter extends RecyclerView.Adapter<NewBookRCVAdapter.ViewHolder> {

    private List<MainScreenWithImageModel> ExhibitList;
    private Context mContext;
    private NewBookRCVAdapter.PostItemListener mItemListener;
    private int id;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imvBook;
        private ProgressBar progressBar;
        NewBookRCVAdapter.PostItemListener mItemListener;

        public ViewHolder(View itemView, NewBookRCVAdapter.PostItemListener postItemListener) {
            super(itemView);
            imvBook = itemView.findViewById(R.id.imvItemImage);
            progressBar = itemView.findViewById(R.id.pbItemImage);

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

    public NewBookRCVAdapter(Context context, List<MainScreenWithImageModel> posts, NewBookRCVAdapter.PostItemListener itemListener) {
        ExhibitList = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public NewBookRCVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_rcv_new_book, parent, false);

        NewBookRCVAdapter.ViewHolder viewHolder = new NewBookRCVAdapter.ViewHolder(postView, this.mItemListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewBookRCVAdapter.ViewHolder holder, int position) {

        MainScreenWithImageModel item = ExhibitList.get(position);
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

    private void showImage(String imageString, NewBookRCVAdapter.ViewHolder holder) {
        try {
            Picasso.with(mContext).load(imageString).into(holder.imvBook);
            /*Bitmap bmp = Util.StringToBitMap(imageString);
            holder.imvBook.setImageBitmap(bmp);*/
        } catch (Exception ex) {
            ex.getMessage();
        }
    }



}