import { Component, OnInit, OnDestroy } from '@angular/core';
import {FooBarQuixService, ResultDto} from '../foo-bar-quix.service';
import {take} from 'rxjs/operators';

@Component({
  selector: 'app-foo-bar-quix',
  templateUrl: './foo-bar-quix.component.html'
})
export class FooBarQuixComponent implements OnInit, OnDestroy {
  errorMessage: string;
  showError = false;
  convertedNumbers = [];

  constructor(private fooBarQuixService: FooBarQuixService) { }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }

  convertNumber(inputNumber: number): void {
    this.showError = false;
    this.fooBarQuixService.convertNumber(inputNumber)
      .pipe(take(1))
      .subscribe(
        result => {
          console.log(result);
          const numberConverted = {} as NumberConverted;
          numberConverted.numberToConvert = inputNumber;
          numberConverted.result = result.result;
          this.convertedNumbers = [...this.convertedNumbers, numberConverted];
        },
        error => {
          console.log(error);
          this.errorMessage = 'A error has occurred : unable to convert number.';
          this.showError = true;
        }
      );
  }

}

interface NumberConverted {
  numberToConvert: number;
  result: string;
}
