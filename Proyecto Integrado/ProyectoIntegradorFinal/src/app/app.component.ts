import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  title = 'ProyectoIntegradorFinal';

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
}
