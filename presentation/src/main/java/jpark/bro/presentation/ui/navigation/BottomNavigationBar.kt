package jpark.bro.presentation.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<NavItem.BottomItem>
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

            NavigationBarItem(
                icon = {
                    val iconRedId = if (isSelected) screen.selectedIcon else screen.unselectedIcon
                    Icon(painterResource(id = iconRedId), contentDescription = stringResource(id = screen.label))
                },
                label = {
                    Text(
                        text = stringResource(id = screen.label),
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        // 네비게이션 스택에서 지정된 목적지까지의 모든 항목을 제거하는 역할. 이 경우, 네비게이션 그래프의 시작 목적지로 돌아가서 모든 중간 항목을 제거
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true // 네비게이션 스택에서 제거된 항목의 상태를 저장할지 여부를 결정. true로 설정하면 상태를 저장하고, 나중에 동일한 목적지로 다시 네비게이션할 때 복원
                        }
                        launchSingleTop = true // 동일한 목적지로 여러 번 네비게이션할 때 중복된 항목이 네비게이션 스택에 추가되지 않도록 합니다.
                        restoreState = true // 이전에 저장된 상태를 복원할지 여부를 결정합니다. popUpTo와 함께 사용하여 상태를 저장했다면, restoreState를 사용하여 해당 상태를 복원할 수 있습니다.
                    }
                },
            )
        }
    }
}