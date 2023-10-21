import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set dark mode as the default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        setContentView(R.layout.activity_main)

        // Add animation for the app logo
        val appLogo = findViewById<ImageView>(R.id.appLogo)
        val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_animation)
        appLogo.startAnimation(fadeAnimation)

        // Add any additional code for your app
    }
}
