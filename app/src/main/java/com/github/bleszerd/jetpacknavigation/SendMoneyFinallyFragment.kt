package com.github.bleszerd.jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class SendMoneyFinallyFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    lateinit var recipient: String
    lateinit var money: Money

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_money_finally, container, false)
    }

    override fun onClick(v: View?) {
        val buttonPressedId = v?.id

        if (buttonPressedId != null) {
            navController.navigate(R.id.action_sendMoneyFinallyFragment_to_welcomeFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
        money = arguments?.getParcelable("amount")!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        val amount = money.amount
        view.findViewById<Button>(R.id.back_to_welcome_button).setOnClickListener(this)
        view.findViewById<TextView>(R.id.send_money_text_view).text = "Sending $amount to"
        view.findViewById<TextView>(R.id.person_name_text_view).text = recipient
    }
}