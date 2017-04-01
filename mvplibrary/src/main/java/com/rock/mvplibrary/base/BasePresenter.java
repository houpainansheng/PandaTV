package com.rock.mvplibrary.base;

/**
 * Created by Rock on 2017/3/24.
 */

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {

    public M mModel;

    public V mView;

    public BasePresenter() {
    }

    public void setVM(V mView, M mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }
}
