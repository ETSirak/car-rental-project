import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {MatPaginator} from "@angular/material/paginator";
import {ClientService} from "../../services/client/client.service";
import {Client} from "../../models/client";
import {FormControl, FormGroup, Validators} from "@angular/forms";
@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {
  displayedColumns: Array<string> =
    ['id', 'name', 'surname', 'phone', 'email', 'address', 'hasDrivingLicense', 'registrationDateTime', 'dateOfBirth'];
  dataSource: MatTableDataSource<Client>;
  clients!: Array<Client>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  clientForm = new FormGroup({
    name: new FormControl('', Validators.required),
    surname: new FormControl('', Validators.required),
    phone: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    address: new FormControl(''),
    hasDrivingLicence: new FormControl(false, Validators.required),
    registrationDateTime: new FormControl(null),
    dateOfBirth: new FormControl('', Validators.required)
  });

  constructor(
    private clientService: ClientService
  ) {
    this.dataSource = new MatTableDataSource(this.clients);
    console.log('inside clients component constructor')
  }
  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.clientService.getAllClients()
      .subscribe(clients => {
        this.clients = clients;
        this.dataSource.data = this.clients;
        console.log(`results: ${JSON.stringify(clients, null, 2)}`);
      });
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
