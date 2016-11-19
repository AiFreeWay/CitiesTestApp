package aifree.com.citiestestapp.presentation.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import aifree.com.citiestestapp.presentation.adapters.holders.BaseHolder;

public class MultiRvAdapter<M, VC> extends RecyclerView.Adapter<BaseHolder<M, VC>> {

    private List<M> mData;
    private BaseHolder<M, VC> mBaseHolderTemplate;

    public MultiRvAdapter(BaseHolder<M, VC> baseHolderTemplate) {
        mData = Collections.emptyList();
        mBaseHolderTemplate = baseHolderTemplate;
    }

    @Override
    public BaseHolder<M, VC> onCreateViewHolder(ViewGroup parent, int viewType) {
        return mBaseHolderTemplate.create(parent);
    }

    @Override
    public void onBindViewHolder(BaseHolder<M, VC> holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void loadData(List<M> data) {
        if (data != null) {
            mData = data;
            notifyDataSetChanged();
        }
    }

    public List<M> getData() {
        return mData;
    }

    private M getItem(int position) {
        return mData.get(position);
    }
}
