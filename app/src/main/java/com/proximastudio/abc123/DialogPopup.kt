package com.proximastudio.abc123

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_dialog_popup.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogPopup.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogPopup : DialogFragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return inflater.inflate(R.layout.fragment_dialog_popup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if(Database.tipe == 1){
            img.text = Database.selectedName
            title.text = Database.selectedText
        }else{
            img.setBackgroundResource(Database.selectedImg)
            title.text = Database.selectedName
        }

        playAudio.setOnClickListener {

            activity?.let { it1 -> Database.playSound(Database.selectedAudio, it1) }
        }

        close.setOnClickListener {
            dialog?.dismiss()
        }

    }


}
