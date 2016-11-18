package aifree.com.citiestestapp.presentation.adapters.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;


public abstract class BaseGroupHolder<M, VC> extends GroupViewHolder {

    private VC mViewController;
    private View mView;
    private Context mContext;

    public BaseGroupHolder(@NonNull Context context, VC viewController) {
        super(new View(context));
        mViewController = viewController;
        mContext = context;
    }

    private BaseGroupHolder(@NonNull View itemView, VC viewController) {
        super(itemView);
        mViewController = viewController;
        mView = itemView;
        mContext = itemView.getContext();
    }

    private View viewInflater(ViewGroup viewGroup, int resLayout) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return layoutInflater.inflate(resLayout, viewGroup, false);
    }

    public abstract BaseGroupHolder<M, VC> create(ViewGroup viewGroup);

    public abstract void bind(M dataModel);
}