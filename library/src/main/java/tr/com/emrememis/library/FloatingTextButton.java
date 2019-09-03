package tr.com.emrememis.library;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FloatingTextButton extends LinearLayout implements View.OnClickListener {

    private static String text;
    private static int color,ripple,src;
    private static boolean textClickable,isAnimation;
    private FloatingTextButtonClickListener callback;

    private Animation animation;

    public FloatingTextButton(Context context) { super(context); }

    public FloatingTextButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FloatingTextButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        inflate(getContext(),R.layout.floating_text_button,this);
        FloatingActionButton floatingActionButton = findViewById(R.id.one);
        AppCompatTextView appCompatTextView = findViewById(R.id.two);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.FloatingTextButton);
        try {
            text = typedArray.getString(R.styleable.FloatingTextButton_label);
            color = typedArray.getColor(R.styleable.FloatingTextButton_btnColor,-1299);
            if (color == -1299) {
                color = Color.parseColor("#E91E63");
            }
            ripple = typedArray.getColor(R.styleable.FloatingTextButton_btnRippleColor,-1453);
            if (ripple == -1453) {
                ripple = Color.WHITE;
            }
            src = typedArray.getResourceId(R.styleable.FloatingTextButton_src,-1);
            textClickable = typedArray.getBoolean(R.styleable.FloatingTextButton_textClickable,true);
            isAnimation = typedArray.getBoolean(R.styleable.FloatingTextButton_animation,false);
        }finally {
            typedArray.recycle();
        }
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(color));
        floatingActionButton.setRippleColor(ripple);
        if (src != -1) {
            floatingActionButton.setImageResource(src);
        }
        appCompatTextView.setText(text);

        floatingActionButton.setOnClickListener(this);

        if (textClickable) {
            appCompatTextView.setOnClickListener(this);
        }


        if (isAnimation) {
            animation = AnimationUtils.loadAnimation(getContext(),R.anim.bubble);
            animation.start();
            appCompatTextView.setAnimation(animation);
        }
    }

    public void setCallback(FloatingTextButtonClickListener callback) {
        this.callback = callback;
    }

    @Override
    public void onClick(View view) {
        if (callback != null) {
            callback.clicked();
        }
    }

    public interface FloatingTextButtonClickListener {
        void clicked();
    }
}
