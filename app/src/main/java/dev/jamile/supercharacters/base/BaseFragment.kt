package dev.jamile.supercharacters.base

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import dev.jamile.supercharacters.R

abstract class BaseFragment(@LayoutRes layoutRes: Int = 0) : Fragment(layoutRes) {

    final override fun onAttach(context: Context) {
        super.onAttach(context)
        onAttachContext(context)
    }

    @Suppress("DEPRECATION", "OverridingDeprecatedMember")
    final override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        onAttachContext(activity)
    }

    open fun onAttachContext(context: Context?) {}

    fun snackBarError(
        anchorView: View? = view,
        error: String = getString(R.string.default_error_snack),
        duration: Int = Snackbar.LENGTH_SHORT,
        block: (Snackbar.() -> Unit)? = null
    ) {
        anchorView?.let {
            val snack = Snackbar.make(it, error, duration)
            if (block != null) {
                snack.block()
            }
            snack.show()
        }
    }
}
