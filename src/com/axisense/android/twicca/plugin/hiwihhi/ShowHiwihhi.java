package com.axisense.android.twicca.plugin.hiwihhi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ShowHiwihhi extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent receiveIntent = getIntent();
		
		if("jp.r246.twicca.ACTION_SHOW_USER".equals(receiveIntent.getAction())) {
			// ユーザ表示
			String screenName = receiveIntent.getStringExtra(Intent.EXTRA_TEXT);
			Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format(getString(R.string.hiwihhi_user_url), screenName)));
			startActivity(sendIntent);
			finish();
		} else if("jp.r246.twicca.ACTION_SHOW_TWEET".equals(receiveIntent.getAction())) {
			// ツイート表示
			String screenName = receiveIntent.getStringExtra("user_screen_name");
			String tweetId = receiveIntent.getStringExtra("id");
			Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format(getString(R.string.hiwihhi_tweet_url), screenName, tweetId)));
			startActivity(sendIntent);
			finish();
		}
	}
}
