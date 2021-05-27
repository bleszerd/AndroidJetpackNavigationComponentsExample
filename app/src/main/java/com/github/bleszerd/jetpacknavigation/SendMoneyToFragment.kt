package com.github.bleszerd.jetpacknavigation

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_send_money_to.*
import java.math.BigDecimal

class SendMoneyToFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments?.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_money_to, container, false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_send_money_continue -> {

                if (!TextUtils.isEmpty(text_input_amount.text.toString())) {
                    val amount = Money(BigDecimal(text_input_amount.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount
                    )
                    navController.navigate(
                        R.id.action_sendMoneyToFragment_to_sendMoneyFinallyFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.button_send_money_cancel -> activity?.onBackPressed()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button_send_money_continue).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_send_money_cancel).setOnClickListener(this)
        view.findViewById<TextView>(R.id.person_name_text_view).text = recipient
    }
}