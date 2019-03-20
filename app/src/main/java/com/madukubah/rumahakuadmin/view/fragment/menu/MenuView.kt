package com.madukubah.rumahakuadmin.view.fragment.menu

import com.madukubah.rumahakuadmin.config.base.BasePresenter
import com.madukubah.rumahakuadmin.config.base.BaseView
import com.madukubah.rumahakuadmin.model.Ad
import com.madukubah.rumahakuadmin.model.BannerPromo
import com.madukubah.rumahakuadmin.model.Category
import com.madukubah.rumahakuadmin.model.response.AdsResponse
import com.madukubah.rumahakuadmin.model.response.CategoryResponse

interface MenuView {
    interface Presenter : BasePresenter
    {
        fun loadData()
        fun loadCategory( response : CategoryResponse)
        fun loadAds( response : AdsResponse)
    }

    interface MView : BaseView<Presenter>
    {
        fun onLoadCategory( response : List<Category>)
        fun onLoadAds( banners : List<Ad>)
        fun status(isEmpty : Boolean)
    }
}