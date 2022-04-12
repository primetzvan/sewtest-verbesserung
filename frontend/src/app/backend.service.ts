import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IDevice} from "./models/idevice";

const BASE_URL = "http://localhost:8080/api"

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  constructor(private readonly http: HttpClient) {}

  public getAllDevices():Observable<IDevice[]>{
    return this.http.get<IDevice[]>(BASE_URL + "/device");
  }

}
