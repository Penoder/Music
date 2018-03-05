package com.penod.mylibrary.refresh.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.penod.mylibrary.refresh.PenoderRefreshLayout;
import com.penod.mylibrary.refresh.api.RefreshFooter;
import com.penod.mylibrary.refresh.api.RefreshKernel;
import com.penod.mylibrary.refresh.api.RefreshLayout;
import com.penod.mylibrary.refresh.constant.RefreshState;
import com.penod.mylibrary.refresh.constant.SpinnerStyle;

/**
 * 刷新底部包装
 * Created by SCWANG on 2017/5/26.
 */

public class RefreshFooterWrapper implements RefreshFooter {

    private static final String TAG_REFRESH_FOOTER_WRAPPER = "TAG_REFRESH_FOOTER_WRAPPER";

    private View mWrapperView;
    private SpinnerStyle mSpinnerStyle;

    public RefreshFooterWrapper(View wrapper) {
        this.mWrapperView = wrapper;
        this.mWrapperView.setTag(TAG_REFRESH_FOOTER_WRAPPER.hashCode(), TAG_REFRESH_FOOTER_WRAPPER);
    }

    public static boolean isTagedFooter(View view) {
        return TAG_REFRESH_FOOTER_WRAPPER.equals(view.getTag(TAG_REFRESH_FOOTER_WRAPPER.hashCode()));
    }

    @NonNull
    public View getView() {
        return mWrapperView;
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
		return 0;
	}

    @Override@Deprecated
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        if (mSpinnerStyle != null) {
            return mSpinnerStyle;
        }
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params instanceof PenoderRefreshLayout.LayoutParams) {
            mSpinnerStyle = ((PenoderRefreshLayout.LayoutParams) params).spinnerStyle;
            if (mSpinnerStyle != null) {
                return mSpinnerStyle;
            }
        }
        if (params != null) {
            if (params.height == 0) {
                return mSpinnerStyle = SpinnerStyle.Scale;
            }
        }
        return mSpinnerStyle = SpinnerStyle.Translate;
    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params instanceof PenoderRefreshLayout.LayoutParams) {
            kernel.requestDrawBackgoundForFooter(((PenoderRefreshLayout.LayoutParams) params).backgroundColor);
        }
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override
    public void onPullingUp(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

    }

    @Override
    public boolean setLoadmoreFinished(boolean finished) {
        return false;
    }
}
