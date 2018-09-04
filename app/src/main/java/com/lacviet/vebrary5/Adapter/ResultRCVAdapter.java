package com.lacviet.vebrary5.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lacviet.vebrary5.Model.MainScreenWithImageModel;
import com.lacviet.vebrary5.Model.ResultItemModel;
import com.lacviet.vebrary5.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ResultRCVAdapter extends RecyclerView.Adapter<ResultRCVAdapter.ViewHolder> {

    private List<ResultItemModel> itemList;
    private Context mContext;
    private ResultRCVAdapter.PostItemListener mItemListener;
    private int id;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvTitle, tvAuthor,tvTotalCount,tvCirculateCount;
        public Button btnAvailableCount;
        public CircleImageView imvAvatar;
        ResultRCVAdapter.PostItemListener mItemListener;

        public ViewHolder(View itemView, ResultRCVAdapter.PostItemListener postItemListener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvTotalCount = itemView.findViewById(R.id.tvTotalCount);
            tvCirculateCount = itemView.findViewById(R.id.tvCirculate);
            btnAvailableCount = itemView.findViewById(R.id.btnAvailableCount);
            imvAvatar = itemView.findViewById(R.id.circleImvAvatar);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ResultItemModel item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getId());

            /*notifyDataSetChanged();*/
        }
    }

    public ResultRCVAdapter(Context context, List<ResultItemModel> posts, ResultRCVAdapter.PostItemListener itemListener) {
        itemList = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public ResultRCVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_rcv_result, parent, false);

        ResultRCVAdapter.ViewHolder viewHolder = new ResultRCVAdapter.ViewHolder(postView, this.mItemListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ResultRCVAdapter.ViewHolder holder, int position) {

        ResultItemModel item = itemList.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvAuthor.setText(item.getAuthor());
        holder.tvTotalCount.setText(String.valueOf(item.getTotal()));
        holder.tvCirculateCount.setText(String.valueOf(item.getCirculate()));
        holder.btnAvailableCount.setText(String.valueOf(item.getAvailable()));
        //
        if(item.getAvailable()==0)
        {
            holder.btnAvailableCount.setBackground(mContext.getResources().getDrawable(R.drawable.shape_circle_red));
        }


       /* //get ID and load image by id
        id = item.getEXHID();
        loadImage(id,holder);*/

        if (item.getImage() != null) {
            //holder.progressBar.setVisibility(View.GONE);
            showImage(item.getImage(), holder);
        } else {
            //holder.progressBar.setVisibility(View.VISIBLE);
            holder.imvAvatar.setImageDrawable(null);
        }
        if(item.getImage()==""){
            //holder.progressBar.setVisibility(View.GONE);
            holder.imvAvatar.setImageDrawable(mContext.getResources().getDrawable(R.drawable.img_no_image));
        }
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void updateAnswers(List<ResultItemModel> items) {
        itemList = items;
        notifyDataSetChanged();
    }


    public void updateMoreAnswers(List<ResultItemModel> items) {
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    private ResultItemModel getItem(int adapterPosition) {
        return itemList.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(String id);
    }

    public List<ResultItemModel> getTestList() {
        return itemList;
    }

    private void showImage(String imageString, ResultRCVAdapter.ViewHolder holder) {
        try {
            Picasso.with(mContext).load(imageString).into(holder.imvAvatar);
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