import android.content.Context
import android.widget.FrameLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.visitsacompose.common.navigation.Screen
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@Composable
fun MapScreen() {
    val context = LocalContext.current

    // Initialize osmdroid configuration
    Configuration.getInstance().load(
        context,
        androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
    )

    val mapView = remember {
        MapView(context).apply {
            setTileSource(TileSourceFactory.MAPNIK) // Use the default map tile source

            // Add a marker to the map
            val marker = Marker(this)
            marker.position = GeoPoint(43.856430, 18.413029)
            marker.title = "Sarajevo" // Update the marker title if needed
            overlays.add(marker)

            // Zoom to the marker
            controller.setZoom(15.0) // Adjust the zoom level as needed
            controller.setCenter(marker.position)

            invalidate()

        }
    }

    AndroidView(
        factory = { mapView },
        modifier = Modifier.fillMaxSize()
    )
}


