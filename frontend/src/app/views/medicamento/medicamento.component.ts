import { VentaModalComponent } from './venta-modal/venta-modal.component';
import { MedicamentoModalComponent } from './medicamento-modal/medicamento-modal.component';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { MedicamentoService } from 'src/app/service/medicamento.service';
import { Component, ViewChild, OnInit } from '@angular/core';
import { Medicamento } from 'src/app/model/medicamento';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';


@Component({
  selector: 'app-medicamento',
  templateUrl: './medicamento.component.html',
  styleUrls: ['./medicamento.component.css']
})
export class MedicamentoComponent implements OnInit{
  displayedColumns = ['idMedicamento','nombre','laboratorio','fechaF','fechaV','stock','valorU','acciones'];
  dataSource!: MatTableDataSource<Medicamento>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private dialog: MatDialog,
    private medicamentoService: MedicamentoService){ }
  ngOnInit(): void {
    this.medicamentoService.medicamentoActualizar.subscribe(data=>{
      this.dataSource = new MatTableDataSource(data);
    })
    this.medicamentoService.listar().subscribe(data => {
      console.log(data);
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    })
  }
  openModal(medicamento?: Medicamento){
    const dialogRef = this.dialog.open(MedicamentoModalComponent,{
      width:'500px',
      data: medicamento
    })
    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }
  openModalVentas(medicamento?: Medicamento){
    const dialogRef = this.dialog.open(VentaModalComponent,{
      width:'250px',
      data: medicamento
    })
    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }
  onDelete(id:number){
    let dialogRef = this.dialog.open(ConfirmDialogComponent,{
      disableClose:true
    });
    dialogRef.afterClosed().subscribe((estado: any) => {
      if(estado){
        this.medicamentoService.eliminar(id).subscribe(()=>{
          this.medicamentoService.listar().subscribe(data =>{
            this.dataSource = new MatTableDataSource(data);
          })
        })
      }
    })
    this.dataSource.paginator = this.paginator;
  }
  applyFilter(event: Event){
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
    this.dataSource.paginator = this.paginator;
  }
}
