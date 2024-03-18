package com.example.retrofitexamplewithcardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class UsersAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    inner class MyViewHolder (itemView: View): RecyclerView.ViewHolder (itemView) {
        // This class will represent a single row in our recyclerView list
        // This class also allows caching views and reuse them
        // Each MyViewHolder object keeps a reference to 3 view items in our row_item.xml file
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val gender = itemView.findViewById<TextView>(R.id.tv_gender)
        val email = itemView.findViewById<TextView>(R.id.tv_email)
        val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate a layout from our XML (row_item.XML) and return the holder
        // create a new view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val currentItem = users[position]
        holder.name.text = "${currentItem.name.title} ${currentItem.name.first} ${currentItem.name.last}"
        holder.email.text = currentItem.email
        holder.gender.text = currentItem.gender

        // Get the context for glide
        val context = holder.itemView.context

        // Load the image from the url using Glide library
        Glide.with(context)
            .load(currentItem.imageUrl.medium)
            .placeholder(R.drawable.baseline_account_circle_24) // In case the image is not loaded show this placeholder image
            .circleCrop() // optional - Circle image with rounded corners
            .into(holder.profileImage)

    }

    override fun getItemCount(): Int {
        // Return the size of your dataset (invoked by the layout manager)
        return users.size
    }

}
