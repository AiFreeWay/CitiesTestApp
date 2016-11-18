package aifree.com.citiestestapp.presentation.adapters;

import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.MultiTypeExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import aifree.com.citiestestapp.presentation.adapters.holders.BaseHolder;
import aifree.com.citiestestapp.presentation.adapters.holders.BaseGroupHolder;


public class MultiExpannadleRvAdapter<MG extends ExpandableGroup, MC, VC> extends MultiTypeExpandableRecyclerViewAdapter<BaseGroupHolder<MG, VC>, BaseHolder<MC, VC>> {

    private BaseGroupHolder<MG, VC> mBaseGroupHolderTemplate;
    private BaseHolder<MC, VC> mBaseHolderTemplate;

    public MultiExpannadleRvAdapter(BaseGroupHolder<MG, VC> groupHolderTemplate, BaseHolder<MC, VC> childHolderTemplate, List<MG> data) {
        super(data);
        mBaseGroupHolderTemplate = groupHolderTemplate;
        mBaseHolderTemplate = childHolderTemplate;
    }

    @Override
    public BaseGroupHolder<MG, VC> onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        return mBaseGroupHolderTemplate.create(parent);
    }

    @Override
    public BaseHolder<MC, VC> onCreateChildViewHolder(ViewGroup parent, int viewType) {
        return mBaseHolderTemplate.create(parent);
    }

    @Override
    public void onBindChildViewHolder(BaseHolder<MC, VC> holder, int flatPosition, ExpandableGroup group, int childIndex) {
        MC childModel = (MC) group.getItems().get(childIndex);
        holder.bind(childModel);
    }

    @Override
    public void onBindGroupViewHolder(BaseGroupHolder<MG, VC> holder, int flatPosition, ExpandableGroup group) {
        holder.bind((MG) group);
    }
}
