import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  // {
  //   path: 'folder/:id',
  //   loadChildren: () => import('./folder/folder.module').then( m => m.FolderPageModule)
  // },
  {
    path: '',
    redirectTo: 'loader',
    pathMatch: 'full',
  },
  {
    path: 'loader',
    loadChildren: () =>
      import('./pages/loader/loader.module').then((m) => m.LoaderPageModule),
  },
  {
    path: 'login',
    loadChildren: () =>
      import('./pages/login/login.module').then((m) => m.LoginPageModule),
  },
  {
    path: 'register',
    loadChildren: () =>
      import('./pages/register/register.module').then(
        (m) => m.RegisterPageModule
      ),
  },
  {
    path: 'forgotten-password',
    loadChildren: () =>
      import('./pages/forgotten-password/forgotten-password.module').then(
        (m) => m.ForgottenPasswordPageModule
      ),
  },
  {
    path: 'welcome-login',
    loadChildren: () =>
      import('./pages/welcome-login/welcome-login.module').then(
        (m) => m.WelcomeLoginPageModule
      ),
  },
  {
    path: 'homepage',
    loadChildren: () =>
      import('./pages/homepage/homepage.module').then(
        (m) => m.HomepagePageModule
      ),
  },
  {
    path: 'add-expense',
    loadChildren: () => import('./pages/add-expense/add-expense.module').then( m => m.AddExpensePageModule)
  },
  {
    path: 'add-income',
    loadChildren: () => import('./pages/add-income/add-income.module').then( m => m.AddIncomePageModule)
  },
  {
    path: 'history',
    loadChildren: () => import('./pages/history/history.module').then( m => m.HistoryPageModule)
  },
  {
    path: 'bla',
    loadChildren: () => import('./pages/bla/bla.module').then( m => m.BlaPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
