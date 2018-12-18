package com.example.convenientbanner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Yang . 网络图片加载
 */
public class ImageBannerView implements Holder<String> {
	private ImageView imageView;

	@Override
	public View createView(Context context) {
		// 你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
		imageView = new ImageView(context);
//		imageView.setImageResource(R.drawable.banner);
		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		return imageView;
	}

//	@Override
//	public void UpdateUI(Context context, int position, List<BannerEntity> data) {
//		// TODO Auto-generated method stub
//		for (int i = 0; i < data.size(); i++) {
//			ImageLoaderUtils.initUtils().display(data.get(i).getImg(),
//					imageView);
//		}
//	}

	@Override
	public void UpdateUI(Context context, int position, String url) {

		if(url.length()!=0){
            Picasso.get().load(url).into(imageView);
		}
	}
}
