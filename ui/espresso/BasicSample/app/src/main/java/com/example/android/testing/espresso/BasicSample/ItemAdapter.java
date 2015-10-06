package com.example.android.testing.espresso.BasicSample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * ItemAdapter
 *
 * @author <a href="mailto:info@movilok.com">Movilok Interactividad Movil S.L.</a>
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

  private String[] items;

  public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public ViewHolder(View itemView) {
      super(itemView);
      textView = (TextView) itemView.findViewById(android.R.id.text1);
    }
  }

  public ItemAdapter(Context context) {
    items = context.getResources().getStringArray(R.array.fake_values);
  }

  @Override public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);
    View contactView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
    ViewHolder viewHolder = new ViewHolder(contactView);
    return viewHolder;
  }

  @Override public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
    holder.textView.setText(items[position]);
  }

  @Override public int getItemCount() {
    return items.length;
  }
}
