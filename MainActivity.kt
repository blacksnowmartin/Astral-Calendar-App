import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar

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
