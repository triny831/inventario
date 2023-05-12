import { VentasComponent } from './../../ventas/ventas.component';
import { VentasService } from './../../../service/ventas.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Component, Inject, OnInit } from '@angular/core';
import { Medicamento } from 'src/app/model/medicamento';
import { MedicamentoService } from 'src/app/service/medicamento.service';
import { Ventas } from 'src/app/model/ventas';

@Component({
  selector: 'app-venta-modal',
  templateUrl: './venta-modal.component.html',
  styleUrls: ['./venta-modal.component.css']
})
export class VentaModalComponent implements OnInit{
  ventas!: Ventas;
  constructor(
    public dialogRef: MatDialogRef<VentaModalComponent>, 
    private ventasService: VentasService,
    private MedicamentoService: MedicamentoService,
  @Inject(MAT_DIALOG_DATA) private data: Medicamento ){
    this.ventas = new Ventas();
    this.ventas.id_medicamento = data.idMedicamento
    this.ventas.nombreM = data.nombre
    this.ventas.valorU = data.valorU;
    this.ventas.cantidad = 0;
  }
  ngOnInit(): void {
    this.calcValorTotal();

  }

  guardar(){
    if (this.ventas.cantidad > 0) {
      const medicamento = {
        ...this.data,
        stock: this.data.stock - this.ventas.cantidad
      }
      this.MedicamentoService.editar(medicamento).subscribe((data) => {
        this.ventas.fechaYHora = new Date().toDateString();
        this.ventasService.registrar(this.ventas).subscribe(() => {
          this.cancelar();
        });
      })
    }

  }
  cancelar(){
    this.dialogRef.close();
  }

  calcValorTotal() {
    this.ventas.valorT = this.data.valorU * this.ventas.cantidad
  }
}
