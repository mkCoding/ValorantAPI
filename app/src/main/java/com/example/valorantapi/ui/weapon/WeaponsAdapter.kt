package com.example.valorantapi.ui.weapon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.valorantapi.R
import com.example.valorantapi.data.model.weapon.DataModel
import com.example.valorantapi.databinding.ItemWeaponBinding

class WeaponsAdapter(
    private val weaponList: List<DataModel?>?
) : RecyclerView.Adapter<WeaponsAdapter.WeaponViewHolder>() {

    inner class WeaponViewHolder(itemView: View) : ViewHolder(itemView) {
        private val binding = ItemWeaponBinding.bind(itemView)

        fun updateUI(weaponItemModel: DataModel?) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(weaponItemModel?.displayIcon)
                    .placeholder(R.drawable.ic_android_black_24dp)
                    .into(ivWeaponImage)
                tvWeaponName.text = weaponItemModel?.displayName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponViewHolder {
        return WeaponViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_weapon, parent, false)
        )
    }

    override fun getItemCount(): Int = weaponList?.size?: 0

    override fun onBindViewHolder(holder: WeaponsAdapter.WeaponViewHolder, position: Int) {
        holder.updateUI(weaponList?.get(position))
    }


}
