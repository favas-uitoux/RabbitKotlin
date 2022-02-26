package com.project.rabbitkotlin.fragments

//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.rabbitkotlin.R
import com.project.rabbitkotlin.adapter.AdapterEmployDetails
import com.project.rabbitkotlin.database.entities.EmployEntiity
import com.project.rabbitkotlin.modelviews.EmployeesViewModel


//import com.project.myapplication.viewmodel.HomeViewModel

class EmployeesFragment : Fragment() {


    private lateinit var view1 : View
  private lateinit var viewModel: EmployeesViewModel

    private lateinit var adp:AdapterEmployDetails
    private lateinit var recv: RecyclerView
    private lateinit var edtSearch: EditText
    private lateinit var list:MutableList<EmployEntiity>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


         view1= inflater.inflate(R.layout.fragment_employees, container, false)


        init()
        display("")

        return view1



    }

    private fun  init()
    {
        viewModel = ViewModelProvider(this).get(EmployeesViewModel::class.java)

        recv=view1.findViewById(R.id.recv)
        edtSearch=view1.findViewById(R.id.edtSearch)




        edtSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                var word = s.toString().trim()
                word = "%$word%"

                display(word)
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {


            }
        })




        viewModel.readLiveSize().observe(viewLifecycleOwner, Observer {


//            adp = AdapterHome(view1.context, it)
//            recv1.layoutManager = LinearLayoutManager(view1.context)
//            recv1.adapter = adp
            var word = "%%"
            display(word)

        })

    }



    private fun display(word: String) {


        recv.adapter=null
        list = ArrayList<EmployEntiity>()

        if(word.trim().equals(""))
        {
            list.addAll(viewModel.readAllEmployees())
        }
        else
        {
            list.addAll(viewModel.readSimilarEmploy(word))
        }


        recv.layoutManager= LinearLayoutManager(activity)
        recv.adapter= AdapterEmployDetails(requireActivity(), list)



    }


}