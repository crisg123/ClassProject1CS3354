import { Component, OnInit, ViewChild } from '@angular/core';
import {ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { InOrder} from '../InOrder';
import { INORDER} from '../mock-InOrder';
import { BaseChartDirective} from 'ng2-charts';

@Component({
  selector: 'app-sorting-interface',
  templateUrl: './sorting-interface.component.html',
  styleUrls: ['./sorting-interface.component.css']
})
export class SortingInterfaceComponent implements OnInit {
  constructor() {
  }
  @ViewChild(BaseChartDirective) chart: BaseChartDirective;
  inOrder: InOrder = {data: [], label: ''};
  inOrderArray: InOrder[] = [];
  inOrderFilled: InOrder[] = INORDER;
  barChartOptions: ChartOptions = {
    responsive: true,
  };
  barChartLabels: Label[] = ['Insertion Sort', 'Selection Sort', 'Quick Sort', 'Merge Sort', 'Heap Sort', 'Radix Sort'];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartPlugins = [];
  barChartData: ChartDataSets[] =
    [
      {
        data: [0, 0, 0, 0, 0, 0],
        label: 'select an option'
      }
    ];
  disabled = false;
  invert = false;
  max = 30000;
  min = 1;
  step = 1;
  thumbLabel = false;
  value = 0;
  vertical = false;
  onClickInOrder() {
    console.log('function called');
    this.inOrderArray[0] = (this.inOrder)
    this.inOrderArray[0] = (this.inOrderFilled[0]);
    this.chart.chart.data.datasets[0].data = this.inOrderFilled[0].data;
    this.chart.chart.data.datasets[0].label = 'In Order';
    this.chart.chart.update();
  }
  ngOnInit(): void {

  }
}
