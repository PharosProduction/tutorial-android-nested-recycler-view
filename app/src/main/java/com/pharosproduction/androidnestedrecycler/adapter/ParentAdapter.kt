package com.pharosproduction.androidnestedrecycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.pharosproduction.androidnestedrecycler.BR
import com.pharosproduction.androidnestedrecycler.Holder
import com.pharosproduction.androidnestedrecycler.R
import com.pharosproduction.androidnestedrecycler.RvOnClickListener
import com.pharosproduction.androidnestedrecycler.data.HasType
import com.pharosproduction.androidnestedrecycler.data.NestedDataObjectWrapper
import com.pharosproduction.androidnestedrecycler.data.Pdo
import com.pharosproduction.androidnestedrecycler.databinding.ItemNestedHorizontalHostBinding
import com.pharosproduction.androidnestedrecycler.databinding.ItemParentHolderBinding
import kotlin.properties.Delegates

class ParentAdapter : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    // Variables

    private var listOfData = listOf<HasType>()
    private lateinit var onClickListenerNested: RvOnClickListener

    // Public

    fun setData(dataList: List<HasType>) {
        listOfData = emptyList()
        listOfData = dataList
        notifyDataSetChanged()
    }

    fun setOnClickListener(onClickListenerNested: RvOnClickListener) {
        this.onClickListenerNested = onClickListenerNested
    }

    // Live

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding: ViewDataBinding? = null

        when (viewType) {
            Holder.PARENT.type -> binding = DataBindingUtil.inflate<ItemParentHolderBinding>(inflater, R.layout.item_parent_holder, parent, false)
            Holder.NESTED.type -> binding = DataBindingUtil.inflate<ItemNestedHorizontalHostBinding>(inflater, R.layout.item_nested_horizontal_host, parent, false)
        }

        return ViewHolder(binding!!, onClickListenerNested)
    }

    override fun getItemCount(): Int {
        return listOfData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfData[position], getItemViewType(position), position)
    }

    override fun getItemViewType(position: Int): Int {
        return listOfData[position].getType()
    }

    // Inner class RecyclerView.ViewHolder

    class ViewHolder(private val binding: ViewDataBinding, private val onClickListener: RvOnClickListener) : RecyclerView.ViewHolder(binding.root)
        , View.OnClickListener {

        // Variables

        private var parentPosition: Int by Delegates.notNull()

        // Public

        fun bind(dataObject: HasType, viewType: Int, parentPosition: Int) {
            this.parentPosition = parentPosition

            when (viewType) {
                Holder.PARENT.type -> {
                    with(binding) {
                        setVariable(BR.dataItem, dataObject as Pdo)
                        executePendingBindings()
                        root.setOnClickListener(this@ViewHolder)
                    }
                }
                Holder.NESTED.type -> {
                    val nestedAdapter = NestedAdapter(parentPosition).apply {
                        setOnClickListenerNested(onClickListener)
                        setData(dataList = (dataObject as NestedDataObjectWrapper).nestedDataObjectList)
                    }
                    with(binding) {
                        setVariable(BR.adapter, nestedAdapter)
                        executePendingBindings()
                        root.setOnClickListener(this@ViewHolder)
                    }
                }
            }
        }

        override fun onClick(v: View?) {
            onClickListener.onItmClick(parentPosition)
        }
    }
}