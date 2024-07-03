package com.example.animelistapptest.ui.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.animelistapptest.ui.screens.anime.AnimeScreen
import com.example.animelistapptest.ui.screens.trending_anime.TrendingAnimeScreen
import kotlinx.serialization.Serializable

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SetUpNavigation(navController: NavHostController) {
    SharedTransitionLayout {
        NavHost(navController = navController, startDestination = TrendingAnimeRoute) {
            composable<TrendingAnimeRoute> {
                TrendingAnimeScreen(animatedVisibilityScope = this, onAnimeClick = { coverUrl, id ->
                    navController.navigate(
                        AnimeRoute(coverUrl = coverUrl, id = id)
                    )
                })
            }

            composable<AnimeRoute> {
                val args = it.toRoute<AnimeRoute>()

                AnimeScreen(
                    animatedVisibilityScope = this, id = args.id.toInt(), coverImage = args.coverUrl
                )
            }
        }
    }
}

@Serializable
data object TrendingAnimeRoute

@Serializable
data class AnimeRoute(val coverUrl: String, val id: String)