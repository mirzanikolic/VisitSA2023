package com.example.visitsacompose.common.navigation

import com.example.visitsacompose.R
import MapScreen
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.visitsacompose.common.feature.home.Home
import com.example.visitsacompose.common.feature.itemdetails.ItemDetails
import com.example.visitsacompose.common.feature.login.Login
import com.example.visitsacompose.common.feature.login.Register
import com.example.visitsacompose.common.feature.onboarding.Onboarding
import com.example.visitsacompose.common.feature.settings.Settings
import com.example.visitsacompose.common.feature.tours.Tours
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

sealed class Screen(open val route: String) {
    object Onboarding : Screen("onboarding")
    object Home : Screen("home")
    object ItemDetails : Screen("itemDetails/{id}") {
        fun getRoute(id: Int) = "itemDetails/${id}"
    }

    object MapScreen : Screen("map")
    object Tours : Screen("tours")
    object Settings : Screen("settings")
    object Login: Screen("login")
    object Register: Screen("register")
}

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomNavItem(
        route = Screen.Home.route,
        title = "Home",
        icon = R.drawable.ic_home
    )

    object Map : BottomNavItem(
        route = Screen.MapScreen.route,
        title = "Map",
        icon = R.drawable.ic_map
    )

    object Tours : BottomNavItem(
        route = Screen.Tours.route,
        title = "Tours",
        icon = R.drawable.ic_tours
    )

    object Settings : BottomNavItem(
        route = Screen.Settings.route,
        title = "Settings",
        icon = R.drawable.ic_settings
    )
}

@ExperimentalAnimationApi
@Composable
internal fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        enterTransition = { defaultEnterTransition(initialState, targetState) },
        exitTransition = { defaultExitTransition(initialState, targetState) },
        popEnterTransition = { defaultPopEnterTransition() },
        popExitTransition = { defaultPopExitTransition() },
        modifier = modifier,
    ) {
        composable(route = Screen.Onboarding.route) {
            Onboarding(modifier = Modifier, openHome = {
                navController.navigate(Screen.Home.route)
            })
        }
        composable(route = Screen.Home.route) {
            Home(openDetails = { itemId ->
                navController.navigate(Screen.ItemDetails.getRoute(itemId))
            })
        }
        composable(
            route = Screen.ItemDetails.route,
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
            ),
        ) {
            ItemDetails(onClick = {
                navController.navigateUp()
            })
        }
        composable(route = Screen.MapScreen.route) {
            MapScreen()
        }
        composable(route = Screen.Tours.route) {
            Tours(openDetails = { itemId ->
                navController.navigate(Screen.ItemDetails.getRoute(itemId))
            })
        }
        composable(route = Screen.Settings.route) {
            Settings()
        }
        composable(route = Screen.Login.route) {
            Login(onLoginClicked = {
                navController.navigate(Screen.Onboarding.route)
            })
        }
        composable(route = Screen.Register.route) {
            Register(onRegisterClicked = { one, two, three ->
                navController.navigateUp()
            })
        }
    }
}

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultEnterTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): EnterTransition {
    val initialNavGraph = initial.destination.hostNavGraph
    val targetNavGraph = target.destination.hostNavGraph
    // If we're crossing nav graphs (bottom navigation graphs), we crossfade
    if (initialNavGraph.id != targetNavGraph.id) {
        return fadeIn()
    }
    // Otherwise we're in the same nav graph, we can imply a direction
    return fadeIn() + slideIntoContainer(AnimatedContentScope.SlideDirection.Start)
}

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultExitTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): ExitTransition {
    val initialNavGraph = initial.destination.hostNavGraph
    val targetNavGraph = target.destination.hostNavGraph
    // If we're crossing nav graphs (bottom navigation graphs), we crossfade
    if (initialNavGraph.id != targetNavGraph.id) {
        return fadeOut()
    }
    // Otherwise we're in the same nav graph, we can imply a direction
    return fadeOut() + slideOutOfContainer(AnimatedContentScope.SlideDirection.Start)
}

private val NavDestination.hostNavGraph: NavGraph
    get() = hierarchy.first { it is NavGraph } as NavGraph

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultPopEnterTransition(): EnterTransition {
    return fadeIn() + slideIntoContainer(AnimatedContentScope.SlideDirection.End)
}

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultPopExitTransition(): ExitTransition {
    return fadeOut() + slideOutOfContainer(AnimatedContentScope.SlideDirection.End)
}
