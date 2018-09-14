package com.lacviet.vebrary5.MagazineOnline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lacviet.vebrary5.Model.MagazineOnlineModel;
import com.lacviet.vebrary5.Model.MainScreenWithImageModel;
import com.lacviet.vebrary5.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MagazineOnlineRCVAdapter extends RecyclerView.Adapter<MagazineOnlineRCVAdapter.ViewHolder> {

    private List<MagazineOnlineModel> ListMagazine;
    private Context mContext;
    private PostItemListener mItemListener;
    private int id;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvName, tvTotal;
        public ImageView imvBook;
        private ProgressBar progressBar;
        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvItemName);
            tvTotal = itemView.findViewById(R.id.tvItemTotal);
            imvBook = itemView.findViewById(R.id.imvItemImage);
            progressBar = itemView.findViewById(R.id.pbItemMagazine);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            MagazineOnlineModel item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getId());

            /*notifyDataSetChanged();*/
        }
    }

    public MagazineOnlineRCVAdapter(Context context, List<MagazineOnlineModel> posts, PostItemListener itemListener) {
        ListMagazine = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public MagazineOnlineRCVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_rcv_magazine, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MagazineOnlineRCVAdapter.ViewHolder holder, int position) {

        MagazineOnlineModel item = ListMagazine.get(position);
        holder.tvName.setText(item.getTitle());
        holder.tvTotal.setText(item.getTotal() + " số");


       /* //get ID and load image by id
        id = item.getEXHID();
        loadImage(id,holder);*/

        if (item.getImage() != null) {
            holder.progressBar.setVisibility(View.GONE);
            showImage(item.getImage(), holder);
        } else {
            holder.progressBar.setVisibility(View.VISIBLE);
            holder.imvBook.setImageDrawable(null);
        }
        if(item.getImage()==""){
            holder.progressBar.setVisibility(View.GONE);
            holder.imvBook.setImageDrawable(mContext.getResources().getDrawable(R.drawable.img_no_image));
        }
    }


    @Override
    public int getItemCount() {
        return ListMagazine.size();
    }

    public void updateAnswers(List<MagazineOnlineModel> items) {
        ListMagazine = items;
        notifyDataSetChanged();
    }


    public void updateMoreAnswers(List<MagazineOnlineModel> items) {
        ListMagazine.addAll(items);
        notifyDataSetChanged();
    }

    private MagazineOnlineModel getItem(int adapterPosition) {
        return ListMagazine.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(String id);
    }

    public List<MagazineOnlineModel> getTestList() {
        return ListMagazine;
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


}