package com.madukubah.rumahakuadmin.config.base

interface BaseView<T>
{
    fun setPresenter( presenter : T )
    fun showLoading()
    fun hideLoading()
}