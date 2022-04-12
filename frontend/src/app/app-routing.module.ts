import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DevicesComponent} from "./devices/devices.component";
import {DeviceDetailComponent} from "./device-detail/device-detail.component";

const routes: Routes = [
  {path: 'devices', component: DevicesComponent},
  {path: '**', component: DevicesComponent},
  {path: 'detail/', component: DeviceDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
