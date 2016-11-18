package aifree.com.citiestestapp.presentation.adapters;

import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.MultiTypeExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import aifree.com.citiestestapp.presentation.adapters.holders.BaseChildHolder;
import aifree.com.citiestestapp.presentation.adapters.holders.BaseGroupHolder;


public class MultiExpannadleRvAdapter<MG extends ExpandableGroup, MC, VC> extends MultiTypeExpandableRecyclerViewAdapter<BaseGroupHolder<MG, VC>, BaseChildHolder<MC, VC>> {

    private BaseGroupHolder<MG, VC> mBaseGroupHolderTemplate;
    private BaseChildHolder<MC, VC> mBaseChildHolderTemplate;

    public MultiExpannadleRvAdapter(BaseGroupHolder<MG, VC> groupHolderTemplate, BaseChildHolder<MC, VC> childHolderTemplate, List<MG> data) {
        super(data);
        mBaseGroupHolderTemplate = groupHolderTemplate;
        mBaseChildHolderTemplate = childHolderTemplate;
    }

    @Override
    public BaseGroupHolder<MG, VC> onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        return mBaseGroupHolderTemplate.create(parent);
    }

    @Override
    public BaseChildHolder<MC, VC> onCreateChildViewHolder(ViewGroup parent, int viewType) {
        return mBaseChildHolderTemplate.create(parent);
    }

    @Override
    public void onBindChildViewHolder(BaseChildHolder<MC, VC> holder, int flatPosition, ExpandableGroup group, int childIndex) {
        MC childModel = (MC) group.getItems().get(childIndex);
        mBaseChildHolderTemplate.bind(childModel);
    }

    @Override
    public void onBindGroupViewHolder(BaseGroupHolder<MG, VC> holder, int flatPosition, ExpandableGroup group) {
        mBaseGroupHolderTemplate.bind((MG) group);
    }

    @Override
    public boolean isGroup(int viewType) {
        return super.isGroup(viewType);
    }

    @Override
    public boolean isChild(int viewType) {
        return super.isChild(viewType);
    }
}
