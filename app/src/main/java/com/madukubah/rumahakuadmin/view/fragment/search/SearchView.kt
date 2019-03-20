package com.madukubah.rumahakuadmin.view.fragment.search

import com.madukubah.rumahakuadmin.config.base.BasePresenter
import com.madukubah.rumahakuadmin.config.base.BaseView
import com.madukubah.rumahakuadmin.model.response.ItemResponse

interface SearchView {
    interface Presenter : BasePresenter
    {
        fun loadData()
        fun loadPLace( itemResponse: ItemResponse)
    }

    interface MView : BaseView<Presenter>
    {

    }
}