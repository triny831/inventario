import { MedicamentoService } from 'src/app/service/medicamento.service';
import { Medicamento } from 'src/app/model/medicamento';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-medicamento-modal',
  templateUrl: './medicamento-modal.component.html',
  styleUrls: ['./medicamento-modal.component.css']
})
export class MedicamentoModalComponent implements OnInit{
  medicamento!: Medicamento;
  constructor(
    public dialogRef: MatDialogRef<MedicamentoModalComponent>, 
    private MedicamentoService: MedicamentoService,
  @Inject(MAT_DIALOG_DATA) private data: Medicamento ){
    this.medicamento = new Medicamento();
    if (!!data) {
      this.medicamento = data;
    }
  }
  ngOnInit(): void {
    
  }
  actualizar(){
    if (this.medicamento.idMedicamento) {
      this.MedicamentoService.editar(this.medicamento).subscribe();
    } else {
      this.MedicamentoService.registrar(this.medicamento).subscribe();
    }
     this.cancelar();
  }
  
  cancelar(){
    this.dialogRef.close();
  }

}