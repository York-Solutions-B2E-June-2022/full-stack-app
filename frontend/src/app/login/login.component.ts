import {Component, OnInit} from '@angular/core';
import {HttpService} from "../http.service";
import {ILoginResponse} from "../Interfaces/ILoginResponse";
import {DataService} from "../data.service";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username!: string;
  password!: string;
  isLoggedIn: boolean = false;

  user: any;

  constructor(private dataService: DataService, private httpService: HttpService) {
    // this.dataService.currentUser$.subscribe(
    //   (userData) => {
    //     this.user = userData
    //   }
    // )
  }

  ngOnInit(): void {
  }

  onLogin() {
    // this.dataService.login(this.username, this.password);
    this.httpService.login(this.username, this.password).subscribe(
      (data) => {this.user = data},
      (error) => {console.error(error)}
    )
  }
}
