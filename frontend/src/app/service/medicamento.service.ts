import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Medicamento } from '../model/medicamento';

@Injectable({
  providedIn: 'root'
})
export class MedicamentoService {
  medicamentoActualizar = new Subject<Medicamento[]>();
  private url: string = 'http://localhost:8080/medicamentos'
  constructor(private http: HttpClient) { }
  listar(){
    return this.http.get<Medicamento[]>(this.url);
  }
  eliminar(id: number){
    return this.http.delete(`${this.url}/${id}`)
  }
  editar(medicamento: Medicamento){
    return this.http.put(this.url, medicamento);
  }
  registrar(medicamento: Medicamento){
    return this.http.post(this.url, medicamento);
  }
}
