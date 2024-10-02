import { Routes, RouterModule} from '@angular/router';
import { LoginComponent } from "./login/login.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { NgModule } from "@angular/core";

export const routes: Routes = [
    
    { path: "", redirectTo: "/iniciar-sesion", pathMatch: "full"}, 
    { path: "inicio", component: DashboardComponent},
    { path: "iniciar-sesion", component: LoginComponent},
    { path: "cerrar-sesion", redirectTo: "/iniciar-sesion", pathMatch: "full"},
    
    
    {
        path: "new",
        loadComponent: () => import("./contact-form/contact-form.component")
    },
    {
        path: ":id/edit",
        loadComponent: () => import("./contact-form/contact-form.component")
    }

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
