package com.example.youkumenu;

import com.example.youkumenu.utils.AnimationUtils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private Context context;
	private ImageButton ib_home;
	private ImageButton ib_menu;
	private RelativeLayout rl_level1;
	private RelativeLayout rl_level2;
	private RelativeLayout rl_level3;
	boolean isLevel3display = true;
	boolean isLevel2display = true;
	boolean isLevel1display = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.context = this;

		initUI();
	}

	private void initUI() {
		ib_home = (ImageButton) findViewById(R.id.ib_home);
		ib_menu = (ImageButton) findViewById(R.id.ib_menu);
		rl_level1 = (RelativeLayout) findViewById(R.id.rl_level1);
		rl_level2 = (RelativeLayout) findViewById(R.id.rl_level2);
		rl_level3 = (RelativeLayout) findViewById(R.id.rl_level3);

		ib_home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if (AnimationUtils.runningAnimationCount > 0) {
					return;
				}
				if (isLevel2display) {
					long delay = 0;
					if (isLevel3display) {
						AnimationUtils.rotateOutAnim(rl_level3, delay);
						delay += 200;
						isLevel3display = !isLevel3display;
					}
					AnimationUtils.rotateOutAnim(rl_level2, delay);

				} else {
					AnimationUtils.rotateInAnim(rl_level2, (long) 0);
				}
				isLevel2display = !isLevel2display;
			}
		});
		ib_menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if (AnimationUtils.runningAnimationCount > 0) {
					return;
				}
				if (isLevel3display) {
					AnimationUtils.rotateOutAnim(rl_level3, (long) 0);

				} else {
					AnimationUtils.rotateInAnim(rl_level3, (long) 0);
				}
				isLevel3display = !isLevel3display;
			}
		});

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 自动生成的方法存根

		if (keyCode == KeyEvent.KEYCODE_MENU) {
			
			//防止还没执行完 ，就第二次执行  速度过快
			if (AnimationUtils.runningAnimationCount > 0) {
				return true;
			}
			
			
			long deplaytime = 0;
			if (isLevel1display) {
				if (isLevel2display) {
					if (isLevel3display) {
						deplaytime += 200;
						AnimationUtils.rotateOutAnim(rl_level3, (long) 0);
					}
					AnimationUtils.rotateOutAnim(rl_level2, deplaytime);
					deplaytime += 200;
				}

				AnimationUtils.rotateOutAnim(rl_level1, deplaytime);
			} else {
				AnimationUtils.rotateInAnim(rl_level1, (long) 0);
				AnimationUtils.rotateInAnim(rl_level2, (long) 200);
				AnimationUtils.rotateInAnim(rl_level3, (long) 400);
			}

			isLevel2display = !isLevel2display;
			isLevel3display = !isLevel3display;
			isLevel1display = !isLevel1display;
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
