package com.proximastudio.abc123
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.grid.view.*
import kotlinx.android.synthetic.main.grid1.view.*

class Adapter(private val listData: ArrayList<DataItem>) : RecyclerView.Adapter<Adapter.GridViewHolder>() {


    var bgId = 0
    var counter = 0


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        var layoutGrid:Int = 0
        Log.d("isi variabel list","${listData.size}")
        // Cek Tipe

        if(Database.tipe==1){

            layoutGrid = R.layout.grid1

        }else if(Database.tipe==2){
            layoutGrid = R.layout.grid
        }


        val view = LayoutInflater.from(viewGroup.context).inflate(layoutGrid, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        fun bind(dataItem: DataItem) {

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, dataItem.name, Toast.LENGTH_SHORT).show()
                val mediaPlayer = MediaPlayer.create(itemView.context,dataItem.audio)
                mediaPlayer.start()
//
                //assign to selected
                if(Database.tipe==1){

                    Database.selectedName = dataItem.name
                    Database.selectedText = dataItem.text
                    Database.selectedAudio = dataItem.audio
                }else{
                    Database.selectedName = dataItem.name
                    Database.selectedAudio = dataItem.audio
                    Database.selectedImg = dataItem.image
                }

//              //show dialog
                //dapetin activity
                val activity =  itemView.context as? MenuBelajar

                val pop = DialogPopup()
               // val fm = activity?.supportFragmentManager
                activity?.supportFragmentManager?.let { it1 -> pop.show(it1, DialogPopup::class.java.simpleName) }



            }

            if(Database.tipe==1){

                itemView.text_item.text = dataItem.name

                counter++
                getBgId()

                itemView.text_item.setBackgroundResource(bgId)

                //toast when item clicked


            }
            else if(Database.tipe==2){
                with(itemView){
                    Glide.with(itemView.context)
                        .load(dataItem.image)
                        //.apply(RequestOptions().override(350, 550))
                        .into(avatar_item)


            }




            }
        }
    }

    private fun getBgId() {

        val x = counter%5
        when(x){
            0 -> bgId = R.drawable.item_red
            1 -> bgId = R.drawable.item_blue
            2 -> bgId = R.drawable.item_yellow
            3 -> bgId = R.drawable.item_green
            4 -> bgId = R.drawable.item_pink
        }

    }


}

