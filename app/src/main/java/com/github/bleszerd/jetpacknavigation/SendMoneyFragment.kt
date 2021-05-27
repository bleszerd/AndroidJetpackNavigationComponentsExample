package com.github.bleszerd.jetpacknavigation

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_send_money.*

class SendMoneyFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    lateinit var recipient: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_money, container, false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_send_money_continue -> {
                if (!TextUtils.isEmpty(text_input_name.text.toString())) {
                    val bundle = bundleOf("recipient" to text_input_name.text.toString())
                    navController?.navigate(
                        R.id.action_sendMoneyFragment_to_sendMoneyToFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "Enter a name", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.button_send_money_cancel -> {
                activity?.onBackPressed()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button_send_money_continue).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_send_money_cancel).setOnClickListener(this)
    }
}