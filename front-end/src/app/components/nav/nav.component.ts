import {Component, OnInit} from '@angular/core';
import {User} from "../../models/user";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  public connectedUser: User = null;

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    this.authService.connectedUser.subscribe(
      user => this.connectedUser = user,
      err => this.connectedUser = null
    );
  }

  logout(): void {
    this.authService.logout();
  }
}
