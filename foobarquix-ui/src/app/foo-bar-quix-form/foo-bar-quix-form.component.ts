import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-foo-bar-quix-form',
  templateUrl: './foo-bar-quix-form.component.html'
})
export class FooBarQuixFormComponent implements OnInit {

  public myForm: FormGroup;

  @Output()
  submitNumberOutput = new EventEmitter<number>();

   readonly numberToConvertFieldName = 'numberToConvert';
    maxLength = 9;

  constructor() {
    this.myForm = new FormGroup({numberToConvert: new FormControl('', [Validators.required, Validators.maxLength(this.maxLength)])});

    this.myForm.statusChanges
      .subscribe(
        value => console.log(value)
      );
  }

  ngOnInit(): void {
  }

  submitNumber(): void {
    if (this.myForm.status === 'VALID') {
      console.log(this.myForm.controls[this.numberToConvertFieldName].errors);
      this.submitNumberOutput.emit(this.myForm.controls[this.numberToConvertFieldName].value);
    }
  }

  get numberToConvert(): FormControl { return this.myForm.get(this.numberToConvertFieldName) as FormControl; }

}
