创建闪屏页布局

	activity_splash.xml

	<?xml version="1.0" encoding="utf-8"?>
	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
	              android:orientation="vertical"
	              android:layout_width="match_parent"
	              android:layout_height="match_parent"
	    android:background="@color/bg_splash">

	    <ImageView
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:src="@mipmap/ic_funchat"
	        android:layout_centerInParent="true"/>

	</RelativeLayout>

	全屏样式
	style.xml

	<resources>

	    <!-- Base application theme. -->
	    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
	        <!-- Customize your theme here. -->
	        <item name="colorPrimary">@color/colorPrimary</item>
	        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
	        <item name="colorAccent">@color/colorAccent</item>
	    </style>

	    <style name="AppTheme.FullScreen" parent="AppTheme">
	        <item name="android:windowFullscreen">true</item>
	    </style>

	</resources>

	<activity
        android:name=".SplashActivity"
		#全屏样式
        android:theme="@style/AppTheme.FullScreen">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />

            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>

