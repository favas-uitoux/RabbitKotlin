package com.project.rabbitkotlin.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.rabbitkotlin.R
import com.project.rabbitkotlin.Utils
import com.project.rabbitkotlin.database.entities.EmployEntiity


class AdapterEmployDetails(
    private val context: Context,
    private val list: MutableList<EmployEntiity>
) :
    RecyclerView.Adapter<AdapterEmployDetails.VHClass>() {


    class VHClass(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val txtName: TextView = itemview.findViewById(R.id.txtName)
        val txtCompany: TextView = itemview.findViewById(R.id.txtCompany)
        val iv: ImageView = itemview.findViewById(R.id.iv)
        val card: CardView = itemview.findViewById(R.id.card)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHClass {

        val view = LayoutInflater.from(context).inflate(R.layout.model_row, parent, false)

        return VHClass(view)

    }

    override fun onBindViewHolder(holder: VHClass, position: Int) {

        val cpr = list[position]
       holder.txtName.setText("" + cpr.name)
       holder.txtCompany.setText("" + cpr.companyName)


        holder.card.setOnClickListener {
            Utils.homeActivityInterface.showEmploy(cpr.empId)
        }


var profilepic = cpr.profileImageUrl


        Glide.with(context).load(profilepic)
            .sizeMultiplier(.5f)
            .placeholder(R.drawable.blanc_pic)
            .error(R.drawable.blanc_pic)
            .fallback(R.drawable.blanc_pic)
            .dontAnimate()
            .into(holder.iv)



    }

    override fun getItemCount(): Int {
        return list.size
    }


}