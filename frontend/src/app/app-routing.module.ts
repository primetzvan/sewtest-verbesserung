import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DevicesComponent} from "./devices/devices.component";
import {DeviceDetailComponent} from "./device-detail/device-detail.component";
import {AddDeviceComponent} from "./add-device/add-device.component";

const routes: Routes = [
  {path: 'devices', component: DevicesComponent},
  {path: '', component: DevicesComponent},
  {path: 'detail/:id', component: DeviceDetailComponent},
  {path: 'new', component: AddDeviceComponent},
  {path: '**', component: DevicesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
