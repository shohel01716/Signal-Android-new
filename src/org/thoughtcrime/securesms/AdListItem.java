package org.thoughtcrime.securesms;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

import org.thoughtcrime.securesms.database.model.ThreadRecord;
import org.thoughtcrime.securesms.mms.GlideRequests;
import org.thoughtcrime.securesms.util.ViewUtil;

import java.util.Locale;
import java.util.Set;

public class AdListItem extends LinearLayout implements BindableConversationListItem {

  private LinearLayout adLL;
  private Context context;
  private AdView adView;

  public AdListItem(Context context) {
    super(context);
    this.context =context;
  }

  public AdListItem(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.context =context;
  }

  @TargetApi(Build.VERSION_CODES.HONEYCOMB)
  public AdListItem(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.context = context;
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();
    this.adLL = ViewUtil.findById(this, R.id.adLL);
    //your ad id
    adView = new AdView(context, "345447992986192_354527978744860", AdSize.BANNER_HEIGHT_50);
  }

  @Override
  public void bind(@NonNull ThreadRecord thread,
                   @NonNull GlideRequests glideRequests,
                   @NonNull Locale locale,
                   @NonNull Set<Long> typingThreads,
                   @NonNull Set<Long> selectedThreads,
                   boolean batchMode)
  {
    this.adLL.removeAllViews();
    this.adLL.addView(adView);
    this.adView.loadAd();
  }

  @Override
  public void unbind() {

  }
}
