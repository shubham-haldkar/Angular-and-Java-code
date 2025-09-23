import { validateHorizontalPosition } from '@angular/cdk/overlay';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  imports: [],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {

  postForm!: FormGroup;

  constructor(private fb: FormBuilder,
    private router : Router,
    private snakbar : MatSnackBar
  ){}

  ngOnInit(){
    this.postForm = this.fb.group({
      name: [null,Validators.required],
      content: [null,Validators.required, Validators.maxLength(5000) ],
      img: [null,Validators.required],
      postedBy: [null,Validators.required],
    })
  }

}
