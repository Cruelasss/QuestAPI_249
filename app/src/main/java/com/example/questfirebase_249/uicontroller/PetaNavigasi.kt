package com.example.questfirebase_249.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.questfirebase_249.uicontroller.route.DestinasiDetail
import com.example.questfirebase_249.uicontroller.route.DestinasiEdit
import com.example.questfirebase_249.uicontroller.route.DestinasiEntry
import com.example.questfirebase_249.uicontroller.route.DestinasiHome
import com.example.questfirebase_249.view.DetailSiswaScreen
import com.example.questfirebase_249.view.EditSiswaScreen
import com.example.questfirebase_249.view.EntrySiswaScreen
import com.example.questfirebase_249.view.HomeScreen

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier // Tambahkan default value agar tidak error saat dipanggil
) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier // Gunakan parameter modifier yang dilewatkan
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { nim -> // Beri nama parameter yang jelas, misal: nim
                    navController.navigate("${DestinasiDetail.route}/$nim")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = {
                navController.popBackStack(DestinasiHome.route, false)
            })
        }

        composable(
            route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.itemIdArg) {
                // Sesuaikan tipe data NIM. Jika di Firebase/DB adalah String, gunakan StringType
                type = NavType.StringType
            })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { nim ->
                    navController.navigate("${DestinasiEdit.route}/$nim")
                },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(DestinasiEdit.routeWithArgs, arguments = listOf(navArgument(DestinasiEdit.itemIdArg)
        ){
            type = NavType.IntType})){
        EditSiswaScreen(navigateBack = { navController.navigate(DestinasiHome.route) },
            onNavigateUp = { navController.navigateUp() })
    }
    }
}