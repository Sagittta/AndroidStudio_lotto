package kr.hs.emirim.sagittta.lotto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_constellation.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_name.*
import kr.hs.emirim.sagittta.lotto.LottoNumberMaker.getLottoNumbersFromHash
import java.text.SimpleDateFormat
import java.util.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        goButton.setOnClickListener {

            if (TextUtils.isEmpty(editText.text.toString()))
                return@setOnClickListener

            editText.text?.let {

                val intent = Intent(this, ResultActivity::class.java)

                intent.putIntegerArrayListExtra(
                    "result",
                    ArrayList(LottoNumberMaker.getLottoNumbersFromHash(editText.text.toString()) )
                )
                intent.putExtra(
                    "name",
                    editText.text.toString()
                )

                startActivity(intent)

            }

        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
