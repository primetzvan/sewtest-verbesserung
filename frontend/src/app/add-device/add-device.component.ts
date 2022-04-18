import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {BackendService} from "../backend.service";
import {ICategory, IDevice, IDeviceDTO} from "../models/idevice";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-device',
  templateUrl: './add-device.component.html',
  styleUrls: ['./add-device.component.scss']
})
export class AddDeviceComponent implements OnInit {

  myForm: FormGroup;
  devices!: IDevice[];
  selectedValue: IDevice | undefined;

  constructor(private fb: FormBuilder, private readonly backend: BackendService, private router: Router) {
    this.myForm = this.fb.group({
      inventoryNo: ['', [Validators.required, Validators.pattern('HTL-L-[0-9][0-9][0-9][0-9][0-9]-[0-9]')]],
      name: ['', [Validators.required]],
      type: ['', [Validators.required]],
      brand: [''],
      description: [''],
      abbreviation: ['', [Validators.required,Validators.maxLength(20)]],
      namec: ['', [Validators.required,Validators.maxLength(100)]]
    })
  }

  ngOnInit(): void {
    this.backend.getAllDevices().subscribe(val => {
      this.devices = val;
      }
    )
  }

  add() {
    let device: IDeviceDTO = {
      brand: this.myForm.controls['brand'].value,
      description: this.myForm.controls['description'].value,
      shortName: this.myForm.controls['name'].value,
      type: this.myForm.controls['type'].value,
      inventoryNo: this.myForm.controls['inventoryNo'].value,
      belongsto: this.selectedValue!,
      category: {
        abbr: this.myForm.controls['inventoryNo'].value,
        name:this.myForm.controls['inventoryNo'].value}
    }

    this.backend.addDevice(device).subscribe(val => {
      this.router.navigate([""]);
    });
  }
}
