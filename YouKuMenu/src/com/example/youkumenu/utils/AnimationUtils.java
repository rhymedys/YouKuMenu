package com.example.youkumenu.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimationUtils {

	public static int runningAnimationCount = 0;

	/**
	 * 旋转出去的动画
	 */
	public static void rotateOutAnim(RelativeLayout relativeLayout, Long deplaytime) {
		// 屏蔽控件内的所有功能
		int childCount = relativeLayout.getChildCount();
		for (int i = 0; i < childCount; i++) {
			View childAt = relativeLayout.getChildAt(i);
			childAt.setEnabled(false);
		}

		// 指定旋转中心
		RotateAnimation rotateAnimation = new RotateAnimation(0f, -180f, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 1.0f);
		rotateAnimation.setDuration(500);
		rotateAnimation.setFillAfter(true); // 设置动画停留在结束位置
		rotateAnimation.setStartOffset(deplaytime);

		rotateAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

				// TODO 自动生成的方法存根
				runningAnimationCount++;
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO 自动生成的方法存根
				runningAnimationCount--;
			}
		});

		relativeLayout.startAnimation(rotateAnimation);
	}

	public static void rotateInAnim(RelativeLayout relativeLayout, Long deplaytime) {
		// TODO 自动生成的方法存根

		int childCount = relativeLayout.getChildCount();
		for (int i = 0; i < childCount; i++) {
			View childAt = relativeLayout.getChildAt(i);
			childAt.setEnabled(true);
		}

		RotateAnimation rotateAnimation = new RotateAnimation(-180f, 0f, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 1.0f);
		rotateAnimation.setDuration(500);
		rotateAnimation.setFillAfter(true); // 设置动画停留在结束位置
		rotateAnimation.setStartOffset(deplaytime);
		rotateAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO 自动生成的方法存根
				runningAnimationCount++;
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO 自动生成的方法存根
				runningAnimationCount--;
			}
		});

		relativeLayout.startAnimation(rotateAnimation);

	}

}
