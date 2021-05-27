package com.github.bleszerd.jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class SendMoneyToFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController

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
                navController.navigate(R.id.action_sendMoneyToFragment_to_sendMoneyFinallyFragment)
            }
            R.id.button_send_money_cancel -> activity?.onBackPressed()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button_send_money_continue).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_send_money_cancel).setOnClickListener(this)
    }
}