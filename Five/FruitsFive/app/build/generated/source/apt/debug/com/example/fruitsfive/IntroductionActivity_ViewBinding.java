// Generated code from Butter Knife. Do not modify!
package com.example.fruitsfive;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IntroductionActivity_ViewBinding implements Unbinder {
  private IntroductionActivity target;

  private View view2131427422;

  @UiThread
  public IntroductionActivity_ViewBinding(IntroductionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public IntroductionActivity_ViewBinding(final IntroductionActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.jump, "field 'jump' and method 'jump'");
    target.jump = Utils.castView(view, R.id.jump, "field 'jump'", Button.class);
    view2131427422 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.jump();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    IntroductionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.jump = null;

    view2131427422.setOnClickListener(null);
    view2131427422 = null;
  }
}
