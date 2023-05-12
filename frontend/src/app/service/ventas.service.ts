import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Ventas } from '../model/ventas';

@Injectable({
  providedIn: 'root'
})
export class VentasService {
  ventasActualizar = new Subject<Ventas[]>();
  private url: string = 'http://localhost:8080/ventas'
  constructor(private http: HttpClient) { }
  listar(){
    return this.http.get<Ventas[]>(this.url);
  }
  registrar(ventas: Ventas){
    return this.http.post(this.url, ventas);
  }

  filtrarFechas(fecha: string) {
    return this.http.get<Ventas[]>(`${this.url}/${fecha}`);
  }
}
