import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IDevice, IDeviceDTO} from "./models/idevice";

const BASE_URL = "http://localhost:8080/api"

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  constructor(private readonly http: HttpClient) {}

  public getAllDevices():Observable<IDevice[]>{
    return this.http.get<IDevice[]>(BASE_URL + "/device");
  }

  public getDeviceById(id: number):Observable<IDevice>{
    return this.http.get<IDevice>(BASE_URL + "/device/" + id);
  }

  public getComponentsById(id: number):Observable<IDevice[]>{
    return this.http.get<IDevice[]>(BASE_URL + "/device/components/" + id);
  }

  addDevice(device: IDeviceDTO) {
    return this.http.post<IDevice>(BASE_URL + "/device",device);
  }
}
