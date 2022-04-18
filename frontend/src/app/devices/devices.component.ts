import {Component, OnInit, ViewChild} from '@angular/core';
import {BackendService} from "../backend.service";
import {MatTable, MatTableDataSource} from "@angular/material/table"
import {IDevice} from "../models/idevice";

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.scss']
})
export class DevicesComponent implements OnInit {

  private datasource:MatTableDataSource<IDevice>;
  @ViewChild(MatTable)
  public table!: MatTable<IDevice>;
  private data: IDevice[];
  public display: string[] = ["id", "name","category","inventoryid"]


  constructor(private readonly backservice: BackendService) {
    this.datasource = new MatTableDataSource<IDevice>();
    this.data = [];
    this.reload();
  }

  ngOnInit(): void {
    this.reload();
  }

  private reload() {
    this.backservice.getAllDevices().subscribe((d) => {
        this.datasource.data = d;
        this.data = d;
        this.table.dataSource = this.datasource;
      });
  }

}
