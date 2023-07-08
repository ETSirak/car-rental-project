import { Component } from '@angular/core';
import {clientPageUrl, homePageUrl} from "../../models/links";

@Component({
  selector: 'app-navigtion-bar',
  templateUrl: './navigtion-bar.component.html',
  styleUrls: ['./navigtion-bar.component.css']
})
export class NavigtionBarComponent {

  protected readonly homePageUrl = homePageUrl;
  protected readonly clientPageUrl = clientPageUrl;
}
