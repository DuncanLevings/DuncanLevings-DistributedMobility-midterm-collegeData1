package sheridan.levings.collegeData1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import sheridan.levings.collegeData1.OutputActivity.Companion.STUDENT_INFO
import sheridan.levings.collegeData1.databinding.ActivityInputBinding
import sheridan.levings.collegeData1.model.StudentInfo

class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener{showOutput()}
    }

    private fun showOutput() {
        val studentName = binding.txtStudent.text.toString().trim()
        if (studentName.isEmpty()) {
            val required = getString(R.string.required)
            binding.txtStudent.error = required
            Toast.makeText(this, required, Toast.LENGTH_LONG).show()
        } else {
            val programType =
                when (binding.radioGroup.checkedRadioButtonId) {
                    R.id.diploma -> getString(R.string.diploma)
                    R.id.degree -> getString(R.string.degree)
                    else -> getString(R.string.undefined)
                }
            val studentInfo = StudentInfo(studentName, programType)
            val intent = Intent(this, OutputActivity::class.java)
            intent.putExtra(STUDENT_INFO, studentInfo)
            startActivity(intent)
        }
    }
}