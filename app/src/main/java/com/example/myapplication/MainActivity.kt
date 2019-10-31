package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCal.setOnClickListener {
            calculator()
        }
    }

    private fun calculator() {
        //get input
        val car_price = etxtPrice.text.toString().toInt()
        val down_payment = etxtDownPayment.text.toString().toInt()
        val loan_period = etxtLoan.text.toString().toInt()
        val interest_rate = etxtRate.text.toString().toFloat()

        val car_loan = car_price - down_payment
        txtCarLoan.text = getString(R.string.car_loan) + ": ${car_loan}"

        val interest = (car_loan * interest_rate * loan_period) / 100
        txtInterest.text = getString(R.string.interest) + ": ${interest}"

        val monthly_payment = (car_loan + interest) / loan_period / 12
        txtMonthlyPayment.text = getString(R.string.monthly_payment) + ": ${monthly_payment}"
}

    fun resetInput(View: View) {
       
        txtCarLoan.text = ""
        txtInterest.text = ""
        txtMonthlyPayment.text = ""

    }
}
