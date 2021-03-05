package com.vietth.gapo.core.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * https://stackoverflow.com/a/59504797
 * https://github.com/android/architecture-components-samples/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/util/AutoClearedValue.kt
 */
class AutoClearedValue<T : Any>(val fragment: Fragment, unregister: (T) -> Unit = {}) :
    ReadWriteProperty<Fragment, T> {
    private var _value: T? = null

    init {
        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.observe(
                    fragment,
                    Observer { viewLifecycleOwner ->
                        viewLifecycleOwner?.lifecycle?.addObserver(object :
                            DefaultLifecycleObserver {
                            override fun onDestroy(owner: LifecycleOwner) {
                                _value?.let { unregister(it) }
                                _value = null
                            }
                        })
                    })
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return _value ?: throw IllegalStateException("Should never call auto-cleared-value get when it might not be available")
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
        _value = value
    }
}

fun <T : Any> Fragment.autoCleared(unregister: (T) -> Unit = {}) = AutoClearedValue<T>(this, unregister)