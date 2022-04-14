import {Component, Input, OnInit} from '@angular/core';
import {IDevice} from "../models/idevice";
import {BackendService} from "../backend.service";
import {MatTableDataSource} from "@angular/material/table";
import {Router} from "@angular/router";

@Component({
  selector: 'app-device-detail',
  templateUrl: './device-detail.component.html',
  styleUrls: ['./device-detail.component.scss']
})
export class DeviceDetailComponent implements OnInit {

  public id: number;
  public act!: IDevice;
  public components!: IDevice[];

  constructor(private readonly backservice: BackendService, private readonly router :Router) {
    let urlparts = this.router.url.split("/");
    this.id = Number.parseInt(urlparts[urlparts.length-1]);
    this.backservice.getDeviceById(this.id).subscribe((d) => {
      this.act = d;
    });
    this.backservice.getComponentsById(this.id).subscribe((d) => {
      this.components = d;
      console.log(d)
    });
  }

  ngOnInit(): void {
  }

}
