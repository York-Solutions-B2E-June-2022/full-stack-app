import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ILoginResponse} from "./Interfaces/ILoginResponse";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpClient: HttpClient) {
  }

  login(username: string, password: string) {
    return this.httpClient.post(
      "http://localhost:8080/account/login",
      {username, password}
    ) as Observable<ILoginResponse>
  }

}
