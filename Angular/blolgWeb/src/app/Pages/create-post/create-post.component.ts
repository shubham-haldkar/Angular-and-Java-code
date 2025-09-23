import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from "@angular/forms";
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { MatChipsModule } from "@angular/material/chips";
import { MatIcon } from '@angular/material/icon';
import { NgForOf } from '@angular/common';
import { MatFormField } from '@angular/material/form-field';

@Component({
  selector: 'app-create-post',
  imports: [FormsModule, ReactiveFormsModule, MatChipsModule, NgForOf, MatIcon, MatFormField ],
  templateUrl: './create-post.component.html',
  styleUrl: './create-post.component.css'
})
export class CreatePostComponent {
  postForm!: FormGroup;
  tags:string[]=[]; 
$event: any;

  constructor(private fb: FormBuilder,
    private router: Router,
    private snakbar: MatSnackBar
  ) { }

  ngOnInit() {
    this.postForm = this.fb.group({
      name: [null, Validators.required],
      content: [null, Validators.required, Validators.maxLength(5000)],
      img: [null, Validators.required],
      postedBy: [null, Validators.required],
    })
  }

  add(event:any){
    const value = (event.value || '').trim();
    if(value){
      this.tags.push(value) ;
    }

    event.chipInput!.clear() ;
  }

  remove(tag:any){
    const index = this.tags.indexOf(tag);
    
    if (index>=0) {
      this.tags.splice(index,1) ;
    }
  }

}
