import { Component, Host, HostListener, OnInit } from '@angular/core';
import { Input } from '@angular/core'

@Component({
  selector: 'evolutionChain',
  templateUrl: './evolution-component.component.html',
  styleUrls: ['./evolution-component.component.css']
})
export class EvolutionComponentComponent implements OnInit {

  @Input()
  public url:string;

  @Input()
  public name:string;

  selectionClass:string;

  constructor() { }

  ngOnInit(): void {
    this.selectionClass = "unselected";
  }

  @HostListener('mouseenter')
  onMouseEnter(){
    this.selectionClass = "selected";
  }

  @HostListener('mouseleave')
  onMouseLeave(){
    this.selectionClass = "unselected";
  }
}
