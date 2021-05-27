package com.github.bleszerd.jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SendMoneyFinallyFragment : Fragment() {
    lateinit var recipient: String
    lateinit var money: Money

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_money_finally, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
        money = arguments?.getParcelable("amount")!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amount = money.amount
        view.findViewById<TextView>(R.id.send_money_text_view).text = "Sending $amount to"
        view.findViewById<TextView>(R.id.person_name_text_view).text = recipient
    }
}