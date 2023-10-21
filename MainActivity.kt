import android.content.res.Configuration
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set dark mode as the default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        setContentView(R.layout.activity_main)

        // Calculate and display the Gregorian date and astral date
        calculateAndDisplayDates()

        // Add animation for the app logo
        val appLogo = findViewById<ImageView>(R.id.appLogo)
        val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_animation)
        appLogo.startAnimation(fadeAnimation)
    }

    private fun calculateAndDisplayDates() {
        // Get the current Gregorian date
        val currentDate = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val formattedDate = dateFormat.format(currentDate.time)

        // Display the Gregorian date in your TextView
        val gregorianDateTextView = findViewById<TextView>(R.id.gregorianDate)
        gregorianDateTextView.text = formattedDate

        // Calculate the superscript number
        val superscriptNumber = calculateSuperscript(formattedDate)

        // Display the superscript number in your TextView
        val superscriptNumberTextView = findViewById<TextView>(R.id.superscriptNumber)
        superscriptNumberTextView.text = superscriptNumber.toString()
    }

    // Function to calculate the superscript number
    private fun calculateSuperscript(date: String): Int {
        var sum = 0
        date.forEach {
            if (it.isDigit()) {
                sum += it.toString().toInt()
            }
        }
        while (sum > 9) {
            sum = sum.toString().map { it.toString().toInt() }.sum()
        }
        return sum
    }
}
