package com.example.retrofit.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.db.entity.Comment;
import com.example.retrofit.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.DataViewHolder> {

    ArrayList<Comment> dataModelList = new ArrayList<>();
    Context context;

    public CommentAdapter(Context context) {
        this.context = context;
    }


    @Override
    public CommentAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_comment, parent, false);
        CommentAdapter.DataViewHolder holder = new CommentAdapter.DataViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommentAdapter.DataViewHolder holder, int position) {

        holder.getTxtPostId().setText("" + dataModelList.get(position).getPostId());
        holder.getTxtId().setText("" + dataModelList.get(position).getId());
        holder.getTxtName().setText(dataModelList.get(position).getName());
        holder.getTxtEmail().setText(dataModelList.get(position).getEmail());
        holder.getTxtBody().setText(dataModelList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return dataModelList.size() > 0 ? dataModelList.size() : 0;
    }

    public void setDataToAdapter(ArrayList<Comment> dataModelList) {
        this.dataModelList = dataModelList;
        notifyDataSetChanged();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView txtPostId, txtId, txtName, txtEmail, txtBody;
//        private ImageView imgProfile;

        public DataViewHolder(View itemView) {
            super(itemView);
        }

        public TextView getTxtPostId() {
            if (txtPostId == null) {
                txtPostId = itemView.findViewById(R.id.txtPostId);
            }
            return txtPostId;
        }

        public TextView getTxtId() {
            if (txtId == null) {
                txtId = itemView.findViewById(R.id.txtId);
            }
            return txtId;
        }

        public TextView getTxtName() {
            if (txtName == null) {
                txtName = itemView.findViewById(R.id.txtName);
            }
            return txtName;
        }

        public TextView getTxtEmail() {
            if (txtEmail == null) {
                txtEmail = itemView.findViewById(R.id.txtEmail);
            }
            return txtEmail;
        }

        public TextView getTxtBody() {
            if (txtBody == null) {
                txtBody = itemView.findViewById(R.id.txtBody);
            }
            return txtBody;
        }
    }
}
