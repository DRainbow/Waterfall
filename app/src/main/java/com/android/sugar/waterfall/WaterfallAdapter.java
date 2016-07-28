package com.android.sugar.waterfall;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @ClassName: WaterfallAdapter
 * @Description:
 * @author: SugarT
 * @date: 16/7/26 下午11:10
 */
public class WaterfallAdapter extends RecyclerView.Adapter<WaterfallAdapter.WaterfallVH> {

    private Context mContext;
    /**
     * 展示的图片源
     */
    private List<String> mImageArr;

    /**
     * item点击事件
     */
    private OnItemClickListener mOnItemClickListener;

    public WaterfallAdapter(Context context, List<String> imageArr) {
        mContext = context;
        mImageArr = imageArr;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public WaterfallVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_waterfall, parent, false);
        WaterfallVH holder = new WaterfallVH(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final WaterfallVH holder, int position) {
//        Glide.with(mContext).load(mImageArr.get(position)).into(holder.mContentIv);

        /* 网络图片 */
//        Glide.with(mContext).load(mImageArr.get(position)).into(new SimpleTarget<GlideDrawable>() {
//            @Override
//            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                ViewGroup.LayoutParams lp = holder.mContentIv.getLayoutParams();
//
//                WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
//                DisplayMetrics outMetrics = new DisplayMetrics();
//                wm.getDefaultDisplay().getMetrics(outMetrics);
//                lp.width = outMetrics.widthPixels / 3;
//                lp.height = resource.getIntrinsicHeight() * outMetrics.widthPixels / 3 / resource.getIntrinsicWidth();
//
//                holder.mContentIv.setLayoutParams(lp);
//
//                holder.mContentIv.setImageDrawable(resource);
//            }
//        });

        /* 本地图片 */
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mImageArr.get(position), opts);

        ViewGroup.LayoutParams lp = holder.mContentIv.getLayoutParams();
        lp.width = outMetrics.widthPixels / 3;
        lp.height = opts.outHeight * outMetrics.widthPixels / 3 / opts.outWidth;
        holder.mContentIv.setLayoutParams(lp);

        Glide.with(mContext).load(mImageArr.get(position)).into(holder.mContentIv);

        /* 添加item点击事件 */
        holder.mContentIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageArr.size();
    }

    public class WaterfallVH extends RecyclerView.ViewHolder {

        private ImageView mContentIv;

        public WaterfallVH(View itemView) {
            super(itemView);
            mContentIv = (ImageView) itemView.findViewById(R.id.iv_waterfall_content);
        }
    }

    public interface OnItemClickListener {
        void onItemClick();
    }
}
