package com.github.bleszerd.jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class WelcomeFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_transactions -> navController?.navigate(R.id.action_welcomeFragment_to_transactionsFragment)
            R.id.button_send_money -> navController?.navigate(R.id.action_welcomeFragment_to_sendMoneyFragment)
            R.id.button_my_balance -> navController?.navigate(R.id.action_welcomeFragment_to_balanceFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button_my_balance).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_send_money).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_transactions).setOnClickListener(this)
    }
}