package com.example.utsav.animationdemo

import android.content.Context
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.item_row_data.view.*
import android.view.animation.Animation


class RecycleAdapter(val items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<RecycleAdapter.RecycleAdapterHolder>() {

    private var lastPosition = -1
    var delayAnimate = 300 //global variable
    var delayAnimatetwo = 500 //global variable
    var delayAnimatethree = 800 //global variable

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapterHolder {
        return RecycleAdapterHolder(LayoutInflater.from(context).inflate(R.layout.item_row_data, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecycleAdapterHolder, position: Int) {
        holder.textViewName.text = items.get(position)
        holder.imageone.setVisibility(View.INVISIBLE);
        holder.imagetwo.setVisibility(View.INVISIBLE);

        setAnimation(holder.imageone, holder.imagetwo);

        holder.imagethree.setVisibility(View.INVISIBLE);
        setAnimationthree(holder.imagethree)

    }

    inner class RecycleAdapterHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageone = view.imageview1
        val imagetwo = view.imageview2
        val imagethree = view.imageview3
        val textViewName = view.tvName

    }

    private fun setAnimation(view: View?, viewtwo: View?) {
        val handler = Handler()
        handler.postDelayed(Runnable {
            val animation = AnimationUtils.loadAnimation(context, R.anim.popup)
            if (view != null ) {
                view.startAnimation(animation)
                view.visibility = View.VISIBLE
                if (viewtwo!=null){
                    val animationtwo = AnimationUtils.loadAnimation(context, R.anim.popup)

                    Handler().postDelayed({
                        viewtwo.startAnimation(animationtwo)
                        viewtwo.visibility = View.VISIBLE
                    }, 300)
                }


            }
        }, delayAnimate.toLong())
        delayAnimate += 300
    }

    private fun setAnimationtwo(view: View?) {
        val handler = Handler()
        handler.postDelayed(Runnable {
            val animation = AnimationUtils.loadAnimation(context, R.anim.popup)
            if (view != null) {
                view.startAnimation(animation)
                view.visibility = View.VISIBLE
            }
        }, delayAnimatetwo.toLong())
        delayAnimatetwo += 500
    }

    private fun setAnimationthree(view: View?) {
        val handler = Handler()
        handler.postDelayed(Runnable {
            val animation = AnimationUtils.loadAnimation(context, R.anim.popup)
            if (view != null) {
                view.startAnimation(animation)
                view.visibility = View.VISIBLE
            }
        }, delayAnimatethree.toLong())
        delayAnimatethree += 800
    }
//    private fun setAnimation(viewToAnimate: View, position: Int) {
//        // If the bound view wasn't previously displayed on screen, it's animated
//        if (position > lastPosition) {
//            val h = Handler()
//
//            val animation = AnimationUtils.loadAnimation(context, R.anim.popup)
//            viewToAnimate.startAnimation(animation)
//            lastPosition = position
//            h.postDelayed({},1000)
//
//        }
//    }


}