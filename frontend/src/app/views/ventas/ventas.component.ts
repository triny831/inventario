import { FormGroup, FormControl } from '@angular/forms';
import { VentasService } from 'src/app/service/ventas.service';
import { ViewChild, Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import { Ventas } from 'src/app/model/ventas';

@Component({
  selector: 'app-ventas',
  templateUrl: './ventas.component.html',
  styleUrls: ['./ventas.component.css']
})
export class VentasComponent implements OnInit{
  displayedColumns = ['idVenta','fecha','medicamento','cantidad','valorU','valorT'];
  dataSource!: MatTableDataSource<Ventas>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(
    private ventasService: VentasService){ }
  ngOnInit(): void {
    this.ventasService.listar().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    })
  }

  fecha = "";

  range = new FormGroup({
    start: new FormControl<Date | null>(null),
    end: new FormControl<Date | null>(null),
  });
  paginador(){
    this.dataSource.paginator = this.paginator;
  }
  applyFilter(event: Event){
    const filterValue = (event.target as HTMLInputElement).value;

    this.dataSource.filter = filterValue.trim();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
    this.dataSource.paginator = this.paginator;
  }

  filtrarFecha() {
    if (this.fecha != "") {
      this.ventasService.filtrarFechas(this.fecha).subscribe(data => {
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
      })
    }
  }
  }
