import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {BackendService} from "../backend.service";
import {IDevice} from "../models/idevice";

@Component({
  selector: 'app-add-device',
  templateUrl: './add-device.component.html',
  styleUrls: ['./add-device.component.scss']
})
export class AddDeviceComponent implements OnInit {

  myForm: FormGroup;
  devices!: IDevice[];

  constructor(private fb: FormBuilder, private readonly backend: BackendService) {
    this.myForm = this.fb.group({
      inventoryNo: ['', [Validators.required, Validators.pattern(/^[0-9]*$/)]],
      name: ['', [Validators.required]],
      type: ['', [Validators.required, Validators.pattern(/^[0-9]*$/),Validators.minLength(2),Validators.maxLength(2)]],
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

  }
}
