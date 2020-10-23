package sheridan.levings.collegeData1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sheridan.levings.collegeData1.databinding.ActivityOutputBinding
import sheridan.levings.collegeData1.model.StudentInfo

class OutputActivity : AppCompatActivity() {

    companion object{
        const val STUDENT_INFO = "student_info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentInfo = intent.getSerializableExtra(STUDENT_INFO) as StudentInfo

        with(binding){
            nameOutput.text = studentInfo.studentName
            programOutput.text = studentInfo.programType

            btnBack.setOnClickListener { finish() }
        }
    }
}