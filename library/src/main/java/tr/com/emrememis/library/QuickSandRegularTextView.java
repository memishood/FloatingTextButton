package tr.com.emrememis.library;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class QuickSandRegularTextView extends AppCompatTextView {
    public QuickSandRegularTextView(Context context) {
        super(context);
        init();
    }

    public QuickSandRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public QuickSandRegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/Quicksand-Regular.ttf");
        setTypeface(typeface);
    }
}
