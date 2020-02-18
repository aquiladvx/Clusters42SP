package debcomp.com.aql.clusters42sp.infra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import debcomp.com.aql.clusters42sp.R
import debcomp.com.aql.clusters42sp.models.Coalition
import kotlinx.android.synthetic.main.listitem.view.*

class NoteListAdapter(val context: Context, var coalitions: List<Coalition>) : RecyclerView.Adapter<NoteListAdapter.ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false)
        return (ListHolder(view))
    }

    override fun getItemCount(): Int = coalitions.size

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bindView(coalitions[position])
    }

    inner class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.name
        //var hero_rate = itemView.hero_rate

        fun bindView(coalition: Coalition) {
            name.text = coalition.name

        }
    }

}
