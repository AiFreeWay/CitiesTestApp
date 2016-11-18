package aifree.com.citiestestapp.presentation.adapters.holders;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public abstract class BaseHolder<M, VC>  extends ChildViewHolder {

    protected VC mViewController;
    protected View mView;
    protected Context mContext;

    public BaseHolder(@NonNull  Context context, VC viewController) {
        super(new View(context));
        mViewController = viewController;
        mContext = context;
    }

    public BaseHolder(@NonNull View itemView, VC viewController) {
        super(itemView);
        mViewController = viewController;
        mView = itemView;
        mContext = itemView.getContext();
    }

    protected View viewInflater(ViewGroup viewGroup, int resLayout) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return layoutInflater.inflate(resLayout, viewGroup, false);
    }

    public abstract BaseHolder<M, VC> create(ViewGroup viewGroup);

    public abstract void bind(M dataModel);
}

