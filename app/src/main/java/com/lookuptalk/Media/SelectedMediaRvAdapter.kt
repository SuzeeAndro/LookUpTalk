package com.anilokcun.uwandroidmediapicker

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lookuptalk.R
import java.util.*



internal class SelectedMediaRvAdapter(
	private var itemList: ArrayList<String>,
	private val gridSize: Int
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	/** Creates View for each item in the List */
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
		return MediaVH(ImageView(parent.context).apply {
			RecyclerView.LayoutParams(gridSize, gridSize)
			adjustViewBounds = true
		})
	}

	/** Binds the data on the List */
	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		Glide.with(holder.itemView.context)
			.load(itemList[position])
			.apply(
				RequestOptions()
					.override(gridSize).centerCrop()
					.placeholder(ColorDrawable(ContextCompat
						.getColor(holder.itemView.context, R.color.colorImagePlaceHolder))))
			.into(holder.itemView as ImageView)
	}

	/** Gets the 'Size of the List' or 'Item count in the RecyclerView'*/
	override fun getItemCount(): Int = itemList.size

	fun update(list: ArrayList<String>) {
		itemList = list
		notifyDataSetChanged()
	}

	class MediaVH(itemView: View) : RecyclerView.ViewHolder(itemView)

}