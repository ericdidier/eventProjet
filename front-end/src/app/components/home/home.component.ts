import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../services/admin.service";
import {User} from "../../models/user";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user: User;
  users: User[];

  constructor(private adminService: AdminService, private authService: AuthService) { }

  ngOnInit() {
    this.authService.connectedUser.subscribe(
      user => {
        this.user = user;
        this.loadUsers();
      },
      err => this.user = null
    );
  }

  private loadUsers(): void {
    this.adminService.getUsers().subscribe(
      res => this.users = res
    );
  }

  get isAdmin(): boolean {
    return this.user != null
      && this.user.authorities.filter(a => a.authority === 'ROLE_ADMIN').length > 0;
  }

}
