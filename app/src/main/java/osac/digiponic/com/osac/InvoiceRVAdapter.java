package osac.digiponic.com.osac;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import osac.digiponic.com.osac.Model.DataItemMenu;

public class InvoiceRVAdapter extends RecyclerView.Adapter<InvoiceRVAdapter.ViewHolder> {

    private List<DataItemMenu> mDataItem;
    private Context mContext;
    MenuRVAdapter.ItemClickListener mClickListener;

    public InvoiceRVAdapter(Context mContext, List<DataItemMenu> mDataItem) {
        this.mDataItem = mDataItem;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.invoice_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DataItemMenu data = mDataItem.get(i);
        viewHolder._itemName.setText(data.get_itemName());
        viewHolder._itemPrice.setText(data.get_itemPrice());
    }

    @Override
    public int getItemCount() {
        return mDataItem.size();
    }

    String getItem(int id) {
        return String.valueOf(mDataItem.get(id).get_itemName());
    }

    public void removeAt(int position) {
        mDataItem.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mDataItem.size());
    }

    void setClickListener(MenuRVAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView mCardView;
        public TextView _itemName, _itemPrice;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);

            mCardView = v.findViewById(R.id.cardView_itemInvoice);
            _itemName = v.findViewById(R.id.text_itemName_Invoice);
            _itemPrice = v.findViewById(R.id.text_itemPrice_Invoice);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}
