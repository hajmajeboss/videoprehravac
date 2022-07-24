package cz.hajma.videoplayer.adapters

import android.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData


@BindingAdapter("query")
fun setQuery(searchView: SearchView, queryText: String?) {
    searchView.setQuery(queryText, false)
}

@InverseBindingAdapter(attribute = "query")
fun getQuery(searchView : SearchView) : String? {
    return searchView.query.toString();
}

@BindingAdapter("app:timeAttrChanged")
fun setListeners(
    view: SearchView,
    attrChange: InverseBindingListener
) {
    // Set a listener for click, focus, touch, etc.
}