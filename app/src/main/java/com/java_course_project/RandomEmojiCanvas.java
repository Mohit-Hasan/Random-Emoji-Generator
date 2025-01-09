package com.java_course_project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class RandomEmojiCanvas extends View {

    private static int score = -2;
    private Random random;
    private Paint paint;
    private Thread emojiThread;
    private boolean isRunning;
    private int width, height;
    private static WeakReference<TextView> scoreTextViewRef;

    private String[] emojis = {
            "😀", "😁", "😂", "🤣", "😃", "😄", "😅", "😆", "😇", "🥰", "😍", "😎", "😜",
            "🤪", "😝", "😏", "😌", "😎", "😈", "👻", "💀", "🤖", "👾", "🐱", "🐶", "📡",
            "🦄", "🐝", "🦋", "🌸", "🌞", "🇧🇩 ", "🌍", "🌑", "🌟", "⚡", "🫡", "📺", "✌️",
            "🎓", "🦑", "🦖", "🦭", "🐠", "🐅", "💐", "🖥️", "💻", "⌚️"
    };

    public RandomEmojiCanvas(Context context) {
        super(context);
        init();
    }

    public RandomEmojiCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RandomEmojiCanvas(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        random = new Random();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);

        isRunning = false;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String randomEmoji = emojis[random.nextInt(emojis.length)];

        float randomSize = 90 + random.nextInt(150);
        paint.setTextSize(randomSize);

        float x = random.nextFloat() * width;
        float y = random.nextFloat() * height;

        canvas.drawText(randomEmoji, x, y, paint);

        score++;

        if (scoreTextViewRef != null && scoreTextViewRef.get() != null) {
            scoreTextViewRef.get().post(new Runnable() {
                @Override
                public void run() {
                    scoreTextViewRef.get().setText("Score: " + score);
                }
            });
        }
    }

    public void startRandomEmojis() {
        if (!isRunning) {
            isRunning = true;
            emojiThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isRunning) {
                        postInvalidate();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            emojiThread.start();
        }
    }

    public void stopRandomEmojis() {
        isRunning = false;
        if (emojiThread != null) {
            emojiThread.interrupt();
        }
    }

    public static int getScore() {
        return score;
    }

    public static void setScoreTextView(TextView scoreTextView) {
        scoreTextViewRef = new WeakReference<>(scoreTextView);
    }
}
