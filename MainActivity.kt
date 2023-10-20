import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set dark mode as the default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        setContentView(R.layout.activity_main)

        // Add any additional code you need for your app
    }

    // Method to toggle dark and light mode
    private fun toggleDarkLightMode() {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        val newNightMode = when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> AppCompatDelegate.MODE_NIGHT_YES
            Configuration.UI_MODE_NIGHT_YES -> AppCompatDelegate.MODE_NIGHT_NO
            else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }
        AppCompatDelegate.setDefaultNightMode(newNightMode)
        recreate()
    }
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
