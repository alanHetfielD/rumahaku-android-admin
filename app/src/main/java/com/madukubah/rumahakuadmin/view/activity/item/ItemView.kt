package com.madukubah.rumahakuadmin.view.activity.item

import com.madukubah.rumahakuadmin.config.base.BasePresenter
import com.madukubah.rumahakuadmin.config.base.BaseView
import com.madukubah.rumahakuadmin.model.response.ItemResponse

interface ItemView
{
    interface Presenter : BasePresenter
    {
        fun loadData()
        fun loadItems( itemResponse: ItemResponse)
        fun loadMore( itemResponse: ItemResponse)
    }

    interface MView : BaseView<Presenter>
    {
        fun status(isEmpty : Boolean)
        fun statusMore(isEmpty : Boolean)

    }
}